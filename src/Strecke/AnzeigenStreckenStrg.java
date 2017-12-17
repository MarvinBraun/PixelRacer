package Strecke;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.Fahrt;
import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Nutzer.Nutzerverwaltung;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;


public class AnzeigenStreckenStrg implements ActionListener{

	StreckeDetailView viewDetail;
	Streckenuebersicht viewUebersicht;
	
	SingleplayerFahrt sf;
	
	Streckenverwaltung verwStrecke;
	Fahrtverwaltung verwFahrt;
	
	LinkedList<SingleplayerFahrt> singleplayerFahrten = new LinkedList<SingleplayerFahrt>();
	LinkedList<Strecke> streckenListe = new LinkedList<Strecke>();
	
	Array[] array;
	
	int counterRang1 =0;
	int counterRang2 =0;
	int counterRang3 =0;
	
	Strecke s;
	ResultSet rs;
	
	static MyIteratorStrecke<Strecke> itStrecke;
	static MyIteratorString<String> itString;
	
	BufferedImage streckenbild;
	
	boolean forward = false;
	boolean backward = false;
	
	int counter=-1;
	
	public AnzeigenStreckenStrg(){
		
		viewUebersicht = new Streckenuebersicht();
		
		verwFahrt = new Fahrtverwaltung();
		singleplayerFahrten = verwFahrt.gibSingleplayerFahrten();
		
		verwStrecke = new Streckenverwaltung();
		streckenListe = verwStrecke.gibStrecke();
		itStrecke = new MyIteratorStrecke(streckenListe.listIterator());
		
		viewUebersicht.streckeBackward.addActionListener(this);
		viewUebersicht.streckeForward.addActionListener(this);
		viewUebersicht.btnDetailView.addActionListener(this);
		
		ladeStrecke();
		
		SwingUtilities.updateComponentTreeUI(viewUebersicht.frame);
		
	
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
						
		}
	}
	
	public void setDetailView() throws SQLException {
		
		StreckeDetailView viewDetail= new StreckeDetailView();
					
		//Länge setzten
		viewDetail.lblSetLaenge.setText(Integer.toString(s.getLaenge())+ "m");
		
		// Label umschreiben auf ges. Sf-Strecke
		Fahrtverwaltung v = new Fahrtverwaltung();
		LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFürBenutzerUndStrecke("DZeller","Tundra");
		viewDetail.lblSetGesRennen.setText(Integer.toString(fahrten.size()));
				
		// Label umschreiben auf ges. m pro Sf-Strecke
		viewDetail.lblSetGesKm.setText(Integer.toString(fahrten.size()*s.getLaenge())+"m");
				
		// Anzahl Erster
		for(int i =0; i <= fahrten.size(); i++) {
			
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
		
		System.out.println("Anzahl Erster:" + counterRang1);
		System.out.println("Anzahl Zweiter:" + counterRang2);
		System.out.println("Anzahl Dritter:" + counterRang3);
		
		
		

		viewDetail.frame.setVisible(true);
		
		//}
		//}
		rs.close();
		Datenbankschnittstelle.closeConnections();
		
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
		if(e.getSource()==viewUebersicht.streckeBackward)
		{
			streckeRückwärts();
		}
		if(e.getSource()==viewUebersicht.streckeForward)
		{
			ladeStrecke();
		}
		if(e.getSource()==viewUebersicht.btnDetailView)
		{
			
			try {
				setDetailView();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			
		}
		if(e.getSource()==viewDetail.btnZurueck)
		{
			viewDetail.frame.dispose();
		}
		
	}

	
	
}