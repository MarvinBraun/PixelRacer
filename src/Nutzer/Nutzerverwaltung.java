package Nutzer;

import java.util.LinkedList;
import Datenbankverwaltung.Datenbankschnittstelle;

public class Nutzerverwaltung {
	LinkedList<Kunde> kundenliste = new LinkedList<Kunde>();
	LinkedList<Mitarbeiter> mitarbeiterliste = new LinkedList<Mitarbeiter>();
	
	public LinkedList<Kunde> gibKundenliste() { //greift auf die Datenbank zu und gibt alle Kunden zurück
		
		String abfrage = ("select * from kunde");
		
		kundenliste = (LinkedList<Kunde>) Datenbankschnittstelle.executeQuery(abfrage);
		
		return kundenliste;
	}
	
	public LinkedList<Mitarbeiter> gibMitarbeiterliste() { //greift auf die Datenbank zu und gibt alle Mitarbeiter zurück
		
		String abfrage = ("select * from mitarbeiter");
		
		mitarbeiterliste = (LinkedList<Mitarbeiter>) Datenbankschnittstelle.executeQuery(abfrage);
		
		return mitarbeiterliste;
	}
}
