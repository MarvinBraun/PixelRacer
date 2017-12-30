package Kart;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import Datenbankverwaltung.Datenbankschnittstelle;
import Fahrt.Fahrt;
import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;
import Nutzer.Nutzerverwaltung;
import myIterator.MyIteratorKart;
import myIterator.MyIteratorStrecke;
import myIterator.MyIteratorString;

public class AnzeigenKartStrg implements ActionListener {

	KartDetailView viewDetail;
	Kartuebersicht ku;

	SingleplayerFahrt sf;

	Kartverwaltung kv;
	Fahrtverwaltung fv;

	LinkedList<SingleplayerFahrt> singleplayerFahrten = new LinkedList<SingleplayerFahrt>();
	LinkedList<Kart> Kartliste = new LinkedList<Kart>();

	int counterRang1 = 0;
	int counterRang2 = 0;
	int counterRang3 = 0;

	Kart k;
	ResultSet rs;

	static MyIteratorKart<Kart> itKart;
	static MyIteratorString<String> itString;

	BufferedImage kartbild;

	boolean forward = false;
	boolean backward = false;

	public AnzeigenKartStrg() {

		ku = new Kartuebersicht();

		fv = new Fahrtverwaltung();
		singleplayerFahrten = fv.gibSingleplayerFahrten();

		kv = new Kartverwaltung();
		Kartliste = kv.gibKart();
		itKart = new MyIteratorKart<Kart>(Kartliste.listIterator());

		ku.kartBackward.addActionListener(this);
		ku.kartForward.addActionListener(this);
		ku.btnDetailView.addActionListener(this);

		viewDetail = new KartDetailView();
		viewDetail.frame.setVisible(false);

		viewDetail.btnZurueck.addActionListener(this);

		ladeKart();

		SwingUtilities.updateComponentTreeUI(ku.frame);

	}

	public void ladeKart() {
		if ((k = itKart.next()) != null) {
			BufferedImage newImage = k.getGrafik();
			ku.kartName.setText(k.getKartname());
			kartbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(kartbild);
			ku.kartLbl.setIcon(icon);
			k.getMaxkmh();

		}
	}

	public void streckeRückwärts() {
		if ((k = itKart.previous()) != null) {

			BufferedImage newImage = k.getGrafik();
			ku.kartName.setText(k.getKartname());
			kartbild = imageResizer(newImage);
			ImageIcon icon = new ImageIcon(kartbild);
			ku.kartLbl.setIcon(icon);

		}
	}

	public void setDetailView() throws SQLException {

		KartDetailView viewDetail = new KartDetailView();

		viewDetail.lblSetmaxkmh.setText((k.getMaxkmh() + " KM/h"));
		viewDetail.lblSetbesch.setText(Integer.toString(k.getBeschleunigung()) + " ");

		viewDetail.frame.setVisible(true);

		rs.close();
		Datenbankschnittstelle.closeConnections();

	}

	public static BufferedImage imageResizer(BufferedImage original) {

		BufferedImage newImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

		Graphics g = newImage.createGraphics();
		g.drawImage(original, 0, 0, 300, 200, null);
		g.dispose();
		return newImage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewDetail.btnZurueck) {
			viewDetail.frame.dispose();
			ku.frame.setVisible(true);
		}
		if (e.getSource() == ku.kartBackward) {
			streckeRückwärts();
		}
		if (e.getSource() == ku.kartForward) {
			ladeKart();
			viewDetail.frame.dispose();
		}
		if (e.getSource() == ku.btnDetailView) {
			viewDetail.frame.setVisible(true);

		}

	}

	public static void main(String[] args) {

		AnzeigenKartStrg steuerung = new AnzeigenKartStrg();

	}

}
