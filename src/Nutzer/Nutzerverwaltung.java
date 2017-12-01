package Nutzer;

import java.sql.ResultSet;
import java.util.LinkedList;

import Datenbankverwaltung.DBAbfrage;
import Datenbankverwaltung.Datenbankschnittstelle;

public class Nutzerverwaltung {
	LinkedList<Kunde> kundenliste;
	LinkedList<Mitarbeiter> mitarbeiterliste;
	
	public LinkedList gibKundenliste() { //greift auf die Datenbank zu und gibt alle Kunden zur�ck
		
		String abfrage = ("select * from kunde");
		
		kundenliste = Datenbankschnittstelle.abfrage(abfrage);
		
		return kundenliste;
	}
	
	public LinkedList gibMitarbeiterliste() { //greift auf die Datenbank zu und gibt alle Mitarbeiter zur�ck
		
		String abfrage = ("select * from mitarbeiter");
		
		mitarbeiterliste = DBAbfrage.abfrage(abfrage);
		
		return mitarbeiterliste;
	}
}
