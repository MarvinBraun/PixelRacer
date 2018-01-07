/**
 @author Sean Cartner
*/

package MitarbeiterAnsicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import KartHinzufügen.KartHinzufügenStrg;
import StreckeHinzufügen.StreckeHinzufügenStrg;
import MitarbeiterHinzufügen.MitarbeiterHinzufügenStrg;
import KartBearbeiten.KartBearbeitenStrg;
import Anmelden.AnmeldenStrg;

public class MitarbeiterAnsichtStrg implements ActionListener, TreeSelectionListener{
	
	private MitarbeiterAnsichtView maaView;
	private StartView start;
	private FunktionNichtVorhandenView nv;
	private KartHinzufügenStrg kStrg;
	private StreckeHinzufügenStrg sStrg;
	private KartBearbeitenStrg kbStrg;
	
	public MitarbeiterAnsichtStrg() {
		maaView = new MitarbeiterAnsichtView();
		maaView.setVisible(true);
		
		start = new StartView();
		
		maaView.getPanelContent().add("Start", start);
		start.getbtnAbmelden().addActionListener(this);
		
    	MitarbeiterHinzufügenStrg mStrg = new MitarbeiterHinzufügenStrg();
    	mStrg.getView();
   	    maaView.getPanelContent().add("MitarbeiterHinzufügen", mStrg.getView());
		
   	    kStrg = new KartHinzufügenStrg();
   	    kStrg.getView();
  	    maaView.getPanelContent().add("KartHinzufügen", kStrg.getView());
  	    
  	    kbStrg = new KartBearbeitenStrg();
  	    kbStrg.getView();
  	    maaView.getPanelContent().add("KartBearbeiten", kbStrg.getView());
  	    
    	StreckeHinzufügenStrg sStrg = new StreckeHinzufügenStrg();
    	sStrg.getView();
   	    maaView.getPanelContent().add("StreckeHinzufügen", sStrg.getView());
   	    
 	    nv = new FunktionNichtVorhandenView();
 	    maaView.getPanelContent().add("FunktionNichtVorhanden", nv);
		
		maaView.getTree().getSelectionModel().addTreeSelectionListener(this);
	} 

	public static void main(String[] args) {
		MitarbeiterAnsichtStrg maaStrg = new MitarbeiterAnsichtStrg();
	}
	
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) maaView.getTree().getLastSelectedPathComponent();
        if(selectedNode.getUserObject().toString() == "Start") {
    	   maaView.getCL().show(maaView.getPanelContent(), "Start");
        }
        if(selectedNode.getUserObject().toString() == "Füge Mitarbeiter hinzu") {
      	   maaView.getCL().show(maaView.getPanelContent(), "MitarbeiterHinzufügen");
          }
        if(selectedNode.getUserObject().toString() == "Füge Kart hinzu") {
     	   maaView.getCL().show(maaView.getPanelContent(), "KartHinzufügen");
         }
        if(selectedNode.getUserObject().toString() == "Bearbeite Kart") {
      	   maaView.getCL().show(maaView.getPanelContent(), "KartBearbeiten");
          }
        if(selectedNode.getUserObject().toString() == "Füge Strecke hinzu") {
      	   maaView.getCL().show(maaView.getPanelContent(), "StreckeHinzufügen");
          }
        if(selectedNode.getUserObject().toString() == "Füge Bezahlart hinzu") {
     	   maaView.getCL().show(maaView.getPanelContent(), "FunktionNichtVorhanden");
       }
    }
    
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == start.getbtnAbmelden()) {
			maaView.dispose();
			AnmeldenStrg anmelden = new AnmeldenStrg();
		}
	}

}
