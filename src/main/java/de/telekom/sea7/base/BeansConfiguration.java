package de.telekom.sea7.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.telekom.sea7.model.ZahlungImpl;
import de.telekom.sea7.model.ZahlungenImpl;

@Configuration
public class BeansConfiguration {

	@Bean //("name" = zahlung)
	public Zahlung zahlung() {
		return new ZahlungImpl();
	}
	
//	@Bean //("name" = zahlung)
//	public ZahlungView zahlungview() {
//		return new ZahlungViewImpl();
//	}
	@Bean
	public Zahlungen[] zahlungen() {
		return ((Zahlungen[]) new ZahlungenImpl[9]);
	}
}