package Kart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import Datenbankverwaltung.Datenbankschnittstelle;

public class Kartverwaltung {

	LinkedList<Kartverwaltung> ll;

	public LinkedList<Kartverwaltung> gibKart() {

		String abfrage = "select * from kart;";
		try {
			;
			ResultSet rs = Datenbankschnittstelle.executeQuery(abfrage);
			rs.next();
			ll.add((Kartverwaltung) rs);

			rs.close();

		} catch (SQLException sql) {
			System.out.println("Fehler beim auslesend er Karts" + sql.getMessage());
		}
		return ll;
	}
}
