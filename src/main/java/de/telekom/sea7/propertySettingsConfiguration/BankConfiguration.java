package de.telekom.sea7.propertySettingsConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BankConfiguration {

	@Value("${de.telekom.sea7.bankname}")
	private String bankname; // <- "Telekom-Bank"

	@Value("${server.port}")
	private int port;
	
	public String getBankname() {
		return bankname;
	}

	private void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public BankConfiguration() {
		
	}
}