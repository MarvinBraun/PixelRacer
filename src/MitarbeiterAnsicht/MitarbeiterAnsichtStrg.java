package MitarbeiterAnsicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import KartHinzufügen.KartHinzufügenStrg;

public class MitarbeiterAnsichtStrg implements ActionListener {
	
	protected MitarbeiterAnsichtView maaView;
	
	public MitarbeiterAnsichtStrg(){
		maaView = new MitarbeiterAnsichtView();
		maaView.frmPixelRacer.setVisible(true);
		maaView.btnFgeKartHinzu.addActionListener(this);
		maaView.btnFgeStreckeHinzu.addActionListener(this);
		maaView.btnFgeStreckeHinzu.addActionListener(this);
		maaView.btnFgeBezahlartHinzu.addActionListener(this);
		
	}

	public static void main(String[] args) {
		MitarbeiterAnsichtStrg maaStrg = new MitarbeiterAnsichtStrg();

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == maaView.btnFgeBezahlartHinzu){
			featureNichtVorhandenMeldung();
		}
		if(e.getSource() == maaView.btnFgeKartHinzu){
			KartHinzufügenStrg khStrg = new KartHinzufügenStrg();
			maaView.frmPixelRacer.dispose();
		}
	}
	
	private void featureNichtVorhandenMeldung(){
		JOptionPane.showMessageDialog(maaView.frmPixelRacer,
			    "Diese Funktion steht aktuell nicht zur Verfügung", "Funktion nicht vorhanden",
			    JOptionPane.WARNING_MESSAGE);
	}

}
