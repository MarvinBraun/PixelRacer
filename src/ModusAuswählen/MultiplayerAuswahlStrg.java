package ModusAuswählen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplayerAuswahlStrg implements ActionListener {

	static MultiplayerAuswahlStrg ms;
	MultiplayerAuswahlView mv = new MultiplayerAuswahlView();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mv.btnbeitreten){
			
		}if(e.getSource() == mv.btnerstellen){
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ms = new MultiplayerAuswahlStrg();
	}

}
