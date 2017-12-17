package MultiplayerFahrtSpielen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import Computergegner.Bot;
import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import FahrtSpielen.FahrtAuswertungStrg;
import FahrtSpielen.FahrtSpielenView;
import FahrtSpielen.ZeitBehaltenView;
import Kart.Kart;
import Strecke.Strecke;

public class MultiplayerFahrtSpielenStrg implements ActionListener{
	MultiplayerFahrt mf=null;
	
	MultiplayerFahrtSpielenView fahrtSpielenView;
	MultiplayerZeitBehaltenStrg zeitBehaltenView;
	int versuche = 3;
	int zeit=0;
	int rang;
	Kart kart;
	int wert = 0;
	int speed = 1;
	Strecke strecke;
	

	//Singleplayerfahrt Konstruktor
	
	public MultiplayerFahrtSpielenStrg(MultiplayerFahrt mf, Kart k, Strecke s)
	{
		kart = k;
		strecke = s;
		this.mf = mf;
	
		fahrtSpielenView = new MultiplayerFahrtSpielenView();
		fahrtSpielenView.fahrenBtn.addActionListener(this);
		System.out.println("Registriert");
		
		fahrtSpielenView.zeiger.balken.setVisible(false);
		fahrtSpielenView.frame.setVisible(true);
		fahrtSpielenView.frame.setFocusable(true);
		fahrtSpielenView.frame.setFocusTraversalKeysEnabled(false);
	
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
		            	fahrtSpielenView.lblAnzahlVerbleibenderVersuche.setText("Versuche: "+a);
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

		        			
		            	}
		            }
		         }
		      });
		
	
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
