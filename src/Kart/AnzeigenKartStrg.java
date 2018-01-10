package Kart;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.Fahrt;
import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Nutzer.Kunde;
import Nutzer.Nutzerverwaltung;
import Premium.PremiumKartView;
import Premium.kaufePremiumKart;
import Rechnung.Rechnung;
import Rechnung.Rechnungsverwaltung;
import Startansicht.StartansichtStrg;
import myIterator.MyIteratorKart;
import myIterator.MyIteratorString;
/**
 * Die Klasse AnzeigenKartStrg ruft  die grafischen Oberflächen Kartuebersicht und KartDetailView auf und verwaltet diese.
 * @author Ferhat Koca
 *
 */
public class AnzeigenKartStrg implements ActionListener {

	KartDetailView viewDetail;
	Kartuebersicht viewUebersicht;
	AnzeigenKartStrg strg;

	SingleplayerFahrt sf;
	Rechnung r;
	Kart k;
	ResultSet rs;
	BufferedImage Kartbild;

	Rechnungsverwaltung verwRechnung;
	Kartverwaltung verwKart;
	Fahrtverwaltung verwFahrt;

	LinkedList<SingleplayerFahrt> singleplayerFahrten = new LinkedList<SingleplayerFahrt>();
	LinkedList<Kart> KartListe = new LinkedList<Kart>();
	LinkedList<Rechnung> rechnungsListe = new LinkedList<Rechnung>();

	int counterRang1 = 0;
	int counterRang2 = 0;
	int counterRang3 = 0;

	static MyIteratorKart<Kart> itKart;
	static MyIteratorString<String> itString;
	
	public AnzeigenKartStrg() {

		viewUebersicht = new Kartuebersicht();
		viewUebersicht.getFrame().setLocationRelativeTo(null);

		verwFahrt = new Fahrtverwaltung();
		singleplayerFahrten = verwFahrt.gibSingleplayerFahrten();

		verwKart = new Kartverwaltung();
		KartListe = verwKart.gibKart();
		itKart = new MyIteratorKart(KartListe.listIterator());

		verwRechnung = new Rechnungsverwaltung();
		rechnungsListe = verwRechnung.gibKartRechnungenfuerBenutzer();

		viewUebersicht.kartBackward.addActionListener(this);
		viewUebersicht.kartForward.addActionListener(this);
		viewUebersicht.btnDetailView.addActionListener(this);
		viewUebersicht.btnZurueck.addActionListener(this);
		viewUebersicht.btnKartKaufen.addActionListener(this);
		
		ladeKart();

		SwingUtilities.updateComponentTreeUI(viewUebersicht.frame);

	}

	public static void main(String[] args) {

		AnzeigenKartStrg steuerung = new AnzeigenKartStrg();

	}

	public void ladeKart() {
		try {
			if ((k = itKart.next()) != null) {

				BufferedImage newImage = k.getGrafik();
				viewUebersicht.kartName.setText(k.getKartname());
				Kartbild = imageResizer(newImage);
				ImageIcon icon = new ImageIcon(Kartbild);
				viewUebersicht.kartLbl.setIcon(icon);

				// KartDetailView initiieren
				counterRang1 = 0;
				counterRang2 = 0;
				counterRang3 = 0;

				viewDetail = new KartDetailView();
				viewDetail.btnZurueck.addActionListener(this);

				// Länge setzten
				viewDetail.lblSetmaxkmh.setText(Integer.toString(k.getMaxkmh()) + " Km/h");

				viewDetail.lblSetbesch.setText(Integer.toString(k.getBeschleunigung()));

				// Label umschreiben auf ges. Sf-Kart & auf angmeldeter Benutzer

				Fahrtverwaltung v = new Fahrtverwaltung();
				LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFürBenutzerUndKart(
						Nutzerverwaltung.getangKunde().getnutzername(), k.getKartname());
				viewDetail.lblSetGesRennen.setText(Integer.toString(fahrten.size()));

				// Anzahl Erster
				for (int i = 0; i < fahrten.size(); i++) {

					sf = fahrten.get(i);

					if (sf.getRang() == 1) {
						counterRang1++;
					}
					if (sf.getRang() == 2) {
						counterRang2++;
					}
					if (sf.getRang() == 3) {
						counterRang3++;
					}
				}
				viewDetail.lblSetAnzErster.setText(Integer.toString(counterRang1));
				viewDetail.lblSetAnzZweiter.setText(Integer.toString(counterRang2));
				viewDetail.lblSetAnzDritter.setText(Integer.toString(counterRang3));
			}
			if (k.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte()) { // PrÃ¼fung Punktestand Spieler
																					// grÃ¶ÃŸer gleich Punktelimit Kart
				viewUebersicht.getlblKartPunkteLimit().setVisible(false);
				viewUebersicht.getlblKartPunkte().setText("Kart in deinem Besitz!");
				viewUebersicht.getlblKartPunkte().setVisible(true);
			} else if (k.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()) { // PrÃ¼fung Punktestand Spieler
																							// kleiner Punktelimit Kart
				viewUebersicht.getlblKartPunkte().setVisible(false);
				viewUebersicht.getlblKartPunkteLimit()
						.setText("Erreiche " + k.getPunktewert() + " Punkte um diese Kart freizuschalten!");
				viewUebersicht.getlblKartPunkteLimit().setVisible(true);
			}
			// Prüfung Kart bereits vom Nutzer gekauft? Falls nicht Kauf-Button
			// einblenden

			Rechnungsverwaltung r = new Rechnungsverwaltung();
			LinkedList<Rechnung> rechnungen = r.gibKartRechnungenfuerBenutzer();

			viewUebersicht.getBtnkartKaufen().setVisible(false);

			if (k.getPremium().equals("true")) {
				viewUebersicht.getlblKartPunkteLimit().setVisible(false);
				viewUebersicht.getlblKartPunkte().setVisible(false);
				viewUebersicht.getBtnkartKaufen().setVisible(true);

				Rechnung rechnung = null;
				Iterator<Rechnung> it = rechnungen.iterator();
				while (it.hasNext()) {
					rechnung = it.next();
					if (k.getKartname().equals(rechnung.getKartname())) {

						viewUebersicht.getBtnkartKaufen().setVisible(false);
						viewUebersicht.getlblKartPunkteLimit().setVisible(false);
						viewUebersicht.getlblKartPunkte().setVisible(true);
						viewUebersicht.getlblKartPunkte().setText("Kart in deinem Besitz!");

					}
				}
			}
			Datenbankschnittstelle.closeConnections();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Zurzeit stehen keine weiteren Karts zur Verfügung!",
					"Keine weiteren Karts", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

		}
	}

	public void KartRückwärts() {
		try {
			if ((k = itKart.previous()) != null) {

				BufferedImage newImage = k.getGrafik();
				viewUebersicht.kartName.setText(k.getKartname());
				Kartbild = imageResizer(newImage);
				ImageIcon icon = new ImageIcon(Kartbild);
				viewUebersicht.kartLbl.setIcon(icon);

				// KartDetailView initiieren
				counterRang1 = 0;
				counterRang2 = 0;
				counterRang3 = 0;

				viewDetail = new KartDetailView();
				viewDetail.btnZurueck.addActionListener(this);

				// Länge setzten
				viewDetail.lblSetmaxkmh.setText(Integer.toString(k.getMaxkmh()) + " Km/h");

				viewDetail.lblSetbesch.setText(Integer.toString(k.getBeschleunigung()));

				// Label umschreiben auf ges. Sf-Kart & auf angmeldeter Benutzer
				Fahrtverwaltung v = new Fahrtverwaltung();
				LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFürBenutzerUndKart(
						Nutzerverwaltung.getangKunde().getnutzername(), k.getKartname());
				viewDetail.lblSetGesRennen.setText(Integer.toString(fahrten.size()));

				// Anzahl Erster
				for (int i = 0; i < fahrten.size(); i++) {

					sf = fahrten.get(i);

					if (sf.getRang() == 1) {
						counterRang1++;
					}
					if (sf.getRang() == 2) {
						counterRang2++;
					}
					if (sf.getRang() == 3) {
						counterRang3++;
					}
				}
				viewDetail.lblSetAnzErster.setText(Integer.toString(counterRang1));
				viewDetail.lblSetAnzZweiter.setText(Integer.toString(counterRang2));
				viewDetail.lblSetAnzDritter.setText(Integer.toString(counterRang3));

			}
			if (k.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte()) { // PrÃ¼fung Punktestand Spieler
																					// grÃ¶ÃŸer gleich Punktelimit Kart
				viewUebersicht.getlblKartPunkteLimit().setVisible(false);
				viewUebersicht.getlblKartPunkte().setText("Kart in deinem Besitz!");
				viewUebersicht.getlblKartPunkte().setVisible(true);
			} else if (k.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()) { // PrÃ¼fung Punktestand Spieler
																							// kleiner Punktelimit Kart
				viewUebersicht.getlblKartPunkte().setVisible(false);
				viewUebersicht.getlblKartPunkteLimit()
						.setText("Erreiche " + k.getPunktewert() + " Punkte um diese Kart freizuschalten!");
				viewUebersicht.getlblKartPunkteLimit().setVisible(true);
			}
			// Prüfung Kart bereits vom Nutzer gekauft? Falls nicht Kauf-Button
			// einblenden

			Rechnungsverwaltung r = new Rechnungsverwaltung();
			LinkedList<Rechnung> rechnungen = r.gibKartRechnungenfuerBenutzer();

			viewUebersicht.getBtnkartKaufen().setVisible(false);

			if (k.getPremium().equals("true")) {
				viewUebersicht.getlblKartPunkteLimit().setVisible(false);
				viewUebersicht.getlblKartPunkte().setVisible(false);
				viewUebersicht.getBtnkartKaufen().setVisible(true);

				Rechnung rechnung = null;
				Iterator<Rechnung> it = rechnungen.iterator();
				while (it.hasNext()) {
					rechnung = it.next();
					if (k.getKartname().equals(rechnung.getKartname())) {

						viewUebersicht.getBtnkartKaufen().setVisible(false);
						viewUebersicht.getlblKartPunkteLimit().setVisible(false);
						viewUebersicht.getlblKartPunkte().setVisible(true);
						viewUebersicht.getlblKartPunkte().setText("Kart in deinem Besitz!");

					}
				}
			}
			Datenbankschnittstelle.closeConnections();

		} catch (NoSuchElementException ns) {
			JOptionPane.showConfirmDialog(null, "Zurzeit stehen keine weiteren Karts zur Verfügung!",
					"Keine weiteren Karts", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
		}
	}

	public static BufferedImage imageResizer(BufferedImage original) {

		BufferedImage newImage = new BufferedImage(545, 122, BufferedImage.TYPE_INT_RGB);

		Graphics g = newImage.createGraphics();
		g.drawImage(original, 130, 0, 300, 150, null);
		g.dispose();
		return newImage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == viewUebersicht.getBtnZurueck()) {

				viewUebersicht.frame.dispose();
				viewDetail.frame.dispose();
				StartansichtStrg strg = new StartansichtStrg();
			}

			if (e.getSource() == viewUebersicht.getBtnkartKaufen()) {

				kaufePremiumKart strg = new kaufePremiumKart(k, viewUebersicht);
			}
			if (e.getSource() == viewDetail.btnZurueck) {
				viewDetail.frame.dispose();
				viewUebersicht.frame.setVisible(true);
			}

			if (e.getSource() == viewUebersicht.kartBackward) {
				viewDetail.frame.dispose();
				KartRückwärts();
			}

			if (e.getSource() == viewUebersicht.kartForward) {
				viewDetail.frame.dispose();
				ladeKart();
			}
			//bsp

			if (e.getSource() == viewUebersicht.btnDetailView) {
				viewDetail.frame.setVisible(true);
			}

		} catch (NullPointerException o) {
			System.out.println(o.getMessage());
		}
	}
}
