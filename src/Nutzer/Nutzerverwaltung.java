package Nutzer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.SingleplayerFahrt;

public class Nutzerverwaltung {
	LinkedList<Kunde> kundenliste = new LinkedList<Kunde>();
	LinkedList<Mitarbeiter> mitarbeiterliste = new LinkedList<Mitarbeiter>();
	static Kunde angkunde = new Kunde();
	
	public LinkedList<Kunde> gibKundenliste() { //greift auf die Datenbank zu und gibt alle Kunden zur�ck
		
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from kunde");
		try {
			while(rs.next())
			{
				Kunde kunde = new Kunde();
				kunde.setvn(rs.getString("vorname"));
				kunde.setnn(rs.getString("nachname"));
				kunde.setnutzername(rs.getString("benutzername"));
				kunde.setpasswort(rs.getString("passwort"));
				kunde.setpremium(rs.getBoolean("premium"));
				kunde.setpunkte(rs.getInt("punktzahl"));
				kunde.setemail(rs.getString("email"));
				kunde.setgebdat(rs.getString("geburtsdatum"));
				kundenliste.add(kunde);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kundenliste;
	}
	
	public LinkedList<Mitarbeiter> gibMitarbeiterliste() { //greift auf die Datenbank zu und gibt alle Mitarbeiter zur�ck
		
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from mitarbeiter");
		try {
			while(rs.next())
			{
				Mitarbeiter mitarbeiter = new Mitarbeiter();
				mitarbeiter.setvn(rs.getString("vorname"));
				mitarbeiter.setnn(rs.getString("nachname"));
				mitarbeiter.setnutzername(rs.getString("benutzername"));
				mitarbeiter.setpasswort(rs.getString("passwort"));
				mitarbeiter.setmitarbeiterid(rs.getInt("mitarbeiterID"));
				mitarbeiter.setjobtitel(rs.getString("jobtitel"));
				mitarbeiter.setemail(rs.getString("email"));
				mitarbeiter.setgebdat(rs.getString("geburtsdatum"));
				mitarbeiterliste.add(mitarbeiter);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mitarbeiterliste;
	}
	
	public void setangKunde() {
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from kunde where benutzername = " + anmelden.nutzername);
		try {
			while(rs.next())
			{
				angkunde.setvn(rs.getString("vorname"));
				angkunde.setnn(rs.getString("nachname"));
				angkunde.setnutzername(rs.getString("benutzername"));
				angkunde.setpasswort(rs.getString("passwort"));
				angkunde.setpremium(rs.getBoolean("premium"));
				angkunde.setpunkte(rs.getInt("punktzahl"));
				angkunde.setemail(rs.getString("email"));
				angkunde.setgebdat(rs.getString("geburtsdatum"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Kunde getangKunde() {
		return angkunde;
	}
}