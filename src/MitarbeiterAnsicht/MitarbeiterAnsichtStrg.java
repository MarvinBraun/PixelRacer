/**
 @author Sean Cartner
*/

package MitarbeiterAnsicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import KartHinzuf�gen.KartHinzuf�genStrg;
import StreckeHinzuf�gen.StreckeHinzuf�genStrg;
import MitarbeiterHinzuf�gen.MitarbeiterHinzuf�genStrg;
import KartBearbeiten.KartBearbeitenStrg;
import Anmelden.AnmeldenStrg;

public class MitarbeiterAnsichtStrg implements ActionListener, TreeSelectionListener{
	
	private MitarbeiterAnsichtView maaView;
	private StartView start;
	private FunktionNichtVorhandenView nv;
	private KartHinzuf�genStrg kStrg;
	private StreckeHinzuf�genStrg sStrg;
	private KartBearbeitenStrg kbStrg;
	
	public MitarbeiterAnsichtStrg() {
		maaView = new MitarbeiterAnsichtView();
		maaView.setVisible(true);
		
		start = new StartView();
		
		maaView.getPanelContent().add("Start", start);
		start.getbtnAbmelden().addActionListener(this);
		
    	MitarbeiterHinzuf�genStrg mStrg = new MitarbeiterHinzuf�genStrg();
    	mStrg.getView();
   	    maaView.getPanelContent().add("MitarbeiterHinzuf�gen", mStrg.getView());
		
   	    kStrg = new KartHinzuf�genStrg();
   	    kStrg.getView();
  	    maaView.getPanelContent().add("KartHinzuf�gen", kStrg.getView());
  	    
  	    kbStrg = new KartBearbeitenStrg();
  	    kbStrg.getView();
  	    maaView.getPanelContent().add("KartBearbeiten", kbStrg.getView());
  	    
    	StreckeHinzuf�genStrg sStrg = new StreckeHinzuf�genStrg();
    	sStrg.getView();
   	    maaView.getPanelContent().add("StreckeHinzuf�gen", sStrg.getView());
   	    
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
        if(selectedNode.getUserObject().toString() == "F�ge Mitarbeiter hinzu") {
      	   maaView.getCL().show(maaView.getPanelContent(), "MitarbeiterHinzuf�gen");
          }
        if(selectedNode.getUserObject().toString() == "F�ge Kart hinzu") {
     	   maaView.getCL().show(maaView.getPanelContent(), "KartHinzuf�gen");
         }
        if(selectedNode.getUserObject().toString() == "Bearbeite Kart") {
      	   maaView.getCL().show(maaView.getPanelContent(), "KartBearbeiten");
          }
        if(selectedNode.getUserObject().toString() == "F�ge Strecke hinzu") {
      	   maaView.getCL().show(maaView.getPanelContent(), "StreckeHinzuf�gen");
          }
        if(selectedNode.getUserObject().toString() == "F�ge Bezahlart hinzu") {
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
