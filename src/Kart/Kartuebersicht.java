package Kart;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import BackgroundAnimation.Movement;
import FontHandler.FontHandler;
import java.awt.Color;

/**
 * 
 * Die Kartuebersicht ist die grafische Benutzeroberflaeche, die dem Nutzer die
 * Karts anzeigt.
 * 
 * @author Ferhat Koca
 *
 */
public class Kartuebersicht {

	private JFrame frame;
	private JButton kartForward;
	private JButton kartBackward;

	private JButton btnZurueck;
	private JLabel kartName;
	private JLabel kartLbl;
	private JLabel lblHintergrund;
	private JLabel lblNewLabel;
	private JLabel lblKartPunkte;
	private JButton btnDetailView;
	private JLabel lblKartPunkteLimit;
	private JButton btnKartKaufen;

	AnzeigenKartStrg strg;

	/**
	 * Fuehrt die GUI aus
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kartuebersicht window = new Kartuebersicht();
					window.getFrame().setVisible(true);
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

		Font customFont = FontHandler.registriereSchriftart(15f);
		Font customFont20f = FontHandler.registriereSchriftart(20f);

		setFrame (new JFrame());
		getFrame().setTitle("Pixel Racer - Kartuebersicht");
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setVisible(true);
		getFrame().setResizable(false);
		getFrame().getContentPane().setLayout(null);

		setKartForward(new JButton(""));
		getKartForward().setBorderPainted(false);
		getKartForward().setIcon(new ImageIcon(Kartuebersicht.class.getResource("/Resources/forward.png")));
		getKartForward().setContentAreaFilled(false);
		getKartForward().setBounds(712, 238, 60, 60);
		getKartForward().setVisible(true);
		getFrame().getContentPane().add(getKartForward());

		setKartBackward(new JButton(""));
		getKartBackward().setBorderPainted(false);
		getKartBackward().setIcon(new ImageIcon(Kartuebersicht.class.getResource("/Resources/backward.png")));
		getKartBackward().setOpaque(false);
		getKartBackward().setContentAreaFilled(false);
		getKartBackward().setBounds(27, 238, 60, 60);
		getKartBackward().setVisible(true);
		getFrame().getContentPane().add(getKartBackward());

		setKartLbl(new JLabel("", JLabel.CENTER));
		getKartLbl().setBounds(247, 144, 300, 200);
		getKartLbl().setVisible(true);
		getFrame().getContentPane().add(getKartLbl());

		setKartName(new JLabel("FireBird", JLabel.CENTER));
		getKartName().setFont(customFont20f);
		getKartName().setBounds(296, 355, 215, 60);
		getKartName().setVisible(true);
		getFrame().getContentPane().add(getKartName());

		setBtnDetailView( new JButton("Zeig mir mehr!"));
		getBtnDetailView().setFont(customFont);
		getBtnDetailView().setBounds(290, 428, 229, 35);
		getBtnDetailView().setVisible(true);
		getBtnDetailView().setBorderPainted(false);
		getBtnDetailView().setOpaque(false);
		getBtnDetailView().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnDetailView);

		setLblKartPunkte( new JLabel("New label"));
		getLblKartPunkte().setVisible(false);
		getLblKartPunkte().setFont(customFont);
		getLblKartPunkte().setBounds(300, 474, 229, 65);
		getFrame().getContentPane().add(lblKartPunkte);

		setLblKartPunkteLimit( new JLabel("New label"));
		getLblKartPunkteLimit().setVisible(false);
		getLblKartPunkteLimit().setFont(customFont);
		getLblKartPunkteLimit().setBounds(200, 474, 600, 76);
		getFrame().getContentPane().add(lblKartPunkteLimit);

		setBtnKartKaufen(new JButton("Kart kaufen!"));
		getBtnKartKaufen().setVisible(false);
		getBtnKartKaufen().setFont(customFont);
		getBtnKartKaufen().setBounds(568, 428, 181, 33);
		getBtnKartKaufen().setBorderPainted(false);
		getBtnKartKaufen().setOpaque(false);
		getBtnKartKaufen().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(getBtnKartKaufen());

		setBtnZurueck(new JButton("Zurueck"));
		getBtnZurueck().setFont(customFont);
		getBtnZurueck().setBounds(27, 510, 150, 29);
		getBtnZurueck().setBorderPainted(false);
		getBtnZurueck().setOpaque(false);
		getBtnZurueck().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnZurueck);

		lblHintergrund = new JLabel("");
		lblHintergrund.setVisible(false);
		lblHintergrund.setOpaque(true);
		lblHintergrund.setBounds(0, 0, 794, 571);
		getFrame().getContentPane().add(lblHintergrund);

		Movement m = new Movement(10);

		BufferedImage image = null;
		try {
			URL url = getClass().getResource("/Resources/Hintergrund.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		m.label.setBufferedImage(image, 0);

		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		getFrame().getContentPane().add(m.label);

	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getKartForward() {
		return kartForward;
	}

	public JButton getKartBackward() {
		return kartBackward;
	}

	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public JLabel getKartName() {
		return kartName;
	}

	public JLabel getKartLbl() {
		return kartLbl;
	}

	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JLabel getLblKartPunkte() {
		return lblKartPunkte;
	}

	public JButton getBtnDetailView() {
		return btnDetailView;
	}

	public JLabel getLblKartPunkteLimit() {
		return lblKartPunkteLimit;
	}

	public JButton getBtnKartKaufen() {
		return btnKartKaufen;
	}

	public AnzeigenKartStrg getStrg() {
		return strg;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setKartForward(JButton kartForward) {
		this.kartForward = kartForward;
	}

	public void setKartBackward(JButton kartBackward) {
		this.kartBackward = kartBackward;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
		btnZurueck.setForeground(Color.RED);
	}

	public void setKartName(JLabel kartName) {
		this.kartName = kartName;
	}

	public void setKartLbl(JLabel kartLbl) {
		this.kartLbl = kartLbl;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public void setLblKartPunkte(JLabel lblKartPunkte) {
		this.lblKartPunkte = lblKartPunkte;
	}

	public void setBtnDetailView(JButton btnDetailView) {
		this.btnDetailView = btnDetailView;
		btnDetailView.setForeground(Color.RED);
	}

	public void setLblKartPunkteLimit(JLabel lblKartPunkteLimit) {
		this.lblKartPunkteLimit = lblKartPunkteLimit;
	}

	public void setBtnKartKaufen(JButton btnKartKaufen) {
		this.btnKartKaufen = btnKartKaufen;
		btnKartKaufen.setForeground(Color.RED);
	}

}
