package de.telekom.sea7.view;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.base.Zahlung;
import de.telekom.sea7.base.Zahlungen;
import de.telekom.sea7.model.ZahlungImpl;

@Controller
public class ViewImpl {

//	@Autowired
//	Zahlung zahlung;
	
//	@Autowired
//	Zahlungen<Zahlung> zahlungen;
	
	@Autowired
	ZahlungenService zahlungenService;
	
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

	@GetMapping ("/index.json")
	@ResponseBody
	public String getJSON() {
		Zahlung zahlung1 = new ZahlungImpl();
		Zahlung zahlung2 = new ZahlungImpl();
		Zahlung zahlung3 = new ZahlungImpl();
		zahlung1.setZahlung(1, "Erika Mueller", 612.78f, "Rechnung Fitnessstudio", false, "DE123456789");
		zahlungenService.getZahlungen().setListe(zahlung1, zahlung1.getZahlung_id());
		zahlung2.setZahlung(2, "Sepp Herberger", 88.88f, "Jahresabo Bildzeitung", true, "DE9988776655");
		zahlungenService.getZahlungen().setListe(zahlung2, zahlung2.getZahlung_id());
		zahlung3.setZahlung(3, "Lisa Dunkel", 9.32f, "Strafzettel Parken", false, "DE5574531289");
		zahlungenService.getZahlungen().setListe(zahlung3, zahlung3.getZahlung_id());
		/* Im "Browser" ausgeben (statt System.out) */
		String json = "[";
		for (int i = 1; i <= zahlungenService.getZahlungen().size(); i++) {
		json = json + "{\"Zahlung_id\": \"" + zahlungenService.getZahlungen().get(i).getZahlung_id() + "\",\"Empfaenger\": \"" 
		+ zahlungenService.getZahlungen().get(i).getEmpfaenger()
		+ "\",\"Betrag\": \"" + zahlungenService.getZahlungen().get(i).getBetrag() + "\",\"Verwendungszweck\": \"" 
		+ zahlungenService.getZahlungen().get(i).getVerwendungszweck()
		+ "\",\"Echtzeitueberweisung\": \"" + zahlungenService.getZahlungen().get(i).getEchtzeitueberweisung()
		+ "\",\"IBAN\": \"" + zahlungenService.getZahlungen().get(i).getIban() + "\"}";
		if(i < (zahlungenService.getZahlungen().size())) json = json + ",";
		}
		json = json + "]";
		return json;
		
	}
}
