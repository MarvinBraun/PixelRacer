package Fahrt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import Datenbankverwaltung.Datenbankschnittstelle;

public class Fahrtverwaltung {
	
	HashSet<SingleplayerFahrt> singleplayerFahrten;
	HashSet<MultiplayerFahrt> multiplayerFahrten;
	
	public Fahrtverwaltung(ResultSet rs)
	{
		
	}
	
	public HashSet gibSingleplayerFahrten()
	{
		ResultSet rs = Datenbankschnittstelle.abfrage("select * from Singleplayerfahrt");
		try {
			while(rs.next())
			{
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return singleplayerFahrten;
	}
	
	public HashSet gibMultiplayerFahrten()
	{
		ResultSet rs = Datenbankschnittstelle.abfrage("select * from Multiplayerfahrt");
		try {
			while(rs.next())
			{
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return multiplayerFahrten;
	}
	
	
}
