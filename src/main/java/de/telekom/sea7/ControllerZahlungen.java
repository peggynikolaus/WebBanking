package de.telekom.sea7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.implementation.ZahlungImplService;
import de.telekom.sea7.implementation.ZahlungenImplService;

@RestController
public class ControllerZahlungen {
	
	//Array für Testdaten erzeugen
	@Autowired
	ZahlungenImplService zahlungenList;  //ArryList leer
	
	//Methode um Testdaten ins Array zu schreiben
	@GetMapping ("/testdaten/{anzahl}")
	@ResponseBody
	public String createTestdata(@PathVariable(name="anzahl") int anzahl) {
		zahlungenList.addTestzahlungen(anzahl);
		return "Daten wurden erzeugt! <a href=\"/index.html\">Startseite</a>";
	}
	
	/** Methode Rest Schnittstelle zur Ausgabe aller Zahlungen aus der ArrayList als Json
	 *  durch @RestController wird der Inhalt ArrayList direkt als Json zurückgegeben (manuell siehe ViewImpl.java)
	 *  URL: http://localhost:8080/zahlungen/
	 */
	@GetMapping ("/zahlungen/")
	public ZahlungenImplService ausgabeZahlungen() {
		return zahlungenList;
	}
	
	@GetMapping ("/zahlung/{id}")
	public ZahlungImplService ausgabeZahlung(@PathVariable (name="id") int id) throws Exception {
		return zahlungenList.get(id);
	}
	
	@PostMapping("/zahlung/")
	public void addZahlung(@RequestBody ZahlungImplService zahlungNeu) {
		zahlungenList.addArrayList(zahlungNeu);
	}
	
	@PutMapping("/zahlung/{id}")
	public void updateZahlung(@PathVariable (name="id") int id, @RequestBody ZahlungImplService zahlungNeu)	{
		zahlungenList.delete(id);
		zahlungenList.addArrayList(zahlungNeu);
	}
		 
	
	/** 
	 * Schnittstelle zum Löschen eines Datensatzes aus der ArrayList
	 * Aufruf URL:
	 */
	@DeleteMapping ("/zahlung/{id}")
	public ZahlungImplService deleteZahlung(@PathVariable (name="id") int id)	{
		return zahlungenList.delete(id);
	}
}
