//@author Ferhat Koca
package Kart;

import java.sql.ResultSet;
import java.sql.SQLException;
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
			System.out.println("Fehler beim auslesen der Karts" + sql.getMessage());
		}
		return ll;
	}
}
