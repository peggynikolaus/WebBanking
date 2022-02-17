package de.telekom.sea7;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.implementation.ZahlungImplService;

@Controller 
	public class ViewImpl {

// Instanziierung von class ZahlungImplService mit Testdaten aus Constructor über @Autowired	
@Autowired
	ZahlungImplService testdaten;

@GetMapping("/zahlung.json") // http://localhost:8080/zahlung.json
@ResponseBody
	public String getJson() {
		
	
	
	return "{"
			//+ " \"zahlung\": {"
			+ " \"empfaenger\": " + "\"" + testdaten.getEmpfaenger() + "\"" + ","
			+ " \"iban\": " + "\"" + testdaten.getIban() +"\"" + ","
			+ " \"bic\": " + "\"" + testdaten.getBic() + "\"" + ","
			+ " \"betrag\":" + "\"" + testdaten.getBetrag() + "\"" + ","
			+ " \"waehrung\": " + "\"" + testdaten.getWaehrung() + "\"" + ","
			+ " \"verwendungszweck\": " + "\"" + testdaten.getVerwendungszweck() + "\""
			//+"},"
			+"}";
		
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	/* Übungsmethode HTML und CSS ohne direkten Bezug auf WebBanking
		@GetMapping("/index.html")
		@ResponseBody
		public String getHtml() {
			/* Im "Browser" ausgeben (statt System.out) 
			String body = LocalDateTime.now().toString();
			String html = "<!doctype html>" 
			+ "<html>" 
					+ " <head>" 
			+ " <title>Testsite</title>" 
					+ " </head>"
					+ " <body>" 
					//+ "<h1> Hello Peg </h1>"
					+ body + " </body>" 
					+ "</html>";
			return html;
		}
		
		@GetMapping("/index.css")
		@ResponseBody
		public String getCSS() {
			String css = "<@charset UTF-8>"
				+ ""
				+ "";
			return css;
			
		}
		*/
	}


