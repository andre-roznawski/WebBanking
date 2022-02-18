package de.telekom.sea7.view;

import org.springframework.stereotype.Service;

import de.telekom.sea7.base.Zahlung;
import de.telekom.sea7.base.Zahlungen;
import de.telekom.sea7.model.ZahlungenImpl;


@Service
public class ZahlungenService {
	private Zahlungen<Zahlung> zahlungen = new ZahlungenImpl<Zahlung>();

	public Zahlungen<Zahlung> getZahlungen() {
		return zahlungen;
	}

	public void setZahlungen(Zahlungen<Zahlung> zahlungen) {
		this.zahlungen = zahlungen;
	}
	
}
