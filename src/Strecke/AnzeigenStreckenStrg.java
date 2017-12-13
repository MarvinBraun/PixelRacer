package Strecke;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.*;


public class AnzeigenStreckenStrg extends Streckenuebersicht implements MouseListener{

	static StreckeDetailView viewDetail;
	static Streckenuebersicht viewUebersicht;
	Streckenverwaltung vstrecke;
	static LinkedList<Strecke> streckenliste = new LinkedList<Strecke>();
	
	
	public AnzeigenStreckenStrg(){
		
		viewUebersicht.lblBildStrecke1.addMouseListener(this);
		viewUebersicht.lblBildStrecke2.addMouseListener(this);
		
	}
		
	public static void main(String[] args) {
		
		try{
			AnzeigenStreckenStrg.befuelleGUi();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static void befuelleGUi(){
				
		viewUebersicht = new Streckenuebersicht();	
		Streckenverwaltung vstrecke = new Streckenverwaltung();  
		streckenliste = vstrecke.gibStrecke();
				
		try{
		
		
					
			int i = 0;
				
			for(Strecke s : streckenliste){
				
				if(i == 0){
					viewUebersicht.setlblBildStrecke1();
					viewUebersicht.setTitelStrecke1(s.getStreckenname());
					viewUebersicht.setBeschreibungStrecke1("Strecke in deinem Besitz");
				}
				if(i == 1){
					viewUebersicht.setlblBildStrecke2();
					viewUebersicht.setTitelStrecke2(s.getStreckenname());
					viewUebersicht.setBeschreibungStrecke2("Erreiche 10 Punkte um diese Strecke freizuschalten");
				}
				i++;
				
			}	
		
		
		}catch(Exception e){
			e.printStackTrace();
	
		}
}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getSource() == viewUebersicht.lblBildStrecke1){
			viewDetail = new StreckeDetailView();
		}
		if(arg0.getSource() == viewUebersicht.lblBildStrecke2){
			viewDetail = new StreckeDetailView();
		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
}