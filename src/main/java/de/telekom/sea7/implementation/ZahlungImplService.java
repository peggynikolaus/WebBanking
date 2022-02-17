package de.telekom.sea7.implementation;

import org.springframework.stereotype.Service;

@Service
public class ZahlungImplService {
	private String empfaenger;
	private String iban;
	private String bic;
	private double betrag;
	private String waehrung;
	private String verwendungszweck;
	
	public ZahlungImplService() {
		this.empfaenger = "Testempfaenger";
		this.iban = "DE123456";
		this.bic = "PBNK5555";
		this.betrag = 33.50;
		this.waehrung = "Euro";
		this.verwendungszweck = "Testzweck";
		
	}

	public String getEmpfaenger() {
		return empfaenger;
	}

	public void setEmpfaenger(String empfaenger) {
		this.empfaenger = empfaenger;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public String getWaehrung() {
		return waehrung;
	}

	public void setWaehrung(String waehrung) {
		this.waehrung = waehrung;
	}

	public String getVerwendungszweck() {
		return verwendungszweck;
	}

	public void setVerwendungszweck(String verwendungszweck) {
		this.verwendungszweck = verwendungszweck;
	}
	
	

}
