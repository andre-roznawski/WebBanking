package de.telekom.sea7.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.telekom.sea7.view.ZahlungImpl;
import de.telekom.sea7.view.ZahlungViewImpl;

@Configuration
public class BeansConfiguration {

	@Bean //("name" = zahlung)
	public Zahlung zahlung() {
		return new ZahlungImpl();
	}
	
	@Bean //("name" = zahlung)
	public ZahlungView zahlungview() {
		return new ZahlungViewImpl();
	}
}
