package Anmelden;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;

import BackgroundAnimation.Movement;
import FontHandler.FontHandler;

import javax.swing.JPasswordField;
import javax.swing.JLabel;

/**
 * Grafische Benutzeroberfläche, die das Anmeldefenster für den Kunden anzeigt.
 * @author Daniel Zeller
 *
 */

public class AnmeldenView { 

	private JFrame frmPixelRacer; //Deklarierung der benötigten Variablen
	private JTextField txtNutzername;
	private JPasswordField passwordField;
	private JButton btnAnmelden;
	private JButton btnAccountAnlegen;
	private JLabel lblNutzername;
	private JLabel lblPasswort;
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
		Font customFont14f = FontHandler.registriereSchriftart(14f);
		Font customFont10f = FontHandler.registriereSchriftart(10f);
		
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
		txtNutzername.setFont(customFont14f);
		
		btnAnmelden = new JButton("Anmelden");
		btnAnmelden.setBounds(205, 264, 127, 45);
		btnAnmelden.setFont(customFont14f);
		btnAnmelden.setBorderPainted(false);
		btnAnmelden.setOpaque(false);
		btnAnmelden.setBackground(SystemColor.activeCaption);
		btnAnmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmPixelRacer.getContentPane().add(btnAnmelden);
	
		
		btnAccountAnlegen = new JButton("Account anlegen");
		btnAccountAnlegen.setBounds(365, 264, 210, 45);
		btnAccountAnlegen.setFont(customFont14f);
		btnAccountAnlegen.setBorderPainted(false);
		btnAccountAnlegen.setOpaque(false);
		btnAccountAnlegen.setBackground(SystemColor.activeCaption);
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
		lblNutzername.setBounds(252, 111, 150, 14);
		lblNutzername.setFont(customFont14f);
		frmPixelRacer.getContentPane().add(lblNutzername);
		
		lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(254, 167, 150, 14);
		lblPasswort.setFont(customFont14f);
		frmPixelRacer.getContentPane().add(lblPasswort);
		
		btnMitarbeiter = new JButton("Mitarbeiter");
		btnMitarbeiter.setBounds(642, 519, 120, 23);
		btnMitarbeiter.setFont(customFont10f);
		btnMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnMitarbeiter);
		
Movement m = new Movement(10);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/Hintergrund.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m.label.setBufferedImage(image,0);
		
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		frmPixelRacer.getContentPane().add(m.label);
		frmPixelRacer.setVisible(true);
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
		return lblPasswort;
	}

	public void setLblPassowrt(JLabel lblPassowrt) {
		this.lblPasswort = lblPassowrt;
	}

	public JButton getBtnMitarbeiter() {
		return btnMitarbeiter;
	}

	public void setBtnMitarbeiter(JButton btnMitarbeiter) {
		this.btnMitarbeiter = btnMitarbeiter;
	}
}
