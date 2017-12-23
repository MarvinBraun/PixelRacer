//@Author Marvin Braun
package Fahrt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import Datenbankverwaltung.Datenbankschnittstelle;
import Nutzer.Nutzerverwaltung;

/*
 * Die Klasse Fahrtverwaltung verarbeitet Objekte der Klassen SingleplayerFahrt und MultiplayerFahrt.
 * Gespeichert werden die Fahrten in einer LinkedList.
 */

public class Fahrtverwaltung {

	
	
	private LinkedList<SingleplayerFahrt> singleplayerFahrten = new LinkedList<SingleplayerFahrt>();
	private LinkedList<MultiplayerFahrt> multiplayerFahrten = new LinkedList<MultiplayerFahrt>();
	

	
	public LinkedList<SingleplayerFahrt> getSingleplayerFahrten() {
		return singleplayerFahrten;
	}

	public void setSingleplayerFahrten(LinkedList<SingleplayerFahrt> singleplayerFahrten) {
		this.singleplayerFahrten = singleplayerFahrten;
	}

	public LinkedList<MultiplayerFahrt> getMultiplayerFahrten() {
		return multiplayerFahrten;
	}

	public void setMultiplayerFahrten(LinkedList<MultiplayerFahrt> multiplayerFahrten) {
		this.multiplayerFahrten = multiplayerFahrten;
	}

	
	
	/* 
	 * Methode: public LinkedList<SingleplayerFahrt> gibSingleplayerFahrten()
	 * Über die Datenbankschnittstelle werden alle SingleplayerFahrten über ein ResultSet ausgelesen.
	 * Dabei werden die Fahrten anschließend in der LinkedList der Fahrtverwaltung gespeichert.
	 * Im Anschluss wird noch die Methode closeConnections aufgerufen, damit die Verbindung und das ResultSet entsprechend geschlossen werden.
	 * Keine Parameter vorhanden.
	 * Die LinkedList wird am Ende zurückgegeben.
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
	/* 
	 * Methode: public LinkedList<SingleplayerFahrt> gibSingleplayerFahrtenFürBenutzerUndStrecke(String benutzername, String streckenname)
	 * Über die Datenbankschnittstelle werden alle SingleplayerFahrten für einen bestimmten Benutzer zu einer bestimmten Strecke ausgelesen.
	 * Die Parameter der Methode übergeben den Benutzernamen und den Streckennamen. Der entsprechende SQL-Befehl wird anschließend erstellt und über Datenbankschnittstelle.executeQuery ausgeführt.
	 * Dabei werden die Fahrten anschließend in der LinkedList der Fahrtverwaltung gespeichert.
	 * Im Anschluss wird noch die Methode closeConnections aufgerufen, damit die Verbindung und das ResultSet entsprechend geschlossen werden.
	 * Die LinkedList wird am Ende zurückgegeben.
	 */
	
	public LinkedList<SingleplayerFahrt> gibSingleplayerFahrtenFürBenutzerUndStrecke(String benutzername, String streckenname)
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
	
	
	/*
	 *  Methode: public LinkedList<SingleplayerFahrt> gibSingleplayerFahrtenFürBenutzer(String benutzername)
	 * Über die Datenbankschnittstelle werden alle SingleplayerFahrten für einen bestimmten Benutzer (alle Strecken) ausgelesen.
	 * Die Parameter der Methode übergeben den Benutzernamen. Der entsprechende SQL-Befehl wird anschließend erstellt und über Datenbankschnittstelle.executeQuery ausgeführt.
	 * Dabei werden die Fahrten anschließend in der LinkedList der Fahrtverwaltung gespeichert.
	 * Im Anschluss wird noch die Methode closeConnections aufgerufen, damit die Verbindung und das ResultSet entsprechend geschlossen werden.
	 * Die LinkedList wird am Ende zurückgegeben.
	 */
	public LinkedList<SingleplayerFahrt> gibSingleplayerFahrtenFürBenutzer(String benutzername)
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
	
	/*
	 *  Methode: public int gibNeueID(int a)
	 * Über die Datenbankschnittstelle wird die Anzahl an vorhandenen SingleplayerFahrten ausgelesen. Auf den Int-Wert wird am Ende +1 addiert.
	 * Über den Parameter (int a) wird entschieden ob die Relation "Multiplayer_Fahrt" oder die Relation "
	 * Die zu verwendende SitzungsID wird im Anschluss zurückgegeben.
	 */
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

	/*
	 *  Methode: public int gibNeueMultiplayerID()
	 * Über die Datenbankschnittstelle wird die Anzahl an vorhandenen MultiplayerFahrten ausgelesen. Auf den Int-Wert wird am Ende +1 addiert.
	 * Auf die Anzahl der MultiplayerID's wird dann +1 addiert.
	 * Die zu verwendende MultiplayerID wird im Anschluss zurückgegeben.
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
				System.out.println("MultiplayerID:"+id);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
		
	}
	
	/*
	 * Methode: public void sendeMultiplayerFahrt(MultiplayerFahrt mf)
	 * Die MultiplayerFahrt wird über die Datenbankschnittstelle an die Datenbank gesendet.
	 * Alle Verbindungen werden im Anschluss geschlossen.
	 */
	
	
	public void sendeMultiplayerFahrt(MultiplayerFahrt mf)
	{
			mf.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
			System.out.println(mf.getSitzungsID()+","+mf.getZeit()+","+mf.getMultiplayerID()+","+mf.getRang()+",'"+mf.getBenutzername()+"','"+mf.getStreckenName()+"','"+mf.getKartName());
		
			Datenbankschnittstelle.executeUpdate("insert into multiplayer_fahrt values("+mf.getSitzungsID()+","+mf.getZeit()+","+mf.getMultiplayerID()+","+mf.getRang()+",'"+mf.getBenutzername()+"','"+mf.getStreckenName()+"','"+mf.getKartName()+"')");
			Datenbankschnittstelle.closeConnections();
	}
	
	/*
	 * Methode: sendeSingleplayerFahrt(SingleplayerFahrt sf)
	 * Die SingleplayerFahrt wird über die Datenbankschnittstelle an die Datenbank gesendet.
	 * Alle Verbindungen werden im Anschluss geschlossen.
	 */
	
	public void sendeSingleplayerFahrt(SingleplayerFahrt sf)
	{
		sf.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
		System.out.println(sf.getSitzungsID()+","+sf.getZeit()+","+sf.getRang()+",'"+sf.getBenutzername()+"','"+sf.getStreckenName()+"','"+sf.getKartName()+"','"+sf.getSchwierigkeit()+"')");
		
			Datenbankschnittstelle.executeUpdate("insert into singleplayer_fahrt values("+sf.getSitzungsID()+","+sf.getZeit()+","+sf.getRang()+",'"+sf.getBenutzername()+"','"+sf.getStreckenName()+"','"+sf.getKartName()+"','"+sf.getSchwierigkeit()+"')");
			Datenbankschnittstelle.closeConnections();
	}
	
	/* 
	 * Methode: public LinkedList<MultiplayerFahrt> gibMultiplayerFahrten()
	 * Über die Datenbankschnittstelle werden alle MultiplayerFahrten über ein ResultSet ausgelesen.
	 * Dabei werden die Fahrten anschließend in der LinkedList der Fahrtverwaltung gespeichert.
	 * Im Anschluss wird noch die Methode closeConnections aufgerufen, damit die Verbindung und das ResultSet entsprechend geschlossen werden.
	 * Keine Parameter vorhanden.
	 * Die LinkedList wird am Ende zurückgegeben.
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
	
	/* 
	 * Methode:	public LinkedList<MultiplayerFahrt> gibMultiplayerFahrtenNachZeit(String name)
	 * Über die Datenbankschnittstelle werden alle MultiplayerFahrten einer bestimmten MultiplayerID über ein ResultSet ausgelesen.
	 * Dabei werden die Fahrten anschließend in der LinkedList der Fahrtverwaltung gespeichert.
	 * Im Anschluss wird noch die Methode closeConnections aufgerufen, damit die Verbindung und das ResultSet entsprechend geschlossen werden.
	 * Die LinkedList wird am Ende zurückgegeben.
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
		
		/* 
		 * Methode:	public LinkedList<MultiplayerFahrt> gibMultiplayerFahrtenNachZeit(String name)
		 * Über die Datenbankschnittstelle werden alle MultiplayerFahrten einer bestimmten MultiplayerID über ein ResultSet ausgelesen.
		 * Dabei werden die Fahrten anschließend in der LinkedList der Fahrtverwaltung gespeichert.
		 * Im Anschluss wird noch die Methode closeConnections aufgerufen, damit die Verbindung und das ResultSet entsprechend geschlossen werden.
		 * Die LinkedList wird am Ende zurückgegeben.
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
							System.out.println(fahrt.getSitzungsID());
							fahrt.setRang(rs.getInt("Rang"));
							fahrt.setMultiplayerID(rs.getInt("MultiplayerID"));
							fahrt.setZeit(rs.getInt("Zeit"));
							System.out.println(fahrt.getZeit());
							fahrt.setStreckenName(rs.getString("Streckenname"));
							fahrt.setKartName(rs.getString("Kartname"));
							fahrt.setBenutzername(rs.getString("Benutzername"));
							multiplayerFahrten.add(fahrt);
							
							System.out.println("Fahrtzeit: "+fahrt.getZeit());
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
		LinkedList<MultiplayerFahrt> fahrten = v.gibMultiplayerFahrtenNachMultiplayerID(10001);
		System.out.println("Gefahrene Fahrten:"+fahrten.size());
	}
}
