package Anmelden;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class AnmeldenView {

	private JFrame frmPixelRacer;
	private JTextField txtNutzername;
	private JPasswordField passwordField;

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
		
		JButton btnAnmelden = new JButton("Anmelden");
		btnAnmelden.setBounds(205, 264, 127, 45);
		frmPixelRacer.getContentPane().add(btnAnmelden);
		
		JButton btnAccountAnlegen = new JButton("Account anlegen");
		btnAccountAnlegen.setBounds(365, 264, 127, 45);
		frmPixelRacer.getContentPane().add(btnAccountAnlegen);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 191, 190, 20);
		frmPixelRacer.getContentPane().add(passwordField);
		
		JLabel lblNutzername = new JLabel("Nutzername");
		lblNutzername.setBounds(252, 111, 80, 14);
		frmPixelRacer.getContentPane().add(lblNutzername);
		
		JLabel lblPassowrt = new JLabel("Passwort");
		lblPassowrt.setBounds(254, 167, 46, 14);
		frmPixelRacer.getContentPane().add(lblPassowrt);
	}
}