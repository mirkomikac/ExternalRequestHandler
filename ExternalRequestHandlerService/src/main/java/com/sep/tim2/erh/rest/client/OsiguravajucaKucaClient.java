package com.sep.tim2.erh.rest.client;

import org.springframework.web.client.RestTemplate;

import com.sep.tim2.erh.config.DatabaseUri;
import com.sep.tim2.erh.model.OsiguravajucaKuca;

public class OsiguravajucaKucaClient {
	
	public OsiguravajucaKuca sendOsiguravajucaKuca(DatabaseUri databaseUri, Long osiguravajucaKucaId){
		
		RestTemplate restTemplate = new RestTemplate();
		OsiguravajucaKuca ok = (OsiguravajucaKuca)restTemplate
				.getForObject(databaseUri.getDatabaseUri() + "/osiguravajuceKuce/"+osiguravajucaKucaId, OsiguravajucaKuca.class);
		System.out.println(ok.toString() + "poslata");
		return ok;
	}
	
}
