package Rechnung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;

public class speicherRechnung {

	private JFrame frmSpeicherrechnung;
			JLabel lblRechnungErfolgreichAuf;
			JButton btnZurck;
				
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					speicherRechnung window = new speicherRechnung();
					window.frmSpeicherrechnung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public speicherRechnung() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSpeicherrechnung = new JFrame();
		frmSpeicherrechnung.setTitle("Rechnung speichern");
		frmSpeicherrechnung.setBounds(100, 100, 600, 200);
		frmSpeicherrechnung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSpeicherrechnung.getContentPane().setLayout(null);
		
		lblRechnungErfolgreichAuf = new JLabel("Rechnung erfolgreich in dem hinterlegtem Verzeichnis gespeichert.");
		lblRechnungErfolgreichAuf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRechnungErfolgreichAuf.setBounds(87, 30, 458, 50);
		frmSpeicherrechnung.getContentPane().add(lblRechnungErfolgreichAuf);
		
		btnZurck = new JButton("zur\u00FCck");
		btnZurck.setBounds(22, 114, 89, 23);
		frmSpeicherrechnung.getContentPane().add(btnZurck);
	
	}
}
