//author Matthias Westermeyer

package Rechnung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Rechnungsübersicht {

	private JFrame frmRechnungsbersicht;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rechnungsübersicht window = new Rechnungsübersicht();
					window.frmRechnungsbersicht.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rechnungsübersicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRechnungsbersicht = new JFrame();
		frmRechnungsbersicht.setTitle("Rechnungs\u00FCbersicht");
		frmRechnungsbersicht.setBounds(100, 100, 800, 600);
		frmRechnungsbersicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechnungsbersicht.getContentPane().setLayout(null);
		
		JLabel lblRechnung = new JLabel("Rechnung:");
		lblRechnung.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechnung.setBounds(20, 44, 89, 30);
		frmRechnungsbersicht.getContentPane().add(lblRechnung);
		
		JButton btnAnzeigen = new JButton("anzeigen");
		btnAnzeigen.setBounds(341, 50, 95, 23);
		frmRechnungsbersicht.getContentPane().add(btnAnzeigen);
		
		JButton btnBezahlen = new JButton("bezahlen");
		btnBezahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBezahlen.setBounds(457, 50, 95, 23);
		frmRechnungsbersicht.getContentPane().add(btnBezahlen);
		
		JButton btnSpeichern = new JButton("speichern");
		btnSpeichern.setBounds(569, 50, 95, 23);
		frmRechnungsbersicht.getContentPane().add(btnSpeichern);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(140, 50, 111, 24);
		frmRechnungsbersicht.getContentPane().add(textPane);
	}

}
