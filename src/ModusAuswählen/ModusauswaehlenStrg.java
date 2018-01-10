package ModusAuswählen;


 /** Die Klasse ModusauswählenStrg steuert die Aktionen, die in der Klasse 
 * ModusauswählenView getätigt werden.
 * @author Ferhat Koca
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import SingleplayerFahrt.FahrtErstellenStrg;
import Startansicht.StartansichtStrg;
import Nutzer.Kunde;
import Nutzer.Nutzerverwaltung;

public class ModusauswaehlenStrg implements ActionListener {

	static ModusauswaehlenStrg ms;
	static ModusauswaehlenView mav;
	Kunde kunde;

	/**
	 * 
	 * Die Methode actionPerformed liest den Button, auf den der Nutzer in der View
	 * klickt und führt die jeweilige Methode aus.
	 * 
	 * Der Button "Singleplayer" führt dazu, das der Nutzer eine Singleplayerfahrt
	 * spielen wird und zu dessen View weitergeleitet wird.
	 * 
	 * Der Button "Multiplayer" kann nur betätigt werden, wenn der Nutzer ein
	 * Premiumaccount erworben hat. Wenn ein Premiumaccount vorliegt führt ein Klick
	 * auf den Button dazu, dass der Nutzer zur MultiplayerView weitergeleitet wird.
	 * 
	 * Der "Zurück"-Button bringt den Nutzer zurück zur Startansicht.
	 */
	public void actionPerformed(ActionEvent e) {
	
		kunde = Nutzerverwaltung.getangKunde();
		if (e.getSource() == mav.btnSingleplayer) {
			mav.frame.dispose();
			FahrtErstellenStrg strg = new FahrtErstellenStrg(1);
		}

		if (e.getSource() == mav.btnzurueck) {
			mav.frame.dispose();
			StartansichtStrg sa = new StartansichtStrg();
		}

		if (e.getSource() == mav.btnMultiplayer) {
			mav.frame.dispose();
			try {
				MultiplayerAuswahlStrg.main(null);
			} catch (IOException e1) {
			
				e1.getMessage();
				System.out.println("Fehler beim Klicken von MultiplayerButton!");
			}
		}
	}

	/**
	 * Der Konstruktor ModusauswaehlenStrg ruft die ModusauswaehlenView auf und gibt
	 * jedem Button den dazugehörigen Befehl aus der Methode actionPerformed.
	 * 
	 * Im if-Teil wird nachgeschaut, ob der Kunde einen Premiumaccount hat. Je nach
	 * dem kann der Button betätigt werden oder nicht.
	 */
	public ModusauswaehlenStrg() {
		mav = new ModusauswaehlenView();
		mav.frame.setVisible(true);
		mav.btnSingleplayer.addActionListener(this);
		mav.btnzurueck.addActionListener(this);
		if (Nutzerverwaltung.getangKunde().getpremium().equals("false")) {
			mav.btnMultiplayer.setEnabled(false);
		} else {
			mav.btnMultiplayer.addActionListener(this);
		}
	}

	public static void main(String[] args) {
		ms = new ModusauswaehlenStrg();
	}

}
