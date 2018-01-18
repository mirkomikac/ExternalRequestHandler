package com.sep.tim2.erh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUri {
	
	@Value("${spring.data.database}")
	private String databaseUri;
	
	@Value("${spring.data.paymentHandler}")
	private String paymentHandlerUri;
	

	public String getPaymentHandlerUri() {
		return paymentHandlerUri;
	}

	public void setPaymentHandlerUri(String paymentHandlerUri) {
		this.paymentHandlerUri = paymentHandlerUri;
	}

	public String getDatabaseUri() {
		return databaseUri;
	}

	public void setDatabaseUri(String databaseUri) {
		this.databaseUri = databaseUri;
	}
}
