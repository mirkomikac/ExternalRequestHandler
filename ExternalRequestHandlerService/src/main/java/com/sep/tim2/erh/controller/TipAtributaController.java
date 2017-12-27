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
import com.sep.tim2.erh.model.TipAtributa;

@RestController
@RequestMapping("/tipoviAtributa")
public class TipAtributaController {
	
	private final RestTemplate restTemplate;
	private final DatabaseUri databaseUri;
	
	@Autowired
	public TipAtributaController(RestTemplate restTemplate, DatabaseUri databaseUri) {
		this.restTemplate = restTemplate;
		this.databaseUri = databaseUri;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/zaTipOsiguranja/{tipOsiguranjaId}")
	@ResponseBody
	public List<TipAtributa> getTipoviAtributaZaTipOsiguranja(@PathVariable("tipOsiguranjaId")Long tipOsiguranjaId) {
		return restTemplate.getForObject(databaseUri.getDatabaseUri() + "/tipoviAtributa/zaTipOsiguranja/" + tipOsiguranjaId, List.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/zaKontekst/{kontekstAtributaId}")
	@ResponseBody
	public List<TipAtributa> getTipoviAtributaZaKontekstAtributa(@PathVariable("kontekstAtributaId")Long kontekstAtributaId) {
		return restTemplate.getForObject(databaseUri.getDatabaseUri() + "/tipoviAtributa/zaKontekst/" + kontekstAtributaId, List.class);
	}
	
}
