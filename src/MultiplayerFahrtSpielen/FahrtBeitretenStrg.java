package MultiplayerFahrtSpielen;

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
import MusicHandler.MusicPlayer;
import Strecke.Strecke;
import Strecke.Streckenverwaltung;
import myIterator.MyIteratorKart;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;
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
	
	/* 
	 * Konstruktor: public FahrtBeitretenStrg()
	 * das Objekt "view" der Klasse FahrtBeitretenView wird initialisiert. Anschließend werden die Karts über die Kartverwaltung geladen.
	 * Damit der ListIterator funktioniert wird hier wieder die angepasste Version"myIterator" verwendet. Anschleßend wird eine MultiplayerFahrt erzeugt.
	 */
	
	public FahrtBeitretenStrg() {
		view = new FahrtBeitretenView();
	
		//Initialisieren der Karts, Strecken und der Buttons
		karts = new Kartverwaltung();
		kartliste =karts.gibKart();
		
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
	

	/* 
	 * Methode:	public void ladeKarts()
	 * Die Methode prüft ob der ListIterator itKart ein weiteres Element hat. Wenn ja, dann wird die Grafik des neuen Element gesetzt und auch der Kartname aktualisiert.
	 * Keine Parameter vorhanden.
	 * 
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
	
	/* 
	 * Methode:	public void kartRückwärts()
	 * Die Methode prüft ob der ListIterator itKart ein Element n-1 hat. Wenn ja, dann wird die Grafik des neuen Element gesetzt und auch der Kartname aktualisiert.
	 * Keine Parameter vorhanden.
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
	
	/* 
	 * Methode:	public Strecke gibStrecke(LinkedList<Strecke> liste,String strecke)
	 * Die Methode bekommt als Parameter eine LinkedList<Strecke> und einen Streckennamen (String) übergeben.
	 * Anschließend wird über den Namen geprüft ob die Strecke vorhanden ist. Wenn ja wird das Objekt s der Klasse Strecke entsprechend der gefundenen Strecke initialisiert.
	 * Das Objekt s wird am Ende zurückgegeben.
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
	
	/* Methode: public void multiplayerBeitreten()
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
				
				
				
				mf.setZeit(50);
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
	
	}
	
	

	
	
	

}
