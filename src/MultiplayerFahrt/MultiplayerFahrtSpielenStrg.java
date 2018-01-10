package MultiplayerFahrt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import Computergegner.Bot;
import Fahrt.Fahrtverwaltung;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import Kart.Kart;
import Strecke.Strecke;
/**
 * Steuerungsklasse, welche die grafische Benutzeroberfläche MultiplayerFahrtSpielenView verwaltet und mit den Multientitäten (Verwaltungen) kommuniziert.
 * @author Marvin Braun
 *
 */
public class MultiplayerFahrtSpielenStrg implements ActionListener{
	private MultiplayerFahrt mf=null;
	
	private MultiplayerFahrtSpielenView fahrtSpielenView;

	private int versuche = 10;

	private BufferedImage kartBild;
	private BufferedImage streckenBild;
	
	private int[] zeiten = new int[3];
	private int rang;
	private Kart kart;
	private Strecke strecke;
	private int schwierigkeit;
	private int speed = 1;
	private int wert =0;
	
	//Singleplayerfahrt Konstruktor
	
	/**
	 * Erzeugt ein Objekt der Klasse MultiplayerFahrtSpielenStrg und befüllt die grafische Benutzeroberfläche "fahrtSpielenView".
	 * @param fahrt Ein Objekt der Klasse MultiplayerFahrt
	 * @param kart1 Ein Objekt der Klasse Kart
	 * @param strecke1 Ein Objekt der Klasse Strecke
	 */
	public MultiplayerFahrtSpielenStrg(MultiplayerFahrt fahrt, Kart kart1, Strecke strecke1)
	{
		kart = kart1;
		strecke = strecke1;
		this.mf = fahrt;
		System.out.println(mf.getBenutzername());
	
		
		this.schwierigkeit = schwierigkeit;
		
		for(int i = 0; i<zeiten.length;i++)
		{
			Bot b = new Bot(strecke1.getLaenge(),kart.getBeschleunigung(),kart.getMaxkmh(),schwierigkeit);
			zeiten[i] = b.getZeit();
		}
		Arrays.sort(zeiten);
		
		 kartBild = kart1.getGrafik();
		streckenBild = strecke.getGrafik(); 

		
		fahrtSpielenView = new MultiplayerFahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.getFahrenBtn().addActionListener(this);
		fahrtSpielenView.getZeiger().zeiger.setVisible(false);
		fahrtSpielenView.getFrame().setVisible(true);
		fahrtSpielenView.getFrame().setFocusable(true);
		fahrtSpielenView.getFrame().setFocusTraversalKeysEnabled(false);
		fahrtSpielenView.getFrame().setLocationRelativeTo(null);
		
		
		System.out.println("Registriert");
	
	}

	//Singleplayerfahrt Konstruktor
	/*
	public MultiplayerFahrtSpielenStrg()
	{
		fahrtSpielenView = new MultiplayerFahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.getFahrenBtn().addActionListener(this);
		System.out.println("Registriert");
	}
	
	*/
	public void fahren()
	{
		
		fahrtSpielenView.getFahrenBtn().setVisible(false);
		fahrtSpielenView.getZeiger().zeiger.setVisible(true);
		fahrtSpielenView.getBalkenLbl().setVisible(true);
		fahrtSpielenView.getBewertungLbl().setVisible(true);
		fahrtSpielenView.getFrame().addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	            	if( versuche>=0)
	            	{ 
	            		int record = fahrtSpielenView.getZeiger().zeiger.backgroundX1;
	            	wert = wert + record;
	            	System.out.println(wert);
	            	if(speed<6)
	            	{
	            		speed = speed+speed;
	            		fahrtSpielenView.getZeiger().setSpeed(speed);
	            	}
	            	System.out.println("Hi from KeyListener");
	            	versuche--;
	            	String a = ""+versuche;
	            	fahrtSpielenView.getLblAnzahlVerbleibenderVersuche().setText("Runden verbleibend: "+a);
	               	String b = ""+mf.getZeit();
	        
	               	if(200<record&&record<500)
	               	{
	               		fahrtSpielenView.getBewertungLbl().setText("Super");
	               	
	               	}
	               	
	               	
	            	}
	            	
	            	
	            	if(versuche == 0)
	            	{
	            		float berechneLeistung = (float) wert / 1750;
	            		System.out.println("Alter Wert: "+berechneLeistung);
	            		if(berechneLeistung<1)
	            		{
	            			berechneLeistung = (float) 1/berechneLeistung;
	            		}
	            	
	            		
	            		System.out.println(berechneLeistung);
	            		
	            		
	            		float schwierigkeit2 = (float) (0.8 +(Math.random() * 1.5)); 
	        			
	        			int zeit = (int) ((int) ((strecke.getLaenge()/kart.getMaxkmh())+(kart.getMaxkmh()/kart.getBeschleunigung())*schwierigkeit2)*berechneLeistung);
	        			System.out.println("Zeit"+zeit);
	        			mf.setZeit(zeit);
	        			versuche--;
	        			
	           			//Weise alle verbleibenden Werte zu und Sende Match an DB:
		        		
	        			mf.setKartName(kart.getKartname());
	        			mf.setBenutzername("DZeller");
	        			mf.setStreckenName(strecke.getStreckenname());
	        			
	        			Fahrtverwaltung verwaltung = new Fahrtverwaltung();
	        			verwaltung.sendeMultiplayerFahrt(mf);
	        			fahrtSpielenView.getFrame().dispose();
	        			MultiplayerAuswertungStrg auswertung = new MultiplayerAuswertungStrg(mf,streckenBild);
	
	            	}
	            }
	         }
	      });

		
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

	public MultiplayerFahrt getMf() {
		return mf;
	}

	public void setMf(MultiplayerFahrt mf) {
		this.mf = mf;
	}

	public MultiplayerFahrtSpielenView getFahrtSpielenView() {
		return fahrtSpielenView;
	}

	public void setFahrtSpielenView(MultiplayerFahrtSpielenView fahrtSpielenView) {
		this.fahrtSpielenView = fahrtSpielenView;
	}

	public int getVersuche() {
		return versuche;
	}

	public void setVersuche(int versuche) {
		this.versuche = versuche;
	}

	public BufferedImage getKartBild() {
		return kartBild;
	}

	public void setKartBild(BufferedImage kartBild) {
		this.kartBild = kartBild;
	}

	public BufferedImage getStreckenBild() {
		return streckenBild;
	}

	public void setStreckenBild(BufferedImage streckenBild) {
		this.streckenBild = streckenBild;
	}

	public int[] getZeiten() {
		return zeiten;
	}

	public void setZeiten(int[] zeiten) {
		this.zeiten = zeiten;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public Kart getKart() {
		return kart;
	}

	public void setKart(Kart kart) {
		this.kart = kart;
	}

	public Strecke getStrecke() {
		return strecke;
	}

	public void setStrecke(Strecke strecke) {
		this.strecke = strecke;
	}

	public int getSchwierigkeit() {
		return schwierigkeit;
	}

	public void setSchwierigkeit(int schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}
	
	

}
