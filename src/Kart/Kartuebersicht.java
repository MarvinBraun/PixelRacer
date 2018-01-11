package Kart;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import BackgroundAnimation.Movement;
import FontHandler.FontHandler;
/**
 * 
 * Die Kartuebersicht ist die grafische Benutzeroberflaeche, die dem Nutzer die Karts anzeigt.
 * @author Ferhat Koca
 *
 */
public class Kartuebersicht {

	JFrame frame;
	JButton kartForward;
	JButton kartBackward;

	JButton btnZurueck;
	JLabel kartName;
	JLabel kartLbl;
	JLabel lblHintergrund;
	JLabel lblNewLabel;
	JLabel lblKartPunkte;
	JButton btnDetailView;
	JLabel lblKartPunkteLimit;
	JButton btnKartKaufen;

	AnzeigenKartStrg strg;
	/**
	 * Fuehrt die GUI aus
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kartuebersicht window = new Kartuebersicht();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Der Konstruktor fuehrt die Methode initialize aus.
	 */
	public Kartuebersicht() {
		initialize();
	}

	/**
	 * Initialisert das Objekt
	 */
	private void initialize() {

		Font customFont = FontHandler.registriereSchriftart(16f);
		Font customFont14f = FontHandler.registriereSchriftart(12f);
		Font customFont20f = FontHandler.registriereSchriftart(20f);
		
		frame = new JFrame();
		frame.setTitle("Pixel Racer - Kartuebersicht");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		kartForward = new JButton("");
		kartForward.setBorderPainted(false);
		kartForward.setIcon(new ImageIcon(Kartuebersicht.class
				.getResource("/Resources/forward.png")));
		kartForward.setContentAreaFilled(false);
		kartForward.setBounds(712, 238, 60, 60);
		kartForward.setVisible(true);
		frame.getContentPane().add(kartForward);

		kartBackward = new JButton("");
		kartBackward.setBorderPainted(false);
		kartBackward.setIcon(new ImageIcon(Kartuebersicht.class
				.getResource("/Resources/backward.png")));
		kartBackward.setOpaque(false);
		kartBackward.setContentAreaFilled(false);
		kartBackward.setBounds(27, 238, 60, 60);
		kartBackward.setVisible(true);
		frame.getContentPane().add(kartBackward);

		kartLbl = new JLabel("", JLabel.CENTER);
		kartLbl.setBounds(247, 144, 300, 200);
		kartLbl.setVisible(true);
		frame.getContentPane().add(kartLbl);

		kartName = new JLabel("FireBird", JLabel.CENTER);
		kartName.setFont(customFont20f);
		kartName.setBounds(296, 355, 215, 60);
		kartName.setVisible(true);
		frame.getContentPane().add(kartName);

		btnDetailView = new JButton("Zeig mir mehr!");
		btnDetailView.setFont(customFont);
		btnDetailView.setBounds(290, 428, 229, 35);
		btnDetailView.setVisible(true);
		getBtnDetailView().setBorderPainted(false);
		getBtnDetailView().setOpaque(false);
		getBtnDetailView().setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(btnDetailView);

		lblKartPunkte = new JLabel("New label");
		lblKartPunkte.setVisible(false);
		lblKartPunkte.setFont(customFont14f);
		lblKartPunkte.setBounds(315, 474, 229, 65);
		frame.getContentPane().add(lblKartPunkte);

		lblKartPunkteLimit = new JLabel("New label");
		lblKartPunkteLimit.setVisible(false);
		lblKartPunkteLimit.setFont(customFont14f);
		lblKartPunkteLimit.setBounds(200, 474, 478, 76);
		frame.getContentPane().add(lblKartPunkteLimit);

		btnKartKaufen = new JButton("Kart kaufen!");
		btnKartKaufen.setVisible(false);
		btnKartKaufen.setFont(customFont);
		btnKartKaufen.setBounds(568, 428, 181, 33);
		getBtnkartKaufen().setBorderPainted(false);
		getBtnkartKaufen().setOpaque(false);
		getBtnkartKaufen().setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(btnKartKaufen);
		
		btnZurueck = new JButton("Zurueck");
		btnZurueck.setFont(customFont14f);
		btnZurueck.setBounds(27, 510, 102, 29);
		getBtnZurueck().setBorderPainted(false);
		getBtnZurueck().setOpaque(false);
		getBtnZurueck().setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(btnZurueck);
		

		lblHintergrund = new JLabel("");
		lblHintergrund.setVisible(false);
		lblHintergrund.setOpaque(true);
		lblHintergrund.setBounds(0, 0, 794, 571);
		frame.getContentPane().add(lblHintergrund);

		Movement m = new Movement(10);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/Hintergrund.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		m.label.setBufferedImage(image, 0);

		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(m.label);

	}
	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}

	public JButton getBtnkartKaufen() {
		return btnKartKaufen;
	}

	public void setBtnkartKaufen(JButton btnkartKaufen) {
		this.btnKartKaufen = btnkartKaufen;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getkartForward() {
		return kartForward;
	}

	public void setkartForward(JButton kartForward) {
		this.kartForward = kartForward;
	}

	public JButton getkartBackward() {
		return kartBackward;
	}

	public void setkartBackward(JButton kartBackward) {
		this.kartBackward = kartBackward;
	}

	public JLabel getkartName() {
		return kartName;
	}

	public void setkartName(JLabel kartName) {
		this.kartName = kartName;
	}

	public JLabel getkartLbl() {
		return kartLbl;
	}

	public void setkartLbl(JLabel kartLbl) {
		this.kartLbl = kartLbl;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JButton getBtnDetailView() {
		return btnDetailView;
	}

	public void setBtnDetailView(JButton btnDetailView) {
		this.btnDetailView = btnDetailView;
	}

	public JLabel getlblKartPunkte() {
		return lblKartPunkte;
	}

	public void setlblKartPunkte(JLabel lblKartPunkte) {
		this.lblKartPunkte = lblKartPunkte;
	}

	public JLabel getlblKartPunkteLimit() {
		return lblKartPunkteLimit;
	}

	public void setlblKartPunkteLimit(JLabel lblKartPunkteLimit) {
		this.lblKartPunkteLimit = lblKartPunkteLimit;
	}

	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
	}

}
