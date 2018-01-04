package FahrtErstellen;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Fahrt.Fahrtverwaltung;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import FahrtSpielen.FahrtSpielenStrg;
import MusicHandler.MusicPlayer;
import Nutzer.Kunde;
import Nutzer.Nutzerverwaltung;
import Rechnung.Rechnung;
import Rechnung.Rechnungsverwaltung;
import Strecke.Strecke;
import Strecke.Streckenverwaltung;
import myIterator.MyIteratorKart;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;
import Kart.*;
import ModusAuswählen.ModusauswaehlenStrg;
import MultiplayerFahrtSpielen.MultiplayerFahrtSpielenStrg;
import MultiplayerFahrtSpielen.MultiplayerFahrtSpielenStrg;

/**
 * Die Klasse FahrtErstellenStrg steuert das Erstellen einer Fahrt. Sie verwaltet dabei die grafische Benutzeroberfläche (FahrtErstellenView).
 * @author Marvin Braun
 *
 */
public class FahrtErstellenStrg implements ActionListener {
	
	//Objekte der Klasse
	private FahrtErstellenView view;
	private boolean forward = false;
	private boolean backward = false;
	
	private Kartverwaltung karts;
	private Streckenverwaltung strecken;
	private Fahrtverwaltung fahrten;
	
	private static MyIteratorKart<Kart> itKart;
	private static MyIteratorString<String> itString;
	private static MyIteratorStrecke<Strecke> itStrecke;
	private static Iterator<SingleplayerFahrt> it;
	
	private LinkedList<String> schwierigkeiten;
	private LinkedList<Kart> kartliste = new LinkedList<Kart>();
	private LinkedList<Strecke> streckenliste = new LinkedList<Strecke>();
	private LinkedList<SingleplayerFahrt> schwierigkeitsCheck = new LinkedList<SingleplayerFahrt>();
	
	
	private BufferedImage streckenbild;
	private int singlemultiplayer;
	
	private SingleplayerFahrt sf;
	private MultiplayerFahrt mf;
	private Kart k;
	private Strecke s;
	private Kunde kunde;
	private int schwierigkeit=1;
	int counter=-1;
	
	/**
	 * Erzeugt ein neues Objekt der Klasse FahrtErstellenStrg und deklariert die entsprechenden Variablen.
	 * Bei einer SingleplayerFahrt wird zusätzlich die Schwierigkeit geladen.
	 * Bei einer MultiplayerFahrt wird eine MultiplayerID erzeugt.
	 * @param singleMultiplayer entscheidet ob es sich um eine SingleplayerFahrt oder eine MultiplayerFahrt handelt.
	 */
	public FahrtErstellenStrg(int singleMultiplayer) {
		view = new FahrtErstellenView();
	
		view.getFrame().setLocationRelativeTo(null);
		singlemultiplayer = singleMultiplayer;
		fahrten = new Fahrtverwaltung();
		kunde = Nutzerverwaltung.getangKunde();
		System.out.println(Nutzerverwaltung.getangKunde().getnutzername());
		
		//Initialisieren der Karts 
		karts = new Kartverwaltung();
		kartliste = gibZuFahrendeKarts();
		System.out.println("Zu verfüungstehende Karts:" +kartliste.size());
		itKart = new MyIteratorKart(kartliste.listIterator());
		ladeKarts();
		
		//Initialisieren der Strecke
		strecken= new Streckenverwaltung();
		streckenliste = strecken.gibStrecke();
		
		itStrecke = new MyIteratorStrecke(streckenliste.listIterator());
		
	
		
		//ActionListener
		view.getKartForward().addActionListener(this);
		view.getKartBackward().addActionListener(this);
		view.getStreckeBackward().addActionListener(this);
		view.getStreckeForward().addActionListener(this);
		view.getSpielenBtn().addActionListener(this);
		view.getBackBtn().addActionListener(this);
	

		//Initialisieren des Schwierigkeitsgrades
		//nur für Singleplayer
	
		if(singleMultiplayer==1)
		{
			schwierigkeiten = new LinkedList<String>();
			schwierigkeiten.add("Bronze");
			schwierigkeiten.add("Silber");
			schwierigkeiten.add("Gold");
			itString = new MyIteratorString(schwierigkeiten.listIterator());

			view.getSchwierigkeitBtn1().addActionListener(this);
			view.getSchwierigkeitBtn2().addActionListener(this);
	
			sf = new SingleplayerFahrt();
			sf.setSchwierigkeit("Bronze");
			sf.setBenutzername(kunde.getnutzername());
			sf.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
			view.getSchwierigkeitLbl().setText(sf.getSchwierigkeit());
			ladeStrecke();
			schwierigkeitsCheck = fahrten.gibSingleplayerFahrtenFürBenutzerUndStrecke(kunde.getnutzername(),s.getStreckenname());
			System.out.println("Fahrten:"+schwierigkeitsCheck.size());
			
		
		}
		//Initialisieren der MultiplayerID
		// nur für Multiplayer
		else
		{
			ladeStrecke();
			view.getSchwierigkeitBtn1().setVisible(false);
			view.getSchwierigkeitBtn2().setVisible(false);
			view.getSchwierigkeitLbl().setVisible(false);
			view.getMultiplayerLbl().setVisible(true);
			mf = new MultiplayerFahrt();
			int sitzungsID = fahrten.gibNeueID(1);
			view.getMultiplayerLbl().setText(""+sitzungsID);
			mf.setSitzungsID(sitzungsID);
			mf.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
			
			int multiplayerID = fahrten.gibNeueMultiplayerID();
			view.getMultiplayerLbl().setText(""+multiplayerID);
			mf.setMultiplayerID(multiplayerID);
		}
		
		SwingUtilities.updateComponentTreeUI(view.getFrame());
	
		SwingUtilities.updateComponentTreeUI(view.getFrame());
		
		
	}
	
	public static void main(String[] args)
	{
		FahrtErstellenStrg strg = new FahrtErstellenStrg(1);
		MusicPlayer.audioBackground();

	}

	/**
	 * Prüft ob ein weiteres Kart n+1 existiert. Wenn ja, werden die enstprechenden Felder der GUI aktualisiert.
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
			if(k.getPremium().equals("false") && k.getPunktewert()==0 || Nutzerverwaltung.getangKunde().getpunkte()>=k.getPunktewert())
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
	 * Prüft ob eine weitere Strecke n+1 existiert. Wenn ja, dann wird das Streckenbild über die Methode imageResizer(BufferedImage image) verkleinert und die GUI befüllt.
	 * 
	 */
	
	public void ladeStrecke()
	{
		if((s=itStrecke.next())!=null)
		{
			
			BufferedImage newImage= s.getGrafik();
			view.getStreckeName().setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			view.getStreckeLbl().setIcon(icon);
			itString = new MyIteratorString(schwierigkeiten.listIterator());
			sf.setSchwierigkeit(itString.next());
			view.getSchwierigkeitLbl().setText(sf.getSchwierigkeit());
			

		}
	}
	/** 
	 * Prüft ob ein weiteres Kart n-1 existiert. Wenn ja, werden die enstprechenden Felder der GUI aktualisiert.
	 * 
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
	 * Prüft ob eine weitere Strecke n-1 existiert. Wenn ja,  Wenn ja, dann wird das Streckenbild über die Methode imageResizer(BufferedImage image) verkleinert und die GUI befüllt.
	 */
	public void streckeRückwärts()
	{
		if((s=itStrecke.previous())!=null)
		{
			
			BufferedImage newImage= s.getGrafik();
			view.getStreckeName().setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			view.getStreckeLbl().setIcon(icon);
			itString = new MyIteratorString(schwierigkeiten.listIterator());	
			sf.setSchwierigkeit(itString.next());
			view.getSchwierigkeitLbl().setText(sf.getSchwierigkeit());
			
		}
	}
	
	

	
	
	
	
	
	
	/** 
	 * Die Methode verkleinert ein Objekt des Typs BufferedImage von 800x600 auf 300x200. Die Grafiken werden dabei über die Klasse Graphics neu gezeichnet.
	 * @return BufferedImage in der Größe 300x200.
	 */
	public static BufferedImage imageResizer(BufferedImage original)
	{
		
		BufferedImage newImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

				Graphics g = newImage.createGraphics();
				g.drawImage(original, 0, 0, 300, 200, null);
				g.dispose();
				return newImage;
	}
	
	/** 
	 * Die Methode prüft ob die Schwierigkeit n-1 existiert und springt wenn möglich auf dieses Element. Anschließend wird das TextFeld der GUI befüllt.
	 */
	
	public void schwierigkeitBack()
	{
		String s;
		if((s=itString.previous())!=null)
		{
			view.getSchwierigkeitLbl().setText(s);
			sf.setSchwierigkeit(s);
		}
		
		
	}
	
	public void pruefeKarts()
	{
		
	}
	
	public void pruefeStrecke()
	{
		
	}
	
	/** 
	 * Die Methode prüft ob die Schwierigkeit bereits für den Nutzer freigeschaltet ist. 
	 * @return boolean
	 */
	
	
	public boolean pruefeSchwierigkeit(String a)
	{
	System.out.println("Starte Methode PruefeSchwierigkeit");
	
		it = schwierigkeitsCheck.iterator();
		boolean pruefung = false;
		while(it.hasNext())
		{
			System.out.println("Starte Schleife");
			SingleplayerFahrt sf;
			
			System.out.println("Vergleiche:"+a);
			
			String check;
			
			sf = it.next();
			check = sf.getSchwierigkeit();
			System.out.println("Vergleich zu:"+check);
			if(a.equals(check) && sf.getRang()==1)
			{	
			pruefung = true;
			break;
			}	
		}
		return pruefung;
		
		
		
	}
	
	
	
	/** 
	 * Prüft ob eine Schwierigkeit n+1 existiert. Falls dies der Fall ist und der Spieler zum Spielen der Schwierigkeit berechtigt ist (pruefeSchwierigkeit() == true) dann wird auf dieses Element verwiesen und die GUI entsprechend aktualisiert.
	 */
	public void schwierigkeitVorwärts()
	{
		String s;
		String prüfung = sf.getSchwierigkeit();
		
		if((s=itString.next())!=null)
		{
			System.out.println("Bis hierhin kommt die Mtehode");
			System.out.println(prüfung);
			if(pruefeSchwierigkeit(prüfung)==true)
			{
			view.getSchwierigkeitLbl().setText(s);
			sf.setSchwierigkeit(s);
			}
			else
				{System.out.println("Schwierigkeit noch nicht freigeschaltet");
				JOptionPane pane = new JOptionPane();
				pane.setBounds(view.getFrame().getX()+300,view.getFrame().getY()+250,200,100);
				pane.showMessageDialog(null, "Schwierigkeit nocht nicht freigeschaltet");
					
				itString.previous();
				}
		}
		
	}
	/**
	 * Liest den Schwierigkeitswert bei einer SingleplayerFahrt aus und initialisert je nach Fahrtenart die entsprechenden Attribute. Anschließend wird die Fahrt gestartet.
	 * 
	 */
	public void starteSpiel()
	{
		if(singlemultiplayer==1)
		{
		String schwierigkeit1 = view.getSchwierigkeitLbl().getText();
		if(schwierigkeit1.equals("Bronze"))
			{
			schwierigkeit = 1;
			sf.setSchwierigkeit("Bronze");
			}
		
		
		if(schwierigkeit1.equals("Silber"))
		{
			sf.setSchwierigkeit("Silber");
			schwierigkeit = 2;
		}
		if(schwierigkeit1.equals("Gold"))
		{	
			sf.setSchwierigkeit("Gold");
			schwierigkeit = 3;
		
		}
			sf.setZeit(0);
		System.out.println("Schwierigkeit:" + schwierigkeit);
		int id = fahrten.gibNeueID(2);
		sf.setSitzungsID(id);
		
		sf.setKartName(k.getKartname());
		sf.setStreckenName(s.getStreckenname());
		FahrtSpielenStrg strg = new FahrtSpielenStrg(sf,k,s,schwierigkeit);

		}
		if(singlemultiplayer==2)
		{
			mf.setZeit(0);
			mf.setRang(0);
			MultiplayerFahrtSpielenStrg strg = new MultiplayerFahrtSpielenStrg(mf,k,s);
		}
		view.getFrame().dispose();
		
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */

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
		if(e.getSource()==view.getSchwierigkeitBtn1())
		{
			schwierigkeitBack();
		}
		if(e.getSource()==view.getSchwierigkeitBtn2())
		{
			schwierigkeitVorwärts();
		}
		if(e.getSource()==view.getSpielenBtn())
		{
		starteSpiel();
		}
		if(e.getSource()==view.getBackBtn())
		{
			ModusauswaehlenStrg strg = new ModusauswaehlenStrg();
			view.getFrame().dispose();
		}
		
		if(e.getSource()==view.getStreckeBackward())
		{
			streckeRückwärts();
		}
		if(e.getSource()==view.getStreckeForward())
		{
			ladeStrecke();
		}
		
	}
	
	

	
	
	

}
