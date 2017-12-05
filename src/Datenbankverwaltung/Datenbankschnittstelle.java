//@Author Ferhat Koca, Marvin Braun

package Datenbankverwaltung;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialException;

public class Datenbankschnittstelle {

	private static Connection con;
	
	public static void main(String[] args)
	{
		ResultSet rs = executeQuery("Select * from Kunde");
		
		
		executeUpdate("insert into Mitarbeiter values (12345648,'Tester12','testest','Max','Mustermann','CEO','Maxddd@gmx.de','03.04.94')");	
		System.out.println("durchgeführt");
		executeUpdate("insert into kart values ('FireBird','100','300','false',0,null)");	
	}

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
			con.close();

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
	
	public static Blob konvertiereBild(BufferedImage bild)
	{
		Blob blFile = null;
		try {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bild, "png", baos);
		 blFile = new javax.sql.rowset.serial.SerialBlob(baos.toByteArray());
		}
		catch(Exception e)
		{
			System.out.println("Fehler!");
			e.printStackTrace();
			
		}
		
		return blFile;
		
	}
	
	public static void sendImage()
	{
		String s = "insert into kart values ('FireBird','100','300','false',0,null)";
		String sql = "update kart set grafik=? " + " where kartname ='FireBird'";
				Connection con;
		con = getConnection();
				//try {
					executeUpdate(s);
					/*PreparedStatement myStmt = con.prepareStatement(sql);
					File f =new File("src/Resources/Car1.png");
					FileInputStream input = new FileInputStream(f);
					myStmt.setBinaryStream(1, input);
					myStmt.executeUpdate();
					System.out.println("Successfull");
				*/
					
				} 
				/*
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
				
				
				catch (IOException f)
				{
					System.out.println("Bildfehler");
				}
			
				
	}
		*/
	public static void receiveKart()
	{
		
	}

}
