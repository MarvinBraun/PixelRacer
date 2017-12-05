package Datenbankverwaltung;

import java.sql.Connection;

public class Testklasse {
	
	public static void sendeTestDaten()
	{
		String st = "insert into mitarbeiter values(19827263,'MarvinBraun','Test1','Marvin','Braun','Entwickler','Marvinbraun@gmx.de','03.04.94')";
		Datenbankschnittstelle.executeUpdate(st);
	}
	
	public static void main(String[] args)
	{
		sendeTestDaten();
	}

}
