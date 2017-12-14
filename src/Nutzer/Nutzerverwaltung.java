package Nutzer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Anmelden.AnmeldenStrg;
import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.SingleplayerFahrt;

//Autor Daniel Zeller

public class Nutzerverwaltung {
	static LinkedList<Kunde> kundenliste = new LinkedList<Kunde>();
	static LinkedList<Mitarbeiter> mitarbeiterliste = new LinkedList<Mitarbeiter>();
	static Kunde angkunde = new Kunde();
	
	public static LinkedList<Kunde> gibKundenliste() { //greift auf die Datenbank zu und gibt alle Kunden zurück
		
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from kunde");
		try {
			while(rs.next())
			{
				Kunde kunde = new Kunde();
				kunde.setvn(rs.getString("vorname"));
				kunde.setnn(rs.getString("nachname"));
				kunde.setnutzername(rs.getString("benutzername"));
				kunde.setpasswort(rs.getString("passwort"));
				kunde.setpremium(rs.getString("premium"));
				kunde.setpunkte(rs.getInt("punktzahl"));
				kunde.setemail(rs.getString("email"));
				kunde.setgebdat(rs.getString("geburtsdatum"));
				kundenliste.add(kunde);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Datenbankschnittstelle.closeConnections();
		
		return kundenliste;
	}
	
	public static LinkedList<Mitarbeiter> gibMitarbeiterliste() { //greift auf die Datenbank zu und gibt alle Mitarbeiter zurück
		
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from mitarbeiter");
		try {
			while(rs.next())
			{
				Mitarbeiter mitarbeiter = new Mitarbeiter();
				mitarbeiter.setvn(rs.getString("vorname"));
				mitarbeiter.setnn(rs.getString("nachname"));
				mitarbeiter.setnutzername(rs.getString("benutzername"));
				mitarbeiter.setpasswort(rs.getString("passwort"));
				mitarbeiter.setmitarbeiterid(rs.getString("mitarbeiterID"));
				mitarbeiter.setjobtitel(rs.getString("jobtitel"));
				mitarbeiter.setemail(rs.getString("email"));
				mitarbeiter.setgebdat(rs.getString("geburtsdatum"));
				mitarbeiterliste.add(mitarbeiter);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Datenbankschnittstelle.closeConnections();
		
		return mitarbeiterliste;
	}
	
	public void setangKunde() {
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from kunde where benutzername = " + AnmeldenStrg.getAngNutzername());
		try {
			while(rs.next())
			{
				angkunde.setvn(rs.getString("vorname"));
				angkunde.setnn(rs.getString("nachname"));
				angkunde.setnutzername(rs.getString("benutzername"));
				angkunde.setpasswort(rs.getString("passwort"));
				angkunde.setpremium(rs.getString("premium"));
				angkunde.setpunkte(rs.getInt("punktzahl"));
				angkunde.setemail(rs.getString("email"));
				angkunde.setgebdat(rs.getString("geburtsdatum"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			Datenbankschnittstelle.closeConnections();
		}
	}
	
	public static Kunde getangKunde() {
		return angkunde;
	}
}
