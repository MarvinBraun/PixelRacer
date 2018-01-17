package SingleplayerFahrt;
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
import Iterator.IteratorKart;
import Iterator.IteratorStrecke;
import Iterator.IteratorString;
import MusicHandler.MusicPlayer;
import Nutzer.Kunde;
import Nutzer.Nutzerverwaltung;
import Rechnung.Rechnung;
import Rechnung.Rechnungsverwaltung;
import Strecke.Strecke;
import Strecke.Streckenverwaltung;
import Kart.*;

import MultiplayerFahrt.*;

/**
 * Die Klasse FahrtErstellenStrg steuert das Erstellen einer Fahrt. Sie verwaltet dabei die grafische Benutzeroberfl�che (FahrtErstellenView).
 * @author Marvin Braun
 *
 */
public class FahrtErstellenStrg implements ActionListener {
	
	//Objekte der Klasse
	private FahrtErstellenView view;
	private Fahrtverwaltung fahrten;
	
	private static IteratorKart<Kart> itKart;
	private static IteratorString<String> itString;
	private static IteratorStrecke<Strecke> itStrecke;
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
	 * Bei einer SingleplayerFahrt wird zus�tzlich die Schwierigkeit geladen.
	 * Bei einer MultiplayerFahrt wird eine MultiplayerID erzeugt.
	 * @param singleMultiplayer entscheidet ob es sich um eine SingleplayerFahrt oder eine MultiplayerFahrt handelt.
	 */
	public FahrtErstellenStrg(int singleMultiplayer) {
		
		//View initialisieren, zentrieren, Fahrtverwaltung initialisieren, Kunde wird geladen
		singlemultiplayer = singleMultiplayer;
		view = new FahrtErstellenView();
	
		fahrten = new Fahrtverwaltung();
		kunde = Nutzerverwaltung.getangKunde();
		
		new Kartverwaltung();
		kartliste = gibZuFahrendeKarts();
		itKart = new IteratorKart(kartliste.listIterator());
		
		//Lade Karts
		ladeKarts();
		
		//Initialisieren der Strecke
		streckenliste = gibZuFahrendStrecken();
		itStrecke = new IteratorStrecke(streckenliste.listIterator());

		
	
		
		//ActionListener
		view.getKartForward().addActionListener(this);
		view.getKartBackward().addActionListener(this);
		view.getStreckeBackward().addActionListener(this);
		view.getStreckeForward().addActionListener(this);
		view.getSpielenBtn().addActionListener(this);
		view.getBackBtn().addActionListener(this);

		//Initialisieren des Schwierigkeitsgrades
		//nur f�r Singleplayer
	
		if(singleMultiplayer==1)
		{	
			
			schwierigkeiten = new LinkedList<String>();
			schwierigkeiten.add("Bronze");
			schwierigkeiten.add("Silber");
			schwierigkeiten.add("Gold");
			itString = new IteratorString(schwierigkeiten.listIterator());

			view.getSchwierigkeitBtn1().addActionListener(this);
			view.getSchwierigkeitBtn2().addActionListener(this);
	
			sf = new SingleplayerFahrt();
			sf.setSchwierigkeit("Bronze");
			sf.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
			view.getSchwierigkeitLbl().setText(sf.getSchwierigkeit());
			ladeStrecke();
			
			schwierigkeitsCheck = fahrten.gibSingleplayerFahrtenFuerBenutzerUndStrecke(kunde.getnutzername(),s.getStreckenname());
		}
		
		//Initialisieren der MultiplayerID
		// nur f�r Multiplayer
		
		else
		{
		
			view.getSchwierigkeitBtn1().setVisible(false);
			view.getSchwierigkeitBtn2().setVisible(false);
			view.getSchwierigkeitLbl().setVisible(false);
			view.getMultiplayerLbl().setVisible(true);
			mf = new MultiplayerFahrt();
			int sitzungsID = fahrten.gibNeueID(1);
			mf.setSitzungsID(sitzungsID);
			mf.setBenutzername(Nutzerverwaltung.getangKunde().getnutzername());
			
			int multiplayerID = fahrten.gibNeueMultiplayerID();
			view.getMultiplayerLbl().setText("MultiplayerID: "+multiplayerID);
			mf.setMultiplayerID(multiplayerID);
			ladeStrecke();
		}
		
		SwingUtilities.updateComponentTreeUI(view.getFrame());
		
	}
	
	public static void main(String[] args)
	{
		FahrtErstellenStrg strg = new FahrtErstellenStrg(1);
		MusicPlayer.audioBackground();

	}

	/**
	 * Pr�ft ob ein weiteres Kart n+1 existiert. Wenn ja, werden die enstprechenden Felder der GUI aktualisiert.
	 */
	public void ladeKarts()
	{
		try {
		if((k=itKart.next())!=null)
		{
			ImageIcon icon = new ImageIcon(k.getGrafik());
			view.getKartBild().setIcon(icon);
			view.getKartName().setText(k.getKartname());
		
		}
		}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null,
	                "Du hast noch keine weiteren Karts freigeschaltet. Besuche dein Profil um Karts zu Kaufen.",
	                "Keine weiteren Karts",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.PLAIN_MESSAGE);
			
		}
	}
	/**
	 * L�dt alle kostenlosen, sowie gekauften bzw. durch Punkte freigeschaltete Karts f�r den Benutzer.
	 * @return @return LinkedList mit den Karts die benutzt werden k�nnen
	 */
	public LinkedList<Kart> gibZuFahrendeKarts()
	{
		LinkedList<Kart> alleKarts = new LinkedList<Kart>();
		
		Kartverwaltung karts1 = new Kartverwaltung();
		
		//Laden aller Karts
		alleKarts =karts1.gibKart();
		Iterator<Kart> it = alleKarts.iterator();
		
		//Laden der Rechnungsliste
		LinkedList<Rechnung> kartrechnungen = Rechnungsverwaltung.gibKartRechnungenfuerBenutzer();
		Iterator<Rechnung> itR = kartrechnungen.iterator();
		
		//Leere LinkedList f�r Karts des Benutzers:
		kartliste = new LinkedList<Kart>();
		
		//Laden der kostenlosen Karts
		Kart k= null;
		while(it.hasNext())
		{
			
			k = it.next();
			if(k.getPremium().equals("false") && k.getPunktewert()==0 || Nutzerverwaltung.getangKunde().getpunkte()>=k.getPunktewert()&&k.getPunktewert()>0)
			{
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
			
			Iterator<Kart> itN = alleKarts.iterator();
		
			while(itN.hasNext())
			{
				
				k = itN.next();
			
				if(k.getKartname().equals(kartName))
				{	
					kartliste.add(k);
				}
			}
		}
		return kartliste;
	}
	

	/**
	 * L�dt alle kostenlosen, sowie gekauften bzw. durch Punkte freigeschalteten Strecken f�r den Benutzer.
	 * @return LinkedList mit den Strecken die befahren werden k�nnen
	 */
	public LinkedList<Strecke> gibZuFahrendStrecken()
	{
		LinkedList<Strecke> alleStrecken = new LinkedList<Strecke>();
		
		Streckenverwaltung strecke1 = new Streckenverwaltung();
		
		//Laden aller Karts
		alleStrecken =strecke1.gibStrecke();
		Iterator<Strecke> it = alleStrecken.iterator();
		
		//Laden der Rechnungsliste
		LinkedList<Rechnung> streckenrechnungen = Rechnungsverwaltung.gibStreckenRechnungenfuerBenutzer();
		Iterator<Rechnung> itR = streckenrechnungen.iterator();
		
		//Leere LinkedList f�r Karts des Benutzers:
		streckenliste = new LinkedList<Strecke>();
		
		//Laden der kostenlosen Karts
		Strecke s= null;
		while(it.hasNext())
		{
			
			s = it.next();
			if(s.getPremium().equals("false") && s.getPunktewert()==0 || Nutzerverwaltung.getangKunde().getpunkte()>=s.getPunktewert() && s.getPremium().equals("false"))
			{
				
				streckenliste.add(s);
			}
		}
		
		//Laden der gekauften Karts
		Rechnung r = null;
		while(itR.hasNext())
		{
			r = itR.next();
			String streckenName;
			streckenName = r.getStreckenname();
			
			 
			
			it = alleStrecken.iterator();
			
		
			
			while(it.hasNext())
			{
				
				s = it.next();
				 

				if(s.getStreckenname().equals(streckenName))
				{	
					streckenliste.add(s);
				}
			}
		}
		return streckenliste;
	}
	
	/**
	 * Pr�ft ob eine weitere Strecke n+1 existiert. Wenn ja, dann wird das Streckenbild �ber die Methode imageResizer(BufferedImage image) verkleinert und die GUI bef�llt.
	 * 
	 */
	
	public void ladeStrecke()
	{
		try {
			if((s=itStrecke.next())!=null)
			{
				
				BufferedImage newImage= s.getGrafik();
				view.getStreckeName().setText(s.getStreckenname());
				streckenbild = imageResizer(newImage);
				ImageIcon icon = new ImageIcon(streckenbild);
				view.getStreckeLbl().setIcon(icon);
				
			
				if(singlemultiplayer==1)
				{
					itString = new IteratorString(schwierigkeiten.listIterator());
					sf.setSchwierigkeit(itString.next());
					view.getSchwierigkeitLbl().setText(sf.getSchwierigkeit());
				}

			}
		}
		
		
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null,
	                "Du hast noch keine weiteren Strecken freigeschaltet. Besuche dein Profil um Strecken zu Kaufen.",
	                "Keine weiteren Strecken",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.PLAIN_MESSAGE);
		}
	}
	/** 
	 * Pr�ft ob ein weiteres Kart n-1 existiert. Wenn ja, werden die enstprechenden Felder der GUI aktualisiert.
	 * 
	 */
	public void kartR�ckw�rts()
	{
		
	try {
		if((k=itKart.previous())!=null)
		{
			ImageIcon icon = new ImageIcon(k.getGrafik());
			view.getKartBild().setIcon(icon);
			view.getKartName().setText(k.getKartname());
		
		}
	}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null,
	                "Du hast noch keine weiteren Karts freigeschaltet. Besuche dein Profil um Karts zu Kaufen.",
	                "Keine weiteren Karts",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.PLAIN_MESSAGE);
		}
	
	}
	
	/** 
	 * Pr�ft ob eine weitere Strecke n-1 existiert. Wenn ja,  Wenn ja, dann wird das Streckenbild �ber die Methode imageResizer(BufferedImage image) verkleinert und die GUI bef�llt.
	 */
	public void streckeR�ckw�rts()
	{
		try {
		if((s=itStrecke.previous())!=null)
		{
			
			BufferedImage newImage= s.getGrafik();
			view.getStreckeName().setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			view.getStreckeLbl().setIcon(icon);
			if(singlemultiplayer==1)
			{
				itString = new IteratorString(schwierigkeiten.listIterator());	
				sf.setSchwierigkeit(itString.next());
				view.getSchwierigkeitLbl().setText(sf.getSchwierigkeit());
			}
			
		}
		}
		catch(Exception e)
		{
			JOptionPane.showConfirmDialog(null,
	                "Du hast noch keine weiteren Strecken freigeschaltet. Besuche dein Profil um Strecken zu Kaufen.",
	                "Keine weiteren Strecken",
	                JOptionPane.DEFAULT_OPTION,
	                JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	

	
	
	
	
	
	
	/** 
	 * Die Methode verkleinert ein Objekt des Typs BufferedImage von 800x600 auf 300x200. Die Grafiken werden dabei �ber die Klasse Graphics neu gezeichnet.
	 * @return BufferedImage in der Gr��e 300x200.
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
	 * Die Methode pr�ft ob die Schwierigkeit n-1 existiert und springt wenn m�glich auf dieses Element. Anschlie�end wird das TextFeld der GUI bef�llt.
	 */
	
	public void schwierigkeitBack()
	{
		try {
		String s;
		if((s=itString.previous())!=null)
		{
			view.getSchwierigkeitLbl().setText(s);
			sf.setSchwierigkeit(s);
		}
		}
		catch(Exception e)
		{
			
		}
		
		
		
	}
	
	/** 
	 * Die Methode pr�ft ob die Schwierigkeit bereits f�r den Nutzer freigeschaltet ist. 
	 * @return boolean
	 */
	
	public boolean pruefeSchwierigkeit(String a)
	{
		schwierigkeitsCheck = fahrten.gibSingleplayerFahrtenFuerBenutzerUndStrecke(kunde.getnutzername(),s.getStreckenname());
		it = schwierigkeitsCheck.iterator();
		boolean pruefung = false;
		while(it.hasNext())
		{
			SingleplayerFahrt sf;
			
			String check;
			
			sf = it.next();
			check = sf.getSchwierigkeit();
		
			if(a.equals(check) && sf.getRang()==1 && s.getStreckenname().equals(sf.getStreckenName()))
			{	
			pruefung = true;
			break;
			}	
		}
		return pruefung;
		
		
		
	}
	
	
	
	/** 
	 * Pr�ft ob eine Schwierigkeit n+1 existiert. Falls dies der Fall ist und der Spieler zum Spielen der Schwierigkeit berechtigt ist (pruefeSchwierigkeit() == true) dann wird auf dieses Element verwiesen und die GUI entsprechend aktualisiert.
	 */
	public void schwierigkeitVorw�rts()
	{
		try {
		String s;
		String pr�fung = sf.getSchwierigkeit();
		
		if((s=itString.next())!=null)
		{
			if(pruefeSchwierigkeit(pr�fung)==true)
			{
			view.getSchwierigkeitLbl().setText(s);
			sf.setSchwierigkeit(s);
			}
			else
				{
		
				JOptionPane pane = new JOptionPane();
				pane.setBounds(view.getFrame().getX()+300,view.getFrame().getY()+250,200,100);
				pane.showMessageDialog(null, "Schwierigkeit nocht nicht freigeschaltet");
			
				itString.previous();
				}
		}
		}
		catch(Exception e)
		{
			
		}
		
	}
	/**
	 * Liest den Schwierigkeitswert bei einer SingleplayerFahrt aus und initialisert je nach Fahrtenart die entsprechenden Attribute. Anschlie�end wird die Fahrt gestartet.
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
			MusicHandler.MusicPlayer.forwardBtn();
		}
		if(e.getSource()==view.getKartBackward())
		{
			MusicHandler.MusicPlayer.backwardBtn();
			kartR�ckw�rts();
			
		}
		if(e.getSource()==view.getSchwierigkeitBtn1())
		{
			MusicHandler.MusicPlayer.backwardBtn();
			schwierigkeitBack();
		}
		if(e.getSource()==view.getSchwierigkeitBtn2())
		{
			MusicHandler.MusicPlayer.forwardBtn();
			schwierigkeitVorw�rts();
		}
		if(e.getSource()==view.getSpielenBtn())
		{
			MusicHandler.MusicPlayer.forwardBtn();
		starteSpiel();
		}
		if(e.getSource()==view.getBackBtn())
		{
			MusicHandler.MusicPlayer.backwardBtn();
			ModusAuswaehlen.ModusauswaehlenStrg strg = new ModusAuswaehlen.ModusauswaehlenStrg();
			view.getFrame().dispose();
		}
		
		if(e.getSource()==view.getStreckeBackward())
		{
			MusicHandler.MusicPlayer.backwardBtn();
			streckeR�ckw�rts();
		}
		if(e.getSource()==view.getStreckeForward())
		{
			MusicHandler.MusicPlayer.forwardBtn();
			ladeStrecke();
		}
		
	}
	
	

	
	
	

}
