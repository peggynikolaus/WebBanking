package de.telekom.sea7.implementation;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // die Annotation gibt an, dass das Objekt von Spring Data verwaltet wird und dass seine Attribute in Spalten von DB-Tabellen konvertiert werden
public class ZahlungEntity {
	
	@Id // gibt an, dass das Attribut als Primärschlüssel in der Tabelle verwendet werden soll, die der Entität entspricht
	@GeneratedValue(strategy = GenerationType.IDENTITY) // gibt an dass der Wert der ID beim Einfügen in die Datenbank automatisch und inkrementell generiert wird
	
	private Long id;
	
	@Column(name="empfaenger")
	private String empfaenger;
	@Column(name="iban")
	private String iban;
	@Column(name="bic")
	private String bic;
	@Column(name="betrag")
	private double betrag;
	@Column(name="waehrung")
	private String waehrung;
	@Column(name="verwendungszweck")
	private String verwendungszweck;
	
	// ein leerer Konstruktor sowie alle Getter/Setter: Dank ihnen kann eine Instanz der Entität automatisch vom Repository erstellt werden
	public ZahlungEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
