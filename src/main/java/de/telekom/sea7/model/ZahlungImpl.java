package de.telekom.sea7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import de.telekom.sea7.base.Iban;
import de.telekom.sea7.base.Zahlung;

@Entity
@Table(name = "zahlungen")
public class ZahlungImpl implements Zahlung {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int zahlung_id;
	@Column(name = "Empfaenger")
	private String empfaenger;
	@Column(name = "Betrag")
	private float betrag;
	@Column(name = "Verwendungszweck")
	private String verwendungszweck;
	@Column(name = "Echtzeitueberweisung")
	private boolean echtzeitueberweisung;
//	@Column(name = "iban_id")
//	private int ibanid;
	@ManyToOne
	@JoinColumn(name = "iban_id")
	private IbanImpl iban;

	public ZahlungImpl() {
	}

	public ZahlungImpl(int zahlung_id, String empfaenger, float betrag, String verwendungszweck,
			boolean echtzeitueberweisung, IbanImpl iban) {
		this.zahlung_id = zahlung_id;
		this.empfaenger = empfaenger;
		this.betrag = betrag;
		this.verwendungszweck = verwendungszweck;
		this.echtzeitueberweisung = echtzeitueberweisung;
		this.iban = iban;
	}

	public void setZahlung(int zahlung_id, String empfaenger, float betrag, String verwendungszweck,
			boolean echtzeitueberweisung, IbanImpl iban) {
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

//	public int getIbanid() {
//		return ibanid;
//	}
//
//	public void setIbanid(int ibanid) {
//		this.ibanid = ibanid;
//	}

	public IbanImpl getIban() {
		return iban;
	}

	public void setIban(IbanImpl iban) {
		this.iban = iban;
	}
}