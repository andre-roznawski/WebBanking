package de.telekom.sea7.model;

import de.telekom.sea7.base.Zahlung;

public class ZahlungImpl implements Zahlung {

	private int zahlung_id;
	private String empfaenger;
	private float betrag;
	private String verwendungszweck;
	private boolean echtzeitueberweisung;
	private String iban;

	public ZahlungImpl() {

	}

	public ZahlungImpl(int zahlung_id, String empfaenger, float betrag, String verwendungszweck,
			boolean echtzeitueberweisung, String iban) {
		this.zahlung_id = zahlung_id;
		this.empfaenger = empfaenger;
		this.betrag = betrag;
		this.verwendungszweck = verwendungszweck;
		this.echtzeitueberweisung = echtzeitueberweisung;
		this.iban = iban;
	}

	public void setZahlung(int zahlung_id, String empfaenger, float betrag, String verwendungszweck,
			boolean echtzeitueberweisung, String iban) {
		this.zahlung_id = zahlung_id;
		this.empfaenger = empfaenger;
		this.betrag = betrag;
		this.verwendungszweck = verwendungszweck;
		this.echtzeitueberweisung = echtzeitueberweisung;
		this.iban = iban;
	}
	
	
	@Override
	public int getZahlung_id() {
		return zahlung_id;
	}

	@Override
	public void setZahlung_id(int zahlung_id) {
		this.zahlung_id = zahlung_id;
	}

	@Override
	public String getEmpfaenger() {
		return empfaenger;
	}

	@Override
	public void setEmpfaenger(String empfaenger) {
		this.empfaenger = empfaenger;
	}

	@Override
	public float getBetrag() {
		return betrag;
	}

	@Override
	public void setBetrag(float betrag) {
		this.betrag = betrag;
	}

	@Override
	public String getVerwendungszweck() {
		return verwendungszweck;
	}

	@Override
	public void setVerwendungszweck(String verwendungszweck) {
		this.verwendungszweck = verwendungszweck;
	}

	@Override
	public boolean getEchtzeitueberweisung() {
		return echtzeitueberweisung;
	}

	@Override
	public void setEchtzeitueberweisung(boolean echtzeitueberweisung) {
		this.echtzeitueberweisung = echtzeitueberweisung;
	}

	@Override
	public String getIban() {
		return iban;
	}

	@Override
	public void setIban(String iban) {
		this.iban = iban;
	}
	

}
