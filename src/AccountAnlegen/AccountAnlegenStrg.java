package AccountAnlegen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Nutzer.*;
import Anmelden.AnmeldenStrg;
import Datenbankverwaltung.Datenbankschnittstelle;

//Autor Daniel Zeller

public class AccountAnlegenStrg implements ActionListener {
	private String benutzername; // Deklarierung der benötigten variablen
	private String vn;
	private String nn;
	private String gebdat;
	private String email;
	private String pw;
	private LinkedList<Kunde> kliste;

	AccountAnlegenView view1;

	public AccountAnlegenStrg() { // Konstruktor
		view1 = new AccountAnlegenView();
		view1.getFrmPixelRacer().setVisible(true);

		view1.getBtnAnlegen().addActionListener(this);
		view1.getBtnAbbrechen().addActionListener(this);
	}

	public static void main(String[] args) {
		AccountAnlegenStrg strg = new AccountAnlegenStrg();
	}

	public void eingegebeneDatenSpeichern() { // Speichern der eingegebenen Werte in den Textfeldern der View in
												// Variablen
		benutzername = view1.getTxtNutzername().getText();
		pw = new String(view1.getPasswordField().getPassword());
		vn = view1.getTxtVorname().getText();
		nn = view1.getTxtNachname().getText();
		email = view1.getTxtEmail().getText();
		gebdat = view1.getTxtGeburtsdatum().getText();
	}

	public Boolean DatenPruefen() { // Prüfung der eingegebenen Daten auf Länge und Zeicheninhalte
		if (benutzername.length() <= 20 && benutzername.length() != 0) {

			kliste = Nutzerverwaltung.gibKundenliste(); // Jeder Kunde aus der Datenbank

			for (Kunde temp : kliste) { // Überprüfung auf Gleichheit
				if (temp.getnutzername().equals(benutzername)) {
					JOptionPane.showMessageDialog(null, "Der Benutzername ist leider schon vergeben!", "Ok",
							JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			if (pw.length() <= 20 && pw.length() != 0) {
				if (vn.length() <= 20 && vn.length() != 0 && vn.matches("[a-zA-ZäÄöÖüÜß]+")) {
					if (nn.length() <= 20 && nn.length() != 0 && nn.matches("[a-zA-ZäÄöÖüÜß]+")) {
						if (gebdat.length() <= 8 && gebdat.length() != 0 && gebdat.matches("[0-9.]+")) {
							if (email.length() <= 50 && email.length() != 0 && email.contains("@")) {
								return true;
							}
							// Fehlermeldungen je nachdem, welche IF nicht true ist
							else {
								JOptionPane.showMessageDialog(null,
										"Die Daten der Email sind falsch!\nBeachte das max 50 Zeichen verwendet werden dürfen"
												+ " und ein @ vorhanden sein muss!",
										"Ok", JOptionPane.ERROR_MESSAGE);
								return false;
							}
						}

						else {
							JOptionPane.showMessageDialog(null,
									"Bitte beachte das das Format des Datums den Vorgaben übereinstimmt!", "Ok",
									JOptionPane.ERROR_MESSAGE);
							return false;
						}
					}

					else {
						JOptionPane.showMessageDialog(null,
								"Beachte das beim Nachnamen max 20 Zeichen erlaubt sind und auch keine Zahlen "
										+ "oder Sonderzeichen!",
								"Ok", JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}

				else {
					JOptionPane.showMessageDialog(null,
							"Beachte das beim Vornamen max 20 Zeichen erlaubt sind und auch keine Zahlen "
									+ "oder Sonderzeichen!",
							"Ok", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}

			else {
				JOptionPane.showMessageDialog(null,
						"Beachte das höchstens 20 Zeichen beim Passwort benutzt werden dürfen!", "Ok",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}

		else {
			JOptionPane.showMessageDialog(null,
					"Beachte das höchstens 20 Zeichen beim Benutzernamen benutzt werden dürfen!", "Ok",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public void InsertIntoKunde() { // Speichern des Kundens in der Datenbank
		String update = ("insert into kunde values('" + benutzername + "','" + pw + "','" + vn + "','" + nn
				+ "','false',0,'" + gebdat + "','" + email + "')");

		Datenbankschnittstelle.executeUpdate(update);
		Datenbankschnittstelle.closeConnections();
	}

	@Override
	public void actionPerformed(ActionEvent e) { // ActionPerformed der Buttons
		// TODO Auto-generated method stub
		if (e.getSource() == view1.getBtnAnlegen()) { // Die Daten werden geprüft und bei richtiger Eingabe in die
														// Datenbank geschrieben

			eingegebeneDatenSpeichern();
			if (DatenPruefen()) {
				InsertIntoKunde();
				JOptionPane.showMessageDialog(null, "Der Account wurde erfolgreich angelegt!", "Viel Spaß!",
						JOptionPane.PLAIN_MESSAGE);
				view1.getFrmPixelRacer().dispose();
				AnmeldenStrg strg = new AnmeldenStrg();
			}
		}

		if (e.getSource() == view1.getBtnAbbrechen()) { // Der Vorgang wird abgebrochen und das Anmeldenfenster wird
														// erneut angezeigt
			view1.getFrmPixelRacer().dispose();
			AnmeldenStrg strg = new AnmeldenStrg();
		}
	}
}