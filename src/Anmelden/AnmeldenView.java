package Anmelden;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;

public class AnmeldenView {

	private JFrame frmPixelRacer;
	private JTextField txtNutzername;
	private JTextField txtPasswort;

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
		txtNutzername.setText("Nutzername");
		txtNutzername.setBounds(254, 174, 190, 20);
		frmPixelRacer.getContentPane().add(txtNutzername);
		txtNutzername.setColumns(10);
		
		txtPasswort = new JTextField();
		txtPasswort.setText("Passwort");
		txtPasswort.setBounds(254, 205, 190, 20);
		frmPixelRacer.getContentPane().add(txtPasswort);
		txtPasswort.setColumns(10);
		
		JButton btnAnmelden = new JButton("Anmelden");
		btnAnmelden.setBounds(205, 264, 127, 45);
		frmPixelRacer.getContentPane().add(btnAnmelden);
		
		JButton btnAccountAnlegen = new JButton("Account anlegen");
		btnAccountAnlegen.setBounds(365, 264, 127, 45);
		frmPixelRacer.getContentPane().add(btnAccountAnlegen);
	}
}
