package Kart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;




public class Kartverwaltung {

	LinkedList<Kartverwaltung> ll;
	private static Connection con;

	public static Connection getConnection() {
		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2", "dvi511", "fh5902");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Verbindung zur Datenbank fehlgeschlagen" + "Fehler: " + e.getMessage());
		}
		return con;
	}
	// Ich hab ne DB verbindeung eingebaut, damit ich es erstmal ausprobieren kann

	public LinkedList<Kartverwaltung> gibKart() {

		String abfrage = "select * from kart;";

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(abfrage);
			rs.next();
			ll.add((Kartverwaltung) rs);
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException sql) {
			System.out.println("Fehler beim auslesend er Karts" + sql.getMessage());
		}
		return ll;
	}
}
