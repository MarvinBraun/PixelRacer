//Autor Marvin Braun, Daniel Zeller

package Rechnung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.SingleplayerFahrt;
import Kart.Kart;
import Nutzer.Nutzerverwaltung;
import Strecke.Strecke;

public class Rechnungsverwaltung {


	private static LinkedList<Rechnung> rechnungenKart = new LinkedList<Rechnung>();
	private static LinkedList<Rechnung> rechnungenStrecke= new LinkedList<Rechnung>();
	private static Date today = new Date();
	
	public static void sendeKartRechnung(Kart k)
	{
		Rechnung r = new Rechnung();
		r.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
		r.setBezahlmethode("Paypal");
		r.setKartname(k.getKartname());
		r.setRechnungsbetrag(5);
		r.setRechnungsnummer(gibNeueRechnungsNummerKart());
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yy");
		String date = DATE_FORMAT.format(today);
        System.out.println("Today in dd/MM/yy pattern : " + date);
        r.setRechnungsdatum(date);
		
		String sql = "insert into rechnungkart values("+r.getRechnungsnummer()+",'"+r.getBenutzername()+"',"+r.getRechnungsbetrag()+",'"+r.getRechnungsdatum()+"','"+r.getBezahlmethode()+"','"+r.getKartname()+"')";
		Datenbankschnittstelle.executeUpdate(sql);
		Datenbankschnittstelle.closeConnections();
		
		System.out.println("Erfolg");
	}
	
	public static int gibNeueRechnungsNummerKart()
	{

		int id=0;
		ResultSet rs = null;
		rs = Datenbankschnittstelle.executeQuery("select max(rechnungsnummer) from rechnungkart");
		try {
			while(rs.next())
			{

				id = rs.getInt("max(Rechnungsnummer)");
				id++;
				System.out.println("rechnungsnummer:"+id);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return id;
	}
	

	
	public static int gibNeueRechnungsNummerStrecke()
	{

		int id=0;
		ResultSet rs = null;
		rs = Datenbankschnittstelle.executeQuery("select max(rechnungsnummer) from rechnungstrecke");
		try {
			while(rs.next())
			{

				id = rs.getInt("max(Rechnungsnummer)");
				id++;
				System.out.println("rechnungsnummer:"+id);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return id;
	}
	
	
	public static void sendeStreckenRechnung(Strecke s)
	{
		Rechnung r = new Rechnung();
	r.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
			r.setBezahlmethode("Paypal");
			r.setKartname(s.getStreckenname());
			r.setRechnungsbetrag(5);
			r.setRechnungsnummer(gibNeueRechnungsNummerStrecke());
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yy");
			String date = DATE_FORMAT.format(today);
	        System.out.println("Today in dd/MM/yy pattern : " + date);
	        r.setRechnungsdatum(date);
			
			String sql = "insert into rechnungstrecke values("+r.getRechnungsnummer()+",'"+r.getBenutzername()+"',"+r.getRechnungsbetrag()+",'"+r.getRechnungsdatum()+"','"+r.getBezahlmethode()+"','"+r.getKartname()+"')";
			Datenbankschnittstelle.executeUpdate(sql);
			Datenbankschnittstelle.closeConnections();
			
			System.out.println("Erfolg");
	}
	
	public static LinkedList<Rechnung> gibKartRechnungenfuerBenutzer()
	{
		Rechnung r = null;
		
		
		String benutzername = Nutzerverwaltung.getangKunde().getnutzername();
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from rechnungkart where benutzername='"+benutzername+"'");
		try {
			while(rs.next())
			{
				r = new Rechnung();
				r.setBenutzername(rs.getString("Benutzername"));
				r.setKartname(rs.getString("Kartname"));
				r.setBezahlmethode(rs.getString("Bezahlmethode"));
				r.setRechnungsbetrag(rs.getInt("Rechnungsbetrag"));
				r.setRechnungsnummer(rs.getInt("Rechnungsnummer"));
				String datum = rs.getDate("Rechnungsdatum").toString();
				r.setRechnungsdatum(datum);
				
				rechnungenKart.add(r);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return rechnungenKart;
	}
	
	public static LinkedList<Rechnung> gibStreckenRechnungenfuerBenutzer()
	{

		Rechnung r = null;
		String benutzername = Nutzerverwaltung.getangKunde().getnutzername();
		ResultSet rs = Datenbankschnittstelle.executeQuery("select * from rechnungstrecke where benutzername='"+benutzername+"'");
		try {
			while(rs.next())
			{
				r = new Rechnung();
				r.setBenutzername(rs.getString("Benutzername"));
				r.setStreckenname(rs.getString("Streckenname"));
				r.setBezahlmethode(rs.getString("Bezahlmethode"));
				r.setRechnungsbetrag(rs.getInt("Rechnungsbetrag"));
				r.setRechnungsnummer(rs.getInt("Rechnungsnummer"));
				String datum = rs.getDate("Rechnungsdatum").toString();
				r.setRechnungsdatum(datum);
				
				rechnungenStrecke.add(r);
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Datenbankschnittstelle.closeConnections();
		return rechnungenStrecke;
	}
	
	public static void main(String[] args)
	{
		gibKartRechnungenfuerBenutzer();
		
		for(int i = 0; i<rechnungenKart.size();i++)
		{
			System.out.println("Nr: "+rechnungenKart.get(i).getRechnungsnummer());
		}
		
		gibStreckenRechnungenfuerBenutzer();
		
		for(int i = 0; i<rechnungenStrecke.size();i++)
		{
			System.out.println("2. Nr: "+rechnungenStrecke.get(i).getRechnungsnummer());
		}
	
	}
	
}
