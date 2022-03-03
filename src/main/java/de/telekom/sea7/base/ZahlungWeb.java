package de.telekom.sea7.base;

public interface ZahlungWeb {

	void setZahlung(int zahlung_id, String empfaenger, float betrag, String verwendungszweck,
			boolean echtzeitueberweisung, String iban);

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

	String getIban();

	void setIban(String iban);

}