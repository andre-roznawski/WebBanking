package de.telekom.sea7.services;

import org.springframework.stereotype.Service;

import de.telekom.sea7.base.Kunde;
import de.telekom.sea7.model.KundeImpl;

	@Service
	public class KundeService {

		private Kunde kunde;
		
		public KundeService() {
			kunde = new KundeImpl("Erika", "Mueller", "Hauptstr. 12", 67677, "Musterhausen");
		}
		
	//	public setKunde(String name, String vorname, String strasse_nr,
	//			int plz, String wohnort) {
		
		public Kunde getKunde() {
			return kunde;
		}

		public void setKunde(Kunde kunde) {
			this.kunde = kunde;
		}	
	
}
