package Anmelden;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

//Autor Daniel Zeller

public class AnmeldenView { 

	private JFrame frmPixelRacer; //Deklarierung der benötigten Variablen
	private JTextField txtNutzername;
	private JPasswordField passwordField;
	private JButton btnAnmelden;
	private JButton btnAccountAnlegen;
	private JLabel lblNutzername;
	private JLabel lblPassowrt;
	private JButton btnMitarbeiter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnmeldenView window = new AnmeldenView();
					window.frmPixelRacer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AnmeldenView() { //Konstruktor
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //Initialisierung des Fensters und den dazugehörigen Komponenten
		frmPixelRacer = new JFrame();
		frmPixelRacer.setTitle("Pixel Racer - Anmelden");
		frmPixelRacer.setResizable(false);
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.getContentPane().setLayout(null);
		frmPixelRacer.setLocationRelativeTo(null);
		
		txtNutzername = new JTextField();
		txtNutzername.setBounds(254, 136, 190, 20);
		frmPixelRacer.getContentPane().add(txtNutzername);
		txtNutzername.setColumns(10);
		
		btnAnmelden = new JButton("Anmelden");
		btnAnmelden.setBounds(205, 264, 127, 45);
		btnAnmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnAnmelden);
	
		
		btnAccountAnlegen = new JButton("Account anlegen");
		btnAccountAnlegen.setBounds(365, 264, 170, 45);
		btnAccountAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnAccountAnlegen);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 191, 190, 20);
		frmPixelRacer.getContentPane().add(passwordField);
		
		lblNutzername = new JLabel("Nutzername");
		lblNutzername.setBounds(252, 111, 80, 14);
		frmPixelRacer.getContentPane().add(lblNutzername);
		
		lblPassowrt = new JLabel("Passwort");
		lblPassowrt.setBounds(254, 167, 78, 14);
		frmPixelRacer.getContentPane().add(lblPassowrt);
		
		btnMitarbeiter = new JButton("Mitarbeiter");
		btnMitarbeiter.setBounds(642, 519, 108, 23);
		btnMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnMitarbeiter);
		
		JLabel lblHintergrund = new JLabel();
		lblHintergrund.setIcon(new ImageIcon("src/Resources/Hintergrund.png"));
		lblHintergrund.setBounds(0, 0, 800, 600);
		frmPixelRacer.getContentPane().add(lblHintergrund);
	}

	public JFrame getFrmPixelRacer() { //Getter und Setter der Variablen
		return frmPixelRacer;
	}

	public void setFrmPixelRacer(JFrame frmPixelRacer) {
		this.frmPixelRacer = frmPixelRacer;
	}

	public JTextField getTxtNutzername() {
		return txtNutzername;
	}

	public void setTxtNutzername(JTextField txtNutzername) {
		this.txtNutzername = txtNutzername;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getBtnAnmelden() {
		return btnAnmelden;
	}

	public void setBtnAnmelden(JButton btnAnmelden) {
		this.btnAnmelden = btnAnmelden;
	}

	public JButton getBtnAccountAnlegen() {
		return btnAccountAnlegen;
	}

	public void setBtnAccountAnlegen(JButton btnAccountAnlegen) {
		this.btnAccountAnlegen = btnAccountAnlegen;
	}

	public JLabel getLblNutzername() {
		return lblNutzername;
	}

	public void setLblNutzername(JLabel lblNutzername) {
		this.lblNutzername = lblNutzername;
	}

	public JLabel getLblPassowrt() {
		return lblPassowrt;
	}

	public void setLblPassowrt(JLabel lblPassowrt) {
		this.lblPassowrt = lblPassowrt;
	}

	public JButton getBtnMitarbeiter() {
		return btnMitarbeiter;
	}

	public void setBtnMitarbeiter(JButton btnMitarbeiter) {
		this.btnMitarbeiter = btnMitarbeiter;
	}
}
