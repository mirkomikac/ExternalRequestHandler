package com.sep.tim2.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sep.tim2.erh.model.OsiguravajucaKuca;
import com.sep.tim2.erh.rest.client.OsiguravajucaKucaClient;

@RestController
@RequestMapping(value="/osiguravajuceKuce")
public class OsiguravajucaKucaController {
	
	@Autowired
	private DatabaseUri databaseUri;
	
	@GetMapping("/{osiguravajucaKucaId}")
	public OsiguravajucaKuca vratiOsiguravajucuKucu(@PathVariable("osiguravajucaKucaId")Long osiguravajucaKucaId){
		OsiguravajucaKucaClient okc = new OsiguravajucaKucaClient();
		OsiguravajucaKuca ok = okc.sendOsiguravajucaKuca(databaseUri, osiguravajucaKucaId);
		return ok;
	}
	
}
