package com.sep.tim2.erh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sep.tim2.erh.config.DatabaseUri;
import com.sep.tim2.erh.model.TipOsiguranja;

@RestController
@RequestMapping("/tipoviOsiguranja")
public class TipOsiguranjaController {

	private final RestTemplate restTemplate;
	private final DatabaseUri databaseUri;
	
	@Autowired
	public TipOsiguranjaController(RestTemplate restTemplate, DatabaseUri databaseUri) {
		this.restTemplate = restTemplate;
		this.databaseUri = databaseUri;
	}
	
	@GetMapping("/{tipOsiguranjaId}")
	@ResponseBody
	public TipOsiguranja getTipOsiguranja(@PathVariable("tipOsiguranjaId")Long tipOsiguranjaId) {
		return restTemplate.getForObject(databaseUri.getDatabaseUri() + "/tipoviOsiguranja/" + tipOsiguranjaId, TipOsiguranja.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/zaOsiguravajucuKucu/{osiguravajucaKucaId}")
	@ResponseBody
	public List<TipOsiguranja> getTipoviOsiguranja(@PathVariable("osiguravajucaKucaId")Long osiguravajucaKucaId) {
		return restTemplate.getForObject(databaseUri.getDatabaseUri() + "/tipoviOsiguranja/zaOsiguravajucuKucu/" + osiguravajucaKucaId, List.class);
	}
	
}
