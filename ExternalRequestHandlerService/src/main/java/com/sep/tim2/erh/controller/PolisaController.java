package com.sep.tim2.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sep.tim2.erh.model.Polisa;

@RestController
@RequestMapping("/polise")
public class PolisaController {
	
	@Autowired
	private DatabaseUri databaseUri;
	
	private RestTemplate template;
	
	public PolisaController(){
		template = new RestTemplate();
	}
	
	@RequestMapping(method=RequestMethod.POST, 
					produces = MediaType.APPLICATION_JSON_VALUE,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Polisa novaPolisa(@RequestBody Polisa polisa){
		
		// Tu ide kod za validaciji (provera autenticnosti)
		
		//Slanje polisa ka DataAccessService
		return template.postForObject(databaseUri.getDatabaseUri() + "/polise/1", polisa, Polisa.class);
	}
}
