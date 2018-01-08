
//author Matthias Westermeyer

package Rechnung;


import java.util.Date;

public class Rechnung {
	
	public String benutzername;
	public int rechnungsnummer;

	public int rechnungsbetrag;
	public String rechnungsdatum;
	public String bezahlmethode;
	public String streckenname;
	public String kartname;
	
	public String getBenutzername() {
		return benutzername;
	}
	public int getRechnungsnummer() {
		return rechnungsnummer;
	}
	public void setRechnungsnummer(int rechnungsnummer) {
		this.rechnungsnummer = rechnungsnummer;
	}
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}
	public int getRechnungsbetrag() {
		return rechnungsbetrag;
	}
	public void setRechnungsbetrag(int rechnungsbetrag) {
		this.rechnungsbetrag = rechnungsbetrag;
	}
	public String getRechnungsdatum() {
		return rechnungsdatum;
	}
	public void setRechnungsdatum(String date) {
		this.rechnungsdatum = date;
	}
	public String getBezahlmethode() {
		return bezahlmethode;
	}
	public void setBezahlmethode(String bezahlmethode) {
		this.bezahlmethode = bezahlmethode;
	}
	public String getStreckenname() {
		return streckenname;
	}
	public void setStreckenname(String streckenname) {
		this.streckenname = streckenname;
	}
	public String getKartname() {
		return kartname;
	}
	public void setKartname(String kartname) {
		this.kartname = kartname;
	}

	
	

}