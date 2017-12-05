package Datenbankverwaltung;

import java.sql.Connection;

public class Testklasse {
	
	public static void sendeTestDaten(String s)
	{
		
		Datenbankschnittstelle.executeUpdate(s);
	}
	
	public static void sendeKart()
	{
		BufferedImage bild = new BufferedImage(new File("src/Resources/Car1.png"));
		Blob b  = Datenbankschnittstelle.konvertiereBild(bild);
		String s = "insert data into kart values ('FireBird','100','300','false',0,
	}
	

}
