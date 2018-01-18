package com.sep.tim2.erh.controller;

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
	
	@PostMapping("/{tipOsiguranjaId}")
	@ResponseBody
	public Osiguranje createOsiguranje(@RequestBody Osiguranje osiguranje, @PathVariable("tipOsiguranjaId")Long tipOsiguranjaId) {
		//Kreiranje osiguranja
		restTemplate.postForObject(databaseUri.getDatabaseUri() + "/osiguranja/" + tipOsiguranjaId, osiguranje, Osiguranje.class);
		//Kreiranje osiguranja za placanje
		OsiguranjeUplate osiguranjeUplate = osiguranjeService.prepareOsiguranje(osiguranje.getIznos(),osiguranje.getDatumSklapanja(),osiguranje.getId());
		restTemplate.postForObject(databaseUri.getDatabaseUri() + "/payment/osiguranja/" + tipOsiguranjaId, osiguranje, Osiguranje.class);
		//Slanje osiguranja PaymentHandleru za kreiranje uplate
		restTemplate.postForObject(databaseUri.getPaymentHandlerUri() + "/payment/"/*+cena*/, osiguranjeUplate, OsiguranjeUplate.class);
		return osiguranje;

	}
	
}