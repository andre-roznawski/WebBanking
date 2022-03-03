package de.telekom.sea7.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.base.ZahlungWeb;
import de.telekom.sea7.base.Zahlungen;
import de.telekom.sea7.services.ZahlungenService;

@RestController
public class ZahlungenController {

	// GET, POST, PUT, DELETE
	// READ, CREATE, UPTDATE, DELETE
	// @Autowired

	/**
	 * Alle Zahlungen
	 * 
	 * 
	 */

	@Autowired
	ZahlungenService zahlungenService;

//	@GetMapping("/zahlung/")
//	public Zahlungen<ZahlungWeb> getZahlungen() {
//		ZahlungWeb zahlung1 = new ZahlungWebImpl();
//		ZahlungWeb zahlung2 = new ZahlungWebImpl();
//		ZahlungWeb zahlung3 = new ZahlungWebImpl();
//		zahlung1.setZahlung(1, "Erika Mueller", 612.78f, "Rechnung Fitnessstudio", false, "DE123456789");
//		zahlungenService.getZahlungen().setListe(zahlung1, zahlung1.getZahlung_id());
//		zahlung2.setZahlung(3, "Sepp Herberger", 88.88f, "Jahresabo Bildzeitung", true, "DE9988776655");
//		zahlungenService.getZahlungen().setListe(zahlung2, zahlung2.getZahlung_id());
//		zahlung3.setZahlung(5, "Lisa Dunkel", 9.32f, "Strafzettel Parken", false, "DE5574531289");
//		zahlungenService.getZahlungen().setListe(zahlung3, zahlung3.getZahlung_id());
//		return zahlungenService.getZahlungen();
//	}

	/**
	 * Eine Zahlung, aber welche?
	 * 
	 * 
	 */
//	@GetMapping("/zahlung/{zahlung}/")
//	public ZahlungWeb getZahlung(@PathVariable("zahlung") int zahlung) {
//		ZahlungWeb zahlung0 = new ZahlungWebImpl();
//		ZahlungWeb zahlung1 = new ZahlungWebImpl();
//		ZahlungWeb zahlung2 = new ZahlungWebImpl();
//		ZahlungWeb zahlung3 = new ZahlungWebImpl();
//		zahlung0.setZahlung(0, "", 0f, "", false, "");
//		zahlungenService.getZahlungen().setListe(zahlung1, zahlung1.getZahlung_id());
//		zahlung1.setZahlung(1, "Erika Mueller", 612.78f, "Rechnung Fitnessstudio", false, "DE123456789");
//		zahlungenService.getZahlungen().setListe(zahlung1, zahlung1.getZahlung_id());
//		zahlung2.setZahlung(3, "Sepp Herberger", 88.88f, "Jahresabo Bildzeitung", true, "DE9988776655");		zahlungenService.getZahlungen().setListe(zahlung2, zahlung2.getZahlung_id());
//		zahlung3.setZahlung(5, "Lisa Dunkel", 9.32f, "Strafzettel Parken", false, "DE5574531289");
//		zahlungenService.getZahlungen().setListe(zahlung3, zahlung3.getZahlung_id());
//		if (zahlungenService.getZahlungen().get(zahlung) == null) {
//			return zahlung0;
//		} else {
//			return zahlungenService.getZahlungen().get(zahlung);
//		}
//	}
	// "RequestBody" <-> "ResponseBody"

//	@PostMapping("/zahlung/")
//	public ZahlungWeb addZahlung(@RequestBody ZahlungWebImpl zahlung) {
//		System.out.println(zahlung.getZahlung_id() + zahlung.getEmpfaenger() + zahlung.getBetrag()
//				+ zahlung.getVerwendungszweck() + zahlung.getEchtzeitueberweisung() + zahlung.getIban());
//		zahlungenService.getZahlungen().setListe(zahlung, zahlung.getZahlung_id());
//		return null;
//	}

//	@PutMapping("/zahlung/{zahlung_id}/")
//	public ZahlungWeb updateZahlungImpl(@RequestBody ZahlungWebImpl zahlung, @PathVariable("zahlung_id") int zahlung_id) {
//		System.out.println(zahlung.getZahlung_id() + zahlung.getEmpfaenger() + zahlung.getBetrag()
//				+ zahlung.getVerwendungszweck() + zahlung.getEchtzeitueberweisung() + zahlung.getIban());
//		zahlungenService.getZahlungen().setListe(zahlung, zahlung_id);
//		return null;
//	}
//
//	@DeleteMapping("/zahlung/{zahlung_id}/")
//	public ZahlungWeb deleteZahlung(@PathVariable("zahlung_id") int zahlung_id) {
//		ZahlungWeb zahlung0 = new ZahlungWebImpl();
//		zahlung0.setZahlung(0, "", 0f, "", false, "");
//		zahlungenService.getZahlungen().setListe(null, zahlung_id);
//		return zahlung0;
//	}
}