package Kart;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import Datenbankverwaltung.Datenbankschnittstelle;
import Rechnung.Rechnungsverwaltung;

/**
 * 
 * Die Klasse Kartverwaltung liest die Objekte der Klasse Kart aus und verarbeitet diese.
 * Alle Daten aus der Datenbank werden hier ausgelesen und in der LinkedList Kart abgespeichert.
 * @return gibt die LinkedList mit allen Daten aus der Datenbank wieder.
 * 
 * @author Ferhat Koca
 * 
 */
public class Kartverwaltung {

	LinkedList<Kart> Kartliste = new LinkedList<Kart>();

	public LinkedList<Kart> gibKart() {

		String abfrage = "SELECT * FROM KART";

		try {
			ResultSet rs = Datenbankschnittstelle.executeQuery(abfrage);

			while (rs.next()) {

				Kart k = new Kart();
				k.setKartname(rs.getString("Kartname"));
				k.setBeschleunigung(Integer.parseInt(rs.getString("Beschleunigung")));
				k.setMaxkmh(rs.getInt("Maxkmh"));
				k.setPremium(rs.getString("Premium"));
				k.setPunktewert(rs.getInt("Punktewert"));

				String sql = "select grafik from kart where kartname = '" + k.getKartname() + "'";
				BufferedImage image = Datenbankschnittstelle.downloadBlob(sql);
				k.setGrafik(image);
				Kartliste.add(k);
				
			}
			rs.close();
			Datenbankschnittstelle.closeConnections();

		} catch (SQLException sql) {
			System.out.println("Fehler beim auslesen der Karts " + sql.getMessage());
		}

		return Kartliste;
	}

	public static void main(String[] args) {
		Kartverwaltung kart = new Kartverwaltung();
		kart.gibKart();

	}
}
