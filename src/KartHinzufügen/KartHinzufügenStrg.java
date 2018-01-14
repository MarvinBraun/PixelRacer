package KartHinzufügen;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.activation.MimetypesFileTypeMap;
import Datenbankverwaltung.Datenbankschnittstelle;

import java.awt.event.ActionEvent;

/**
 * Steuerungsklasse, welche die KartHinzufügenView verwaltet, sowie den Vorgang
 * des Hinzufügen eines neuen Karts koodiniert.
 * 
 * @author Sean Cartner
 */
public class KartHinzufügenStrg implements ActionListener {

	// Globale Variablen
	private KartHinzufügenView khView;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
	private boolean istKeineZahl = false;
	private String name;
	private String typ;
	private int beschleunigung;
	private int maxGeschwindigkeit;
	private int punktzahl;
	private char status;
	private File grafik;

	/**
	 * Konstruktor
	 */
	public KartHinzufügenStrg() {
		khView = new KartHinzufügenView();
		khView.getPanel().setVisible(true);
		khView.getBtnAuswaehlen().addActionListener(this);
		khView.getBtnAbsenden().addActionListener(this);
		khView.getBtnAbbrechen().addActionListener(this);
	}

	/**
	 * Methode, die agiert, wenn ein Button gedrückt wurde. Diese soll, wenn: 
	 * - BtnAuswaehlen gedrückt wurde den FileChooser aufrufen. 
	 * - BtnAbsenden gedrückt wurden ein neues Kart in der Datenbank erstellen. 
	 * - BtnAbbrechen gedrückt wurde das Formular leeren.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == khView.getBtnAuswaehlen()) {
			// FileChooser aufrufen
			khView.getFc().setFileFilter(khView.getFilter());
			int rueckgabeWert = khView.getFc().showOpenDialog(null);
			if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
				khView.getTfGrafik().setText(khView.getFc().getSelectedFile().getAbsolutePath());
			}
		}
		if (e.getSource() == khView.getBtnAbsenden()) {
			// Daten pruefen und wenn alles Korrekt ist einen neuen Datensatz anlegen
			if (pruefeFormarAufVollständigkeit() == false) {
				formularUnvollständigMeldung();
			} else {
				istNameZuLang();
				istPunktzahlZuLang();
				if (laengeOk == "false") {
					inhaltZuLangMeldung();
					// reset
					fehlermeldung = "Folgende Angaben sind zu lang:";
					laengeOk = "true";
				} else {
					deklariereVariablenVTextfeldern();
					if (istKeineZahl == true) {
						istKeineZahlMeldung();
						// reset
						istKeineZahl = false;
					} else {
						if (!grafik.exists()) {
							keineDateiGefundenMeldung();
						} else {
							if (IstGrafikPng() == false) {
								nichtPngMeldung();
							} else {
								if (grafik.length() > 20480) {
									grafikZuGrossMeldung();
								} else {
									if (istNameFormatOk() == false) {
										nameFormatNichtOkMeldung();
									} else {
										if (maxGeschwindigkeit > 450) {
											maxGeschwindigkeitZuHochMeldung();
										} else {
											if (beschleunigung > 99) {
												beschleunigungZuHochMeldung();
											} else {
												if (istKartnameVergeben() == true) {
													kartNameBereitsVergebenMeldung();
												} else {
													erstelleKartInDB();
													updateKartGrafik();
													speicherKartZwischen();
													kartErfolgreichAngelegtMeldung();
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
		// Soll Formular bei Abbruch leeren
		if (e.getSource() == khView.getBtnAbbrechen()) {
			leereFormular();
		}
	}

	/**
	 * Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist.
	 */
	private void formularUnvollständigMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Alle Felder müssen ausgefüllt sein!",
				"Formular unvollständig", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu
	 * lang ist.
	 */
	private void inhaltZuLangMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), fehlermeldung, "Inhalt zu lang", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ein Zahlen-Feld mit sonstigen Zeichen befuellt.
	 * wird.
	 */
	public void istKeineZahlMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(),
				"Beschleunigung, MaxGeschwindkeit und Punktzahl müssen eine Zahl sein!", "Keine Zahl",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Grafik nicht existiert.
	 */
	public void keineDateiGefundenMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Es wurde keine Datei unter dem angegebenen Pfad gefunden",
				"Keine Datei gefunden", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Grafik nicht im png Formart vorliegt.
	 */
	public void nichtPngMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Die Grafik muss im Format .png vorliegen",
				"Grafik liegt nicht im PNG Format vor", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Grafik zu Gross (in Speicher) ist.
	 */
	private void grafikZuGrossMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Die Grafik darf maximal 20kb groß sein", "Grafik zu Groß",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ungueltige Zeichen im Vornamen eingegeben wurde.
	 */
	private void nameFormatNichtOkMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(),
				"Beachte die Groß- und Kleinschreibung beim Namen, sowie die nicht erlaubten Sonderzeichen",
				"Name ungültig", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn zu hoher Wert für MaxGeschwindigkeit eingegeben
	 * wurde.
	 */
	private void maxGeschwindigkeitZuHochMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Die maximalGeschwindigkeit darf höchstens 450 betragen",
				"MaximalGeschwindigkeit überschritten", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn zu hoher Wert für Beschleunigung eingegeben
	 * wurde.
	 */
	private void beschleunigungZuHochMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Die Beschleunigung darf höchstens 99 betragen",
				"Beschleunigung zu hoch", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn der Name aufgrund eines Datenbank-Problems nicht
	 * kontrolliert werden konnte.
	 */
	private void konnteKartNamenNichtKontrollierenMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Konnte Kartnamen nicht prüfen", "Datenbankproblem",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn der ausgewählte Name bereits vergeben ist.
	 */
	private void kartNameBereitsVergebenMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Der eingegebene Kartname wird bereits genutzt",
				"Kartname vergeben", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ein Kart zum Zwecke der Zwischenspeicherung
	 * nicht in eine Datei geschrieben werden konnte.
	 */
	private void kartKonnteNichtZwischengespeichertWerdenMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Kart konnte nicht zwischengespeichert werden",
				"Zwischenspeichern nicht möglich", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn das Kart erfolgreich angelegt wurde.
	 */
	private void kartErfolgreichAngelegtMeldung() {
		JOptionPane.showMessageDialog(khView.getPanel(), "Kart erfolgreich angelegt", "Erfolgreich",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt
	 * ist.
	 * 
	 * @return Boolean
	 */
	private boolean pruefeFormarAufVollständigkeit() {
		if (khView.getTfName().getText().isEmpty() || khView.getTfBeschleunigung().getText().isEmpty()
				|| khView.getTfGeschwindigkeit().getText().isEmpty() || khView.getTfPunktzahl().getText().isEmpty()
				|| khView.getTfGrafik().getText().isEmpty() || khView.getBgStatus().getSelection() == null) {
			return false;
		}
		return true;
	}

	/**
	 * Methode, welche die Laenge des Namen-Feldes kontrollieren soll.
	 */
	private void istNameZuLang() {
		if (khView.getTfName().getText().length() > 20) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Name";
		}
	}

	/**
	 * Methode, welche die Laenge des Punktzahl-Feldes kontrollieren soll.
	 */
	private void istPunktzahlZuLang() {
		if (khView.getTfPunktzahl().getText().length() > 2) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Punktzahl";
		}
	}

	/**
	 * Methode, die kontrolliert, ob die Grafik im png Format vorliegt.
	 * 
	 * @return Boolean
	 */
	private boolean IstGrafikPng() {
		MimetypesFileTypeMap mtftp = new MimetypesFileTypeMap();
		mtftp.addMimeTypes("image png");
		String mimetype = mtftp.getContentType(grafik);
		String fileType = mimetype.split("/")[0];
		return fileType.equalsIgnoreCase(mimetype);
	}

	/**
	 * Methode, die kontrolliert, ob der Name im richtigen Format eingegeben wurde.
	 * 
	 * @return Boolean
	 */
	private boolean istNameFormatOk() {
		Pattern patt = Pattern.compile("[A-ZÄÖÜ][a-zäöüß]+[0-9]{0,4}?([ -]?[A-ZÄÖÜ][a-zäöüß]+)?[0-9]{0,4}");
		Matcher match = patt.matcher(khView.getTfName().getText());
		return match.matches();
	}

	/**
	 * Methode, die kontrolliert, ob der ausgewählte Kartname bereits vergebn ist.
	 * 
	 * @return Boolean
	 */
	private boolean istKartnameVergeben() {
		ResultSet rs = Datenbankschnittstelle.executeQuery("select kartname from kart where kartname = '" + name + "'");
		String check = null;
		try {
			while (rs.next()) {
				check = rs.getString(1);
			}
			rs.close();

		} catch (SQLException e) {
			konnteKartNamenNichtKontrollierenMeldung();
		}
		Datenbankschnittstelle.closeConnections();
		if (check != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Methode, in der die Datenbank relevanten Variablen aufgrundlage des Formulars
	 * deklariert werden.
	 */
	private void deklariereVariablenVTextfeldern() {
		try {
			name = khView.getTfName().getText();
			beschleunigung = Integer.parseInt(khView.getTfBeschleunigung().getText());
			maxGeschwindigkeit = Integer.parseInt(khView.getTfGeschwindigkeit().getText());
			punktzahl = Integer.parseInt(khView.getTfPunktzahl().getText());
			status = khView.getRbFree().isSelected() ? 'f' : (khView.getRbPremium().isSelected() ? 'p' : ' ');
			grafik = new File(khView.getTfGrafik().getText());
		} catch (NumberFormatException e) {
			istKeineZahl = true;
		}
	}

	/**
	 * Methode, welche ein Kart in der Datenbank erstellt.
	 */
	private void erstelleKartInDB() {
		if (status == 'p') {
			typ = "true";
		} else {
			typ = "false";
		}
		String abfrage = "insert into kart values('" + name + "','" + beschleunigung + "'," + "'" + maxGeschwindigkeit
				+ "','" + typ + "'," + punktzahl + ",null)";
		Datenbankschnittstelle.executeQuery(abfrage);
		Datenbankschnittstelle.closeConnections();
	}

	/**
	 * Methode, welche das in der Datenbank erstellte Kart um eine Grafik ergaenzt.
	 */
	private void updateKartGrafik() {
		String updateBild = "update kart set grafik =? where kartname ='" + name + "'";
		Datenbankschnittstelle.uploadBlob(updateBild, grafik);
		Datenbankschnittstelle.closeConnections();
	}

	/**
	 * Methode, die das erstellte Kart zum Zwecke des Zwischenspeichern in eine
	 * Datei schreibt.
	 */
	private void speicherKartZwischen() {
		File f = new File("src/Resources/tempKa.dat");
		if (status == 'p') {
			typ = "true";
		} else {
			typ = "false";
		}
		String zeile = name + ";" + beschleunigung + ";" + maxGeschwindigkeit + ";" + typ + ";" + punktzahl;
		try {
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(zeile);
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			kartKonnteNichtZwischengespeichertWerdenMeldung();
		}
	}

	/**
	 * Methode, die das Formular leeren soll.
	 */
	private void leereFormular() {
		khView.getTfName().setText("");
		khView.getTfBeschleunigung().setText("");
		khView.getTfGeschwindigkeit().setText("");
		khView.getTfPunktzahl().setText("");
		khView.getTfGrafik().setText("");
		khView.getBgStatus().clearSelection();
	}

	/**
	 * Getter für die View
	 * 
	 * @return KartHinzufügenView
	 */
	public KartHinzufügenView getView() {
		return khView;
	}
}
