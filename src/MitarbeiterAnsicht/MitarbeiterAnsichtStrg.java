package MitarbeiterAnsicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import KartHinzufügen.KartHinzufügenStrg;
import StreckeHinzufügen.StreckeHinzufügenStrg;
import MitarbeiterHinzufügen.MitarbeiterHinzufügenStrg;
import KartBearbeiten.KartBearbeitenStrg;
import StreckeBearbeiten.StreckeBearbeitenStrg;
import MitarbeiterBearbeiten.MitarbeiterBearbeitenStrg;
import Anmelden.AnmeldenStrg;

/**
 * Steuerungsklasse, die die MitarbeiteransichtView verwaltet und dafür
 * verantwortlich ist die anderen Steuerungsklassen aufrufen.
 * 
 * @author Sean Cartner
 */

public class MitarbeiterAnsichtStrg implements ActionListener, TreeSelectionListener {

	private MitarbeiterAnsichtView maaView;
	private StartView start;
	private FunktionNichtVorhandenView nv;
	private KartHinzufügenStrg kStrg;
	private StreckeHinzufügenStrg sStrg;
	private KartBearbeitenStrg kbStrg;
	private StreckeBearbeitenStrg sbStrg;
	private MitarbeiterHinzufügenStrg mStrg;
	private MitarbeiterBearbeitenStrg mbStrg;

	/**
	 * Konstruktor
	 */
	public MitarbeiterAnsichtStrg() {
		maaView = new MitarbeiterAnsichtView();
		maaView.setVisible(true);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			 ;
		}
		
		start = new StartView();

		maaView.getPanelContent().add("Start", start);
		start.getbtnAbmelden().addActionListener(this);

		mStrg = new MitarbeiterHinzufügenStrg();
		maaView.getPanelContent().add("MitarbeiterHinzufügen", mStrg.getView());

		mbStrg = new MitarbeiterBearbeitenStrg();
		maaView.getPanelContent().add("MitarbeiterBearbeiten", mbStrg.getView());

		kStrg = new KartHinzufügenStrg();
		maaView.getPanelContent().add("KartHinzufügen", kStrg.getView());

		kbStrg = new KartBearbeitenStrg();
		maaView.getPanelContent().add("KartBearbeiten", kbStrg.getView());

		sStrg = new StreckeHinzufügenStrg();
		maaView.getPanelContent().add("StreckeHinzufügen", sStrg.getView());

		sbStrg = new StreckeBearbeitenStrg();
		maaView.getPanelContent().add("StreckeBearbeiten", sbStrg.getView());

		nv = new FunktionNichtVorhandenView();
		maaView.getPanelContent().add("FunktionNichtVorhanden", nv);

		maaView.getTree().getSelectionModel().addTreeSelectionListener(this);
	}
	
	/*
	public static void main(String[] args) {
		MitarbeiterAnsichtStrg maaStrg = new MitarbeiterAnsichtStrg();
	}
	*/

	/**
	 * Methode, die agiert wenn man man ein Punkt im Menü (JTree) anklickt. Sie
	 * sorgt dafür, dass das entsprechende Panel in der MitarbeiterAnsichtView
	 * angezeigt wird.
	 */
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) maaView.getTree().getLastSelectedPathComponent();
		if (selectedNode.getUserObject().toString() == "Start") {
			maaView.getCL().show(maaView.getPanelContent(), "Start");
		}
		if (selectedNode.getUserObject().toString() == "Füge Mitarbeiter hinzu") {
			maaView.getCL().show(maaView.getPanelContent(), "MitarbeiterHinzufügen");
		}
		if (selectedNode.getUserObject().toString() == "Bearbeite Mitarbeiter") {
			maaView.getCL().show(maaView.getPanelContent(), "MitarbeiterBearbeiten");
		}
		if (selectedNode.getUserObject().toString() == "Füge Kart hinzu") {
			maaView.getCL().show(maaView.getPanelContent(), "KartHinzufügen");
		}
		if (selectedNode.getUserObject().toString() == "Bearbeite Kart") {
			maaView.getCL().show(maaView.getPanelContent(), "KartBearbeiten");
		}
		if (selectedNode.getUserObject().toString() == "Füge Strecke hinzu") {
			maaView.getCL().show(maaView.getPanelContent(), "StreckeHinzufügen");
		}
		if (selectedNode.getUserObject().toString() == "Bearbeite Strecke") {
			maaView.getCL().show(maaView.getPanelContent(), "StreckeBearbeiten");
		}
		if (selectedNode.getUserObject().toString() == "Füge Bezahlart hinzu") {
			maaView.getCL().show(maaView.getPanelContent(), "FunktionNichtVorhanden");
		}
	}

	/**
	 * Methode, die agiert, wenn man auf einen Button klickt. In diesem Fall
	 * schließt sie die MitarbeiteransichtView und ruft die AnmeldenStrg auf.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start.getbtnAbmelden()) {
			maaView.dispose();
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			} catch (Exception e1) {
				 ;
			}
			AnmeldenStrg anmelden = new AnmeldenStrg();
		}
	}

}
