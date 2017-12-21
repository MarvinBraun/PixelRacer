package Nutzer;

public class Mitarbeiter extends Nutzer { // Mitarbeiter ist ein Nutzer des Systems
	private String mitarbeiterid; //Deklaration der benötigten Variablen
	private String jobtitel;
	
	public String getvn() { //Getter und Setter der Variablen des Nutzers/Mitarbeiter
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
	
	public String getmitarbeiterid() {
		return mitarbeiterid;
	}
	
	public void setmitarbeiterid(String id) {
		this.mitarbeiterid = id;
	}
	
	public String getjobtitel() {
		return jobtitel;
	}
	
	public void setjobtitel(String jobtitel) {
		this.jobtitel = jobtitel;
	}
}
