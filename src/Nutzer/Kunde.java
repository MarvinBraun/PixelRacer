package Nutzer;

public class Kunde extends Nutzer {
	String premium;
	int punkte;

	public String getvn() {
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

