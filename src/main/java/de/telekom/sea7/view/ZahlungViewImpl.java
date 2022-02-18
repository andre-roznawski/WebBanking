package de.telekom.sea7.view;

import de.telekom.sea7.base.Zahlung;
import de.telekom.sea7.base.ZahlungView;
import de.telekom.sea7.model.ZahlungImpl;

public class ZahlungViewImpl implements ZahlungView {

	private Zahlung zahlung = new ZahlungImpl();

	@Override
	public Zahlung getZahlung() {
		return zahlung;
	}

	@Override
	public void setZahlung(Zahlung zahlung) {
		this.zahlung = zahlung;
	}

	@Override
	public void printView(Zahlung zahlung) {
		System.out.println();
		System.out.println("Zahlung-ID: " + zahlung.getZahlung_id());
		System.out.println("Empfänger: " + zahlung.getEmpfaenger());
		System.out.println("Betrag: " + zahlung.getBetrag());
		System.out.println("Verwendungszweck: " + zahlung.getVerwendungszweck());
		System.out.println("Echtzeitüberweisung? " + zahlung.getEchtzeitueberweisung());
		System.out.println("IBAN: " + zahlung.getIban());

	}

}
