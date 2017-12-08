package FahrtBeitreten;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import Fahrt.MultiplayerFahrt;
import Fahrt.SingleplayerFahrt;
import Kart.Kart;
import Kart.Kartverwaltung;
import MusicHandler.MusicPlayer;
import Strecke.Strecke;
import myIterator.MyIteratorKart;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;
public class FahrtBeitretenStrg implements ActionListener {
	
	//Objekte der Klasse
	FahrtBeitretenView view;
	boolean forward = false;
	boolean backward = false;
	Kart k;
	Kartverwaltung karts;
	static MyIteratorKart<Kart> itKart;
	static MyIteratorString<String> itString;
	int multi =2;
	
	LinkedList<String> schwierigkeiten;
	LinkedList<Kart> kartliste = new LinkedList<Kart>();

	MultiplayerFahrt mf;
	

	//Konstruktor
	@SuppressWarnings("unchecked")
	public FahrtBeitretenStrg(int singleMultiplayer) {
		view = new FahrtBeitretenView();
	
		//Initialisieren der Karts und der Buttons
		karts = new Kartverwaltung();
		kartliste =karts.gibKart();
		itKart = new MyIteratorKart(kartliste.listIterator());
		System.out.println(kartliste.size());
		view.kartForward.addActionListener(this);
		view.kartBackward.addActionListener(this);
	
		mf = new MultiplayerFahrt();
		
		SwingUtilities.updateComponentTreeUI(view.frame);
	

		
	}
	
	
	public static void main(String[] args)
	{
		FahrtBeitretenStrg strg = new FahrtBeitretenStrg(1);
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
	
	}
	
	

	
	
	

}
