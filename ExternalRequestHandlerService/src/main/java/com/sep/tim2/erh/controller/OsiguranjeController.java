package com.sep.tim2.erh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sep.tim2.erh.config.DatabaseUri;
import com.sep.tim2.erh.model.Osiguranje;
import com.sep.tim2.erh.model.OsiguranjeUplate;
import com.sep.tim2.erh.model.VrednostAtributaOsiguranja;
import com.sep.tim2.erh.service.OsiguranjeService;

@RestController
@RequestMapping("/osiguranja")
public class OsiguranjeController {

	private final RestTemplate restTemplate;
	private final DatabaseUri databaseUri;
	private final OsiguranjeService osiguranjeService;
	
	
	@Autowired
	public OsiguranjeController(RestTemplate restTemplate, DatabaseUri databaseUri,OsiguranjeService osiguranjeService) {
		this.restTemplate = restTemplate;
		this.databaseUri = databaseUri;
		this.osiguranjeService = osiguranjeService;
	}
	
	@PostMapping("/{tipOsiguranjaId}/{tipUplate}")
	@ResponseBody
	public String createOsiguranje(@RequestBody Osiguranje osiguranje, @PathVariable("tipOsiguranjaId")Long tipOsiguranjaId, @PathVariable("tipUplate")String tipUplate) {
		//Kreiranje osiguranja
		osiguranje = restTemplate.postForObject(databaseUri.getDatabaseUri() + "/osiguranja/" + tipOsiguranjaId, osiguranje, Osiguranje.class);
		//Kreiranje osiguranja za placanje
		OsiguranjeUplate osiguranjeUplate = osiguranjeService.prepareOsiguranje(osiguranje.getIznos(),osiguranje.getDatumSklapanja(),osiguranje.getId());
		restTemplate.postForObject(databaseUri.getDatabaseUri() + "/payment/osiguranja", osiguranjeUplate, OsiguranjeUplate.class);
		//Slanje osiguranja PaymentHandleru za kreiranje uplate
		return restTemplate.postForObject(databaseUri.getPaymentHandlerUri() + "/payment/" + tipUplate, osiguranjeUplate, String.class);
	}
	
	@PostMapping
	@ResponseBody
	public Double getCena(@RequestBody List<VrednostAtributaOsiguranja> listaVrednosti) {
		return restTemplate.postForObject(databaseUri.getPriceManagmentUri()+"/apii/jboosdrools/izracunajCenu", listaVrednosti, Double.class);
	}
	
}
;