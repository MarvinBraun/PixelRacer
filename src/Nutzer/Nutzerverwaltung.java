package Nutzer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Anmelden.AnmeldenStrg;
import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.SingleplayerFahrt;

/**
 * Die Klasse Nutzerverwaltung verarbeitet Objekte der Klassen Kunde und Mitarbeiter.
 * Die Nutzer werden in verschiedenen LinkedLists gespeichert.
 * @author Daniel Zeller
 *
 */

public class Nutzerverwaltung { //Deklaration der benötigten Variablen
	private static LinkedList<Kunde> kundenliste = new LinkedList<Kunde>();
	private static LinkedList<Mitarbeiter> mitarbeiterliste = new LinkedList<Mitarbeiter>();
	private static Kunde angkunde = new Kunde(); //Variable um die Daten des angemeldeten Kunden zu speichern
	
	/**
	 * Liest alle Kunden aus der Datenbank aus und speichert sie in einer LinkedList.
	 * @return LinkedList<Kunde>
	 */
	
	public static LinkedList<Kunde> gibKundenliste() {
		
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
	/**
	 * Liest alle Mitarbeiter aus der Datenbank aus und speichert sie in einer LinkedList.
	 * @return LinkedList<Mitarbeiter>
	 */
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
	
	public static void setangKunde(Kunde kunde) { //Setter der Variable angkunde
		angkunde = kunde;
	}
	
	public static Kunde getangKunde() { //Getter der Variable angkunde
		return angkunde;
	}
	
	/**
	 * Die Daten des angemeldeten Kunden werden durch die aktuellen Daten in der Datenbank aktualisiert.
	 */
	public static void aktualisereangKunde() { 
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from kunde where benutzername = '" + angkunde.getnutzername() + "'");
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
		}
		Datenbankschnittstelle.closeConnections();
	}
	
	/**
	 * Eine bestimmte Anzahl an Punkten wird dem angemeldeten Kunden auf seinem Punktestand gutgeschrieben.
	 * @param punkte Anzahl der zu addierenden Punkte
	 */
	public static void addpunkte(int punkte) {
		try {
			String update = "Update kunde set punktzahl = punktzahl + '" + punkte + "' where benutzername = '" + Nutzerverwaltung.getangKunde().getnutzername() + "'";
			Datenbankschnittstelle.executeUpdate(update);
			Datenbankschnittstelle.closeConnections();
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Die Punkte konnten nicht aktualisiert werden!",null, JOptionPane.ERROR_MESSAGE);
		}
	}
}
