package Datenbankverwaltung;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialException;

/**
 * 
 * @author Ferhat Koca, Marvin Braun
 *
 */
public class Datenbankschnittstelle {

	private static Connection con;
	private static Statement stmt;
	private static PreparedStatement prepStmt;

	/**
	 * 
	 * baut eine Verbindung zur Datenbank auf
	 * 
	 * @return liefert ein Objekt des Typs Connection zurück
	 * 
	 */
	public static Connection getConnection() {
		try {

			con = DriverManager.getConnection("jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2", "dvi511", "fh5902");
			con.setAutoCommit(true);
		}

		catch (SQLException e) {
			System.out.println("Verbindung zur Datenbank fehlgeschlagen" + "Fehler: " + e.getMessage());
		}
		return con;
	}

	/**
	 * führt eine Datenbankabfrage aus
	 * @param abfrage SQL-Abfrage
	 * @return Ein Objekt des Typs ResultSet
	 */
	
	public static ResultSet executeQuery(String abfrage) {
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(abfrage);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Abfrage konnte nicht durchgefÃ¼hrt werden. " + "Fehler: " + e.getMessage());
		}

		return rs;
	}

	/**
	 * führt ein Update der Datenbank aus.
	 * @param abfrage SQL Abfrage
	 */
	public static void executeUpdate(String abfrage) {
		int updateInfo = -1;
		try {

			con = getConnection();
			stmt = con.createStatement();
			updateInfo = stmt.executeUpdate(abfrage);

		}

		catch (SQLException e) {
			System.out.println();

			e.printStackTrace();
		}
	}

	/**
	 * führt ein SQL-Batch aus
	 * @param queries String-Array mit SQL-Anweisungen
	 */
	
	public static void executeBatch(String queries[]) {
		try {
			con = getConnection();
			stmt = con.createStatement();
			for (String query : queries) {
				stmt.addBatch(query);
			}
			stmt.executeBatch();
			// stmt.close();
			// con.close();
		} catch (SQLException e) {
			System.out.println("Batch konnte nicht ausgefÃ¼hrt werden. " + "Fehler: " + e.getMessage());
		}

	}
/**
 * lädt ein Bild zu einer Strecke oder Kart hoch.
 * @param sql SQL-Anweisung
 * @param file Hochzuladendes Bild
 */
	public static void uploadBlob(String sql, File file) {
		try {
			Connection con = getConnection();
			PreparedStatement prepstmt = con.prepareStatement(sql);

			System.out.println("Bild laden..");
			FileInputStream fis = new FileInputStream(file);
			prepstmt.setBinaryStream(1, fis, (int) file.length());
			prepstmt.execute();
			fis.close();
			prepstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
/**
 * lädt ein Bild zu einer Strecke oder einem Kart
 * @param sql SQL-Anweisung
 * @param filepath Pfad, an der das Bild gespeichert werden soll
 * @return ein Objekt des Typs BufferedImage
 */
	public static BufferedImage downloadBlob(String sql, String filepath) {
		BufferedImage image = null;
		try {
			Connection con = getConnection();
			PreparedStatement prepstmt = con.prepareStatement(sql);
			ResultSet rs = prepstmt.executeQuery(sql);

			while (rs.next()) {
				File file = new File(filepath);
				FileOutputStream fos = new FileOutputStream(file);

				byte[] buffer = new byte[1];
				InputStream is = rs.getBinaryStream("grafik");

				while (is.read(buffer) > 0) {
					fos.write(buffer);
				}
				fos.close();
				image = ImageIO.read(file);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
	}
/**
 * Schließt die Datenbankverbindung
 */
	public static void closeConnections() {
		try {
			stmt.close();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * public static void sendImage() { String s =
	 * "insert into kart values ('FireBird','100','300','false',0,null)"; String sql
	 * = "update kart set grafik=? " + " where kartname ='FireBird'"; Connection
	 * con; con = getConnection(); //try { executeUpdate(s); PreparedStatement
	 * myStmt = con.prepareStatement(sql); File f =new
	 * File("src/Resources/Car1.png"); FileInputStream input = new
	 * FileInputStream(f); myStmt.setBinaryStream(1, input); myStmt.executeUpdate();
	 * System.out.println("Successfull");
	 * 
	 * 
	 * }
	 * 
	 * catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * 
	 * catch (IOException f) { System.out.println("Bildfehler"); }
	 * 
	 * 
	 * }
	 * 
	 * public static void receiveKart() { try { ResultSet rs =
	 * executeQuery("select * from kart"); rs.next(); File image = new
	 * File("src/Resources/newFile.png"); FileOutputStream fos = new
	 * FileOutputStream(image);
	 * 
	 * byte[] buffer = new byte[1]; InputStream is = rs.getBinaryStream("grafik");
	 * 
	 * try { while(is.read(buffer)>0) { fos.write(buffer);
	 * 
	 * } if(image.exists()) System.out.println("exists"); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } try { fos.close();
	 * 
	 * con.close();
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * System.out.println("File not found"); e.printStackTrace(); }
	 * 
	 * 
	 * catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 */

}
