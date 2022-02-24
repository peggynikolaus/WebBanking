package de.telekom.sea7;

import java.time.LocalDateTime;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.implementation.ZahlungImplService;
import de.telekom.sea7.implementation.ZahlungenImplService;


@Controller 
	public class ViewImpl {

// Instanziierung von class ZahlungImplService mit Testdaten aus Constructor über @Autowired	
@Autowired
ZahlungImplService testdaten;

@Autowired
ZahlungenImplService uebersichtZahlungen; //Übernahme der ZahlungenImplService mit ArrayList ZahlungenList und allen Methoden und unter Objekt uebersichtZahlungen gespeichert

@GetMapping("/zahlung.json") // http://localhost:8080/zahlung.json
@ResponseBody
	public String getJson() {
		
	
	return "{"
			+ " \"empfaenger\": " + "\"" + testdaten.getEmpfaenger() + "\"" + ","
			+ " \"iban\": " + "\"" + testdaten.getIban() +"\"" + ","
			+ " \"bic\": " + "\"" + testdaten.getBic() + "\"" + ","
			+ " \"betrag\":" + "\"" + testdaten.getBetrag() + "\"" + ","
			+ " \"waehrung\": " + "\"" + testdaten.getWaehrung() + "\"" + ","
			+ " \"verwendungszweck\": " + "\"" + testdaten.getVerwendungszweck() + "\""
			+"}";
}

@GetMapping("/zahlungen.json") // http://localhost:8080/zahlungen.json
@ResponseBody
	public String multiJson() {
		uebersichtZahlungen.addTestzahlungen(10);  //hier lege ich die Anzahl der Testzahlungen fest
		
		int id = 1;  // Durchnummerierung der json Objekte/Testdaten (notwendig bei multiplen json-Ausgaben)
		
		String gesamtergebnis = "{"; // öffnet die Darstellung des json Pakets
	
	//generiert ein Iterator "zahlungIterator" = Zuweisung der Arraylist aus uebersichtZahlungen (siehe Zeile 24)
	Iterator<ZahlungImplService> zahlungIterator = uebersichtZahlungen.iterator();	
		
	//solange der Iterator ein weiteres Objekt in der ArrayList findet, führe das in den {} aus
	while (zahlungIterator.hasNext()) {
		ZahlungImplService temp = zahlungIterator.next();	// welcher Datentyp und Zwischenspeicher = hol das nächste Objekt raus
		String empfaenger = temp.getEmpfaenger();
		double betrag = temp.getBetrag();
		String waehrung = temp.getWaehrung();
		String zweck = temp.getVerwendungszweck();
		
		String zwischenergebnis = 
				"\""+ id + "\":{"
				+ " \"empfaenger\": " + "\"" + empfaenger + "\"" + ","
				+ " \"betrag\":" + "\"" + betrag + "\"" + ","
				+ " \"waehrung\": " + "\"" + waehrung + "\"" + ","
				+ " \"verwendungszweck\": " + "\"" + zweck + "\""
				+"}";
		gesamtergebnis = gesamtergebnis + zwischenergebnis;
		if (id<=uebersichtZahlungen.size()-1) {
			gesamtergebnis = gesamtergebnis + ","; //setze nach der letzten jsonTestdata kein Komma mehr
		}
			id++;
	}
	
	gesamtergebnis = gesamtergebnis + "}"; // die Zeile ist NUR dafür da das Paket json zu schließen
		
	return gesamtergebnis;
	}

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
	


