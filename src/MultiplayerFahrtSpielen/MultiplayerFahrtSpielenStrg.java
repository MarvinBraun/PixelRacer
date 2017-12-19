package MultiplayerFahrtSpielen;

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

public class MultiplayerFahrtSpielenStrg implements ActionListener{
	MultiplayerFahrt mf=null;
	
	MultiplayerFahrtSpielenView fahrtSpielenView;

	int versuche = 5;

	BufferedImage kartBild;
	BufferedImage streckenBild;
	
	int[] zeiten = new int[3];
	int rang;
	Kart kart;
	Strecke strecke;
	int schwierigkeit;
	int speed = 1;
	int wert =0;
	
	//Singleplayerfahrt Konstruktor
	
	public MultiplayerFahrtSpielenStrg(MultiplayerFahrt fahrt, Kart k, Strecke s)
	{
		kart = k;
		strecke = s;
		this.mf = fahrt;
		System.out.println(mf.getBenutzername());
	
		
		this.schwierigkeit = schwierigkeit;
		
		for(int i = 0; i<zeiten.length;i++)
		{
			Bot b = new Bot(s.getLaenge(),kart.beschleunigung,kart.getMaxkmh(),schwierigkeit);
			zeiten[i] = b.getZeit();
		}
		Arrays.sort(zeiten);
		
		 kartBild = k.getGrafik();
		streckenBild = strecke.getGrafik(); 

		
		fahrtSpielenView = new MultiplayerFahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		
		//KeyAdapter
		fahrtSpielenView.zeiger.balken.setVisible(false);
		fahrtSpielenView.frame.setVisible(true);
		fahrtSpielenView.frame.setFocusable(true);
		fahrtSpielenView.frame.setFocusTraversalKeysEnabled(false);
		
		
		System.out.println("Registriert");
	
	}

	//Singleplayerfahrt Konstruktor
	
	public MultiplayerFahrtSpielenStrg()
	{
		fahrtSpielenView = new MultiplayerFahrtSpielenView(kartBild,streckenBild);
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		System.out.println("Registriert");
	}
	
	
	public void fahren()
	{
		
		fahrtSpielenView.fahrenBtn.setVisible(false);
		fahrtSpielenView.zeiger.balken.setVisible(true);
		fahrtSpielenView.balkenLbl.setVisible(true);
		fahrtSpielenView.bewertungLbl.setVisible(true);
		fahrtSpielenView.frame.addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	            	if( versuche>=0)
	            	{ 
	            		int record = fahrtSpielenView.zeiger.balken.backgroundX1;
	            	wert = wert + record;
	            	System.out.println(wert);
	            	speed = speed+speed;
	            	fahrtSpielenView.zeiger.setSpeed(speed);
	            	System.out.println("Hi from KeyListener");
	            	versuche--;
	            	String a = ""+versuche;
	            	fahrtSpielenView.lblAnzahlVerbleibenderVersuche.setText("Runden verbleibend: "+a);
	               	String b = ""+mf.getZeit();
	               	fahrtSpielenView.lblLetzteZeit.setText("Zeit: "+b+"s");
	               	
	               	if(200<record&&record<500)
	               	{
	               		fahrtSpielenView.bewertungLbl.setText("Super");
	               	
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
	        			
	        			int zeit = (int) ((int) ((strecke.getLaenge()/kart.getMaxkmh())+(kart.getMaxkmh()/kart.beschleunigung)*schwierigkeit2)*berechneLeistung);
	        			System.out.println("Zeit"+zeit);
	        			mf.setZeit(zeit);
	        			versuche--;
	        			
	           			//Weise alle verbleibenden Werte zu und Sende Match an DB:
		        		
	        			mf.setKartName(kart.getKartname());
	        			mf.setBenutzername("DZeller");
	        			mf.setStreckenName(strecke.getStreckenname());
	        			
	        			Fahrtverwaltung verwaltung = new Fahrtverwaltung();
	        			verwaltung.sendeMultiplayerFahrt(mf);
	        			fahrtSpielenView.frame.dispose();
	        			MultiplayerAuswertungStrg auswertung = new MultiplayerAuswertungStrg(mf,streckenBild);
	        			
	        	
	        			
	            	}
	            }
	         }
	      });

		
	}
	
	public static void main(String[] args)
	{
		MultiplayerFahrtSpielenStrg strg = new MultiplayerFahrtSpielenStrg();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==fahrtSpielenView.fahrenBtn)
		{
			System.out.println("Hallo");
			fahren();
		}

		// TODO Auto-generated method stub
		
	}
	
	

}
