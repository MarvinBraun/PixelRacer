package Rechnung;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Grafische Benutzeroberfläche um dem Nutzer die Meldung zu geben, dass seine Rechnung auf dem gewünschten Verzeichnis abgelegt wird.
 * @author Matthias Westermeyer
 *
 */

public class speicherRechnung {

		// benötigte Variablen deklarieren
	
		JFrame frmSpeicherrechnung;
		JLabel lblRechnungErfolgreichAuf;
		JButton btnZurck;
		JLabel lblHintergrund;
			
	// getter und setter Methoden der Variablen
		
	public JFrame getFrmSpeicherrechnung() {
				return frmSpeicherrechnung;
			}

			public void setFrmSpeicherrechnung(JFrame frmSpeicherrechnung) {
				this.frmSpeicherrechnung = frmSpeicherrechnung;
			}

			public JLabel getLblRechnungErfolgreichAuf() {
				return lblRechnungErfolgreichAuf;
			}

			public void setLblRechnungErfolgreichAuf(JLabel lblRechnungErfolgreichAuf) {
				this.lblRechnungErfolgreichAuf = lblRechnungErfolgreichAuf;
			}

			public JButton getBtnZurck() {
				return btnZurck;
			}

			public void setBtnZurck(JButton btnZurck) {
				this.btnZurck = btnZurck;
			}

	/**
	 * Launch the application.
	 */
			
	//  Zugriff auf die View
			
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
	
	// Konstruktor
	
	public speicherRechnung() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	// Fenster / View initialisieren mit den entsprechenden Elementen
	
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
		
		lblHintergrund = new JLabel();
		BufferedImage ic = null;
		URL url = getClass().getResource("/Resources/Hintergrund.png");
		try {
			 ic = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon ic1 = new ImageIcon(ic);
		
		lblHintergrund.setIcon((Icon) ic1);
		lblHintergrund.setBounds(0, 0, 800, 600);
		frmSpeicherrechnung.getContentPane().add(lblHintergrund);
	
	}
}
