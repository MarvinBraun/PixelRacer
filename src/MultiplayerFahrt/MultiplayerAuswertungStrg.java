package MultiplayerFahrt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.ListIterator;

import Fahrt.Fahrtverwaltung;
import Fahrt.MultiplayerFahrt;
import Startansicht.StartansichtStrg;

/**
 * Steuerungsklasse, welche die grafische Benutzeroberfläche MultiplayerAuswertungView verwaltet und mit den Multientitäten kommuniziert.
 * @author Marvin Braun
 *
 */
public class MultiplayerAuswertungStrg implements ActionListener {
	private MultiplayerAuswertungView view;
	public MultiplayerAuswertungView getView() {
		return view;
	}

	public void setView(MultiplayerAuswertungView view) {
		this.view = view;
	}

	public Fahrtverwaltung getVerwaltung() {
		return verwaltung;
	}

	public void setVerwaltung(Fahrtverwaltung verwaltung) {
		this.verwaltung = verwaltung;
	}

	public LinkedList<MultiplayerFahrt> getFahrten() {
		return fahrten;
	}

	public void setFahrten(LinkedList<MultiplayerFahrt> fahrten) {
		this.fahrten = fahrten;
	}

	public MultiplayerFahrt getFahrt() {
		return fahrt;
	}

	public void setFahrt(MultiplayerFahrt fahrt) {
		this.fahrt = fahrt;
	}

	private Fahrtverwaltung verwaltung;
	private LinkedList<MultiplayerFahrt> fahrten = new LinkedList<MultiplayerFahrt>();
	private MultiplayerFahrt fahrt;
	
	/**
	 * Erstellt ein Objekt der Klasse MultiplayerAuswertungStrg und befüllt das Objekt "view" der Klasse MultiplayerAuswertungView.
	 * @param mf Objekt der Klasse MultiplayerFahrt
	 * @param streckenBild Objekt der Klasse BufferedImage
	 */
	
	public MultiplayerAuswertungStrg(MultiplayerFahrt mf, BufferedImage streckenBild)
	{
		//View initialisieren
		fahrt = mf;
		view = new MultiplayerAuswertungView();
		view.getFrame().setLocationRelativeTo(null);
		verwaltung = new Fahrtverwaltung();
		//Fahrten initialisieren
		System.out.println("Es wird gesucht nach: "+mf.getMultiplayerID());
		fahrten = verwaltung.gibMultiplayerFahrtenNachMultiplayerID(mf.getMultiplayerID());	
		ListIterator<MultiplayerFahrt> it = fahrten.listIterator();
		
		view.getMultiplayerIdLbl().setText("MultiplayerID: "+ fahrt.getMultiplayerID());
		view.getBtn().addActionListener(this);
		view.getFrame().setVisible(true);
		
		//Ränge einfügen
		int raenge = 1;
		
		while(it.hasNext()&&raenge<=3)
		{
			fahrt = it.next();
			if(raenge ==1)
			{
				view.getLblName1().setText(fahrt.getBenutzername());
				view.getLblZeit1().setText(fahrt.getZeit()+"");
			}
			else if(raenge ==2)
			{
				view.getLblName2().setText(fahrt.getBenutzername());
				view.getLblZeit2().setText(fahrt.getZeit()+"");
			}
			else if(raenge ==3)
			{
				view.getLblName3().setText(fahrt.getBenutzername());
				view.getLblZeit3().setText(fahrt.getZeit()+"");
			}
			raenge++;
			
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==view.getBtn())
		{
		
			StartansichtStrg strg = new StartansichtStrg();
			view.getFrame().dispose();
			
		}

		// TODO Auto-generated method stub
		
	}

}
