package de.telekom.sea7.view;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.base.Iban;
import de.telekom.sea7.base.Kunde;
import de.telekom.sea7.base.Zahlung;
import de.telekom.sea7.base.Zahlungen;
import de.telekom.sea7.model.IbanImpl;
import de.telekom.sea7.model.KundeImpl;
import de.telekom.sea7.model.ZahlungImpl;
import de.telekom.sea7.propertySettingsConfiguration.BankConfiguration;
import de.telekom.sea7.services.KundeService;
import de.telekom.sea7.services.ZahlungenService;

@Controller
public class ViewImpl {

//	@Autowired
//	Zahlung zahlung;

//	@Autowired
//	Zahlungen<Zahlung> zahlungen;

	@Autowired
	ZahlungenService zahlungenService;
	@Autowired
	KundeService kundeService;
	@Autowired
	private BankConfiguration bankConfiguration;

//	@GetMapping("/index.html")
//	@ResponseBody
//	public String getHtml() {
//		zahlung.setZahlung(1, "Erika Mueller", 612.78f, "Rechnung Fitnessstudio", false, "DE123456789");
//		/* Im "Browser" ausgeben (statt System.out) */
//		String head = "<!doctype html>" + "<html>" + " <head>" + " <title>WebBanking</title>"
//				+ "<meta charset=\"UTF-8\">" + " <link href=\"index.css\" rel=\"stylesheet\">"
//				// + "<script>" + getJS() + "</script>"
//				+ "<script>console.log('ZahlungID: '" + getJSON() + ".zahlung_id)" + "</script>" // "+getJSON()+".zahlung_id)"
//																									// + "</script>"
//				// + "<script src=\"index.js\" type=\"module\"></script>"
//				+ " </head>";
//		String body = " <body>" + "<span id='emph1'> <h1>Welcome to WebBanking</h1> </span>" + "started on "
//		// + zahlung.getEmpfaenger()+ zahlung.getBetrag()+ zahlung.getVerwendungszweck()
//				+ LocalDateTime.now().toString() + "</body>";
//		// String script = "<script>" + getJS() + "</script>";
//		String end = "</html>";
//		String html = head + body + end;
//
//		return html;
//	}
	
	@GetMapping("/index5.html")
	@ResponseBody
	public String getHtml() {
		String head = "<!doctype html>" + "<html>" + " <head>" + " <title>" + this.bankConfiguration.getBankname() + "</title>"
				+ "<meta charset=\"UTF-8\">" + " <link href=\"index.css\" rel=\"stylesheet\">"
			    + "</script>"
				 + "<script src=\"index.js\" type=\"module\"></script>"
				+ " </head>";
		String body = " <body>" + "<span id='emph1'> <h1>Welcome to WebBanking</h1> </span>" + "</body>";
//		// String script = "<script>" + getJS() + "</script>";
		String end = "</html>";
		String html = head + body + end;
		return html;
	}

//	@GetMapping("/index.css")
//	@ResponseBody
//	public String getCSS() {
//		/* Im "Browser" ausgeben (statt System.out) */
//		String css = "#emph1 { color:green; background-color:cdef00 } " + "#emph2 { border: 1px; solid blue } "
//				+ "#emph3 { color:red; background-color:grey } ";
//		return css;
//	}
//
//	@GetMapping("/index.js")
//	@ResponseBody
//	public String getJS() {
//		/* Im "Browser" ausgeben (statt System.out) */
//		String js = "console.log('Hi, here is js speaking')";
//		return js;
//	}

	@GetMapping("/index.json")
	@ResponseBody
	public String getJSON() {
//		Iban iban0 = new IbanImpl();
//		Zahlung zahlung1 = new ZahlungImpl();
//		Zahlung zahlung2 = new ZahlungImpl();
//		Zahlung zahlung3 = new ZahlungImpl();
//		zahlung1.setZahlung(1, "Erika Mueller", 612.78f, "Rechnung Fitnessstudio", false, iban0);
//		zahlungenService.getZahlungen().setListe(zahlung1, zahlung1.getZahlung_id());
//		zahlung2.setZahlung(2, "Sepp Herberger", 88.88f, "Jahresabo Bildzeitung", true, iban0);
//		zahlungenService.getZahlungen().setListe(zahlung2, zahlung2.getZahlung_id());
//		zahlung3.setZahlung(3, "Lisa Dunkel", 9.32f, "Strafzettel Parken", false, iban0);
//		zahlungenService.getZahlungen().setListe(zahlung3, zahlung3.getZahlung_id());
		/* Im "Browser" ausgeben (statt System.out) */
		String json = "[";
		for (int i = 1; i <= zahlungenService.getZahlungen().size(); i++) {
			json = json + "{\"Zahlung_id\": \"" + zahlungenService.getZahlungen().get(i).getZahlung_id()
					+ "\",\"Empfaenger\": \"" + zahlungenService.getZahlungen().get(i).getEmpfaenger()
					+ "\",\"Betrag\": \"" + zahlungenService.getZahlungen().get(i).getBetrag()
					+ "\",\"Verwendungszweck\": \"" + zahlungenService.getZahlungen().get(i).getVerwendungszweck()
					+ "\",\"Echtzeitueberweisung\": \""
					+ zahlungenService.getZahlungen().get(i).getEchtzeitueberweisung() + "\",\"IBAN\": \""
					+ zahlungenService.getZahlungen().get(i).getIban() + "\"}";
			if (i < (zahlungenService.getZahlungen().size()))
				json = json + ",";
		}
		json = json + "]";
		return json;
	}

	@PostMapping("/JSON/index1.json")
	@ResponseBody
	public void postJSON(String json) {
		Zahlung zahlung1 = new ZahlungImpl();
		// zahlung1.setZahlung(, "Erika Mueller", 612.78f, "Rechnung Fitnessstudio",
		// false, "DE123456789");
	}
	
	@GetMapping("/index11.html")
	public String gethtml11(Model model) {
	//	Kunde kunde1 = new KundeImpl();
	//	kunde1.setKunde("Erika", "Mueller", "Hauptstr. 12", 67677, "Musterhausen");
			model.addAttribute("titel", this.bankConfiguration.getBankname());
            model.addAttribute("name", kundeService.getKunde().getName());
            model.addAttribute("vorname", kundeService.getKunde().getVorname());
            model.addAttribute("strasse_nr", kundeService.getKunde().getStrasse_nr());
            model.addAttribute("plz", kundeService.getKunde().getPlz());
            model.addAttribute("wohnort", kundeService.getKunde().getWohnort());    
            
		return "index11";
	}
}