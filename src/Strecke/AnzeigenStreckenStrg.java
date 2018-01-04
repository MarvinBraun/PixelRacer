package Strecke;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.Fahrt;
import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Nutzer.Nutzerverwaltung;
import Rechnung.Rechnung;
import Rechnung.Rechnungsverwaltung;
import Startansicht.StartansichtStrg;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;


public class AnzeigenStreckenStrg implements ActionListener{

	StreckeDetailView viewDetail;
	Streckenuebersicht viewUebersicht;
	
	SingleplayerFahrt sf;
	Rechnung r;
	Strecke s;
	ResultSet rs;
	BufferedImage streckenbild;
	
	Rechnungsverwaltung verwRechnung;
	Streckenverwaltung verwStrecke;
	Fahrtverwaltung verwFahrt;
	
	LinkedList<SingleplayerFahrt> singleplayerFahrten = new LinkedList<SingleplayerFahrt>();
	LinkedList<Strecke> streckenListe = new LinkedList<Strecke>();
	LinkedList<Rechnung> rechnungsListe = new LinkedList<Rechnung>();
			
	int counterRang1 =0;
	int counterRang2 =0;
	int counterRang3 =0;
		
	static MyIteratorStrecke<Strecke> itStrecke;
	static MyIteratorString<String> itString;
	
	boolean forward = false;
	boolean backward = false;
	
	public AnzeigenStreckenStrg(){
		
		viewUebersicht = new Streckenuebersicht();
				
		verwFahrt = new Fahrtverwaltung();
		singleplayerFahrten = verwFahrt.gibSingleplayerFahrten();
		
		verwStrecke = new Streckenverwaltung();
		streckenListe = verwStrecke.gibStrecke();
		itStrecke = new MyIteratorStrecke(streckenListe.listIterator());
		
		verwRechnung = new Rechnungsverwaltung();
		rechnungsListe = verwRechnung.gibStreckenRechnungenfuerBenutzer();
		
		viewUebersicht.streckeBackward.addActionListener(this);
		viewUebersicht.streckeForward.addActionListener(this);
		viewUebersicht.btnDetailView.addActionListener(this);
		viewUebersicht.btnZurueck.addActionListener(this);
		
		ladeStrecke();
		
		SwingUtilities.updateComponentTreeUI(viewUebersicht.frmPixelRacer);
			
	}
		
	public static void main(String[] args) {
		
		AnzeigenStreckenStrg steuerung = new AnzeigenStreckenStrg();
		
	}
	
	public void ladeStrecke()
	{
		if((s=itStrecke.next())!=null)
		{	
									
			BufferedImage newImage= s.getGrafik();
			viewUebersicht.streckeName.setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			viewUebersicht.streckeLbl.setIcon(icon);
			
			//StreckeDetailView initiieren
			counterRang1 = 0;
			counterRang2 = 0;
			counterRang3 = 0;
						
			viewDetail= new StreckeDetailView();
			viewDetail.btnZurueck.addActionListener(this);
						
			//Länge setzten
			viewDetail.lblSetLaenge.setText(Integer.toString(s.getLaenge())+ "m");
			
			// Label umschreiben auf ges. Sf-Strecke & auf angmeldeter Benutzer
			Fahrtverwaltung v = new Fahrtverwaltung();
			LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFürBenutzerUndStrecke("DZeller",s.getStreckenname());
			viewDetail.lblSetGesRennen.setText(Integer.toString(fahrten.size()));
					
			// Label umschreiben auf ges. m pro Sf-Strecke
			viewDetail.lblSetGesKm.setText(Integer.toString(fahrten.size()*s.getLaenge())+"m");
					
			// Anzahl Erster
			for(int i =0; i < fahrten.size(); i++) {
				
				sf = fahrten.get(i);
				
				if(sf.getRang()==1) {
				counterRang1 ++; 
				}
				if(sf.getRang()==2) {
					counterRang2 ++; 
				}
				if(sf.getRang()==3) {
					counterRang3 ++; 
				}
			}			
			viewDetail.lblSetAnzErster.setText(Integer.toString(counterRang1));
			viewDetail.lblSetAnzZweiter.setText(Integer.toString(counterRang2));
			viewDetail.lblSetAnzDritter.setText(Integer.toString(counterRang3));														
		}
		
		//Prüfung Strecke bereits vom Nutzer gekauft? Falls nicht Kauf-Button einblenden
		
		Rechnungsverwaltung r = new Rechnungsverwaltung();
		LinkedList<Rechnung> rechnungen = r.gibStreckenRechnungenfuerBenutzer();
		
		
		if(s.getPremium().equals("true")){
			viewUebersicht.getBtnStreckeKaufen().setVisible(true);
			
		
			Rechnung rechnung = null;
			Iterator<Rechnung> it = rechnungen.iterator();
			while(it.hasNext())
			{
				rechnung = it.next();
				if(s.getStreckenname().equals(rechnung.getStreckenname()))
						{
							
						}
			}
			
		}
		
		Datenbankschnittstelle.closeConnections();
			
		//Punktestandprüfung und Label Aktivierung
			if(s.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte()) {
				viewUebersicht.getLblStreckePunkteLimit().setVisible(false);
				viewUebersicht.getLblStreckePunkte().setText("Strecke in deinem Besitz!");
				viewUebersicht.getLblStreckePunkte().setVisible(true);
			}
			else if(s.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()){
				viewUebersicht.getLblStreckePunkte().setVisible(false);
				viewUebersicht.getLblStreckePunkteLimit().setText("Erreiche " + s.getPunktewert() + " Punkte um diese Strecke freizuschalten!");
				viewUebersicht.getLblStreckePunkteLimit().setVisible(true);
			}
				
}
	
	
	public void streckeRückwärts()
	{
		if((s=itStrecke.previous())!=null)
		{			
			BufferedImage newImage= s.getGrafik();
			viewUebersicht.streckeName.setText(s.getStreckenname());
			streckenbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(streckenbild);
			viewUebersicht.streckeLbl.setIcon(icon);
			
			//StreckeDetailView initiieren
			counterRang1 = 0;
			counterRang2 = 0;
			counterRang3 = 0;
						
			viewDetail= new StreckeDetailView();
			viewDetail.btnZurueck.addActionListener(this);
						
			//Länge setzten
			viewDetail.lblSetLaenge.setText(Integer.toString(s.getLaenge())+ "m");
			
			// Label umschreiben auf ges. Sf-Strecke & auf angmeldeter Benutzer
			Fahrtverwaltung v = new Fahrtverwaltung();
			LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFürBenutzerUndStrecke("DZeller",s.getStreckenname());
			viewDetail.lblSetGesRennen.setText(Integer.toString(fahrten.size()));
					
			// Label umschreiben auf ges. m pro Sf-Strecke
			viewDetail.lblSetGesKm.setText(Integer.toString(fahrten.size()*s.getLaenge())+"m");
					
			// Anzahl Erster
			for(int i =0; i < fahrten.size(); i++) {
				
				sf = fahrten.get(i);
				
				if(sf.getRang()==1) {
				counterRang1 ++; 
				}
				if(sf.getRang()==2) {
					counterRang2 ++; 
				}
				if(sf.getRang()==3) {
					counterRang3 ++; 
				}
			}			
			viewDetail.lblSetAnzErster.setText(Integer.toString(counterRang1));
			viewDetail.lblSetAnzZweiter.setText(Integer.toString(counterRang2));
			viewDetail.lblSetAnzDritter.setText(Integer.toString(counterRang3));
				
		}
		Datenbankschnittstelle.closeConnections();
		

			//Punktestandprüfung und Label Aktivierung
			if(s.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte()) {
				viewUebersicht.getLblStreckePunkteLimit().setVisible(false);
				viewUebersicht.getLblStreckePunkte().setText("Strecke in deinem Besitz!");
				viewUebersicht.getLblStreckePunkte().setVisible(true);
			}
			else if(s.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()){
				viewUebersicht.getLblStreckePunkte().setVisible(false);
				viewUebersicht.getLblStreckePunkteLimit().setText("Erreiche " + s.getPunktewert() + " Punkte um diese Strecke freizuschalten!");
				viewUebersicht.getLblStreckePunkteLimit().setVisible(true);
			}
}
	
		
	public static BufferedImage imageResizer(BufferedImage original)
	{
		
		BufferedImage newImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

				Graphics g = newImage.createGraphics();
				g.drawImage(original, 0, 0, 300, 200, null);
				g.dispose();
				return newImage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==viewUebersicht.getBtnZurueck()) {
			
			viewUebersicht.frmPixelRacer.dispose();
			viewDetail.frame.dispose();
			StartansichtStrg strg = new StartansichtStrg();
		}
		
		if(e.getSource()==viewDetail.btnZurueck) {
			
			viewDetail.frame.dispose();
			viewUebersicht.frmPixelRacer.setVisible(true);
		}
		
		if(e.getSource()==viewUebersicht.streckeBackward)
		{
			viewDetail.frame.dispose();
			streckeRückwärts();			
		}
		
		if(e.getSource()==viewUebersicht.streckeForward)
		{
			viewDetail.frame.dispose();
			ladeStrecke();							
		}
		
		if(e.getSource()==viewUebersicht.btnDetailView)
		{		
			viewDetail.frame.setVisible(true);		
		}
	}
}


	
