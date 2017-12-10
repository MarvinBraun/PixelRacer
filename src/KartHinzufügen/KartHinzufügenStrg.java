/**
 @author Sean Cartner
*/

package KartHinzufügen;

public class KartHinzufügenStrg {
	
	KartHinzufügenView khView;
	
	public KartHinzufügenStrg(){
		khView = new KartHinzufügenView();
		khView.frmPixelRacer.setVisible(true);
	}

	public static void main(String[] args) {
		KartHinzufügenStrg khStrg = new KartHinzufügenStrg();
	}

}
