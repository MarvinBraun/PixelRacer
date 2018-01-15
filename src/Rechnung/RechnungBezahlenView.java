package Rechnung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import FontHandler.FontHandler;
import SingleplayerFahrt.FahrtErstellenView;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

/**
 * Grafische Benutzeroberfläche um den Bezahlprozess auf der externen Website Paypal darszustellen
 * @author Matthias Westermeyer
 *
 */

public class RechnungBezahlenView {

	// benötigte Variablen deklarieren
	
	private JFrame frmBezahlung;
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
	
	public JFrame getFrmBezahlung() {
		return frmBezahlung;
	}

	public void setFrmBezahlung(JFrame frmBezahlung) {
		this.frmBezahlung = frmBezahlung;
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

	/**
	 * Zugriff auf die View
	 * Launch the application.
	 */
	// Zugriff auf die View
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechnungBezahlenView window = new RechnungBezahlenView();
					window.frmBezahlung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktor
	 * Create the application.
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
		
		frmBezahlung = new JFrame();
		frmBezahlung.setTitle("Bezahlung");
		frmBezahlung.setBounds(100, 100, 800, 600);
		frmBezahlung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBezahlung.getContentPane().setLayout(null);
		frmBezahlung.setLocationRelativeTo(null);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email-Mail Adresse");
		txtEmail.setFont(customFont12f);
		txtEmail.setBounds(221, 123, 220, 39);
		frmBezahlung.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		lblE = new JLabel("anders ueberlegt?");
		lblE.setFont(customFont12f);
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setBounds(221, 322, 220, 27);
		frmBezahlung.getContentPane().add(lblE);
		
		btnEinloggen = new JButton("Einloggen");
		btnEinloggen.setFont(customFont12f);
		btnEinloggen.setBounds(221, 231, 220, 39);
		frmBezahlung.getContentPane().add(btnEinloggen);	
		
		lblOder = new JLabel("dann");
		lblOder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOder.setFont(customFont12f);
		lblOder.setBounds(221, 341, 220, 27);
		frmBezahlung.getContentPane().add(lblOder);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(customFont12f);
		btnAbbrechen.setBounds(221, 366, 220, 39);
		frmBezahlung.getContentPane().add(btnAbbrechen);
		
		passwordField = new JPasswordField();
		passwordField.setText("123456789");
		passwordField.setBounds(221, 173, 220, 39);
		frmBezahlung.getContentPane().add(passwordField);
		
		textPane = new JTextPane();
		textPane.setBounds(266, 126, 6, 20);
		frmBezahlung.getContentPane().add(textPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RechnungBezahlenView.class.getResource("/Resources/paypal_Icon.jpg")));
		lblNewLabel.setBounds(221, 28, 220, 65);
		frmBezahlung.getContentPane().add(lblNewLabel);
		
		lblHintergrund = new JLabel();
		lblHintergrund.setIcon(new ImageIcon(RechnungBezahlenView.class.getResource("/Resources/Hintergrund.png")));
		lblHintergrund.setBounds(0, 0, 800, 600);
		frmBezahlung.getContentPane().add(lblHintergrund);
	}
}
