

package Fahrt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import Datenbankverwaltung.Datenbankschnittstelle;
import Nutzer.Nutzerverwaltung;
/**
 * Die Klasse Fahrtverwaltung verarbeitet Objekte der Klassen SingleplayerFahrt und MultiplayerFahrt
 * Gespeichert werden die Fahrten in einer LinkedList.
 * @author Marvin Braun
 */

public class Fahrtverwaltung {

	
	
	private LinkedList<SingleplayerFahrt> singleplayerFahrten = new LinkedList<SingleplayerFahrt>();
	private LinkedList<MultiplayerFahrt> multiplayerFahrten = new LinkedList<MultiplayerFahrt>();
	
	
	
	/**
	 * Liest alle SingleplayerFahrten aus der Datenbank aus und speichert sie in einer LinkedList
	 * @return LinkedList mit allen SingleplayerFahrten.
	 */
	public LinkedList<SingleplayerFahrt> gibSingleplayerFahrten()
	{
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from Singleplayer_Fahrt");
		try {
			while(rs.next())
			{
				SingleplayerFahrt fahrt = new SingleplayerFahrt();
				fahrt.setSitzungsID(rs.getInt("SitzungsID"));
				fahrt.setRang(rs.getInt("Rang"));
				fahrt.setZeit(rs.getInt("Zeit"));
				fahrt.setStreckenName(rs.getString("Streckenname"));
				fahrt.setKartName(rs.getString("Kartname"));
				fahrt.setBenutzername(rs.getString("Benutzername"));
				fahrt.setSchwierigkeit(rs.getString("Schwierigkeit"));
				singleplayerFahrten.add(fahrt);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return singleplayerFahrten;
	}

	/**
	 * Liest alle SingleplayerFahrten aus der Datenbank, f�r einen bestimmten 
	 * Nutzer und eine bestimmte Strecke, aus und speichert sie in einer LinkedList.
	 * @param benutzername Der Benutzername des Spielers
	 * @param streckenname Der Streckenname der Strecke
	 * @return LinkedList mit den SingleplayerFahrten f�r einen Benutzer zu einer Strecke
	 */
	public LinkedList<SingleplayerFahrt> gibSingleplayerFahrtenFuerBenutzerUndStrecke(String benutzername, String streckenname)
	{
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from Singleplayer_Fahrt"+" where benutzername='"+benutzername+"' and streckenname = '"+streckenname+"'");
		try {
			while(rs.next())
			{
				SingleplayerFahrt fahrt = new SingleplayerFahrt();
				fahrt.setSitzungsID(rs.getInt("SitzungsID"));
				fahrt.setRang(rs.getInt("Rang"));
				fahrt.setZeit(rs.getInt("Zeit"));
				fahrt.setStreckenName(rs.getString("Streckenname"));
				fahrt.setKartName(rs.getString("Kartname"));
				fahrt.setBenutzername(rs.getString("Benutzername"));
				fahrt.setSchwierigkeit(rs.getString("Schwierigkeit"));
				singleplayerFahrten.add(fahrt);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return singleplayerFahrten;
	}
	
	/**
	 * Liest alle SingleplayerFahrten aus der Datenbank, f�r einen bestimmten Nutzer 
	 * und eine bestimmte Strecke, aus und speichert sie in einer LinkedList.
	 * @param benutzername Der Benutzername des Spielers
	 * @param kartname Der Name des Karts
	 * @return LinkedList mit den SingleplayerFahrten f�r einen Benutzer zu einer Strecke.
	 */
	public LinkedList<SingleplayerFahrt> gibSingleplayerFahrtenFuerBenutzerUndKart(String benutzername, String kartname)
	{
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from Singleplayer_Fahrt"+" where benutzername='"+benutzername+"' and kartname = '"+kartname+"'");
		try {
			while(rs.next())
			{
				SingleplayerFahrt fahrt = new SingleplayerFahrt();
				fahrt.setSitzungsID(rs.getInt("SitzungsID"));
				fahrt.setRang(rs.getInt("Rang"));
				fahrt.setZeit(rs.getInt("Zeit"));
				fahrt.setStreckenName(rs.getString("Streckenname"));
				fahrt.setKartName(rs.getString("Kartname"));
				fahrt.setBenutzername(rs.getString("Benutzername"));
				fahrt.setSchwierigkeit(rs.getString("Schwierigkeit"));
				singleplayerFahrten.add(fahrt);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return singleplayerFahrten;
	}
	
	/**
	 * Liest alle SingleplayerFahrten aus der Datenbank, 
	 * f�r einen bestimmten Nutzer, aus und speichert sie in einer LinkedList.
	 * @param benutzername Der Benutzername des Spielers
	 * @return LinkedList mit den SingleplayerFahrten f�r einen Benutzer
	 */
	public LinkedList<SingleplayerFahrt> gibSingleplayerFahrtenFuerBenutzer(String benutzername)
	{
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from Singleplayer_Fahrt"+" where benutzername='"+benutzername+"'");
		try {
			while(rs.next())
			{
				SingleplayerFahrt fahrt = new SingleplayerFahrt();
				fahrt.setSitzungsID(rs.getInt("SitzungsID"));
				fahrt.setRang(rs.getInt("Rang"));
				fahrt.setZeit(rs.getInt("Zeit"));
				fahrt.setStreckenName(rs.getString("Streckenname"));
				fahrt.setKartName(rs.getString("Kartname"));
				fahrt.setBenutzername(rs.getString("Benutzername"));
				fahrt.setSchwierigkeit(rs.getString("Schwierigkeit"));
				singleplayerFahrten.add(fahrt);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return singleplayerFahrten;
	}
	
	/**
	 * Gibt eine zu verwendende SitzungsID aus, mit der eine Fahrt erstellt werden kann.
	 *@param singleMulti �ber den Parameter wird entschieden ob die Relation "Multiplayer_Fahrt" oder die Relation "Singleplayer_Fahrt" angesprochen wird.
	 *@return Eine ID, welche genutzt werden kann um eine Single- oder MultiplayerFahrt zu erstellen
	 */
	public int gibNeueID(int singleMulti)
	{
		int id=0;
		
		ResultSet rs = null;
		if(singleMulti==1)
		rs = Datenbankschnittstelle.executeQuery("select max(sitzungsid) from Multiplayer_Fahrt");
		if(singleMulti==2)
		rs = Datenbankschnittstelle.executeQuery("select max(sitzungsid) from Singleplayer_Fahrt");
		try {
			while(rs.next())
			{

				id = rs.getInt("max(sitzungsid)");
				id++;
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return id;
		
	}

	/**
	 * Gibt eine zu verwendende MultiplayerID aus.
	 *@return Eine MultiplayerID, welche genutzt werden kann um mit Freunden zu spielen.
	 */
	public int gibNeueMultiplayerID()
	{
		int id = 0;
		ResultSet rs = null;
		rs = Datenbankschnittstelle.executeQuery("select max(multiplayerID) from Multiplayer_Fahrt");
		try {
			while(rs.next())
			{

				id = rs.getInt("max(MultiplayerID)");
				id++;
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
	}
	

	/**
	 * Sendet eine MultiplayerFahrt an die Datenbank.
	 * @param mf Ein Objekt der Klasse MultiplayerFahrt
	 */
	public void sendeMultiplayerFahrt(MultiplayerFahrt mf)
	{
			mf.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
			
		
			Datenbankschnittstelle.executeUpdate("insert into multiplayer_fahrt values("+mf.getSitzungsID()+","+mf.getZeit()+","+mf.getMultiplayerID()+","+mf.getRang()+",'"+mf.getBenutzername()+"','"+mf.getStreckenName()+"','"+mf.getKartName()+"')");
			Datenbankschnittstelle.closeConnections();
	}
	
	/**
	 * Sendet eine SingleplayerFahrt an die Datenbank.
	 * @param sf Ein Objekt der Klasse SingleplayerFahrt
	 */
	
	public void sendeSingleplayerFahrt(SingleplayerFahrt sf)
	{
		sf.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
		
			Datenbankschnittstelle.executeUpdate("insert into singleplayer_fahrt values("+sf.getSitzungsID()+","+sf.getZeit()+","+sf.getRang()+",'"+sf.getBenutzername()+"','"+sf.getStreckenName()+"','"+sf.getKartName()+"','"+sf.getSchwierigkeit()+"')");
			Datenbankschnittstelle.closeConnections();
	}
	
	/**
	 * Liest alle MultiplayerFahrten aus der Datenbank aus und speichert diese in einer LinkedList.
	 * @return Die LinkedList wird am Ende zur�ckgegeben.
	 */
	
	public LinkedList<MultiplayerFahrt> gibMultiplayerFahrten()
	{
		{
			try {
				String abfrage = "select * from multiplayer_fahrt";
				ResultSet rs = Datenbankschnittstelle.executeQuery(abfrage);
			
				while(rs.next())
				{	
					
					MultiplayerFahrt fahrt = new MultiplayerFahrt();
					fahrt.setSitzungsID(rs.getInt("SitzungsID"));
					fahrt.setRang(rs.getInt("Rang"));
					fahrt.setMultiplayerID(rs.getInt("MultiplayerID"));
					fahrt.setZeit(rs.getInt("Zeit"));
					fahrt.setStreckenName(rs.getString("Streckenname"));
					fahrt.setKartName(rs.getString("Kartname"));
					fahrt.setBenutzername(rs.getString("Benutzername"));
					multiplayerFahrten.add(fahrt);
				}
				rs.close();
				Datenbankschnittstelle.closeConnections();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return multiplayerFahrten;
	
	
		}
}
	
	/**
	 * Liest alle MultiplayerFahrten f�r eine bestimmte MultiplayerID aus und ordnet diese nach der Zeit.
	 * @param id MultiplayerID
	 * @return LinkedList mit MultiplayerFahrten zu einer ID.
	 */
		public LinkedList<MultiplayerFahrt> gibMultiplayerFahrtenNachZeit(String id)
		{
			{
				try {
					String abfrage = "select * from multiplayer_fahrt where multiplayerID = "+id+" order by zeit asc";
					ResultSet rs = Datenbankschnittstelle.executeQuery(abfrage);
				
					while(rs.next())
					{	
						
						MultiplayerFahrt fahrt = new MultiplayerFahrt();
						fahrt.setSitzungsID(rs.getInt("SitzungsID"));
						fahrt.setRang(rs.getInt("Rang"));
						fahrt.setMultiplayerID(rs.getInt("MultiplayerID"));
						fahrt.setZeit(rs.getInt("Zeit"));
						fahrt.setStreckenName(rs.getString("Streckenname"));
						fahrt.setKartName(rs.getString("Kartname"));
						fahrt.setBenutzername(rs.getString("Benutzername"));
						multiplayerFahrten.add(fahrt);
					}
					rs.close();
					Datenbankschnittstelle.closeConnections();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return multiplayerFahrten;
		
		
	}
}
		
		/**
		 * Liest alle MultiplayerFahrten f�r eine bestimmte MultiplayerID aus und ordnet diese nach der Zeit.
		 * @param i MultiplayerID nach der in der Datenbank gesucht wird.
		 * @return LinkedList mit MultiplayerFahrten zu einer ID.
		 */
			
			public LinkedList<MultiplayerFahrt> gibMultiplayerFahrtenNachMultiplayerID(int i)
			{
				{
					try {
						String abfrage = "select * from multiplayer_fahrt where multiplayerID = "+i+" order by zeit asc";
						ResultSet rs = Datenbankschnittstelle.executeQuery(abfrage);
					
						while(rs.next())
						{	
							
							MultiplayerFahrt fahrt = new MultiplayerFahrt();
							fahrt.setSitzungsID(rs.getInt("SitzungsID"));
						
							fahrt.setRang(rs.getInt("Rang"));
							fahrt.setMultiplayerID(rs.getInt("MultiplayerID"));
							fahrt.setZeit(rs.getInt("Zeit"));
							fahrt.setStreckenName(rs.getString("Streckenname"));
							fahrt.setKartName(rs.getString("Kartname"));
							fahrt.setBenutzername(rs.getString("Benutzername"));
							multiplayerFahrten.add(fahrt);

						}
						rs.close();
						Datenbankschnittstelle.closeConnections();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return multiplayerFahrten;
			
			
		}
			
	}

}
