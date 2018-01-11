package Strecke;

import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import Datenbankverwaltung.Datenbankschnittstelle;
/**
 * Die Klasse Streckenverwaltung verarbeitet Objekte der Klasse Strecke.
 * Die Strecken werden in verschiedenen LinkedLists gespeichert.
 * @author Robin Demmler
 *
 */
public class Streckenverwaltung {
	
	LinkedList<Strecke> streckenliste = new LinkedList<Strecke>();
	/**
	 * LinkedList<Strecke> gibStrecke(): Es wird eine LinkedList vom Typ Strecke erstellt und mit 
	 * einer Datenbankabfrage über ein ResultSet wird aus der Relation Strecke für 
	 * jeden Datensatz ein Streckenobjekt erzeugt.
	 * @return LinkedList<Strecke> streckenliste mit den Streckenobjekten aus der DB
	 */
	public LinkedList<Strecke> gibStrecke(){
		
		String abfrage = "SELECT * FROM STRECKE";
		
		try{
			ResultSet rs = Datenbankschnittstelle.executeQuery(abfrage);
			
			while(rs.next()){
			
				Strecke s = new Strecke();
				s.setStreckenname(rs.getString("streckenname"));
				s.setLaenge(rs.getInt("laenge"));
				s.setSchwierigkeit(rs.getInt("schwierigkeit"));
				s.setPremium(rs.getString("premium"));
				s.setPunktewert(rs.getInt("punktewert"));
				
				String sql = "SELECT grafik FROM strecke WHERE streckenname = '" + s.getStreckenname() + "'";
				String filepath = "src/Resources/" + s.getStreckenname() + ".png";
				BufferedImage image = Datenbankschnittstelle.downloadBlob(sql, filepath);
				s.setGrafik(image);
				streckenliste.add(s);
								
			}
			rs.close();
			Datenbankschnittstelle.closeConnections();
			} catch(SQLException sql) {
				System.err.println("Fehler beim auslesen der Strecken" + sql.getMessage());
			}
		
			return streckenliste;
	}
	
	LinkedList<Strecke> streckenlistePunkte = new LinkedList<Strecke>();
	/**
	 * LinkedList<Strecke> gibStreckeBenutzerNachPunktestand(String benutzername, int punktestand): 
	 * Es wird eine LinkedList vom Typ Strecke erstellt und mit 
	 * einer Datenbankabfrage über ein ResultSet wird aus der Relation Strecke für 
	 * jeden Datensatz ein Streckenobjekt erzeugt. Durch den uebergebenen Parameter Punktestand
	 * wird geprüft, das nur Strecken ausgegeben werden, die auch mit dem Punktestand des Spielers, spielbar sind.
	 * @return LinkedList<Strecke> streckenliste mit den Streckenobjekten aus der DB passend zum Punktestand des Nutzers.
	 */
	public LinkedList<Strecke> gibStreckeBenutzerNachPunktestand(String benutzername, int punktestand){
		
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from strecke"+" where benutzername='"+benutzername+"'" + " and punktewert <=" + punktestand);
		try {
			while(rs.next())
			{
				Strecke s = new Strecke();
				s.setStreckenname(rs.getString("streckenname"));
				s.setLaenge(rs.getInt("laenge"));
				s.setSchwierigkeit(rs.getInt("schwierigkeit"));
				s.setPremium(rs.getString("premium"));
				s.setPunktewert(rs.getInt("punktewert"));
				
				String sql = "SELECT grafik FROM strecke WHERE streckenname = '" + s.getStreckenname() + "'";
				String filepath = "src/Resources/" + s.getStreckenname() + ".png";
				BufferedImage image = Datenbankschnittstelle.downloadBlob(sql, filepath);
				s.setGrafik(image);
				streckenlistePunkte.add(s);
			}
			rs.close();
			Datenbankschnittstelle.closeConnections();
			} catch(SQLException sql) {
				System.err.println("Fehler beim auslesen der Strecken" + sql.getMessage());
			}
		
			return streckenlistePunkte;
	}
	/**
	 * Main-Methode.
	 */		
	public static void main(String[] args) {
		Streckenverwaltung strecke = new Streckenverwaltung();
		strecke.gibStrecke();
		
	}

}
