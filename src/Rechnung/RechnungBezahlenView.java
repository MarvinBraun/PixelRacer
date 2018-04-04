package Rechnung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.SwingConstants;

import BackgroundAnimation.Movement;
import FontHandler.FontHandler;
import SingleplayerFahrt.FahrtErstellenView;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Grafische Benutzeroberfläche um den Bezahlprozess auf der externen Website
 * Paypal darszustellen
 * 
 * @author Matthias Westermeyer
 *
 */

public class RechnungBezahlenView {

	// benötigte Variablen deklarieren

	private JFrame frame;
	private JTextField txtEmail;
	private JLabel lblE;
	private JButton btnEinloggen;
	private JLabel lblOder;
	private JButton btnAbbrechen;
	private JPasswordField passwordField;
	private JTextPane textPane;
	private JLabel lblNewLabel;
	private JLabel lblHintergrund;

	// getter und setter Methoden der Variablen

	/**
	 * Zugriff auf die View Launch the application.
	 */
	// Zugriff auf die View

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechnungBezahlenView window = new RechnungBezahlenView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktor Create the application.
	 */

	//

	public RechnungBezahlenView() {
		initialize();
	}

	/**
	 * Fenster / View initialisieren mit den entsprechenden Elementen
	 */

	private void initialize() {

		Font customFont12f = FontHandler.registriereSchriftart(12f);

		setFrame( new JFrame());
		getFrame().setTitle("Bezahluebersicht - Paypal");
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);

		setTxtEmail ( new JTextField());
		getTxtEmail().setText("Email-Mail Adresse");
		getTxtEmail().setFont(customFont12f);
		getTxtEmail().setBounds(221, 123, 220, 39);
		getFrame().getContentPane().add(txtEmail);
		getTxtEmail().setColumns(10);

		setBtnEinloggen ( new JButton("Einloggen"));
		getBtnEinloggen().setFont(customFont12f);
		getBtnEinloggen().setBounds(221, 231, 220, 39);
		getBtnEinloggen().setFocusable(false);
		getBtnEinloggen().setBorderPainted(false);
		getBtnEinloggen().setBackground(SystemColor.activeCaption);
		getBtnEinloggen().setOpaque(false);
		getFrame().getContentPane().add(btnEinloggen);

		setBtnAbbrechen ( new JButton("Abbrechen"));
		getBtnAbbrechen().setFont(customFont12f);
		getBtnAbbrechen().setFocusable(false);
		getBtnAbbrechen().setBorderPainted(false);
		getBtnAbbrechen().setBackground(SystemColor.activeCaption);
		getBtnAbbrechen().setOpaque(false);
		getBtnAbbrechen().setBounds(221, 366, 220, 39);
		getFrame().getContentPane().add(btnAbbrechen);

		setPasswordField ( new JPasswordField());
		getPasswordField().setText("123456789");
		getPasswordField().setBounds(221, 173, 220, 39);
		getFrame().getContentPane().add(passwordField);

		textPane = new JTextPane();
		textPane.setBounds(266, 126, 6, 20);
		getFrame().getContentPane().add(textPane);

		setLblNewLabel ( new JLabel(""));
		getLblNewLabel().setIcon(new ImageIcon(RechnungBezahlenView.class.getResource("/Resources/PayPal.svg.png")));
		getLblNewLabel().setBounds(221, 28, 220, 65);
		getFrame().getContentPane().add(lblNewLabel);

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
		getFrame().setVisible(true);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JLabel getLblE() {
		return lblE;
	}

	public void setLblE(JLabel lblE) {
		this.lblE = lblE;
	}

	public JButton getBtnEinloggen() {
		return btnEinloggen;
	}

	public void setBtnEinloggen(JButton btnEinloggen) {
		this.btnEinloggen = btnEinloggen;
	}

	public JLabel getLblOder() {
		return lblOder;
	}

	public void setLblOder(JLabel lblOder) {
		this.lblOder = lblOder;
	}

	public JButton getBtnAbbrechen() {
		return btnAbbrechen;
	}

	public void setBtnAbbrechen(JButton btnAbbrechen) {
		this.btnAbbrechen = btnAbbrechen;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}
}
