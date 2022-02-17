package de.telekom.sea7.base;

public interface ZahlungView {

	Zahlung getZahlung();

	void setZahlung(Zahlung zahlung);

	void printView(Zahlung zahlung);

}