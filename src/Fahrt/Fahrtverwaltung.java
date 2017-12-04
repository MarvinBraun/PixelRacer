package Fahrt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;

import Datenbankverwaltung.Datenbankschnittstelle;

public class Fahrtverwaltung {
	
	static LinkedList<SingleplayerFahrt> singleplayerFahrten = new LinkedList<SingleplayerFahrt>();
	static LinkedList<MultiplayerFahrt> multiplayerFahrten = new LinkedList<MultiplayerFahrt>();
	

	
	public static LinkedList<SingleplayerFahrt> gibSingleplayerFahrten()
	{
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from Singleplayer-Fahrt");
		try {
			while(rs.next())
			{
				SingleplayerFahrt fahrt = new SingleplayerFahrt();
				fahrt.setSitzungsID(rs.getInt("SitzungsID"));
				fahrt.setRang(rs.getInt("Rang"));
				fahrt.setZeit(rs.getFloat("Zeit"));
				fahrt.setStreckenName(rs.getString("Streckenname"));
				fahrt.setKartName(rs.getString("Kartname"));
				fahrt.setBenutzername(rs.getString("Benutzername"));
				singleplayerFahrten.add(fahrt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return singleplayerFahrten;
	}
	
	public static LinkedList<MultiplayerFahrt> gibMultiplayerFahrten()
	{
		{
			ResultSet rs = Datenbankschnittstelle.executeQuery("select * from Multiplayer-Fahrt");
			try {
				while(rs.next())
				{
					MultiplayerFahrt fahrt = new MultiplayerFahrt();
					fahrt.setSitzungsID(rs.getInt("SitzungsID"));
					fahrt.setRang(rs.getInt("Rang"));
					fahrt.setMultiplayerID(rs.getInt("MultiplayerID"));
					fahrt.setZeit(rs.getFloat("Zeit"));
					fahrt.setStreckenName(rs.getString("Streckenname"));
					fahrt.setKartName(rs.getString("Kartname"));
					fahrt.setBenutzername(rs.getString("Benutzername"));
					multiplayerFahrten.add(fahrt);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return multiplayerFahrten;
	
	
}
	}
}
