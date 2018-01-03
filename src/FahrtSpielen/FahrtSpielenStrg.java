package FahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import Computergegner.Bot;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import FahrtAuswertung.FahrtAuswertungStrg;
import Kart.Kart;
import Strecke.Strecke;

/**
 * Steuerungsklasse, die die grafische Benutzeroberfläche FahrtSpielenView verwaltet und befüllt.
 * @author Marvin Braun
 *
 */
public class FahrtSpielenStrg implements ActionListener{
	private SingleplayerFahrt sf=null;
	private MultiplayerFahrt mf=null;
	
	private FahrtSpielenView fahrtSpielenView;

	private int versuche = 10;

	private BufferedImage kartBild;
	private BufferedImage streckenBild;
	
	private int[] zeiten = new int[3];
	private int rang;
	private Kart kart;
	private Strecke strecke;
	private int schwierigkeit;
	private int speed = 1;
	private int spielstand =0;
	
	/**
	 * Erzeugt ein neues Objekt der Klasse FahrtSpielenStrg. Befüllt die das Objekt fahrtSpielenView.
	 * @param sfahrt Objekt der Klasse SingleplayerFahrt
	 * @param k Objekt der Klasse Kart
	 * @param s Objekt der Klasse Strecke
	 * @param schwierigkeit Int-Variable der ausgewählten Schwierigkeit.
	 * 
	 */
	
	public FahrtSpielenStrg(SingleplayerFahrt sfahrt, Kart k, Strecke s, int schwierigkeit)
	{
		kart = k;
		strecke = s;
		this.sf = sfahrt;
		System.out.println(sf.getBenutzername());
	
		
		this.schwierigkeit = schwierigkeit;
		
		for(int i = 0; i<zeiten.length;i++)
		{
			Bot b = new Bot(s.getLaenge(),kart.getBeschleunigung(),kart.getMaxkmh(),schwierigkeit);
			zeiten[i] = b.getZeit();
		}
		Arrays.sort(zeiten);
		
		 kartBild = k.getGrafik();
		streckenBild = strecke.getGrafik(); 

		
		fahrtSpielenView = new FahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.getFahrenBtn().addActionListener(this);
		fahrtSpielenView.getLblAnzahlVerbleibenderVersuche().setText("Verbleibende Runden: 10");
		
		
		fahrtSpielenView.getZeiger().balken.setVisible(false);
		fahrtSpielenView.getFrame().setVisible(true);
		fahrtSpielenView.getFrame().setFocusable(true);
		//KeyAdapter
		fahrtSpielenView.getFrame().setFocusTraversalKeysEnabled(false);
	}

	/** 
	 * Methode um das Fahren des Karts zu simulieren. Über einen KeyListener wird ein Event für die Leertaste festgelegt. 
	 * Beim Drücken wird der X-Wert ausgelesen und mit den Grenzen des grünen Bereichs verglichen.
	 */
	
	public void fahren()
	{
		
		fahrtSpielenView.getFahrenBtn().setVisible(false);
		fahrtSpielenView.getZeiger().balken.setVisible(true);
		fahrtSpielenView.getBalkenLbl().setVisible(true);
		fahrtSpielenView.getBewertungLbl().setVisible(true);
		fahrtSpielenView.getFrame().addKeyListener(new KeyAdapter() 
		{
	         @Override
	         public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	            	if( versuche>=0)
	            	{ 
	            		
	            	int record = fahrtSpielenView.getZeiger().balken.backgroundX1;
	            	System.out.println(spielstand);
	            	if(speed<6)
	            	speed = speed+speed;
	            	fahrtSpielenView.getZeiger().setSpeed(speed);
	            	versuche--;
	            	String a = ""+versuche;
	            	fahrtSpielenView.getLblAnzahlVerbleibenderVersuche().setText("Runden verbleibend: "+a);
	               
	            	String b = ""+sf.getZeit();
	               	
	               	if(300<record&&record<450)
	               	{
	               		spielstand = spielstand+1;
	               		fahrtSpielenView.getBewertungLbl().setText("Super");
	               	
	               	}
	               	else
	               	{
	               		spielstand = spielstand+2;
	               		fahrtSpielenView.getBewertungLbl().setText("Das geht besser!");
	               	}
	            	}
	            	
	            	
	            	if(versuche == 0)
	            	{
	            		float berechneLeistung = (float) spielstand / 10;
	            		System.out.println("Alter Wert: "+berechneLeistung);
	            		if(berechneLeistung<1)
	            		{
	            			berechneLeistung = (float) 1/berechneLeistung;
	            		}
	            	
	            		
	            		System.out.println(berechneLeistung);
	            		
	            		
	            		float schwierigkeit2 = (float) (0.8 +(Math.random() * 1.3)); 
	        			
	        			int zeit = (int) ((int) ((strecke.getLaenge()/kart.getMaxkmh())+(kart.getMaxkmh()/kart.getBeschleunigung())*schwierigkeit2)*berechneLeistung);
	        			System.out.println("Zeit"+zeit);
	        			sf.setZeit(zeit);
	        			versuche--;
	        			
	        		setzeRang();
	        			FahrtAuswertungStrg strg = new FahrtAuswertungStrg(sf,streckenBild);
	        			fahrtSpielenView.getFrame().dispose();
	
	            	}
	            }
	         }
	      });
	

		
	}
	
	/** 
	 * Die Methode ermittelt den Rang des Spielers.
	 * Beim Erfüllen der Bedingung if(sf.getZeit()<=zeiten[i]) wird der Rang entsprechend gesetzt.
	 * "sf.setRang(i+1);" der Rang ist immer +1 höher als der Index, da dieser bei 0 beginnt.
	 */
	
	public void setzeRang()
	{	
		
		for(int i = 0; i<zeiten.length;i++)
		{
			if(sf.getZeit()<=zeiten[i])
			{
				System.out.println("Zeiten der Bots:"+zeiten[i]);
			sf.setRang(i+1);
			break;
			}
			else
				sf.setRang(zeiten.length);
			
		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==fahrtSpielenView.getFahrenBtn())
		{
			System.out.println("Hallo");
			fahren();
		}
		
		// TODO Auto-generated method stub
		
	}
	
	

}
