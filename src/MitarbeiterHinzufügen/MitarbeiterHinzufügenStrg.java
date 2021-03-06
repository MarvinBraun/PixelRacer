
package MitarbeiterHinzuf�gen;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import javax.swing.JOptionPane;
import Datenbankverwaltung.Datenbankschnittstelle;

import java.awt.event.ActionEvent;

/**
 * Steuerungsklasse, welche die MitarbeiterHinzuf�genView verwaltet, sowie den
 * Vorgang des Hinzuf�gen eines neuen Mitarbeiters koodiniert.
 * 
 * @author Sean Cartner
 */
public class MitarbeiterHinzuf�genStrg implements ActionListener {

	// Globale Variablen
	private MitarbeiterHinzuf�genView mhView;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
	private boolean datumGueltig = true;
	private int mitarbeiterID;
	private String vorname;
	private String nachname;
	private String geburtsdatum;
	private String job;
	private String benutzername;
	private String email;
	private String passwort;

	// Konstruktor
	public MitarbeiterHinzuf�genStrg() {
		mhView = new MitarbeiterHinzuf�genView();
		mhView.getPanel().setVisible(true);
		mhView.getBtnAbsenden().addActionListener(this);
		mhView.getBtnAbbrechen().addActionListener(this);
	}

	/**
	 * Methode, die agiert, wenn ein Button gedr�ckt wurde. Diese soll, wenn: 
	 * -BtnAuswaehlen gedr�ckt wurde den FileChooser aufrufen. 
	 * -BtnAbsenden gedr�ckt wurden einen neuen Mitarbeiter in der Datenbank erstellen. 
	 * -BtnAbbrechen gedr�cktwurde das Formular leeren.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mhView.getBtnAbsenden()) {
			if (pruefeFormarAufVollst�ndigkeit() == false) {
				formularUnvollst�ndigMeldung();
			} else {
				istVornameZuLang();
				istNachnameZuLang();
				istJobZuLang();
				istBenutzernameZuLang();
				istEmailZuLang();
				istPasswortZuLang();
				if (laengeOk == "false") {
					inhaltZuLangMeldung();
					fehlermeldung = "Folgende Angaben sind zu lang:";
					// reset
					laengeOk = "true";
				} else {
					istDatumGueltig();
					if (datumGueltig == false) {
						datumUngueltigMeldung();
						// reset
						datumGueltig = true;
					} else {
						if (istVornameFormatOk() == false) {
							vornameFormatNichtOkMeldung();
						} else {
							if (istNachnameFormatOk() == false) {
								nachnameFormatNichtOkMeldung();
							} else {
								if (istJobFormatOk() == false) {
									jobFormatNichtOkMeldung();
								} else {
									if (istBenutzernameFormatOk() == false) {
										benutzernameFormatNichtOkMeldung();
									} else {
										if (istEmailFormatOk() == false) {
											emailFormatNichtOkMeldung();
										} else {
											if (istDatumFormatOk() == false) {
												datumFormatNichtOkMeldung();
											} else {
												deklariereVariablenVTextfeldern();
												if (istBenutzernameVergeben() == true) {
													benutzernameBereitsVergebenMeldung();
												} else {
													erstelleMitarbeiterInDB();
													speicherMitarbeiterZwischen();
													mitarbeiterErfolgreichAngelegtMeldung();
													leereFormular();
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if (e.getSource() == mhView.getBtnAbbrechen()) {
			leereFormular();
		}
	}

	/**
	 * Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist.
	 */
	private void formularUnvollst�ndigMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(), "Alle Felder m�ssen ausgef�llt sein!",
				"Formular unvollst�ndig", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu
	 * lang ist.
	 */
	private void inhaltZuLangMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(), fehlermeldung, "Inhalt zu lang", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ein ungueltiges Datum eingegeben wurde.
	 */
	private void datumUngueltigMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(), "Das eingegebene Datum existiert nicht", "Datum ung�ltig",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ungueltige Zeichen im Vornamen eingegeben wurde.
	 */
	private void vornameFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(),
				"Beachte die Gro�- und Kleinschreibung beim Vornamen, sowie die nicht erlaubten Sonderzeichen",
				"Vorname ung�ltig", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ungueltige Zeichen im Nachnamen eingegeben
	 * wurde.
	 */
	private void nachnameFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(),
				"Beachte die Gro�- und Kleinschreibung beim Nachnamen, sowie die nicht erlaubten Sonderzeichen",
				"Nachname ung�ltig", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ungueltige Zeichen im Job eingegeben wurde.
	 */
	private void jobFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(),
				"Beachte die Gro�- und Kleinschreibung beim Job, sowie, dass keine Sonderzeichen erlaubt sind",
				"Job ung�ltig", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Benutzername nicht mindestens 3 Buchstaben hat.
	 */
	private void benutzernameFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(), "Benutzername muss mindestens 3 Buchstaben am Anfang haben",
				"Benutzername ung�ltig", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Email keinen gueltigen Muster entspricht.
	 */
	private void emailFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(), "Die eingegene Email entspricht keiner g�ltigen Email-Adresse",
				"Email ung�ltig", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ein ungueltiges Datum eingegeben wurde.
	 */
	private void datumFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(), "Das Datum muss im Format DD.MM.YY vorliegen",
				"Datum ung�ltig", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ein Mitarbeiter erfolgreich angelegt wurde.
	 */
	private void mitarbeiterErfolgreichAngelegtMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(),
				"Mitarbeiter mit der ID " + mitarbeiterID + " erfolgreich angelegt", "Erfolgreich",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn die MitarbeiterID aufgrund eines
	 * Datenbankproblems nicht berechnet werden konnte.
	 */
	private void konnteMitarbeiterIdNichtBerechnenMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(),
				"MitarbeiterID konnte aufgrund eines Datenbank Problms nicht berechnet werden", "Datenbankproblem",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn der Mitarbeiter nicht in die Datei geschrieben
	 * werden konnte.
	 */
	private void mitarbeiterKonnteNichtZwischengespeichertWerdenMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(), "Mitarbeiter konnte nicht zwischengespeichert werden",
				"Zwischenspeichern nicht m�glich", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn der eingegebene Benutzername bereits vergeben
	 * ist.
	 */
	private void benutzernameBereitsVergebenMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(), "Der eingegebene Benutzername wird bereits genutzt",
				"Benutzername vergeben", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn die mitarbeiterID aufgrund eines
	 * Datenbankproblems nicht kontrolliert werden konnte.
	 */
	private void konnteMitarbeiterIdNichtKontrollierenMeldung() {
		JOptionPane.showMessageDialog(mhView.getPanel(), "Konnte MitarbeiterID nicht pr�fen", "Datenbankproblem",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt
	 * ist.
	 * 
	 * @return Boolean
	 */
	private boolean pruefeFormarAufVollst�ndigkeit() {
		if (mhView.getTfVorname().getText().isEmpty() || mhView.getTfNachname().getText().isEmpty()
				|| mhView.getTfGeburtsdatum().getText().isEmpty() || mhView.getTfJob().getText().isEmpty()
				|| mhView.getTfBenutzername().getText().isEmpty() || mhView.getTfEmail().getText().isEmpty()
				|| mhView.getPfPasswort().getPassword().length == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Methode, welche die Laenge des Vorname-Feldes kontrollieren soll.
	 */
	private void istVornameZuLang() {
		if (mhView.getTfVorname().getText().length() > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Vorname";
		}
	}

	/**
	 * Methode, welche die Laenge des Nachname-Feldes kontrollieren soll.
	 */
	private void istNachnameZuLang() {
		if (mhView.getTfNachname().getText().length() > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Nachname";
		}
	}

	/**
	 * Methode, welche die Laenge des Job-Feldes kontrollieren soll.
	 */
	private void istJobZuLang() {
		if (mhView.getTfJob().getText().length() > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Job";
		}
	}

	/**
	 * Methode, welche die Laenge des Benutzername-Feldes kontrollieren soll.
	 */
	private void istBenutzernameZuLang() {
		if (mhView.getTfBenutzername().getText().length() > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Benutzername";
		}
	}

	/**
	 * Methode, welche die Laenge des Email-Feldes kontrollieren soll.
	 */
	private void istEmailZuLang() {
		if (mhView.getTfEmail().getText().length() > 50) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Email";
		}
	}

	/**
	 * Methode, welche die Laenge des Passwort-Feldes kontrollieren soll.
	 */
	private void istPasswortZuLang() {
		if (mhView.getPfPasswort().getPassword().length > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Passwort";
		}
	}

	/**
	 * Methode, die kontrolliert, ob das Datum im richtigen Format eingegeben wurde.
	 */
	private void istDatumGueltig() {
		Date date = null;
		try {
			DateFormat format = new SimpleDateFormat("dd.MM.yy");
			format.setLenient(false);
			date = format.parse(mhView.getTfGeburtsdatum().getText());
		} catch (ParseException e) {
			datumGueltig = false;
		}
	}

	/**
	 * Methode, die kontrolliert, ob der Vorname im richtigen Format eingegeben
	 * wurde.
	 * 
	 * @return
	 */
	private boolean istVornameFormatOk() {
		Pattern patt = Pattern.compile("[A-Z���][a-z����]+([ -][A-Z���][a-z����]+)?");
		Matcher match = patt.matcher(mhView.getTfVorname().getText());
		return match.matches();
	}

	/**
	 * Methode, die kontrolliert, ob der Nachname im richtigen Format eingegeben
	 * wurde.
	 * 
	 * @return Boolean
	 */
	private boolean istNachnameFormatOk() {
		Pattern patt = Pattern.compile("([a-z]{2,3})?[ ]?([a-z]{2,3}[ ])?[A-Z���][a-z����]+([ -][A-Z���][a-z����]+)?");
		Matcher match = patt.matcher(mhView.getTfNachname().getText());
		return match.matches();
	}

	/**
	 * Methode, die kontrolliert, ob der Job im richtigen Format eingegeben wurde.
	 * 
	 * @return Boolean
	 */
	private boolean istJobFormatOk() {
		Pattern patt = Pattern.compile("[A-Z���][a-z����]+");
		Matcher match = patt.matcher(mhView.getTfJob().getText());
		return match.matches();
	}

	/**
	 * Methode, die kontrolliert, ob der Benutzername im richtigen Format eingegeben
	 * wurde.
	 * 
	 * @return Boolean
	 */
	private boolean istBenutzernameFormatOk() {
		Pattern patt = Pattern.compile("[A-Z���a-z����]{3}.*");
		Matcher match = patt.matcher(mhView.getTfBenutzername().getText());
		return match.matches();
	}

	/**
	 * Methode, die kontrolliert, ob die Email im richtigen Format eingegeben wurde.
	 * 
	 * @return Boolean
	 */
	private boolean istEmailFormatOk() {
		Pattern patt = Pattern
				.compile("[A-Z���a-z����0-9.!#$%&'*+-/=?^_`{|}~]+[@][a-z����0-9-]+[.][a-z]{2,3}([.][a-z]{2})?");
		Matcher match = patt.matcher(mhView.getTfEmail().getText());
		return match.matches();
	}

	/**
	 * Methode, die kontrolliert, ob das Datum im richtigen Format eingegeben wurde.
	 * 
	 * @return Boolean
	 */
	private boolean istDatumFormatOk() {
		Pattern patt = Pattern.compile("[0-9]{2}[.][0-9]{2}[.][0-9]{2}");
		Matcher match = patt.matcher(mhView.getTfGeburtsdatum().getText());
		return match.matches();
	}

	/**
	 * Methode, welche kontrolliert, ob der Benutzername bereits vergeben ist.
	 * 
	 * @return Boolean
	 */
	private boolean istBenutzernameVergeben() {
		ResultSet rs = Datenbankschnittstelle
				.executeQuery("select mitarbeiterid from mitarbeiter where benutzername = '" + benutzername + "'");
		int check = 0;
		try {
			while (rs.next()) {
				check = rs.getInt(1);
			}
			rs.close();

		} catch (SQLException e) {
			konnteMitarbeiterIdNichtKontrollierenMeldung();
		}
		Datenbankschnittstelle.closeConnections();
		if (check != 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Methode, welche die hoechste MitarbeiterID aus der Datenbank liest und anhand
	 * dieser eine neue ID berechnet (+1).
	 * 
	 * @return Integer
	 */
	private int berechneMitarbeiterID() {
		ResultSet rs = Datenbankschnittstelle.executeQuery("select max(mitarbeiterid) from mitarbeiter");
		int i = 0;
		try {
			while (rs.next()) {
				i = rs.getInt(1);
			}
			rs.close();

		} catch (SQLException e) {
			konnteMitarbeiterIdNichtBerechnenMeldung();
		}
		Datenbankschnittstelle.closeConnections();
		i = i + 1;

		/*
		 * Speichert die Mitarbeiter ID des neuen Mitarbeiter in die Zwischenablage des
		 * Computers
		 */
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(String.valueOf(i)), null);

		return i;
	}

	/**
	 * Methode, in die Datenbank relevanten Variablen aufgrundlage des Formulars
	 * deklariert werden.
	 */
	private void deklariereVariablenVTextfeldern() {
		mitarbeiterID = berechneMitarbeiterID();
		vorname = mhView.getTfVorname().getText();
		nachname = mhView.getTfNachname().getText();
		geburtsdatum = mhView.getTfGeburtsdatum().getText();
		job = mhView.getTfJob().getText();
		benutzername = mhView.getTfBenutzername().getText();
		email = mhView.getTfEmail().getText();
		passwort = new String(mhView.getPfPasswort().getPassword());
	}

	/**
	 * Methode, welche ein Mitarbeiter in der Datenbank erstellt.
	 */
	private void erstelleMitarbeiterInDB() {
		String abfrage = "insert into mitarbeiter values('" + mitarbeiterID + "', '" + benutzername + "', '" + passwort
				+ "', '" + vorname + "', '" + nachname + "', '" + job + "', '" + email + "', '" + geburtsdatum + "')";
		Datenbankschnittstelle.executeQuery(abfrage);
		Datenbankschnittstelle.closeConnections();
	}

	/**
	 * Methode, welche den Mitarbeiter zum Zwecke der Zwischenspeicherung in eine
	 * Datei schreibt.
	 */
	private void speicherMitarbeiterZwischen() {
		File f;
		String zeile = String.valueOf(mitarbeiterID) + ";" + benutzername + ";" + passwort + ";" + vorname + ";"
				+ nachname + ";" + job + ";" + email + ";" + geburtsdatum;
		try {
			f = File.createTempFile("tempMa", ".dat");
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(zeile);
			bw.newLine();
			bw.close();
			fw.close();
			f.deleteOnExit();
		} catch (IOException e) {
			mitarbeiterKonnteNichtZwischengespeichertWerdenMeldung();
		}
	}

	/**
	 * Methode, die das Formular leeren soll.
	 */
	private void leereFormular() {
		mhView.getTfVorname().setText("");
		mhView.getTfNachname().setText("");
		mhView.getTfGeburtsdatum().setText("");
		mhView.getTfJob().setText("");
		mhView.getTfBenutzername().setText("");
		mhView.getTfEmail().setText("");
		mhView.getPfPasswort().setText("");
	}

	/**
	 * Getter f�r die MitarbeiterHinzuf�genView.
	 * 
	 * @return MitarbeiterHinzuf�genView
	 */
	public MitarbeiterHinzuf�genView getView() {
		return mhView;
	}
}
