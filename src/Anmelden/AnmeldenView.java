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

	JFrame frmPixelRacer;
	JTextField txtNutzername;
	JPasswordField passwordField;
	JButton btnAnmelden;
	JButton btnAccountAnlegen;
	JLabel lblNutzername;
	JLabel lblPassowrt;
	JButton btnMitarbeiter;

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
	public AnmeldenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPixelRacer = new JFrame();
		frmPixelRacer.setTitle("Pixel Racer - Anmelden");
		frmPixelRacer.setResizable(false);
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.getContentPane().setLayout(null);
		
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
		btnAccountAnlegen.setBounds(365, 264, 127, 45);
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
		btnMitarbeiter.setBounds(674, 518, 89, 23);
		btnMitarbeiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AnmeldenStrg strg = new AnmeldenStrg();
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnMitarbeiter);
		
		JLabel lblHintergrund = new JLabel();
		lblHintergrund.setIcon(new ImageIcon("src/Resources/Hintergrund.png"));
		lblHintergrund.setBounds(0, 0, 800, 600);
		frmPixelRacer.getContentPane().add(lblHintergrund);
	}
}