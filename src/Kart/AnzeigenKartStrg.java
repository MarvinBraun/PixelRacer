
package Kart;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Iterator.IteratorKart;
import Iterator.IteratorString;
import Nutzer.Nutzerverwaltung;
import Premium.kaufePremiumKart;
import Rechnung.Rechnung;
import Rechnung.Rechnungsverwaltung;
import Startansicht.StartansichtStrg;

/**
 * Die Klasse AnzeigenKartStrg steuert die Kartansicht fuer den Nutzer. Die
 * Klasse verwaltet auch die grafischen Oberflaechen Kartuebersicht und
 * KartDetailView.
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

	static IteratorKart<Kart> itKart;
	static IteratorString<String> itString;

	/**
	 * Die Methode AnzeigenKartStrg ist der Konstruktor der Klasse und ruft
	 * diese als neues Objekt auf. Sie deklariert die ihm, aus den Klassen
	 * KartDetailView und Kartuebersicht, uebergebenen Labels und Buttons mit
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
		itKart = new IteratorKart(KartListe.listIterator());

		verwRechnung = new Rechnungsverwaltung();
		rechnungsListe = verwRechnung.gibKartRechnungenfuerBenutzer();

		viewUebersicht.getKartBackward().addActionListener(this);
		viewUebersicht.getKartForward().addActionListener(this);
		viewUebersicht.getBtnDetailView().addActionListener(this);
		viewUebersicht.getBtnZurueck().addActionListener(this);
		viewUebersicht.getBtnKartKaufen().addActionListener(this);

		ladeKart();

		SwingUtilities.updateComponentTreeUI(viewUebersicht.getFrame());

	}

	public static void main(String[] args) {

		AnzeigenKartStrg steuerung = new AnzeigenKartStrg();

	}

	/**
	 * Die Methode ladeKart ruft, wenn vorhanden, das naechste kart auf und
	 * ueberprueft ob dieses schon im Besitz des Nutzers ist oder ob es noch
	 * durch Punkte oder durch einen Kauf freigeschaltet werden muss und
	 * deklariert dementsprechend die Variablen.
	 */
	public void ladeKart() {
		try{
			if ((k = itKart.next()) != null) {

				BufferedImage newImage = k.getGrafik();
				viewUebersicht.getKartName().setText(k.getKartname());
				Kartbild = newImage;
				ImageIcon icon = new ImageIcon(Kartbild);
				viewUebersicht.getKartLbl().setIcon(icon);

				counterRang1 = 0;
				counterRang2 = 0;
				counterRang3 = 0;

				viewDetail = new KartDetailView();
				viewDetail.getBtnZurueck().addActionListener(this);
				viewDetail.getLblSetmaxkmh().setText(Integer.toString(k.getMaxkmh()) + " Km/h");
				viewDetail.getLblSetbesch().setText(Integer.toString(k.getBeschleunigung()));
				Fahrtverwaltung v = new Fahrtverwaltung();
				LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFuerBenutzerUndKart(
						Nutzerverwaltung.getangKunde().getnutzername(), k.getKartname());
				viewDetail.getLblSetGesRennen().setText(Integer.toString(fahrten.size()));

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
				viewDetail.getLblSetAnzErster().setText(Integer.toString(counterRang1));
				viewDetail.getLblSetAnzZweiter().setText(Integer.toString(counterRang2));
				viewDetail.getLblSetAnzDritter().setText(Integer.toString(counterRang3));
			}
			if (k.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte()) {
				viewUebersicht.getLblKartPunkteLimit().setVisible(false);
				viewUebersicht.getLblKartPunkte().setText("Kart in deinem Besitz!");
				viewUebersicht.getLblKartPunkte().setVisible(true);
			} else if (k.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()) {
				viewUebersicht.getLblKartPunkte().setVisible(false);
				viewUebersicht.getLblKartPunkteLimit()
						.setText("Erreiche " + k.getPunktewert() + " Punkte um diese Kart freizuschalten!");
				viewUebersicht.getLblKartPunkteLimit().setVisible(true);
			}

			Rechnungsverwaltung r = new Rechnungsverwaltung();
			LinkedList<Rechnung> rechnungen = r.gibKartRechnungenfuerBenutzer();

			viewUebersicht.getBtnKartKaufen().setVisible(false);

			if (k.getPremium().equals("true")) {
				viewUebersicht.getLblKartPunkteLimit().setVisible(false);
				viewUebersicht.getLblKartPunkte().setVisible(false);
				viewUebersicht.getBtnKartKaufen().setVisible(true);

				Rechnung rechnung = null;
				Iterator<Rechnung> it = rechnungen.iterator();
				while (it.hasNext()) {
					rechnung = it.next();
					if (k.getKartname().equals(rechnung.getKartname())) {

						viewUebersicht.getBtnKartKaufen().setVisible(false);
						viewUebersicht.getLblKartPunkteLimit().setVisible(false);
						viewUebersicht.getLblKartPunkte().setVisible(true);
						viewUebersicht.getLblKartPunkte().setText("Kart in deinem Besitz!");

					}
				}
			}
			Datenbankschnittstelle.closeConnections();
		}catch(NoSuchElementException io){
			JOptionPane.showConfirmDialog(null, "Zurzeit stehen keine weiteren Karts zur Verfuegung!",
					"Keine weiteren Karts", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
		}
	}

	/**
	 * Die Methode KartRueckwaerts Funktioniert wie die Methode ladeKart, gibt
	 * aber das vorherige Kart wieder.
	 */
	public void KartRueckwaerts() {
		try {
			if ((k = itKart.previous()) != null) {

				BufferedImage newImage = k.getGrafik();
				viewUebersicht.getKartName().setText(k.getKartname());
			
				ImageIcon icon = new ImageIcon(newImage);
				viewUebersicht.getKartLbl().setIcon(icon);

				counterRang1 = 0;
				counterRang2 = 0;
				counterRang3 = 0;

				viewDetail = new KartDetailView();
				viewDetail.getBtnZurueck().addActionListener(this);

				viewDetail.getLblSetmaxkmh().setText(Integer.toString(k.getMaxkmh()) + " Km/h");

				viewDetail.getLblSetbesch().setText(Integer.toString(k.getBeschleunigung()));

				Fahrtverwaltung v = new Fahrtverwaltung();
				LinkedList<SingleplayerFahrt> fahrten = v.gibSingleplayerFahrtenFuerBenutzerUndKart(
						Nutzerverwaltung.getangKunde().getnutzername(), k.getKartname());
				viewDetail.getLblSetGesRennen().setText(Integer.toString(fahrten.size()));

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
				viewDetail.getLblSetAnzErster().setText(Integer.toString(counterRang1));
				viewDetail.getLblSetAnzZweiter().setText(Integer.toString(counterRang2));
				viewDetail.getLblSetAnzDritter().setText(Integer.toString(counterRang3));

			}
			if (k.getPunktewert() <= Nutzerverwaltung.getangKunde().getpunkte()) {
				viewUebersicht.getLblKartPunkteLimit().setVisible(false);
				viewUebersicht.getLblKartPunkte().setText("Kart in deinem Besitz!");
				viewUebersicht.getLblKartPunkte().setVisible(true);
			} else if (k.getPunktewert() > Nutzerverwaltung.getangKunde().getpunkte()) {
				viewUebersicht.getLblKartPunkte().setVisible(false);
				viewUebersicht.getLblKartPunkteLimit()
						.setText("Erreiche " + k.getPunktewert() + " Punkte um diese Kart freizuschalten!");
				viewUebersicht.getLblKartPunkteLimit().setVisible(true);
			}

			Rechnungsverwaltung r = new Rechnungsverwaltung();
			LinkedList<Rechnung> rechnungen = r.gibKartRechnungenfuerBenutzer();

			viewUebersicht.getBtnKartKaufen().setVisible(false);

			if (k.getPremium().equals("true")) {
				viewUebersicht.getLblKartPunkteLimit().setVisible(false);
				viewUebersicht.getLblKartPunkte().setVisible(false);
				viewUebersicht.getBtnKartKaufen().setVisible(true);

				Rechnung rechnung = null;
				Iterator<Rechnung> it = rechnungen.iterator();
				while (it.hasNext()) {
					rechnung = it.next();
					if (k.getKartname().equals(rechnung.getKartname())) {

						viewUebersicht.getBtnKartKaufen().setVisible(false);
						viewUebersicht.getLblKartPunkteLimit().setVisible(false);
						viewUebersicht.getLblKartPunkte().setVisible(true);
						viewUebersicht.getLblKartPunkte().setText("Kart in deinem Besitz!");

					}
				}
			}
			Datenbankschnittstelle.closeConnections();

		} catch (NoSuchElementException ns) {
			JOptionPane.showConfirmDialog(null, "Zurzeit stehen keine weiteren Karts zur Verfuegung!",
					"Keine weiteren Karts", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
		}
	}

	public static BufferedImage imageResizer(BufferedImage original) {

		BufferedImage newImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_ARGB);

		Graphics g = newImage.createGraphics();
		g.drawImage(original, 0, 0, 300, 200, null);

		g.dispose();
		return newImage;
	}

	/**
	 * Die Methode actionPerformed ruft je nachdem, welcher Button geklickt
	 * wird, die dafuer vorgesehene Funktion auf.
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == viewUebersicht.getBtnZurueck()) {

				MusicHandler.MusicPlayer.backwardBtn();
				
				viewUebersicht.getFrame().dispose();
				viewDetail.frame.dispose();
				StartansichtStrg strg = new StartansichtStrg();
			}

			if (e.getSource() == viewUebersicht.getBtnKartKaufen()) {
				
				MusicHandler.MusicPlayer.forwardBtn();

				kaufePremiumKart strg = new kaufePremiumKart(k, viewUebersicht);
			}
			if (e.getSource() == viewDetail.getBtnZurueck()) {
				MusicHandler.MusicPlayer.backwardBtn();
				viewDetail.frame.dispose();
				viewUebersicht.getFrame().setVisible(true);
			}

			if (e.getSource() == viewUebersicht.getKartBackward()) {
				MusicHandler.MusicPlayer.backwardBtn();
				viewDetail.frame.dispose();
				KartRueckwaerts();
			}

			if (e.getSource() == viewUebersicht.getKartForward()) {
				MusicHandler.MusicPlayer.forwardBtn();
				viewDetail.frame.dispose();
				ladeKart();
			}

			if (e.getSource() == viewUebersicht.getBtnDetailView()) {
				MusicHandler.MusicPlayer.startGame();
				viewDetail.frame.setVisible(true);
			}

		} catch (NullPointerException o) {
			 ;
		}
	}
}
