package MitarbeiterBearbeiten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Datenbankverwaltung.Datenbankschnittstelle;
import Nutzer.Mitarbeiter;
import Nutzer.Nutzerverwaltung;
import MitarbeiterHinzufügen.MitarbeiterHinzufügenView;

/**
 * @author Sean Cartner
 */

public class MitarbeiterBearbeitenStrg implements ActionListener, MouseListener, MouseMotionListener {

	private MitarbeiterBearbeitenView mbv;
	private MitarbeiterHinzufügenView mhv;
	private LinkedList<Mitarbeiter> mitarbeiterliste;
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

	public MitarbeiterBearbeitenStrg() {
		mbv = new MitarbeiterBearbeitenView();
		ladeMitarbeiter();
		mbv.getBtnWeiter().addActionListener(this);
		mbv.getCardPanel().add("Auswahl", mbv.getAuswahlPanel());
		mbv.getAuswahlPanel().addMouseListener(this);
		mbv.getAuswahlPanel().addMouseMotionListener(this);
		mhv = new MitarbeiterHinzufügenView();
		mhv.getLblMitarbeiterHinzufgen().setText("Mitarbeiter Bearbeiten");
		mhv.getBtnAbbrechen().addActionListener(this);
		mhv.getBtnAbsenden().addActionListener(this);
		mbv.getCardPanel().add("Formular", mhv);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mbv.getBtnWeiter()) {
			mbv.getCl().show(mbv.getCardPanel(), "Formular");
			ladeMitarbeiterDaten();
		}
		if (e.getSource() == mhv.getBtnAbbrechen()) {
			mbv.getCl().show(mbv.getCardPanel(), "Auswahl");
		}
		if (e.getSource() == mhv.getBtnAbsenden()) {
			// Daten pruefen und wenn alles Korrekt ist einen neuen Datensatz anlegen
			if (pruefeFormarAufVollständigkeit() == false) {
				formularUnvollständigMeldung();
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
													if(istBenutzernameVergeben() == true) {
														benutzernameBereitsVergebenMeldung();
													}else {
														updateMitarbeiterInDB();
														mitarbeiterErfolgreichUpgedatetMeldung();
														updateMitarbeiterInListe();
														mbv.getCl().show(mbv.getCardPanel(), "Auswahl");
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
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		File f = new File("src/Resources/tempMA.dat");
		if (f.exists()) {
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);

				String zeile;
				String[] split;

				try {
					while ((zeile = br.readLine()) != null) {
						split = zeile.split(";");
						Mitarbeiter ma = new Mitarbeiter();
						ma.setvn(split[3]);
						ma.setnn(split[4]);
						ma.setnutzername(split[1]);
						ma.setpasswort(split[2]);
						ma.setmitarbeiterid(split[0]);
						ma.setjobtitel(split[5]);
						ma.setemail(split[6]);
						ma.setgebdat(split[7]);
						mitarbeiterliste.add(ma);
					}

					fr.close();
					br.close();

				} catch (IOException y) {
					eingabeAusgabeFehlerMeldung();
				}
			} catch (FileNotFoundException x) {
				dateiNichtgefundenMeldung();
			}

			mbv.getComboBoxMitarbeiter().removeAllItems();
			for (Mitarbeiter ma : mitarbeiterliste) {
				mbv.getComboBoxMitarbeiter().addItem(ma.getmitarbeiterid() + ";" + ma.getnutzername());
			}

			f.delete();
		}
	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	private void ladeMitarbeiter() {
		Nutzerverwaltung nv = new Nutzerverwaltung();
		mitarbeiterliste = nv.gibMitarbeiterliste();
		Collections.sort(mitarbeiterliste, new MitarbeiterKomperator());
		for (Mitarbeiter ma : mitarbeiterliste) {
			mbv.getComboBoxMitarbeiter().addItem(ma.getmitarbeiterid() + ";" + ma.getnutzername());
		}
	}

	private void ladeMitarbeiterDaten() {
		String auswahl = (String) mbv.getComboBoxMitarbeiter().getSelectedItem();
		String[] split = auswahl.split(";");
		String id = split[0];
		for (Mitarbeiter ma : mitarbeiterliste) {
			if (id.equals(ma.getmitarbeiterid())) {
				mitarbeiterID = Integer.parseInt(ma.getmitarbeiterid());
				mhv.getTfVorname().setText(ma.getvn());
				mhv.getTfNachname().setText(ma.getnn());
				mhv.getTfGeburtsdatum().setText(ma.getgebdat());
				mhv.getTfJob().setText(ma.getjobtitel());
				mhv.getTfBenutzername().setText(ma.getnutzername());
				mhv.getTfEmail().setText(ma.getemail());
				mhv.getPfPasswort().setText(ma.getpasswort());
			}
		}
	}

	// Methode, in die Datenbank relevanten Variablen aufgrundlage des Formulars
	// deklariert werden
	private void deklariereVariablenVTextfeldern() {
		vorname = mhv.getTfVorname().getText();
		nachname = mhv.getTfNachname().getText();
		geburtsdatum = mhv.getTfGeburtsdatum().getText();
		job = mhv.getTfJob().getText();
		benutzername = mhv.getTfBenutzername().getText();
		email = mhv.getTfEmail().getText();
		passwort = new String(mhv.getPfPasswort().getPassword());
	}

	// Methode, welche ein Mitarbeiter in der Datenbank updatet
	private void updateMitarbeiterInDB() {
		String update = "Update mitarbeiter set benutzername = '" + benutzername + "', passwort = '" + passwort
				+ "', vorname = '" + vorname + "', nachname = '" + nachname + "', jobtitel = '" + job + "', email = '"
				+ email + "', geburtsdatum = '" + geburtsdatum + "' where mitarbeiterid =" + mitarbeiterID;
		Datenbankschnittstelle.executeUpdate(update);
		Datenbankschnittstelle.closeConnections();
	}

	private void updateMitarbeiterInListe() {
		mbv.getComboBoxMitarbeiter().removeAllItems();
		for (Mitarbeiter ma : mitarbeiterliste) {
			if (String.valueOf(mitarbeiterID).equals(ma.getmitarbeiterid())) {
				ma.setvn(vorname);
				ma.setnn(nachname);
				ma.setnutzername(benutzername);
				ma.setpasswort(passwort);
				ma.setjobtitel(job);
				ma.setemail(email);
				ma.setgebdat(geburtsdatum);
			}
			mbv.getComboBoxMitarbeiter().addItem(ma.getmitarbeiterid() + ";" + ma.getnutzername());
		}
	}

	// Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt
	// ist
	private boolean pruefeFormarAufVollständigkeit() {
		if (mhv.getTfVorname().getText().isEmpty() || mhv.getTfNachname().getText().isEmpty()
				|| mhv.getTfGeburtsdatum().getText().isEmpty() || mhv.getTfJob().getText().isEmpty()
				|| mhv.getTfBenutzername().getText().isEmpty() || mhv.getTfEmail().getText().isEmpty()
				|| mhv.getPfPasswort().getPassword().length == 0) {
			return false;
		}
		return true;
	}

	// Methode, welche die Laenge des Vorname-Feldes kontrollieren soll
	private void istVornameZuLang() {
		if (mhv.getTfVorname().getText().length() > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Vorname";
		}
	}

	// Methode, welche die Laenge des Nachname-Feldes kontrollieren soll
	private void istNachnameZuLang() {
		if (mhv.getTfNachname().getText().length() > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Nachname";
		}
	}

	// Methode, welche die Laenge des Job-Feldes kontrollieren soll
	private void istJobZuLang() {
		if (mhv.getTfJob().getText().length() > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Job";
		}
	}

	// Methode, welche die Laenge des Benutzername-Feldes kontrollieren soll
	private void istBenutzernameZuLang() {
		if (mhv.getTfBenutzername().getText().length() > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Benutzername";
		}
	}

	// Methode, welche die Laenge des Email-Feldes kontrollieren soll
	private void istEmailZuLang() {
		if (mhv.getTfEmail().getText().length() > 50) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Email";
		}
	}

	// Methode, welche die Laenge des Passwort-Feldes kontrollieren soll
	private void istPasswortZuLang() {
		if (mhv.getPfPasswort().getPassword().length > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Passwort";
		}
	}

	// Methode, die kontrolliert, ob das Datum im richtigen Format eingegeben wurde
	private void istDatumGueltig() {
		Date date = null;
		try {
			DateFormat format = new SimpleDateFormat("dd.MM.yy");
			format.setLenient(false);
			date = format.parse(mhv.getTfGeburtsdatum().getText());
		} catch (ParseException e) {
			datumGueltig = false;
		}
	}

	// Methode, die kontrolliert, ob der Vorname im richtigen Format eingegeben
	// wurde
	private boolean istVornameFormatOk() {
		Pattern patt = Pattern.compile("[A-ZÄÖÜ][a-zäöüß]+([ -][A-ZÄÖÜ][a-zäöüß]+)?");
		Matcher match = patt.matcher(mhv.getTfVorname().getText());
		return match.matches();
	}

	// Methode, die kontrolliert, ob der Nachname im richtigen Format eingegeben
	// wurde
	private boolean istNachnameFormatOk() {
		Pattern patt = Pattern.compile("([a-z]{2,3})?[ ]?([a-z]{2,3}[ ])?[A-ZÄÖÜ][a-zäöüß]+([ -][A-ZÄÖÜ][a-zäöüß]+)?");
		Matcher match = patt.matcher(mhv.getTfNachname().getText());
		return match.matches();
	}

	// Methode, die kontrolliert, ob der Job im richtigen Format eingegeben wurde
	private boolean istJobFormatOk() {
		Pattern patt = Pattern.compile("[A-ZÄÖÜ][a-zäöüß]+");
		Matcher match = patt.matcher(mhv.getTfJob().getText());
		return match.matches();
	}

	// Methode, die kontrolliert, ob der Benutzername im richtigen Format eingegeben
	// wurde
	private boolean istBenutzernameFormatOk() {
		Pattern patt = Pattern.compile("[A-ZÄÖÜa-zäöüß]{3}.*");
		Matcher match = patt.matcher(mhv.getTfBenutzername().getText());
		return match.matches();
	}

	// Methode, die kontrolliert, ob die Email im richtigen Format eingegeben wurde
	private boolean istEmailFormatOk() {
		Pattern patt = Pattern
				.compile("[A-ZÄÖÜa-zäöüß0-9.!#$%&'*+-/=?^_`{|}~]+[@][a-zäöüß0-9-]+[.][a-z]{2,3}([.][a-z]{2})?");
		Matcher match = patt.matcher(mhv.getTfEmail().getText());
		return match.matches();
	}

	// Methode, die kontrolliert, ob das Datum im richtigen Format eingegeben wurde
	private boolean istDatumFormatOk() {
		Pattern patt = Pattern.compile("[0-9]{2}[.][0-9]{2}[.][0-9]{2}");
		Matcher match = patt.matcher(mhv.getTfGeburtsdatum().getText());
		return match.matches();
	}

	private boolean istBenutzernameVergeben() {
		int check = 0;
		for (Mitarbeiter ma : mitarbeiterliste) {
			if (benutzername.equals(ma.getnutzername())) {
				check = Integer.parseInt(ma.getmitarbeiterid());
			}
		}
		if(check != mitarbeiterID) {
			return true;
		}else {
			return false;
		}
	}

	// Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist
	private void formularUnvollständigMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(), "Alle Felder müssen ausgefüllt sein!", "Formular unvollständig",
				JOptionPane.WARNING_MESSAGE);
	}

	// Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu
	// lang ist
	private void inhaltZuLangMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(), fehlermeldung, "Inhalt zu lang", JOptionPane.WARNING_MESSAGE);
	}

	// Meldung, die erscheint, wenn ein ungueltiges Datum eingegeben wurde
	private void datumUngueltigMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(), "Das eingegebene Datum existiert nicht", "Datum ungültig",
				JOptionPane.WARNING_MESSAGE);
	}

	// Meldung, die erscheint, wenn ungueltige Zeichen im Vornamen eingegeben wurde
	private void vornameFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(),
				"Beachte die Groß- und Kleinschreibung beim Vornamen, sowie die nicht erlaubten Sonderzeichen",
				"Vorname ungültig", JOptionPane.WARNING_MESSAGE);
	}

	// Meldung, die erscheint, wenn ungueltige Zeichen im Nachnamen eingegeben wurde
	private void nachnameFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(),
				"Beachte die Groß- und Kleinschreibung beim Nachnamen, sowie die nicht erlaubten Sonderzeichen",
				"Nachname ungültig", JOptionPane.WARNING_MESSAGE);
	}

	// Meldung, die erscheint, wenn ungueltige Zeichen im Job eingegeben wurde
	private void jobFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(),
				"Beachte die Groß- und Kleinschreibung beim Job, sowie, dass keine Sonderzeichen erlaubt sind",
				"Job ungültig", JOptionPane.WARNING_MESSAGE);
	}

	// Meldung, die erscheint, wenn Benutzername nicht mindestens 3 Buchstaben hat
	private void benutzernameFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(), "Benutzername muss mindestens 3 Buchstaben am Anfang haben",
				"Benutzername ungültig", JOptionPane.WARNING_MESSAGE);
	}

	// Meldung, die erscheint, wenn Email keinen gueltigen Muster entspricht
	private void emailFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(), "Die eingegene Email entspricht keiner gültigen Email-Adresse",
				"Email ungültig", JOptionPane.WARNING_MESSAGE);
	}

	// Meldung, die erscheint, wenn ein ungueltiges Datum eingegeben wurde
	private void datumFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(), "Das Datum muss im Format DD.MM.YY vorliegen", "Datum ungültig",
				JOptionPane.WARNING_MESSAGE);
	}

	// Meldung, die erscheint, wenn ein Mitarbeiter erfolgreich angelegt wurde
	private void mitarbeiterErfolgreichUpgedatetMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(),
				"Mitarbeiter mit der ID " + mitarbeiterID + " erfolgreich upgedatet", "Erfolgreich",
				JOptionPane.WARNING_MESSAGE);
	}

	private void benutzernameBereitsVergebenMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(), "Der eingegebene Benutzername wird bereits genutzt",
				"Benutzername vergeben", JOptionPane.WARNING_MESSAGE);
	}
	
	private void dateiNichtgefundenMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(), "Zwischenspeicher Datei nicht gefunden",
				"Datei nicht gefunden", JOptionPane.WARNING_MESSAGE);
	}
	
	private void eingabeAusgabeFehlerMeldung() {
		JOptionPane.showMessageDialog(mhv.getPanel(), "Fehler bei der Eingabe/-Ausgabe",
				"IOExceptiion", JOptionPane.WARNING_MESSAGE);
	}

	public MitarbeiterBearbeitenView getView() {
		return mbv;
	}
}
