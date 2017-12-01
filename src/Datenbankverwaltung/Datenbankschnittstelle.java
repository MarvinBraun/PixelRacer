//@Author Ferhat Koca, Marvin Braun

package Datenbankverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datenbankschnittstelle {

	private static Connection con;

	public static Connection getConnection() {
		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2", "dvi511", "fh5902");
			con.setAutoCommit(false);
		}

		catch (SQLException e) {
			System.out.println("Verbindung zur Datenbank fehlgeschlagen" + "Fehler: " + e.getMessage());
		}
		return con;
	}

	public static ResultSet executeQuery(String s) {
		ResultSet rs = null;
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(s);

			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Abfrage konnte nicht durchgeführt werden. " + "Fehler: " + e.getMessage());
		}

		return rs;
	}

	public static void executeUpdate(String s) {
		int updateInfo = -1;
		try {

			con = getConnection();
			Statement stmt = con.createStatement();
			updateInfo = stmt.executeUpdate(s);
			con.commit();
			stmt.close();

		}

		catch (SQLException e) {
			System.out.println(
					"Update konnte nicht durchgeführt werden. Rollback durchgeführt. " + "Fehler: " + e.getMessage());

			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Rollback fehlgeschlagen");
			}
			e.printStackTrace();
		}
	}

	public static void executeBatch(String queries[]) {
		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			for (String query : queries) {
				stmt.addBatch(query);
			}
			stmt.executeBatch();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Batch konnte nicht ausgeführt werden. " + "Fehler: " + e.getMessage());
		}

	}

}
