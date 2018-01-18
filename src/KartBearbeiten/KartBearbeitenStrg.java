/**
 
 */
package KartBearbeiten;

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
import Kart.Kart;
import Kart.Kartverwaltung;
import KartHinzufügen.KartHinzufügenView;

/**
 * Steuerungklasse, welche die KartBearbeitenView verwaltet, sowie den Vorgang
 * des Beabeiten eines Karts koordiniert.
 * 
 * @author Sean Cartner
 */

public class KartBearbeitenStrg implements ActionListener, MouseListener, MouseMotionListener {

	private KartBearbeitenView kbv;
	private KartHinzufügenView khv;
	private LinkedList<Kart> kartliste;
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
	public KartBearbeitenStrg() {
		kbv = new KartBearbeitenView();
		ladeKarts();
		kbv.getBtnWeiter().addActionListener(this);
		kbv.getCardPanel().add("Auswahl", kbv.getAuswahlPanel());
		kbv.getAuswahlPanel().addMouseListener(this);
		kbv.getAuswahlPanel().addMouseMotionListener(this);
		khv = new KartHinzufügenView();
		khv.getLblKartHinzufgen().setText("Kart Bearbeiten");
		khv.getBtnAbbrechen().addActionListener(this);
		khv.getBtnAuswaehlen().addActionListener(this);
		khv.getBtnAbsenden().addActionListener(this);
		kbv.getCardPanel().add("Formular", khv);
	}

	/**
	 * Methode, die agiert, wenn ein Button gedrückt wurde. Bei Druck auf BtnWeiter,
	 * soll sie KartHinzufügenView anzeigen. Bei Druck auf BtnAbbrechen die
	 * KartBearbeitenView anzeigen. Bei Druck auf BtnAuswaehlen den FileChooser
	 * aufrufen. Bei Druck auf BtnAbsenden die gänderten Daten in die Datenbank
	 * schreiben.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == kbv.getBtnWeiter()) {
			kbv.getCl().show(kbv.getCardPanel(), "Formular");
			ladeKartDaten();
			khv.getTfName().setEditable(false);
		}
		if (e.getSource() == khv.getBtnAbbrechen()) {
			kbv.getCl().show(kbv.getCardPanel(), "Auswahl");
		}
		if (e.getSource() == khv.getBtnAuswaehlen()) {
			// FileChooser aufrufen
			khv.getFc().setFileFilter(khv.getFilter());
			int rueckgabeWert = khv.getFc().showOpenDialog(null);
			if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
				khv.getTfGrafik().setText(khv.getFc().getSelectedFile().getAbsolutePath());
			}
		}
		if (e.getSource() == khv.getBtnAbsenden()) {
			if (pruefeFormarAufVollständigkeit() == false) {
				formularUnvollständigMeldung();
			} else {
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
						if (maxGeschwindigkeit > 450) {
							maxGeschwindigkeitZuHochMeldung();
						} else {
							if (beschleunigung > 99) {
								beschleunigungZuHochMeldung();
							} else {
								if (khv.getTfGrafik().getText().isEmpty()) {
									updateKartInDB();
									updateKartInListe();
									kartErfolgreichUpgedatetMeldung();
									kbv.getCl().show(kbv.getCardPanel(), "Auswahl");
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
												updateKartInDB();
												updateKartGrafik();
												updateKartInListe();
												kartErfolgreichUpgedatetMeldung();
												kbv.getCl().show(kbv.getCardPanel(), "Auswahl");
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
	 * Methode, die agiert wenn die Maus das JPanel KartHinzufügenView überquert.
	 * Sie soll ein Kart aus einer Datei auslesen und es in die LinkedList
	 * hinzufügen.
	 */
	public void mouseEntered(MouseEvent arg0) {
		File f = new File(System.getProperty("java.io.tmpdir"));
		File[] files = f.listFiles();
		for (File file: files) {
			if(file.getName().contains("tempKa")) {
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					String zeile;
					String[] split;
					try {
						while ((zeile = br.readLine()) != null) {
							split = zeile.split(";");
							Kart ka = new Kart();
							ka.setKartname(split[0]);
							ka.setBeschleunigung(Integer.parseInt(split[1]));
							ka.setMaxkmh(Integer.parseInt(split[2]));
							ka.setPremium(split[3]);
							ka.setPunktewert(Integer.parseInt(split[4]));
							kartliste.add(ka);
						}
						fr.close();
						br.close();
						Collections.sort(kartliste, new KartKomperator());
					} catch (IOException y) {
						eingabeAusgabeFehlerMeldung();
					}
				} catch (FileNotFoundException x) {
					dateiNichtgefundenMeldung();
				}
				kbv.getComboBoxKart().removeAllItems();
				for (Kart kart : kartliste) {
					kbv.getComboBoxKart().addItem(kart.getKartname());
				}

				file.delete();
			}
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
	 * Erstellt die kartliste, füllt diese und füllt anschließend die ComboBox mit
	 * der kartliste.
	 */
	private void ladeKarts() {
		Kartverwaltung kw = new Kartverwaltung();
		kartliste = kw.gibKart();
		Collections.sort(kartliste, new KartKomperator());
		for (Kart kart : kartliste) {
			kbv.getComboBoxKart().addItem(kart.getKartname());
		}

	}

	/**
	 * Lädt die Daten eines spezifischen Karts und fügt diese in die
	 * KartHinzufügenView ein.
	 */
	private void ladeKartDaten() {
		String auswahl = (String) kbv.getComboBoxKart().getSelectedItem();
		for (Kart kart : kartliste) {
			if (auswahl.equals(kart.getKartname())) {
				khv.getTfName().setText(kart.getKartname());
				khv.getTfBeschleunigung().setText(String.valueOf(kart.getBeschleunigung()));
				khv.getTfGeschwindigkeit().setText(String.valueOf(kart.getMaxkmh()));
				khv.getTfPunktzahl().setText(String.valueOf(kart.getPunktewert()));
				if (kart.getPremium().equals("true")) {
					khv.getRbPremium().setSelected(true);
				} else if (kart.getPremium().equals("false")) {
					khv.getRbFree().setSelected(true);
				}
			}
		}
	}

	/**
	 * Methode, in der die Datenbank relevanten Variablen aufgrundlage des Formulars
	 * deklariert werden.
	 */
	private void deklariereVariablenVTextfeldern() {
		try {
			name = khv.getTfName().getText();
			beschleunigung = Integer.parseInt(khv.getTfBeschleunigung().getText());
			maxGeschwindigkeit = Integer.parseInt(khv.getTfGeschwindigkeit().getText());
			punktzahl = Integer.parseInt(khv.getTfPunktzahl().getText());
			status = khv.getRbFree().isSelected() ? 'f' : (khv.getRbPremium().isSelected() ? 'p' : ' ');
			grafik = new File(khv.getTfGrafik().getText());
		} catch (NumberFormatException e) {
			istKeineZahl = true;
		}
	}

	/**
	 * Methode, welche ein Kart in der Datenbank erstellt.
	 */
	private void updateKartInDB() {
		if (status == 'p') {
			typ = "true";
		} else {
			typ = "false";
		}
		String update = "Update kart set kartname = '" + name + "',beschleunigung = '" + beschleunigung + "',maxkmh = "
				+ maxGeschwindigkeit + ",premium = '" + typ + "',punktewert = " + punktzahl + " where kartname = '"
				+ name + "'";
		Datenbankschnittstelle.executeUpdate(update);
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
	 * aktualisiert die Attribute des geänderten Karts in der Liste.
	 */
	private void updateKartInListe() {
		for (Kart ka : kartliste) {
			if (name.equals(ka.getKartname())) {
				ka.setBeschleunigung(beschleunigung);
				ka.setMaxkmh(maxGeschwindigkeit);
				ka.setPremium(typ);
				ka.setPunktewert(punktzahl);
			}
		}
	}

	/**
	 * Methode, welche pruefen soll, ob das Formular auch vollstaendig ausgefuellt
	 * ist.
	 * 
	 * @return Boolean
	 */
	private boolean pruefeFormarAufVollständigkeit() {
		if (khv.getTfBeschleunigung().getText().isEmpty() || khv.getTfGeschwindigkeit().getText().isEmpty()
				|| khv.getTfPunktzahl().getText().isEmpty() || khv.getBgStatus().getSelection() == null) {
			return false;
		}
		return true;
	}

	/**
	 * Methode, welche die Laenge des Punktzahl-Feldes kontrollieren soll.
	 */
	private void istPunktzahlZuLang() {
		if (khv.getTfPunktzahl().getText().length() > 2) {
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
		JOptionPane.showMessageDialog(khv.getPanel(), "Fehler bei der Eingabe/-Ausgabe", "IOExceptiion",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Datei nicht gefunden werden konnte.
	 */
	private void dateiNichtgefundenMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(), "Zwischenspeicher Datei nicht gefunden", "Datei nicht gefunden",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Formular nicht vollstaendig ausgefuellt ist.
	 */
	private void formularUnvollständigMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(), "Alle Felder müssen ausgefüllt sein!", "Formular unvollständig",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn die Eingabe zu einem oder mehreren Feldern zu
	 * lang ist.
	 */
	private void inhaltZuLangMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(), fehlermeldung, "Inhalt zu lang", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn ein Zahlen-Feld mit sonstigen Zeichen befuellt
	 * wird.
	 */
	public void istKeineZahlMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(),
				"Beschleunigung, MaxGeschwindkeit und Punktzahl müssen eine Zahl sein!", "Keine Zahl",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Grafik nicht existiert.
	 */
	public void keineDateiGefundenMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(), "Es wurde keine Datei unter dem angegebenen Pfad gefunden",
				"Keine Datei gefunden", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Grafik nicht im png Formart vorliegt.
	 */
	public void nichtPngMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(), "Die Grafik muss im Format .png vorliegen",
				"Grafik liegt nicht im PNG Format vor", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn Grafik zu Gross (in Speicher) ist.
	 */
	private void grafikZuGrossMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(), "Die Grafik darf maximal 20kb groß sein", "Grafik zu Groß",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn zu hoher Wert für MaxGeschwindigkeit eingegeben
	 * wurde.
	 */
	private void maxGeschwindigkeitZuHochMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(), "Die maximalGeschwindigkeit darf höchstens 450 betragen",
				"MaximalGeschwindigkeit überschritten", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn zu hoher Wert für Beschleunigung eingegeben
	 * wurde.
	 */
	private void beschleunigungZuHochMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(), "Die Beschleunigung darf höchstens 99 betragen",
				"Beschleunigung zu hoch", JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Meldung, die erscheint, wenn das Kart erfolgreich aktualisiert wurde.
	 */
	private void kartErfolgreichUpgedatetMeldung() {
		JOptionPane.showMessageDialog(khv.getPanel(), "Kart erfolgreich upgedatet", "Erfolgreich",
				JOptionPane.WARNING_MESSAGE);
	}

	/**
	 * Getter für die KartBearbeitenView
	 * 
	 * @return KartBearbeitenView
	 */
	public KartBearbeitenView getView() {
		return kbv;
	}

}
