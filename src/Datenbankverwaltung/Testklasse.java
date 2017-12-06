package Datenbankverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;

import Nutzer.Kunde;
import Nutzer.Mitarbeiter;
import Nutzer.Nutzerverwaltung;

public class Testklasse {
	
	public static void sendeTestDaten(String s)
	{
		
	}
	
	public static void Testsendung()
	{
		Nutzerverwaltung nw = new Nutzerverwaltung();
		LinkedList<Mitarbeiter> liste = nw.gibMitarbeiterliste();
		Datenbankschnittstelle.closeConnections();
		System.out.println(liste.size());
	}
	public static void main(String[] args)
	{
	
		
	}
	

}
