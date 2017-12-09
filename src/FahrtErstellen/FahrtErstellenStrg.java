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
import javax.swing.SwingUtilities;

import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import FahrtSpielen.FahrtSpielenStrg;
import MusicHandler.MusicPlayer;
import Strecke.Strecke;
import myIterator.MyIteratorKart;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;
import Kart.*;
public class FahrtErstellenStrg implements ActionListener {
	
	//Objekte der Klasse
	FahrtErstellenView view;
	boolean forward = false;
	boolean backward = false;
	Kart k;
	Strecke s;
	static Kart previousKart;
	Kartverwaltung karts;
	static MyIteratorKart<Kart> itKart;
	static MyIteratorString<String> itString;
	static MyIteratorStrecke<Strecke> itStrecke;
	
	LinkedList<String> schwierigkeiten;
	LinkedList<Kart> kartliste = new LinkedList<Kart>();
	LinkedList<Strecke> streckenliste = new LinkedList<Strecke>();
	
	SingleplayerFahrt sf;
	MultiplayerFahrt mf;
	

	int counter=-1;
	//Konstruktor
	public FahrtErstellenStrg(int singleMultiplayer) {
		view = new FahrtErstellenView();
	
		//Initialisieren der Karts und der Buttons
		karts = new Kartverwaltung();
		kartliste =karts.gibKart();
		itKart = new MyIteratorKart(kartliste.listIterator());
		System.out.println(kartliste.size());
		view.kartForward.addActionListener(this);
		view.kartBackward.addActionListener(this);
		
		//Initialisieren der Strecke
		
			BufferedImage image;
			
				try {
					
					image = ImageIO.read(new File("src/Resources/hockenheim.png"));
					BufferedImage newImage = imageResizer(image);
					ImageIcon icon = new ImageIcon(newImage);
					view.streckeLbl.setIcon(icon);
					} 	
				
				catch (IOException e) {
			// TODO Auto-generated catch block
					e.printStackTrace();
		}

		//Initialisieren des Schwierigkeitsgrades
		//nur für Singleplayer
	
		if(singleMultiplayer==1)
		{
		
			schwierigkeiten = new LinkedList<String>();
			schwierigkeiten.add("Bronze");
			schwierigkeiten.add("Silber");
			schwierigkeiten.add("Gold");
			itString = new MyIteratorString(schwierigkeiten.listIterator());
			
			view.schwierigkeitBtn1.addActionListener(this);
			view.schwierigkeitBtn2.addActionListener(this);
			view.schwierigkeitLbl.setText(itString.next());
			sf = new SingleplayerFahrt();
			
			
		
		}
		//Initialisieren der MultiplayerID
		// nur für Multiplayer
		else
		{
			view.schwierigkeitBtn1.setVisible(false);
			view.schwierigkeitBtn2.setVisible(false);
			view.schwierigkeitLbl.setVisible(false);
			view.multiplayerLbl.setVisible(true);
			mf = new MultiplayerFahrt();
		}
		SwingUtilities.updateComponentTreeUI(view.frame);
	

		
	}
	
	public static void main(String[] args)
	{
		FahrtErstellenStrg strg = new FahrtErstellenStrg(1);
		MusicPlayer.audioBackground();

	}
	
	//Methode um vorwärts durch die Karts zu scrollen
	public void ladeKarts()
	{
		if((k=itKart.next())!=null)
		{
			System.out.println(k.kartname);
			ImageIcon icon = new ImageIcon(k.grafik);
			view.kartBild.setIcon(icon);
			view.kartName.setText(k.kartname);
		}
	}
	//Methode um rückwärts durch die Karts zu scrollen
	public void kartRückwärts()
	{
		
	
		if((k=itKart.previous())!=null)
		{
			System.out.println(k.kartname);
			ImageIcon icon = new ImageIcon(k.grafik);
			view.kartBild.setIcon(icon);
			view.kartName.setText(k.kartname);
		}
	
	}
	
	public void streckeRückwärts()
	{
		//
	}
	
	public void streckeVorwärts()
	{
		
	}
	
	
	
	
	
	

	//Methode um Bilddateien (800x600) in kleinere Formate zu ändern.
	//wird für die Anzeige der Strecken genutzt
	public static BufferedImage imageResizer(BufferedImage original)
	{
		
		BufferedImage newImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

				Graphics g = newImage.createGraphics();
				g.drawImage(original, 0, 0, 300, 200, null);
				g.dispose();
				return newImage;
	}
	
	public void schwierigkeitBack()
	{String s;
		if((s=itString.previous())!=null)
		{
			view.schwierigkeitLbl.setText(s);
		}
		
		
	}
	public void schwierigkeitVorwärts()
	{
		String s;
		if((s=itString.next())!=null)
		{
			view.schwierigkeitLbl.setText(s);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==view.kartForward)
		{
			ladeKarts();
		}
		if(e.getSource()==view.kartBackward)
		{
			kartRückwärts();
			
		}
		if(e.getSource()==view.schwierigkeitBtn1)
		{
			schwierigkeitBack();
		}
		if(e.getSource()==view.schwierigkeitBtn2)
		{
			schwierigkeitVorwärts();
		}
		if(e.getSource()==view.spielenBtn)
		{
			FahrtSpielenStrg strg = new FahrtSpielenStrg(sf,mf,k,strecke);
		}
		
	}
	
	

	
	
	

}
