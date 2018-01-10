package MitarbeiterBearbeiten;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import Nutzer.Mitarbeiter;
import Nutzer.Nutzerverwaltung;
import MitarbeiterHinzufügen.MitarbeiterHinzufügenView;

/**
@author Sean Cartner
*/

public class MitarbeiterBearbeitenStrg implements ActionListener, MouseListener, MouseMotionListener {
	
	private MitarbeiterBearbeitenView mbv;
	private MitarbeiterHinzufügenView mhv;
	private LinkedList<Mitarbeiter> mitarbeiterliste;
	
	public MitarbeiterBearbeitenStrg() {
		mbv = new MitarbeiterBearbeitenView();
		ladeMitarbeiter();
		mbv.getBtnWeiter().addActionListener(this);
		mbv.getCardPanel().add("Auswahl", mbv.getAuswahlPanel());
		mbv.getAuswahlPanel().addMouseListener(this);
		mbv.getAuswahlPanel().addMouseMotionListener(this);
		mhv = new MitarbeiterHinzufügenView();
		mhv.getLblMitarbeiterHinzufgen().setText("Mitarbeiter Bearbeiten");
		mhv.getBtnAbbrechen().addActionListener(this);;
		mhv.getBtnAbsenden().addActionListener(this);
		mbv.getCardPanel().add("Formular", mhv);

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == mbv.getBtnWeiter()) {
			mbv.getCl().show(mbv.getCardPanel(), "Formular");
			ladeMitarbeiterDaten();
		}
		if(e.getSource() == mhv.getBtnAbbrechen()) {
			mbv.getCl().show(mbv.getCardPanel(), "Auswahl");
		}
	}
	
	private void ladeMitarbeiter() {
		Nutzerverwaltung nv = new Nutzerverwaltung();
		mitarbeiterliste = nv.gibMitarbeiterliste();
		
		for(Mitarbeiter ma: mitarbeiterliste) {
			mbv.getComboBoxMitarbeiter().addItem(ma.getmitarbeiterid() + ";" + ma.getnutzername());
		}
		
	}
	
	private void ladeMitarbeiterDaten(){
		String auswahl = (String) mbv.getComboBoxMitarbeiter().getSelectedItem();
		String[] split = auswahl.split(";");
		String id = split[0];
		for(Mitarbeiter ma: mitarbeiterliste){
			if(id.equals(ma.getmitarbeiterid())){
				mhv.getTfVorname().setText(ma.getvn());
				mhv.getTfNachname().setText(ma.getnn());
				mhv.getTfGeburtsdatum().setText(ma.getgebdat());
				mhv.getTfJob().setText(ma.getjobtitel());
				mhv.getTfBenutzername().setText(ma.getnutzername());
				mhv.getTfEmail().setText(ma.getemail());
				mhv.getPfPasswort().setText(ma.getpasswort());
			}
		}
	}

	public MitarbeiterBearbeitenView getView() {
		return mbv;
	}

	public LinkedList<Mitarbeiter> getMitarbeiterliste() {
		return mitarbeiterliste;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		File f = new File("src/Resources/tempMA.dat");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		} catch (FileNotFoundException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
