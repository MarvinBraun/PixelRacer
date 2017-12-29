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
import Strecke.Strecke;
import Strecke.Streckenverwaltung;
import myIterator.MyIteratorKart;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;
import Kart.*;
import ModusAusw�hlen.ModusauswaehlenStrg;
import MultiplayerFahrtSpielen.MultiplayerFahrtSpielenStrg;
import MultiplayerFahrtSpielen.MultiplayerFahrtSpielenStrg;

/**
 * Die Klasse FahrtErstellenStrg steuert das Erstellen einer Fahrt. Sie verwaltet dabei die grafische Benutzeroberfl�che (FahrtErstellenView).
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
	
	/* 
	 * Konstruktor: public FahrtErstellenStrg (int singleMultiplayer)
	 * Eine Neue FahrtErstellenStrg wird erzeugt. Dabei wird die Variable int "singleMultiplayer" verwendet um zu entscheiden ob es sich um eine 
	 * Single oder MultiplayerFahrt handelt. Ungeachtet dessen, wird im Konstruktor die GUI "view" der Klasse FahrtErstellenView erzeugt. 
	 * Objekte die f�r beide Fahrten gebraucht werden (Kunde, Kart, Strecke) werden im Anschluss deklariert.
	 * Au�erdem m�ssen spezielle Listiteratoren der Klasse myIterator verwendet werden, da ein Nutzer sonst bei dem Dr�cken auf "Vorw�rts" 
	 * und anschlie�end auf "R�ckw�rts" das gleiche Objekt angezeigt bekommt, da der Zeiger des normalen Listiterators zwischen zwei Objekten platziert ist. 
	 * Bei einer SingleplayerFahrt werden au�erdem Schwierigkeiten hinzugef�gt.
	 * Bei einem MultiplayerFahrt wird eine MultiplayerID generiert.
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
		kartliste =karts.gibKart();
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
		//nur f�r Singleplayer
	
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
			ladeStrecke();
			schwierigkeitsCheck = fahrten.gibSingleplayerFahrtenF�rBenutzerUndStrecke(kunde.getnutzername(),s.getStreckenname());
			
		
		}
		//Initialisieren der MultiplayerID
		// nur f�r Multiplayer
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

	/* 
	 * Methode:	public void ladeKarts()
	 * Die Methode pr�ft ob der ListIterator itKart ein weiteres Element hat. Wenn ja, dann wird die Grafik des neuen Element gesetzt und auch der Kartname aktualisiert.
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
	 * Methode:	public void ladeStrecke()
	 * Die Methode pr�ft ob der ListIterator itStrecke ein weiteres Element hat. Wenn ja, wird die Grafik entsprechend von 800x600 auf 300x200 �ber die Methode "imageResizer(BufferedImage image)"
	 * verkleinert und dann in der View aktualisiert. Der Name wird ebenfalls aktualisiert. Der Schwierigkeiten Iterator "itString" wird dabei zur�ckgesetzt, 
	 * da sonst z.B. erst die Schwierigkeit Silber ausgesucht werden k�nnte und dann auf die n�chste Strecke geklickt werden k�nnte.
	 * Keine Parameter vorhanden.
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
			
			view.getSchwierigkeitLbl().setText(itString.next());
			
		
		}
	}
	/* 
	 * Methode:	public void kartR�ckw�rts()
	 * Die Methode pr�ft ob der ListIterator itKart ein Element n-1 hat. Wenn ja, dann wird die Grafik des neuen Element gesetzt und auch der Kartname aktualisiert.
	 * Keine Parameter vorhanden.
	 */
	public void kartR�ckw�rts()
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
	 * Methode:	public void ladeStrecke()
	 * Die Methode pr�ft ob der ListIterator itStrecke ein Element n-1 hat. Wenn ja, wird die Grafik entsprechend von 800x600 auf 300x200 �ber die Methode "imageResizer(BufferedImage image)"
	 * verkleinert und dann in der View aktualisiert. Der Name wird ebenfalls aktualisiert. Der Schwierigkeiten Iterator "itString" wird dabei zur�ckgesetzt, 
	 * da sonst z.B. erst die Schwierigkeit Silber ausgesucht werden k�nnte und dann auf die n�chste Strecke geklickt werden k�nnte.
	 * Keine Parameter vorhanden.
	 * 
	 */
	
	public void streckeR�ckw�rts()
	{
		if((s=itStrecke.previous())!=null)
		{
			
			BufferedImage newImage= s.getGrafik();
			view.getStreckeName().setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			view.getStreckeLbl().setIcon(icon);
			itString = new MyIteratorString(schwierigkeiten.listIterator());	
			view.getSchwierigkeitLbl().setText(itString.next());
			
		}
	}
	

	
	
	
	
	
	
	/* 
	 * Methode:	public static BufferedImage imageResizer(BufferedImage original)
	 * Die Methode verkleinert ein Objekt des Typs BufferedImage von 800x600 auf 300x200. Die Grafiken werden dabei �ber die Klasse Graphics neu gezeichnet.
	 * Anschlie�end wird das Bild zur�ckgegeben.
	 */
	public static BufferedImage imageResizer(BufferedImage original)
	{
		
		BufferedImage newImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

				Graphics g = newImage.createGraphics();
				g.drawImage(original, 0, 0, 300, 200, null);
				g.dispose();
				return newImage;
	}
	
	/* 
	 * Methode:	public void schwierigkeitBack()
	 * Die Methode pr�ft ob das Element n-1 existiert und springt wenn m�glich auf dieses Element. Anschlie�end wird das TextFeld der GUI gesetzt.
	 */
	
	public void schwierigkeitBack()
	{
		String s;
		if((s=itString.previous())!=null)
		{
			view.getSchwierigkeitLbl().setText(s);
		}
		
		
	}
	
	public void pruefeKarts()
	{
		
	}
	
	public void pruefeStrecke()
	{
		
	}
	
	/* 
	 * Methode:	public boolean pruefeSchwierigkeit(String a)
	 * Die Methode pr�ft ob die Schwierigkeit bereits f�r den Nutzer freigeschaltet ist. Wenn ja, dann wird ein boolean = true zur�ck geliefert.
	 */
	
	
	public boolean pruefeSchwierigkeit(String a)
	{
	
		it = schwierigkeitsCheck.iterator();
		boolean pruefung = false;
		while(it.hasNext())
		{
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
	
	/* 
	 * Methode:	public void schwierigkeitVorw�rts()
	 * Die Methode iteriert eine Schwierigkeit nach vorne, wenn die aufgerufene Methode "pruefeSchwierigkeit" true als Wert zur�ckliefert.
	 * Keine Parameter vorhanden.
	 */
	public void schwierigkeitVorw�rts()
	{
		String s;
		String pr�fung;
		
		if((s=itString.next())!=null)
		{
			pr�fung = view.getSchwierigkeitLbl().getText();
			System.out.println(pr�fung);
			if(pruefeSchwierigkeit(pr�fung)==true)
			view.getSchwierigkeitLbl().setText(s);
			else
				{System.out.println("Schwierigkeit noch nicht freigeschaltet");
				JOptionPane pane = new JOptionPane();
				pane.setBounds(view.getFrame().getX()+300,view.getFrame().getY()+250,200,100);
				pane.showMessageDialog(null, "Schwierigkeit nocht nicht freigeschaltet");
					
				itString.previous();
				}
		}
		
	}
	/* 
	 * Methode:	public void starteSpiel()
	 * Die Methode agiert je nacht Wert der Variablen "singleMultiplayer":
	 * 
	 * singleMultiplayer = 1:
	 * Die Schwierigkeit wird ausgelesen, au�erdem werden die Variablen der SingleplayerFahrt deklariert und anschlie�end an die erzeugte FahrtSpielenStrg �bergeben.
	 * _____________________
	 * 
	 * singleMultiplayer = 2:
	 * Der Rang der MultiplayerFahrt und die Zeit werden auf 0 gesetzt. 
	 * Anschlie�end wird noch der Benutzername zugewiesen und die Klasse MultiplayerFahrtSpielenStrg aufgerufen und die Objekte MultiplayerFahrt, Kart und Strecke �bergeben.
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
			kartR�ckw�rts();
			
		}
		if(e.getSource()==view.getSchwierigkeitBtn1())
		{
			schwierigkeitBack();
		}
		if(e.getSource()==view.getSchwierigkeitBtn2())
		{
			schwierigkeitVorw�rts();
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
			streckeR�ckw�rts();
		}
		if(e.getSource()==view.getStreckeForward())
		{
			ladeStrecke();
		}
		
	}
	
	

	
	
	

}
