package Nutzer;

import java.sql.ResultSet;
import java.util.LinkedList;

import Datenbankverwaltung.DBAbfrage;

public class Nutzerverwaltung {
	LinkedList<Kunde> kundenliste;
	LinkedList<Mitarbeiter> mitarbeiterliste;
	
	public LinkedList gibKundenliste() { //greift auf die Datenbank zu und gibt alle Kunden zurück
		
		String abfrage = ("select * from kunde");
		
		kundenliste = DBAbfrage.abfrage(abfrage);
		
		return kundenliste;
	}
	
	public LinkedList gibMitarbeiterliste() { //greift auf die Datenbank zu und gibt alle Mitarbeiter zurück
		
		String abfrage = ("select * from mitarbeiter");
		
		mitarbeiterliste = DBAbfrage.abfrage(abfrage);
		
		return mitarbeiterliste;
	}
}
