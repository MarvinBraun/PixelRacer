package Rechnung;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import Datenbankverwaltung.Datenbankschnittstelle;
import Kart.Kart;
import Nutzer.Nutzerverwaltung;
import Strecke.Strecke;

public class Rechnungsverwaltung {


	private LinkedList<Rechnung> rechnungenKart = new LinkedList<Rechnung>();
	private LinkedList<Rechnung> rechnungenStrecke= new LinkedList<Rechnung>();
	private static final DateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	static Date today = new Date();
	
	public static void sendeKartRechnung()
	{
		Rechnung r = new Rechnung();
	//	r.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
		r.setBenutzername("Marv");
		r.setBezahlmethode("Paypal");
		r.setKartname("FireBird");
		r.setRechnungsbetrag(5);
		r.setRechnungsnummer(gibNeueRechnungsNummerKart());
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yy");
		String date = DATE_FORMAT.format(today);
        System.out.println("Today in dd/MM/yy pattern : " + date);
        r.setRechnungsdatum(date);
		
		String sql = "insert into rechnungkart values("+r.getRechnungsnummer()+",'"+r.getBenutzername()+"',"+r.getRechnungsbetrag()+",'"+r.getRechnungsdatum()+"','"+r.getBezahlmethode()+"','"+r.getKartname()+"')";
		Datenbankschnittstelle.executeUpdate(sql);
		
		
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
		
	}
	
	public static void main(String[] args)
	{
		sendeKartRechnung();
	
	}
	
}
