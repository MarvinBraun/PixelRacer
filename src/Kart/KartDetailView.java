package Kart;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import BackgroundAnimation.Movement;
import FontHandler.FontHandler;

import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * KartDetailView ist die grafische Benutzeroberfläche, die benutzt wird um die
 * Details der Karts für den jeweiligen angemeldeten Nutzer anzeigt.
 * 
 * @author Ferhat Koca
 *
 */
public class KartDetailView {

	JFrame frame;

	JLabel lblHintergrund;
	JLabel lblmaxkmh;
	JLabel lblbesch;
	JLabel lblGefahreneRennen;
	JLabel lblRennenAlsErster;
	JLabel lblRennenAlsZweiter;
	JLabel lblRennenAlsDritter;

	JLabel lblSetmaxkmh;
	JLabel lblSetbesch;
	JLabel lblSetGesRennen;
	JLabel lblSetAnzErster;
	JLabel lblSetAnzZweiter;
	JLabel lblSetAnzDritter;

	JButton btnZurueck;

	/**
	 * Führt die GUI aus.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KartDetailView window = new KartDetailView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialisiert und befüllt die grafische oberfläsche durch die Methode initialize.
	 */
	public KartDetailView() {
		initialize();
	}

	/**
	 * Initialisiert das Objekt.
	 */
	private void initialize() {
		
		Font customFont = FontHandler.registriereSchriftart(9f);
		Font customFont22f = FontHandler.registriereSchriftart(8f);

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		lblmaxkmh = new JLabel("Max. Geschwindigkeit:");
		lblmaxkmh.setBounds(32, 37, 140, 14);
		lblmaxkmh.setFont(customFont22f );
		frame.getContentPane().add(lblmaxkmh);

		lblGefahreneRennen = new JLabel("Gefahrene SP-Rennen:");
		lblGefahreneRennen.setFont(customFont22f );
		lblGefahreneRennen.setBounds(32, 77, 140, 14);
		frame.getContentPane().add(lblGefahreneRennen);

		lblbesch = new JLabel("Beschleunigung:");
		lblbesch.setBounds(32, 57, 95, 14);
		lblbesch.setFont(customFont22f);
		frame.getContentPane().add(lblbesch);

		lblRennenAlsErster = new JLabel("Rennen als Erster abgeschlossen");
		lblRennenAlsErster.setBounds(224, 136, 200, 14);
		lblRennenAlsErster.setFont(customFont22f);
		frame.getContentPane().add(lblRennenAlsErster);

		lblRennenAlsZweiter = new JLabel("Rennen als Zweiter abgeschlossen");
		lblRennenAlsZweiter.setFont(customFont22f);
		lblRennenAlsZweiter.setBounds(224, 161, 200, 14);
		frame.getContentPane().add(lblRennenAlsZweiter);

		lblRennenAlsDritter = new JLabel("Rennen als Dritter abgeschlossen");
		lblRennenAlsDritter.setFont(customFont22f);
		lblRennenAlsDritter.setBounds(224, 186, 200, 14);
		frame.getContentPane().add(lblRennenAlsDritter);

		lblSetmaxkmh = new JLabel("New label");
		lblSetmaxkmh.setFont(customFont22f);
		lblSetmaxkmh.setBounds(191, 37, 46, 14);
		frame.getContentPane().add(lblSetmaxkmh);

		lblSetGesRennen = new JLabel("New label");
		lblSetGesRennen.setFont(customFont22f);
		lblSetGesRennen.setBounds(191, 77, 46, 14);
		frame.getContentPane().add(lblSetGesRennen);

		lblSetbesch = new JLabel("New label");
		lblSetbesch.setFont(customFont22f);
		lblSetbesch.setBounds(191, 57, 46, 14);
		frame.getContentPane().add(lblSetbesch);

		lblSetAnzErster = new JLabel("New label");
		lblSetAnzErster.setFont(customFont22f);
		lblSetAnzErster.setBounds(148, 136, 46, 14);
		frame.getContentPane().add(lblSetAnzErster);

		lblSetAnzZweiter = new JLabel("New label");
		lblSetAnzZweiter.setFont(customFont22f);
		lblSetAnzZweiter.setBounds(148, 161, 46, 14);
		frame.getContentPane().add(lblSetAnzZweiter);

		lblSetAnzDritter = new JLabel("New label");
		lblSetAnzDritter.setFont(customFont22f);
		lblSetAnzDritter.setBounds(148, 186, 46, 14);
		frame.getContentPane().add(lblSetAnzDritter);

		btnZurueck = new JButton("Zurueck");
		btnZurueck.setFont(customFont);
		btnZurueck.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnZurueck);
		getBtnZurueck().setBorderPainted(false);
		getBtnZurueck().setOpaque(false);
		getBtnZurueck().setBackground(SystemColor.activeCaption);
		btnZurueck.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		lblHintergrund = new JLabel("");
		lblHintergrund.setVisible(false);
		lblHintergrund.setBounds(0, 0, 794, 571);
		frame.getContentPane().add(lblHintergrund);

		Movement m = new Movement(10);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/Hintergrund.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		m.label.setBufferedImage(image, 0);
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(m.label);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getlblmaxkmh() {
		return lblmaxkmh;
	}

	public void setlblmaxkmh(JLabel lblmaxkmh) {
		this.lblmaxkmh = lblmaxkmh;
	}

	public JLabel getLblGefahreneRennen() {
		return lblGefahreneRennen;
	}

	public void setLblGefahreneRennen(JLabel lblGefahreneRennen) {
		this.lblGefahreneRennen = lblGefahreneRennen;
	}

	public JLabel getLblSetGesRennen() {
		return lblSetGesRennen;
	}

	public void setLblSetGesRennen(JLabel lblSetGesRennen) {
		this.lblSetGesRennen = lblSetGesRennen;
	}

	public JLabel getLblbesch() {
		return lblbesch;
	}

	public void setLblbesch(JLabel lblbesch) {
		this.lblbesch = lblbesch;
	}

	public JLabel getLblRennenAlsErster() {
		return lblRennenAlsErster;
	}

	public void setLblRennenAlsErster(JLabel lblRennenAlsErster) {
		this.lblRennenAlsErster = lblRennenAlsErster;
	}

	public JLabel getLblRennenAlsZweiter() {
		return lblRennenAlsZweiter;
	}

	public void setLblRennenAlsZweiter(JLabel lblRennenAlsZweiter) {
		this.lblRennenAlsZweiter = lblRennenAlsZweiter;
	}

	public JLabel getLblRennenAlsDritter() {
		return lblRennenAlsDritter;
	}

	public void setLblRennenAlsDritter(JLabel lblRennenAlsDritter) {
		this.lblRennenAlsDritter = lblRennenAlsDritter;
	}

	public JLabel getLblSetmaxkmh() {
		return lblSetmaxkmh;
	}

	public void setLblSetmaxkmh(JLabel lblSetmaxkmh) {
		this.lblSetmaxkmh = lblSetmaxkmh;
	}

	public JLabel getLblSetbesch() {
		return lblSetbesch;
	}

	public void setLblSetbesch(JLabel lblSetbesch) {
		this.lblSetbesch = lblSetbesch;
	}

	public JLabel getLblSetAnzErster() {
		return lblSetAnzErster;
	}

	public void setLblSetAnzErster(JLabel lblSetAnzErster) {
		this.lblSetAnzErster = lblSetAnzErster;
	}

	public JLabel getLblSetAnzZweiter() {
		return lblSetAnzZweiter;
	}

	public void setLblSetAnzZweiter(JLabel lblSetAnzZweiter) {
		this.lblSetAnzZweiter = lblSetAnzZweiter;
	}

	public JLabel getLblSetAnzDritter() {
		return lblSetAnzDritter;
	}

	public void setLblSetAnzDritter(JLabel lblSetAnzDritter) {
		this.lblSetAnzDritter = lblSetAnzDritter;
	}

	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
	}
}
