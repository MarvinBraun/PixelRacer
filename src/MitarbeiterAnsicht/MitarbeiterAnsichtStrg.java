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

import Anmelden.AnmeldenStrg;

public class MitarbeiterAnsichtStrg implements ActionListener, TreeSelectionListener{
	
	protected MitarbeiterAnsichtView maaView;
	protected StartView start;
	protected FunktionNichtVorhandenView nv;
	protected KartHinzufügenStrg kStrg;
	protected StreckeHinzufügenStrg sStrg;
	
	public MitarbeiterAnsichtStrg() {
		maaView = new MitarbeiterAnsichtView();
		maaView.setVisible(true);
		
		start = new StartView();
		
		maaView.panelContent.add("Start", start);
		start.btnAbmelden.addActionListener(this);
		
    	MitarbeiterHinzufügenStrg mStrg = new MitarbeiterHinzufügenStrg();
    	mStrg.getView();
   	    maaView.panelContent.add("MitarbeiterHinzufügen", mStrg.getView());
		
   	    kStrg = new KartHinzufügenStrg();
   	    kStrg.getView();
  	    maaView.panelContent.add("KartHinzufügen", kStrg.getView());
  	    
    	StreckeHinzufügenStrg sStrg = new StreckeHinzufügenStrg();
    	sStrg.getView();
   	    maaView.panelContent.add("StreckeHinzufügen", sStrg.getView());
   	    
 	    nv = new FunktionNichtVorhandenView();
 	    maaView.panelContent.add("FunktionNichtVorhanden", nv);
		
		maaView.tree.getSelectionModel().addTreeSelectionListener(this);
	} 

	public static void main(String[] args) {
		MitarbeiterAnsichtStrg maaStrg = new MitarbeiterAnsichtStrg();
	}
	
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) maaView.tree.getLastSelectedPathComponent();
        if(selectedNode.getUserObject().toString() == "Start") {
    	   maaView.cl.show(maaView.panelContent, "Start");
        }
        if(selectedNode.getUserObject().toString() == "Füge Mitarbeiter hinzu") {
      	   maaView.cl.show(maaView.panelContent, "MitarbeiterHinzufügen");
          }
        if(selectedNode.getUserObject().toString() == "Füge Kart hinzu") {
     	   maaView.cl.show(maaView.panelContent, "KartHinzufügen");
         }
        if(selectedNode.getUserObject().toString() == "Füge Strecke hinzu") {
      	   maaView.cl.show(maaView.panelContent, "StreckeHinzufügen");
          }
        if(selectedNode.getUserObject().toString() == "Füge Bezahlart hinzu") {
     	   maaView.cl.show(maaView.panelContent, "FunktionNichtVorhanden");
       }
    }
    
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == start.btnAbmelden) {
			maaView.dispose();
			AnmeldenStrg anmelden = new AnmeldenStrg();
		}
	}

}
