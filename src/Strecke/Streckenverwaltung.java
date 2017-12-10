package Strecke;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import Datenbankverwaltung.Datenbankschnittstelle;

public class Streckenverwaltung {

	LinkedList<Strecke> Streckenliste = new LinkedList<Strecke>();
	
	public LinkedList<Strecke> gibStrecke(){
		
		String abfrage = "SELECT * FROM STRECKE";
		
		try{
			ResultSet rs = Datenbankschnittstelle.executeQuery(abfrage);
			
			while(rs.next()){
			
				Strecke s = new Strecke();
				s.setStreckenname(rs.getString("streckenname"));
				s.setLaenge(rs.getInt("laenge"));
				s.setSchwierigkeit(rs.getInt("schwierigkeit"));
				s.setPremium(rs.getBoolean("premium"));
				s.setPunktewert(rs.getInt("punktewert"));
				
				String sql = "SELECT grafik FROM strecke WHERE streckenname = '" + s.streckenname + "'";
				String filepath = "src/Resources/" + s.streckenname + ".png";
				BufferedImage image = Datenbankschnittstelle.downloadBlob(sql, filepath);
				s.setGrafik(image);
				Streckenliste.add(s);
								
			}
			rs.close();
			Datenbankschnittstelle.closeConnections();
			} catch(SQLException sql) {
				System.err.println("Fehler beim auslesen der Strecken" + sql.getMessage());
			}
		
			return Streckenliste;
	}
	
	
	
	
	public static void main(String[] args) {
		Streckenverwaltung strecke = new Streckenverwaltung();
		strecke.gibStrecke();
		
	}

}
