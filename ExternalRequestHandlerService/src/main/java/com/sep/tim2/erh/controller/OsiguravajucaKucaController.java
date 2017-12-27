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
import com.sep.tim2.erh.model.OsiguravajucaKuca;

@RestController
@RequestMapping(value="/osiguravajuceKuce")
public class OsiguravajucaKucaController {
	
	private final DatabaseUri databaseUri;
	private final RestTemplate restTemplate;
	
	@Autowired
	public OsiguravajucaKucaController(RestTemplate restTemplate, DatabaseUri databaseUri) {
		this.databaseUri = databaseUri;
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/{osiguravajucaKucaId}")
	public OsiguravajucaKuca vratiOsiguravajucuKucu(@PathVariable("osiguravajucaKucaId")Long osiguravajucaKucaId){
		return restTemplate.getForObject(databaseUri.getDatabaseUri() + "/osiguravajuceKuce/"+osiguravajucaKucaId, OsiguravajucaKuca.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping()
	@ResponseBody
	public List<OsiguravajucaKuca> getOsiguravajuceKuce() {
		return restTemplate.getForObject(databaseUri.getDatabaseUri() + "/osiguravajuceKuce", List.class);
	}
	
}
