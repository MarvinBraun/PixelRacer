package MultiplayerFahrt;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.Fahrtverwaltung;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import Kart.Kart;
import Kart.Kartverwaltung;
import ModusAuswählen.MultiplayerAuswahlStrg;
import MusicHandler.MusicPlayer;
import Nutzer.Nutzerverwaltung;
import Rechnung.Rechnung;
import Rechnung.Rechnungsverwaltung;
import Strecke.Strecke;
import Strecke.Streckenverwaltung;
import myIterator.MyIteratorKart;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;

/**
 * Steuerungsklasse, welche die grafische Benutzeroberfläche FahrtBeitretenView verwaltet und mit den Multientitäten (Verwaltungen).
 * @author Marvin Braun
 *
 */
public class FahrtBeitretenStrg implements ActionListener {
	
	//Objekte der Klasse
	private FahrtBeitretenView view;
	private boolean forward = false;
	private boolean backward = false;
	private Kart k;
	private Kartverwaltung karts;
	private static MyIteratorKart<Kart> itKart;
	private static MyIteratorString<String> itString;
	private int multi =2;
	
	private LinkedList<String> schwierigkeiten;
	private LinkedList<Kart> kartliste = new LinkedList<Kart>();

	private Streckenverwaltung verwaltungStrecke;
	private LinkedList<Strecke> Streckenliste ;
	
	private MultiplayerFahrt mf;
	
	/**
	 * Erzeugt ein Objekt der Klasse FahrtBeitretenStrg und befüllt das Objekt "view" der Klasse FahrtBeitretenView. 
	 * Ein ListIterator der Klasse MyIteratorKart wird erzeugt um das korrekte hin und her klicken zwischen den Karts zu gewährleisten.
	 */
	
	public FahrtBeitretenStrg() {
		view = new FahrtBeitretenView();
		view.getFrame().setLocationRelativeTo(null);
		//Initialisieren der Karts, Strecken und der Buttons
		karts = new Kartverwaltung();
		kartliste = gibZuFahrendeKarts();
		
		verwaltungStrecke = new Streckenverwaltung();
		Streckenliste = verwaltungStrecke.gibStrecke();
	
		k = kartliste.get(0);
		itKart = new MyIteratorKart(kartliste.listIterator());
		System.out.println(kartliste.size());
		view.getKartForward().addActionListener(this);
		view.getKartBackward().addActionListener(this);
		view.getMultiplayerBeitretenBtn().addActionListener(this);
		mf = new MultiplayerFahrt();
		ladeKarts();
		
		SwingUtilities.updateComponentTreeUI(view.getFrame());
		
	
		
	

		
	}
	
	
	public static void main(String[] args)
	{
		FahrtBeitretenStrg strg = new FahrtBeitretenStrg();
		MusicPlayer.audioBackground();

	}
	

	/**
	 * Die Methode prüft ob der ListIterator itKart ein weiteres Element hat. 
	 * Wenn ja, dann wird die Grafik des neuen Element gesetzt und auch der Kartname aktualisiert.
	 */
	public void ladeKarts()
	{
		if((k=itKart.next())!=null)
		{
			System.out.println(k.getKartname());
			ImageIcon icon = new ImageIcon(k.getGrafik());
			view.getKartBild().setIcon(icon);
			view.getKartName().setText(k.getKartname());
		}
	}
	
	/**
	 * Die Methode prüft ob der ListIterator itKart ein Element n-1 hat. 
	 * Wenn ja, dann wird die Grafik des neuen Element gesetzt und auch der Kartname aktualisiert.
	 */
	
	public void kartRückwärts()
	{
		
	
		if((k=itKart.previous())!=null)
		{
			System.out.println(k.getKartname());
			ImageIcon icon = new ImageIcon(k.getGrafik());
			view.getKartBild().setIcon(icon);
			view.getKartName().setText(k.getKartname());
		}
	
	}
	
	/** 
	 * Die Methode prüft ob eine Strecke vorhanden ist. Wenn ja wird das Objekt s der Klasse Strecke entsprechend der gefundenen Strecke initialisiert.
	 * @param liste
	 * @param strecke
	 * @return Das Objekt s der Klasse Strecke.
	 */
	
	public Strecke gibStrecke(LinkedList<Strecke> liste,String strecke)
	{
		Strecke s = null;
		
		ListIterator<Strecke> it = liste.listIterator();
		
		while(it.hasNext())
		{ 
			
			s = it.next();
			System.out.println(s.getStreckenname() + " vergleich zu: "+ strecke);
			if(strecke.equals(s.getStreckenname()))
			{
				break;
			}
			else
				System.out.println("Strecke nicht gefunden");
		}
		
		return s;
		
	}
	
	public LinkedList<Kart> gibZuFahrendeKarts()
	{
		LinkedList<Kart> alleKarts = new LinkedList<Kart>();
		
		Kartverwaltung karts1 = new Kartverwaltung();
		
		//Laden aller Karts
		alleKarts =karts1.gibKart();
		System.out.println("Anzahl Karts insgesamt:"+alleKarts.size());
		Iterator<Kart> it = alleKarts.iterator();
		
		//Laden der Rechnungsliste
		LinkedList<Rechnung> kartrechnungen = Rechnungsverwaltung.gibKartRechnungenfuerBenutzer();
		System.out.println("Länge der Recnungen des Benutzers:" + kartrechnungen.size());
		Iterator<Rechnung> itR = kartrechnungen.iterator();
		
		//Leere LinkedList für Karts des Benutzers:
		kartliste = new LinkedList<Kart>();
		
		//Laden der kostenlosen Karts
		Kart k= null;
		while(it.hasNext())
		{
			
			k = it.next();
			if(k.getPremium().equals("false") && k.getPunktewert()==0 || Nutzerverwaltung.getangKunde().getpunkte()>=k.getPunktewert()&&k.getPunktewert()>0)
			{
				System.out.println("Wird hinzugefügt: "+ k.getKartname());
				kartliste.add(k);
			}
		}
		
		//Laden der gekauften Karts
		Rechnung r = null;
		while(itR.hasNext())
		{
			r = itR.next();
			String kartName;
			kartName = r.getKartname();
			System.out.println("Zu suchendes Kart"+ kartName);
			
			Iterator<Kart> itN = alleKarts.iterator();
		
			while(it.hasNext())
			{
				
				k = it.next();
				System.out.println("Vergleiche: "+kartName + " mit: "+k.getKartname() );
				if(k.getKartname().equals(kartName))
				{	
					System.out.println("Wird hinzugefügt über Rechnungen: "+ k.getKartname());
					kartliste.add(k);
				}
			}
		}
		return kartliste;
	}
	
	
	/**
	 * Sucht die MultiplayerID aus der Fahrtenliste mithilfe eines Iterators. Wenn die MultiplayerID existiert, werden dem Objekt "mf" der Klasse MultiplayerFahrt die
	 * entsprechenden Werte zugewiesen. Anschließend wird die nächsthöhere SitungsID (PK der Relation MultiplayerFahrt) ermittelt und dem Objekt mf zugewiesen.
	 * Anschließend wird ein Objekt der Klasse MultiplayerFahrtSpielenStrg erzeugt und die entsprechenden Objekte übergeben.
	 * Falls die ID nicht gefunden wird, wird ein JOptionPane erstellt mit dem Hinweis, eine gültige ID einzugeben. 
	 */
	
	public void multiplayerBeitreten()
	{
		boolean gefunden = false;
		Fahrtverwaltung verwaltung = new Fahrtverwaltung();
		LinkedList<MultiplayerFahrt> fahrten = verwaltung.gibMultiplayerFahrten();
		String a = view.getMultiplayerID().getText();
		int multiplayerID = Integer.parseInt(a);
		System.out.println(multiplayerID);
		
		Iterator<MultiplayerFahrt> it = fahrten.iterator();
		
		while(it.hasNext())
		{
			
			
			MultiplayerFahrt fahrt = it.next();
			if(multiplayerID==fahrt.getMultiplayerID() && gefunden==false)
			{
				gefunden=true;
				System.out.println("Hallo");
				mf = new MultiplayerFahrt();
				mf.setMultiplayerID(multiplayerID);
				mf.setStreckenName(fahrt.getStreckenName());
				mf.setBenutzername("HMuller");
				
				//Hole Strecke aus DB
				System.out.println(mf.getStreckenName());
				Strecke s = gibStrecke(Streckenliste, mf.getStreckenName());
				
				
				
				mf.setZeit(100);
				mf.setRang(99);
				mf.setKartName(k.getKartname());
				int id = verwaltung.gibNeueID(1);
				mf.setSitzungsID(id);
				System.out.println("erfolg!");	
					
				
				MultiplayerFahrtSpielenStrg strg = new MultiplayerFahrtSpielenStrg(mf,k,s);
				
			}
			
			
		}
		if(gefunden==false)
		{
			JOptionPane.showMessageDialog(null, "Die eingegebene ID existiert nicht. Bitte geben Sie eine gültige ID ein.");
		}

}
	
		
			
			
		
		
	
			
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==view.getKartForward())
		{
			ladeKarts();
		}
		if(e.getSource()==view.getKartBackward())
		{
			kartRückwärts();
			
		}
		if(e.getSource()==view.getMultiplayerBeitretenBtn())
		{
			multiplayerBeitreten();
		}
		if(e.getSource()==view.getBackBtn())
		{
			view.getFrame().dispose();
			MultiplayerAuswahlStrg strg = new MultiplayerAuswahlStrg();
		}
	
	}
	
	

	
	
	

}
