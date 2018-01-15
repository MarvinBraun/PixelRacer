package Kart;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

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

	private JLabel lblHintergrund;
	private JLabel lblmaxkmh;
	private JLabel lblbesch;
	private JLabel lblGefahreneRennen;
	private JLabel lblRennenAlsErster;
	private JLabel lblRennenAlsZweiter;
	private JLabel lblRennenAlsDritter;

	private JLabel lblSetmaxkmh;
	private JLabel lblSetbesch;
	private JLabel lblSetGesRennen;
	private JLabel lblSetAnzErster;
	private JLabel lblSetAnzZweiter;
	private JLabel lblSetAnzDritter;

	private JButton btnZurueck;

	/**
	 * Führt die GUI aus.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KartDetailView window = new KartDetailView();
					window.getFrame().setVisible(true);
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

		setFrame (new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().setVisible(false);
		getFrame().setResizable(false);
		getFrame().setLocationRelativeTo(null);
		getFrame().getContentPane().setLayout(null);
		
		setlblmaxkmh (new JLabel("Max. Geschwindigkeit:"));
		getlblmaxkmh().setBounds(32, 37, 140, 14);
		getlblmaxkmh().setFont(customFont );
		getFrame().getContentPane().add(lblmaxkmh);

		setLblGefahreneRennen (new JLabel("Gefahrene SP-Rennen:"));
		getLblGefahreneRennen().setFont(customFont );
		getLblGefahreneRennen().setBounds(32, 77, 140, 14);
		getFrame().getContentPane().add(lblGefahreneRennen);

		setLblbesch(new JLabel("Beschleunigung:"));
		getLblbesch().setBounds(32, 57, 120, 14);
		getLblbesch().setFont(customFont);
		getFrame().getContentPane().add(lblbesch);

		setLblRennenAlsErster( new JLabel("Rennen als Erster abgeschlossen"));
		getLblRennenAlsErster().setBounds(210, 136, 220, 14);
		getLblRennenAlsErster().setFont(customFont);
		getFrame().getContentPane().add(lblRennenAlsErster);

		setLblRennenAlsZweiter (new JLabel("Rennen als Zweiter abgeschlossen"));
		getLblRennenAlsZweiter().setFont(customFont);
		getLblRennenAlsZweiter().setBounds(210, 161, 220, 14);
		getFrame().getContentPane().add(lblRennenAlsZweiter);

		setLblRennenAlsDritter (new JLabel("Rennen als Dritter abgeschlossen"));
		getLblRennenAlsDritter().setFont(customFont);
		getLblRennenAlsDritter().setBounds(210, 186, 220, 14);
		getFrame().getContentPane().add(lblRennenAlsDritter);

		setLblSetmaxkmh (new JLabel("New label"));
		getLblSetmaxkmh().setFont(customFont);
		getLblSetmaxkmh().setBounds(191, 37, 60, 14);
		getFrame().getContentPane().add(lblSetmaxkmh);

		setLblSetGesRennen (new JLabel("New label"));
		getLblSetGesRennen().setFont(customFont);
		getLblSetGesRennen().setBounds(191, 77, 60, 14);
		getFrame().getContentPane().add(lblSetGesRennen);

		setLblSetbesch(new JLabel("New label"));
		getLblSetbesch().setFont(customFont);
		getLblSetbesch().setBounds(191, 57, 60, 14);
		getFrame().getContentPane().add(lblSetbesch);

		setLblSetAnzErster( new JLabel("New label"));
		getLblSetAnzErster().setFont(customFont);
		getLblSetAnzErster().setBounds(148, 136, 60, 14);
		getFrame().getContentPane().add(lblSetAnzErster);

		setLblSetAnzZweiter( new JLabel("New label"));
		getLblSetAnzZweiter().setFont(customFont);
		getLblSetAnzZweiter().setBounds(148, 161, 60, 14);
		getFrame().getContentPane().add(lblSetAnzZweiter);

		setLblSetAnzDritter ( new JLabel("New label"));
		getLblSetAnzDritter().setFont(customFont);
		getLblSetAnzDritter().setBounds(148, 186, 60, 14);
		getFrame().getContentPane().add(lblSetAnzDritter);

		setBtnZurueck( new JButton("Zurueck"));
		getBtnZurueck().setFont(customFont);
		getBtnZurueck().setFocusable(false);
		getBtnZurueck().setBounds(10, 227, 89, 23);
		getBtnZurueck().setBorderPainted(false);
		getBtnZurueck().setOpaque(false);
		getBtnZurueck().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnZurueck);
		getBtnZurueck().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		lblHintergrund = new JLabel("");
		lblHintergrund.setVisible(false);
		lblHintergrund.setBounds(0, 0, 794, 571);
		getFrame().getContentPane().add(lblHintergrund);

		Movement m = new Movement(10);

		BufferedImage image = null;
		try {
			URL url = getClass().getResource("/Resources/Hintergrund.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		btnZurueck.setForeground(Color.RED);
		
	}
}
