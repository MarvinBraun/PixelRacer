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

import Anmelden.AnmeldenStrg;

public class MitarbeiterAnsichtStrg implements ActionListener, TreeSelectionListener{
	
	protected MitarbeiterAnsichtView maaView;
	protected StartView start;
	protected FunktionNichtVorhandenView nv;
	protected KartHinzuf�genStrg kStrg;
	protected StreckeHinzuf�genStrg sStrg;
	
	public MitarbeiterAnsichtStrg() {
		maaView = new MitarbeiterAnsichtView();
		maaView.setVisible(true);
		
		start = new StartView();
		
		maaView.panelContent.add("Start", start);
		start.btnAbmelden.addActionListener(this);
		
    	MitarbeiterHinzuf�genStrg mStrg = new MitarbeiterHinzuf�genStrg();
    	mStrg.getView();
   	    maaView.panelContent.add("MitarbeiterHinzuf�gen", mStrg.getView());
		
   	    kStrg = new KartHinzuf�genStrg();
   	    kStrg.getView();
  	    maaView.panelContent.add("KartHinzuf�gen", kStrg.getView());
  	    
    	StreckeHinzuf�genStrg sStrg = new StreckeHinzuf�genStrg();
    	sStrg.getView();
   	    maaView.panelContent.add("StreckeHinzuf�gen", sStrg.getView());
   	    
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
        if(selectedNode.getUserObject().toString() == "F�ge Mitarbeiter hinzu") {
      	   maaView.cl.show(maaView.panelContent, "MitarbeiterHinzuf�gen");
          }
        if(selectedNode.getUserObject().toString() == "F�ge Kart hinzu") {
     	   maaView.cl.show(maaView.panelContent, "KartHinzuf�gen");
         }
        if(selectedNode.getUserObject().toString() == "F�ge Strecke hinzu") {
      	   maaView.cl.show(maaView.panelContent, "StreckeHinzuf�gen");
          }
        if(selectedNode.getUserObject().toString() == "F�ge Bezahlart hinzu") {
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
