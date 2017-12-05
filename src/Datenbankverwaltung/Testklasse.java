package Datenbankverwaltung;

import java.sql.Connection;

public class Testklasse {
	
	public static void sendeTestDaten(String s)
	{
		
		Datenbankschnittstelle.executeUpdate(s);
	}
	

}
