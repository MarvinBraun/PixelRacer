//@Author Ferhat Koca
package Kart;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import Datenbankverwaltung.Datenbankschnittstelle;

public class Kartverwaltung {

	LinkedList<Kart> Kartliste = new LinkedList<Kart>();

	public LinkedList<Kart> gibKart() {

		String abfrage = "SELECT * FROM KART WHERE Premium = 'false'";

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
				String filepath = "src/Resources/" + k.getKartname() + ".png";
				BufferedImage image = Datenbankschnittstelle.downloadBlob(sql, filepath);
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
