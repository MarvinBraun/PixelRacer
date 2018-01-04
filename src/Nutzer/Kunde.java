package Nutzer;
/**
 * Klasse der Entität Kunde, Subtyp der Klasse Nutzer.
 * @author Daniel Zeller
 *
 */

public class Kunde extends Nutzer { //Kunde ist ein Nutzer des Systems
	private String premium; //Deklaration der benötigten Variablen
	private int punkte = 0;

	public String getvn() { //Getter und Setter der Variablen von Kunde/Nutzer
		return vorname;
		}
	
	public void setvn(String vorname) {
		this.vorname = vorname;
	}
	
	public String getnn() {
		return nachname;
	}
	
	public void setnn(String nachname) {
		this.nachname = nachname;
	}
	
	public String getnutzername() {
		return nutzername;
	}
	
	public void setnutzername(String nutzername) {
		this.nutzername = nutzername;
	}
	
	public String getpasswort() {
		return passwort;
	}
	
	public void setpasswort(String pw) {
		this.passwort = pw;
	}
	
	public String getemail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	public String getgebdat() {
		return gebdat;
	}
	
	public void setgebdat(String gebdat) {
		this.gebdat = gebdat;
	}
	
	public String getpremium() {
		return premium;
	}
	
	public void setpremium(String premium) {
		this.premium = premium;
	}
	
	public int getpunkte() {
		return punkte;
	}
	
	public void setpunkte(int punkte) {
		this.punkte = punkte;
	}
}

