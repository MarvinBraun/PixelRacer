
package StreckeBearbeiten;

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
import java.util.Collections;
import java.util.LinkedList;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Datenbankverwaltung.Datenbankschnittstelle;
import Strecke.Strecke;
import Strecke.Streckenverwaltung;
import StreckeHinzuf�gen.StreckeHinzuf�genView;

/**
 * Steuerungklasse, welche die StreckenBearbeitenView verwaltet, sowie den
 * Vorgang des Beabeiten einer Strecke koordiniert.
 * 
 * @author Sean Cartner
 */

public class StreckeBearbeitenStrg implements ActionListener, MouseListener, MouseMotionListener {

	private StreckeBearbeitenView sbv;
	private StreckeHinzuf�genView shv;
	private LinkedList<Strecke> streckenliste;
	private String laengeOk = "true";
	private String fehlermeldung = "Folgende Angaben sind zu lang:";
	private boolean istKeineZahl = false;
	private String name;
	private String typ;
	private int laenge;
	private int schwierigkeit;
	private int punktzahl;
	private char status;
	private File grafik;

	/**
	 * Konstruktor
	 */
	public StreckeBearbeitenStrg() {
		sbv = new StreckeBearbeitenView();
		ladeStrecken();
		sbv.getBtnWeiter().addActionListener(this);
		sbv.getCardPanel().add("Auswahl", sbv.getAuswahlPanel());
		sbv.getAuswahlPanel().addMouseListener(this);
		sbv.getAuswahlPanel().addMouseMotionListener(this);
		shv = new StreckeHinzuf�genView();
		shv.getLblStrecke().setText("Strecke Bearbeiten");
		shv.getBtnAbbrechen().addActionListener(this);
		shv.getBtnAuswhlen().addActionListener(this);
		shv.getBtnAbsenden().addActionListener(this);
		sbv.getCardPanel().add("Formular", shv);

	}

	/**
	 * Methode, die agiert, wenn ein Button gedr�ckt wurde. Bei Druck auf BtnWeiter,
	 * soll sie StreckeHinzuf�genView anzeigen. Bei Druck auf BtnAbbrechen die
	 * StreckeBearbeitenView anzeigen. Bei Druck auf BtnAuswaehlen den FileChooser
	 * aufrufen. Bei Druck auf BtnAbsenden die g�nderten Daten in die Datenbank
	 * schreiben.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sbv.getBtnWeiter()) {
			sbv.getCl().show(sbv.getCardPanel(), "Formular");
			ladeStreckenDaten();
			shv.getTfName().setEditable(false);
		}
		if (e.getSource() == shv.getBtnAbbrechen()) {
			sbv.getCl().show(sbv.getCardPanel(), "Auswahl");
		}
		if (e.getSource() == shv.getBtnAuswhlen()) {
			// FileChooser aufrufen
			shv.getFileChooser().setFileFilter(shv.getFilter());
			int rueckgabeWert = shv.getFileChooser().showOpenDialog(null);
			if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
				shv.getTfGrafik().setText(shv.getFileChooser().getSelectedFile().getAbsolutePath());
			}
		}
		if (e.getSource() == shv.getBtnAbsenden()) {
			if (pruefeFormarAufVollst�ndigkeit() == false) {
				formularUnvollst�ndigMeldung();
			} else {
				istLaengeZuLang();
				istSchwierigkeitZuLang();
				istPunktzahlZuLang();
				if (laengeOk == "false") {
					inhaltZuLangMeldung();
					fehlermeldung = "Folgende Angaben sind zu lang:";
					laengeOk = "true";
				} else {
					deklariereVariablenVTextfeldern();
					if (istKeineZahl == true) {
						istKeineZahlMeldung();
						// reset
						istKeineZahl = false;
					} else {
						if (shv.getTfGrafik().getText().isEmpty()) {
							updateStreckeInDB();
							updateStreckeInListe();
							streckeErfolgreichUpgedatetMeldung();
							sbv.getCl().show(sbv.getCardPanel(), "Auswahl");
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
										updateStreckeInDB();
										updateStreckenGrafik();
										updateStreckeInListe();
										streckeErfolgreichUpgedatetMeldung();
										sbv.getCl().show(sbv.getCardPanel(), "Auswahl");
									}
								}
							}
						}
					}
				}
			}
		}

	}

	/**
	 * Nicht genutzt, aber notwendig aufgrund des MouseListener.
	 */
	public void mouseDragged(MouseEvent arg0) {

	}

	/**
	 * Nicht genutzt, aber notwendig aufgrund des MouseListener.
	 */
	public void mouseMoved(MouseEvent arg0) {

	}

	/**
	 * Nicht genutzt, aber notwendig aufgrund des MouseListener.
	 */
	public void mouseClicked(MouseEvent arg0) {

	}

	/**
	 * Methode, die agiert wenn die Maus das JPanel KartHinzuf�genView �berquert.
	 * Sie soll ein Kart aus einer Datei auslesen und es in die LinkedList
	 * hinzuf�gen.
	 */
	public void mouseEntered(MouseEvent arg0) {
		File f = new File("src/Resources/tempStr.dat");
		if (f.exists()) {
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);

				String zeile;
				String[] split;

				try {
					while ((zeile = br.readLine()) != null) {
						split = zeile.split(";");
						Strecke str = new Strecke();
						str.setStreckenname(split[0]);
						str.setLaenge(Integer.parseInt(split[1]));
						str.setSchwierigkeit(Integer.parseInt(split[2]));
						str.setPremium(split[3]);
						str.setPunktewert(Integer.parseInt(split[4]));
						streckenliste.add(str);
					}

					fr.close();
					br.close();
					Collections.sort(streckenliste, new StreckenKomperator());
				} catch (IOException y) {
					eingabeAusgabeFehlerMeldung();
				}
			} catch (FileNotFoundException x) {
				dateiNichtgefundenMeldung();
			}
			sbv.getComboBoxStrecke().removeAllItems();
			for (Strecke strecke : streckenliste) {
				sbv.getComboBoxStrecke().addItem(strecke.getStreckenname());
			}
			f.delete();
		}
	}

	/**
	 * Nicht genutzt, aber notwendig aufgrund des MouseListener.
	 */
	public void mouseExited(MouseEvent arg0) {

	}

	/**
	 * Nicht genutzt, aber notwendig aufgrund des MouseListener.
	 */
	public void mousePressed(MouseEvent arg0) {

	}

	/**
	 * Nicht genutzt, aber notwendig aufgrund des MouseListener.
	 */
	public void mouseReleased(MouseEvent arg0) {

	}

	/**
	 * Erstellt die streckenliste, f�llt diese und f�llt anschlie�end die ComboBox
	 * mit der streckenliste.
	 */
	private void ladeStrecken() {
		Streckenverwaltung sw = new Streckenverwaltung();
		streckenliste = sw.gibStrecke();
		Collections.sort(streckenliste, new StreckenKomperator());
		for (Strecke strecke : streckenliste) {
			sbv.getComboBoxStrecke().addItem(strecke.getStreckenname());
		}

	}

	/**
	 * L�dt die Daten einer spezifischen Strecke und f�gt diese in die
	 * StreckeHinzuf�genView ein.
	 */
	private void ladeStreckenDaten() {
		String auswahl = (String) sbv.getComboBoxStrecke().getSelectedItem();
		for (Strecke strecke : streckenliste) {
			if (auswahl.equals(strecke.getStreckenname())) {
				shv.getTfName().setText(strecke.getStreckenname());
				shv.getTfLaenge().setText(String.valueOf(strecke.getLaenge()));
				shv.getTfSchwierigkeit().setText(String.valueOf(strecke.getSchwierigkeit()));
				shv.getTfPunktzahl().setText(String.valueOf(strecke.getPunktewert()));
				if (strecke.getPremium().equals("true")) {
					shv.getRbPremium().setSelected(true);
				} else if (strecke.getPremium().equals("false")) {
					shv.getRbFree().setSelected(true);
				}
			}
		}
	}

	/**
	 * Methode, in die Datenbank relevanten Variablen aufgrundlage des Formulars
	 * deklariert werden.
	 */
	private void deklariereVariablenVTextfeldern() {
		try {
			name = shv.getTfName().getText();
			laenge = Integer.parseInt(shv.getTfLaenge().getText());
			schwierigkeit = Integer.parseInt(shv.getTfSchwierigkeit().getText());
			punktzahl = Integer.parseInt(shv.getTfPunktzahl().getText());
			status = shv.getRbFree().isSelected() ? 'f' : (shv.getRbPremium().isSelected() ? 'p' : ' ');
			grafik = new File(shv.getTfGrafik().getText());
		} catch (NumberFormatException e) {
			istKeineZahl = true;
		}
	}

	/**
	 * Methode, welche eine Strecke in der Datenbank erstellt.
	 */
	private void updateStreckeInDB() {
		if (status == 'p') {
			typ = "true";
		} else {
			typ = "false";
		}
		String update = "update Strecke set streckenname = '" + name + "', laenge = " + laenge + ", schwierigkeit = "
				+ schwierigkeit + ", premium = '" + typ + "', punktewert = " + punktzahl + " where streckenname = '"
				+ name + "'";
		Datenbankschnittstelle.executeUpdate(update);
		Datenbankschnittstelle.closeConnections();
	}

	/**
	 * Methode, welche die in der Datenbank erstellte Strecke um eine Grafik
	 * ergaenzt.
	 */
	private void updateStreckenGrafik() {
		String updateBild = "update strecke set grafik =? where streckenname ='" + name + "'";
		Datenbankschnittstelle.uploadBlob(updateBild, grafik);
		Datenbankschnittstelle.closeConnections();
	}

	/**
	 * aktualisiert die Attribute der ge�nderten Strecke in der Liste.
	 */
	private void updateStreckeInListe() {
		for (Strecke str : streckenliste) {
			if (name.equals(str.getStreckenname())) {
				str.setLaenge(laenge);
				str.setSchwierigkeit(schwierigkeit);
				str.setPremium(typ);
				str.setPunktewert(punktzahl);
			}
		}
	}

	/**
	 * Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt
	 * ist.
	 * 
	 * @return Boolean
	 */
	private boolean pruefeFormarAufVollst�ndigkeit() {
		if (shv.getTfLaenge().getText().isEmpty() || shv.getTfSchwierigkeit().getText().isEmpty()
				|| shv.getTfPunktzahl().getText().isEmpty() || shv.getTfPunktzahl().getText().isEmpty()
				|| shv.getBgStatus().getSelection() == null) {
			return false;
		}
		return true;
	}

	/**
	 * Methode, welche die Laenge des L�nge-Feldes kontrollieren soll.
	 */
	private void istLaengeZuLang() {
		if (shv.getTfLaenge().getText().length() > 5) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "L�nge";
		}
	}

	/**
	 * Methode, welche die Laenge des Schwierigkeit-Feldes kontrollieren soll.
	 */
	private void istSchwierigkeitZuLang() {
		if (shv.getTfSchwierigkeit().getText().length() > 1) {
			laengeOk = "false";
			fehlermeldung = fehlermeldung + "  " + "Schwierigkeit";
		}
	}

	/**
	 * Methode, welche die Laenge des Punktzahl-Feldes kontrollieren soll.
	 */
	private void istPunktzahlZuLang() {
		if (shv.getTfPunktzahl().getText().length() > 2) {
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
	 * Meldung die statt einer IOException erscheint.
	 */
	private void eingabeAusgabeFehlerMeldung() {
		JOptionPane.showMessageDialog(shv.getPanel(), "Fehler bei der Eingabe/-Ausgabe", "IOExceptiion",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Datei nicht gefunden werden konnte.
	 */
	private void dateiNichtgefundenMeldung() {
		JOptionPane.showMessageDialog(shv.getPanel(), "Zwischenspeicher Datei nicht gefunden", "Datei nicht gefunden",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist.
	 */
	private void formularUnvollst�ndigMeldung() {
		JOptionPane.showMessageDialog(shv.getPanel(), "Alle Felder m�ssen ausgef�llt sein!", "Formular unvollst�ndig",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu
	 * lang ist.
	 */
	private void inhaltZuLangMeldung() {
		JOptionPane.showMessageDialog(shv.getPanel(), fehlermeldung, "Inhalt zu lang", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ein Zahlen-Feld mit sonstigen Zeichen befuellt
	 * wird.
	 */
	public void istKeineZahlMeldung() {
		JOptionPane.showMessageDialog(shv.getPanel(), "L�nge, Schwierigkeit und Punktzahl m�ssen eine Zahl sein!",
				"Keine Zahl", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Grafik nicht existiert.
	 */
	public void keineDateiGefundenMeldung() {
		JOptionPane.showMessageDialog(shv.getPanel(), "Es wurde keine Datei unter dem angegebenen Pfad gefunden",
				"Keine Datei gefunden", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Grafik nicht im png Formart vorliegt.
	 */
	public void nichtPngMeldung() {
		JOptionPane.showMessageDialog(shv.getPanel(), "Die Grafik muss im Format .png vorliegen",
				"Grafik liegt nicht im PNG Format vor", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Grafik zu Gross (in Speicher) ist.
	 */
	public void grafikZuGrossMeldung() {
		JOptionPane.showMessageDialog(shv.getPanel(), "Die Grafik darf maximal 20kb gro� sein", "Grafik zu Gro�",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Strecke erfolgreich aktualisiert wurde.
	 */
	private void streckeErfolgreichUpgedatetMeldung() {
		JOptionPane.showMessageDialog(shv.getPanel(), "Strecke erfolgreich upgedatet", "Erfolgreich",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Getter f�r die StreckeBearbeitenView.
	 * 
	 * @return StreckeBearbeitenView
	 */
	public StreckeBearbeitenView getView() {
		return sbv;
	}
}
