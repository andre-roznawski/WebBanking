package de.telekom.sea7.view;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.base.Zahlung;

@Controller
public class ViewImpl {

	@Autowired
	Zahlung zahlung;

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
		zahlung.setZahlung(1, "Erika Mueller", 612.78f, "Rechnung Fitnessstudio", false, "DE123456789");
		/* Im "Browser" ausgeben (statt System.out) */
		String json = "{\"Zahlung_id\": \"" + zahlung.getZahlung_id() + "\",\"Empfaenger\": \"" + zahlung.getEmpfaenger()
		+ "\",\"Betrag\": \"" + zahlung.getBetrag() + "\",\"Verwendungszweck\": \"" + zahlung.getVerwendungszweck()
		+ "\",\"Echtzeitueberweisung\": \"" + zahlung.getEchtzeitueberweisung()
		+ "\",\"IBAN\": \"" + zahlung.getIban() + "\"}";
		return json;
	}
}
