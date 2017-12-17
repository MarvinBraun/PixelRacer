package Fahrt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;

import Datenbankverwaltung.Datenbankschnittstelle;
import Nutzer.Nutzerverwaltung;

public class Fahrtverwaltung {
	
	LinkedList<SingleplayerFahrt> singleplayerFahrten = new LinkedList<SingleplayerFahrt>();
	LinkedList<MultiplayerFahrt> multiplayerFahrten = new LinkedList<MultiplayerFahrt>();
	

	
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
	
	public LinkedList<SingleplayerFahrt> gibSingleplayerFahrtenFürBenutzer(String benutzername, String streckenname)
	{
		System.out.println("select * from Singleplayer_Fahrt"+" where benutzername='"+benutzername+"' and streckenname = '"+streckenname+"'");
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
	
	public LinkedList<SingleplayerFahrt> gibSingleplayerFahrtenFürBenutzer2(String benutzername)
	{
		System.out.println("select * from Singleplayer_Fahrt"+" where benutzername='"+benutzername+"'");
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
	
	
	public int gibNeueID(int a)
	{
		int id=0;
		
		ResultSet rs = null;
		if(a==1)
		rs = Datenbankschnittstelle.executeQuery("select max(sitzungsid) from Multiplayer_Fahrt");
		if(a==2)
		rs = Datenbankschnittstelle.executeQuery("select max(sitzungsid) from Singleplayer_Fahrt");
		try {
			while(rs.next())
			{

				id = rs.getInt("max(sitzungsid)");
				id++;
				System.out.println("SItzunhsID:"+id);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return id;
		
	}

	
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
				System.out.println("MultiplayerID:"+id);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
	}
	
	public void sendeMultiplayerFahrt(MultiplayerFahrt mf)
	{
		System.out.println(mf.getSitzungsID()+","+mf.getZeit()+","+mf.getMultiplayerID()+","+mf.getRang()+",'"+mf.getBenutzername()+"','"+mf.getStreckenName()+"','"+mf.getKartName());
		
			Datenbankschnittstelle.executeUpdate("insert into multiplayer_fahrt values("+mf.getSitzungsID()+","+mf.getZeit()+","+mf.getMultiplayerID()+","+mf.getRang()+",'"+mf.getBenutzername()+"','"+mf.getStreckenName()+"','"+mf.getKartName()+"')");
			Datenbankschnittstelle.closeConnections();
	}
	
	public void sendeSingleplayerFahrt(SingleplayerFahrt sf)
	{
		sf.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
		System.out.println(sf.getSitzungsID()+","+sf.getZeit()+","+sf.getRang()+",'"+sf.getBenutzername()+"','"+sf.getStreckenName()+"','"+sf.getKartName()+"','"+sf.getSchwierigkeit()+"')");
		
			Datenbankschnittstelle.executeUpdate("insert into singleplayer_fahrt values("+sf.getSitzungsID()+","+sf.getZeit()+","+sf.getRang()+",'"+sf.getBenutzername()+"','"+sf.getStreckenName()+"','"+sf.getKartName()+"','"+sf.getSchwierigkeit()+"')");
			Datenbankschnittstelle.closeConnections();
	}
	
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
					System.out.println(fahrt.getSitzungsID());
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
		public LinkedList<MultiplayerFahrt> gibMultiplayerFahrtenNachZeit(String name)
		{
			{
				try {
					String abfrage = "select * from multiplayer_fahrt where multiplayerID = "+name+" order by zeit asc";
					ResultSet rs = Datenbankschnittstelle.executeQuery(abfrage);
				
					while(rs.next())
					{	
						
						MultiplayerFahrt fahrt = new MultiplayerFahrt();
						fahrt.setSitzungsID(rs.getInt("SitzungsID"));
						
						System.out.println(fahrt.getSitzungsID());
						fahrt.setRang(rs.getInt("Rang"));
						fahrt.setMultiplayerID(rs.getInt("MultiplayerID"));
						fahrt.setZeit(rs.getInt("Zeit"));
						System.out.println(fahrt.getZeit());
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
	
	public static void main(String[] args)
	{
		Fahrtverwaltung v = new Fahrtverwaltung();
		LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFürBenutzer2("DZeller");
		System.out.println("Gefahrene Fahrten:"+fahrten.size());
	}
}
