package Nutzer;

import java.sql.ResultSet;
import java.util.LinkedList;

import Datenbankverwaltung.DBAbfrage;

public class Nutzerverwaltung {
	LinkedList<Kunde> kundenliste;
	LinkedList<Mitarbeiter> mitarbeiterliste;
	
	public LinkedList gibKundenliste() {
		
		String abfrage = ("select * from kunde");
		
		kundenliste = DBAbfrage.abfrage(abfrage);
		
		return kundenliste;
	}
	
	public LinkedList gibMitarbeiterliste() {
		
		String abfrage = ("select * from mitarbeiter");
		
		mitarbeiterliste = DBAbfrage.abfrage(abfrage);
		
		return mitarbeiterliste;
	}
}
