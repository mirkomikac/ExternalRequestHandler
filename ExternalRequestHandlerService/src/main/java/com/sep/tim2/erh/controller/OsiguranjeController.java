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

@RestController
@RequestMapping("/osiguranja")
public class OsiguranjeController {

	private final RestTemplate restTemplate;
	private final DatabaseUri databaseUri;
	
	@Autowired
	public OsiguranjeController(RestTemplate restTemplate, DatabaseUri databaseUri) {
		this.restTemplate = restTemplate;
		this.databaseUri = databaseUri;
	}
	
	@PostMapping("/{tipOsiguranjaId}")
	@ResponseBody
	public Osiguranje createOsiguranje(@RequestBody Osiguranje osiguranje, @PathVariable("tipOsiguranjaId")Long tipOsiguranjaId) {
		return restTemplate.postForObject(databaseUri.getDatabaseUri() + "/osiguranja/" + tipOsiguranjaId, osiguranje, Osiguranje.class);
	}
	
}
