package de.telekom.sea7.implementation;

import org.springframework.stereotype.Service;
import de.telekom.sea7.implementation.ZahlungImplService;
import java.util.ArrayList;
import java.util.Iterator;


@Service
public class ZahlungenImplService {
		
		private ArrayList <ZahlungImplService> zahlungenList = new ArrayList<>();
		
		//Testdaten erzeugen
		public void addTestzahlungen(int anzahl) {
			int tester = 1;
			for(int i = 0; i<anzahl; i++) {		// Schleife erwartet eine Anzahl welche bei Aufruf der Methode angefordert wird
				ZahlungImplService testdaten = new ZahlungImplService();
				testdaten.setEmpfaenger("Tester " + tester);
				testdaten.setBetrag(tester + tester + tester + 0.7);
				testdaten.setWaehrung("Euro");
				testdaten.setVerwendungszweck("Testzweck " + tester);
			zahlungenList.add(testdaten);
			tester++;
			}
		}
		
		//Standard get-Methode ist zwingend notwendig
		public ArrayList<ZahlungImplService> getZahlungenList() {
			return zahlungenList;
		}



		public void setZahlungenList(ArrayList<ZahlungImplService> zahlungenList) {
			this.zahlungenList = zahlungenList;
		}



		public void addArrayList(ZahlungImplService addZahlung) {
			zahlungenList.add(addZahlung);
			}
	
		public int size() {
			return zahlungenList.size();
		}
		
		public Iterator iterator() {
			return zahlungenList.iterator();
		}
		
		public ZahlungImplService get(int position) throws Exception {
			if (zahlungenList.size() >= position && position >= 0) {
				position = position -1;
				return zahlungenList.get(position);
			} else {
			throw new Exception(); 
				
			}
		}	
		
		public ZahlungImplService delete(int position) {
			return zahlungenList.remove(position);
		}
		
}







