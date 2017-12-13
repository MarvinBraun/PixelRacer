package MitarbeiterAnsicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import KartHinzuf�gen.KartHinzuf�genStrg;
import StreckeHinzuf�gen.StreckeHinzuf�genStrg;

public class MitarbeiterAnsichtStrg implements ActionListener {
	
	protected MitarbeiterAnsichtView maaView;
	
	public MitarbeiterAnsichtStrg(){
		maaView = new MitarbeiterAnsichtView();
		maaView.frmPixelRacer.setVisible(true);
		maaView.btnFgeKartHinzu.addActionListener(this);
		maaView.btnFgeStreckeHinzu.addActionListener(this);
		maaView.btnFgeBezahlartHinzu.addActionListener(this);
		
	}

	public static void main(String[] args) {
		MitarbeiterAnsichtStrg maaStrg = new MitarbeiterAnsichtStrg();

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == maaView.btnFgeKartHinzu){
			KartHinzuf�genStrg khStrg = new KartHinzuf�genStrg();
			maaView.frmPixelRacer.dispose();
		}
		if(e.getSource() == maaView.btnFgeStreckeHinzu){
			StreckeHinzuf�genStrg stStrg = new StreckeHinzuf�genStrg();
			maaView.frmPixelRacer.dispose();
		}
		if(e.getSource() == maaView.btnFgeBezahlartHinzu){
			featureNichtVorhandenMeldung();
		}
	}
	
	private void featureNichtVorhandenMeldung(){
		JOptionPane.showMessageDialog(maaView.frmPixelRacer,
			    "Diese Funktion steht aktuell nicht zur Verf�gung", "Funktion nicht vorhanden",
			    JOptionPane.WARNING_MESSAGE);
	}

}
