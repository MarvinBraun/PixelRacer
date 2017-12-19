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

	Streckenverwaltung verwaltungStrecke;
	LinkedList<Strecke> Streckenliste ;
	
	MultiplayerFahrt mf;
	

	//Konstruktor
	@SuppressWarnings("unchecked")
	public FahrtBeitretenStrg() {
		view = new FahrtBeitretenView();
	
		//Initialisieren der Karts und der Buttons
		karts = new Kartverwaltung();
		kartliste =karts.gibKart();
	
		k = kartliste.get(0);
		itKart = new MyIteratorKart(kartliste.listIterator());
		System.out.println(kartliste.size());
		view.kartForward.addActionListener(this);
		view.kartBackward.addActionListener(this);
		view.multiplayerBeitretenBtn.addActionListener(this);
		mf = new MultiplayerFahrt();
		ladeKarts();
		
		SwingUtilities.updateComponentTreeUI(view.frame);
		
		verwaltungStrecke = new Streckenverwaltung();
		Streckenliste = verwaltungStrecke.gibStrecke();
		
	

		
	}
	
	
	public static void main(String[] args)
	{
		FahrtBeitretenStrg strg = new FahrtBeitretenStrg();
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
	
	/* Sucht die MultiplayerID aus der Fahrtenliste 
	 * wenn das Rennen gefunden wird, wird die nächsthöhere verfügbare ID ermittelt und dann eine neue Fahrt mit dem Rang 0 und der Zeit 0 eingetragen. 
	 * 
	 * Falls die ID nicht gefunden wird, wird ein JOptionPane erstellt mit dem Hinweis, eine gültige ID einzugeben.
	 */
	
	public void multiplayerBeitreten()
	{
		boolean gefunden = false;
		Fahrtverwaltung verwaltung = new Fahrtverwaltung();
		LinkedList<MultiplayerFahrt> fahrten = verwaltung.gibMultiplayerFahrten();
		String a = view.multiplayerID.getText();
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
		
		if(e.getSource()==view.kartForward)
		{
			ladeKarts();
		}
		if(e.getSource()==view.kartBackward)
		{
			kartRückwärts();
			
		}
		if(e.getSource()==view.multiplayerBeitretenBtn)
		{
			multiplayerBeitreten();
		}
	
	}
	
	

	
	
	

}
