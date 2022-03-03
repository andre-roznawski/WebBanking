package de.telekom.sea7.base;

import org.springframework.stereotype.Component;

import de.telekom.sea7.model.IbanImpl;
@Component
public interface Zahlung {

	int getZahlung_id();

	void setZahlung_id(int zahlung_id);

	String getEmpfaenger();

	void setEmpfaenger(String empfaenger);

	float getBetrag();

	void setBetrag(float betrag);

	String getVerwendungszweck();

	void setVerwendungszweck(String verwendungszweck);

	boolean getEchtzeitueberweisung();

	void setEchtzeitueberweisung(boolean echtzeitueberweisung);

	IbanImpl getIban();

	void setIban(IbanImpl iban);
	
	void setZahlung(int zahlung_id, String empfaenger, float betrag, String verwendungszweck,
			boolean echtzeitueberweisung, IbanImpl iban);

}