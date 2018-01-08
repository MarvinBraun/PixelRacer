//author Matthias Westermeyer

package Rechnung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class bezahlenRechnung_ansicht {

	// benötigte Variablen deklarieren
	
	private JFrame frmBezahlung;
	private JTextField txtEmail;
	private JLabel lblE;
	private JButton btnNewButton;
	private JLabel lblOder;
	private JButton btnNeuAnmelden;
	private JPasswordField passwordField;
	private JTextPane textPane;
	private JLabel lblNewLabel;

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

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JLabel getLblOder() {
		return lblOder;
	}

	public void setLblOder(JLabel lblOder) {
		this.lblOder = lblOder;
	}

	public JButton getBtnNeuAnmelden() {
		return btnNeuAnmelden;
	}

	public void setBtnNeuAnmelden(JButton btnNeuAnmelden) {
		this.btnNeuAnmelden = btnNeuAnmelden;
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

	/**
	 * Launch the application.
	 */
	// Zugriff auf die View
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bezahlenRechnung_ansicht window = new bezahlenRechnung_ansicht();
					window.frmBezahlung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	// Konstruktor
	
	public bezahlenRechnung_ansicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	// Fenster / View initialisieren mit den entsprechenden Elementen
	
	private void initialize() {
		frmBezahlung = new JFrame();
		frmBezahlung.setTitle("Bezahlung");
		frmBezahlung.setBounds(100, 100, 800, 600);
		frmBezahlung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBezahlung.getContentPane().setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email-Mail Adresse");
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setBounds(221, 123, 220, 39);
		frmBezahlung.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		lblE = new JLabel("Probleme beim Einloggen?");
		lblE.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setBounds(221, 322, 220, 27);
		frmBezahlung.getContentPane().add(lblE);
		
		btnNewButton = new JButton("Einloggen");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(221, 231, 220, 39);
		frmBezahlung.getContentPane().add(btnNewButton);
		
		lblOder = new JLabel("oder");
		lblOder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOder.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOder.setBounds(221, 341, 220, 27);
		frmBezahlung.getContentPane().add(lblOder);
		
		btnNeuAnmelden = new JButton("Neu anmelden");
		btnNeuAnmelden.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNeuAnmelden.setBounds(221, 366, 220, 39);
		frmBezahlung.getContentPane().add(btnNeuAnmelden);
		
		passwordField = new JPasswordField();
		passwordField.setText("123456789");
		passwordField.setBounds(221, 173, 220, 39);
		frmBezahlung.getContentPane().add(passwordField);
		
		textPane = new JTextPane();
		textPane.setBounds(266, 126, 6, 20);
		frmBezahlung.getContentPane().add(textPane);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Matze\\Pictures\\paypalIcon.jpg"));
		lblNewLabel.setBounds(221, 28, 220, 65);
		frmBezahlung.getContentPane().add(lblNewLabel);
	}
}
