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
 * Die Klasse AnzeigenKartStrg steuert die kartansicht f�r den Nutzer. Die Klasse
 * verwaltet auch die grafischen Oberfl�chen Kartuebersicht und KartDetailView.
 * 
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

	/**
	 * Die Methode AnzeigenKartStrg ist der Konstruktor der Klasse und ruft
	 * diese als neues Objekt auf. Sie deklariert die ihm, aus den Klassen
	 * KartDetailView und Kartuebersicht, �bergebenen Labels und Buttons mit
	 * Variablen.
	 * 
	 */
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

	/**
	 * Die Methode ladeKart ruft, wenn vorhanden, das n�chste kart auf und
	 * �berpr�ft ob dieses schon im Besitz des Nutzers ist oder ob es noch durch
	 * Punkte oder durch einen Kauf freigeschaltet werden muss und deklariert
	 * dementsprechend die Variablen.
	 */
	public void ladeKart() {
		try {
			if ((k = itKart.next()) != null) {

				BufferedImage newImage = k.getGrafik();
				viewUebersicht.kartName.setText(k.getKartname());
				Kartbild = imageResizer(newImage);
				ImageIcon icon = new ImageIcon(Kartbild);
				viewUebersicht.kartLbl.setIcon(icon);

				counterRang1 = 0;
				counterRang2 = 0;
				counterRang3 = 0;

				viewDetail = new KartDetailView();
				viewDetail.btnZurueck.addActionListener(this);

				viewDetail.lblSetmaxkmh.setText(Integer.toString(k.getMaxkmh()) + " Km/h");

				viewDetail.lblSetbesch.setText(Integer.toString(k.getBeschleunigung()));

				Fahrtverwaltung v = new Fahrtverwaltung();
				LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenF�rBenutzerUndKart(
						Nutzerverwaltung.getangKunde().getnutzername(), k.getKartname());
				viewDetail.lblSetGesRennen.setText(Integer.toString(fahrten.size()));

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
			if (k.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte()) {
				viewUebersicht.getlblKartPunkteLimit().setVisible(false);
				viewUebersicht.getlblKartPunkte().setText("Kart in deinem Besitz!");
				viewUebersicht.getlblKartPunkte().setVisible(true);
			} else if (k.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()) { 
				viewUebersicht.getlblKartPunkte().setVisible(false);
				viewUebersicht.getlblKartPunkteLimit()
						.setText("Erreiche " + k.getPunktewert() + " Punkte um diese Kart freizuschalten!");
				viewUebersicht.getlblKartPunkteLimit().setVisible(true);
			}
			
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
			JOptionPane.showConfirmDialog(null, "Zurzeit stehen keine weiteren Karts zur Verf�gung!",
					"Keine weiteren Karts", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

		}
	}

	/**
	 * Die Methode KartR�ckw�rts Funktioniert wie die Methode ladeKart, gibt
	 * aber das vorherige Kart wieder.
	 */
	public void KartR�ckw�rts() {
		try {
			if ((k = itKart.previous()) != null) {

				BufferedImage newImage = k.getGrafik();
				viewUebersicht.kartName.setText(k.getKartname());
				Kartbild = imageResizer(newImage);
				ImageIcon icon = new ImageIcon(Kartbild);
				viewUebersicht.kartLbl.setIcon(icon);

				counterRang1 = 0;
				counterRang2 = 0;
				counterRang3 = 0;

				viewDetail = new KartDetailView();
				viewDetail.btnZurueck.addActionListener(this);

				viewDetail.lblSetmaxkmh.setText(Integer.toString(k.getMaxkmh()) + " Km/h");

				viewDetail.lblSetbesch.setText(Integer.toString(k.getBeschleunigung()));

				Fahrtverwaltung v = new Fahrtverwaltung();
				LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenF�rBenutzerUndKart(
						Nutzerverwaltung.getangKunde().getnutzername(), k.getKartname());
				viewDetail.lblSetGesRennen.setText(Integer.toString(fahrten.size()));

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
			if (k.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte()) { // Prüfung
																					// Punktestand
																					// Spieler
																					// größer
																					// gleich
																					// Punktelimit
																					// Kart
				viewUebersicht.getlblKartPunkteLimit().setVisible(false);
				viewUebersicht.getlblKartPunkte().setText("Kart in deinem Besitz!");
				viewUebersicht.getlblKartPunkte().setVisible(true);
			} else if (k.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()) { // Prüfung
																							// Punktestand
																							// Spieler
																							// kleiner
																							// Punktelimit
																							// Kart
				viewUebersicht.getlblKartPunkte().setVisible(false);
				viewUebersicht.getlblKartPunkteLimit()
						.setText("Erreiche " + k.getPunktewert() + " Punkte um diese Kart freizuschalten!");
				viewUebersicht.getlblKartPunkteLimit().setVisible(true);
			}

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
			JOptionPane.showConfirmDialog(null, "Zurzeit stehen keine weiteren Karts zur Verf�gung!",
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

	/**
	 * Die Methode actionPerformed ruft je nachdem, welcher Button geklickt
	 * wird, die daf�r vorgesehene Funktion auf.
	 */
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
				KartR�ckw�rts();
			}

			if (e.getSource() == viewUebersicht.kartForward) {
				viewDetail.frame.dispose();
				ladeKart();
			}

			if (e.getSource() == viewUebersicht.btnDetailView) {
				viewDetail.frame.setVisible(true);
			}

		} catch (NullPointerException o) {
			System.out.println(o.getMessage());
		}
	}
}
