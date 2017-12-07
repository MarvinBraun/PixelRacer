package Rechnung;

//author Matthias Westermeyer

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;

public class anzeigenRechnung_ansicht2 {

	private JFrame frmRechnungsbersicht;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anzeigenRechnung_ansicht2 window = new anzeigenRechnung_ansicht2();
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
	public anzeigenRechnung_ansicht2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRechnungsbersicht = new JFrame();
		frmRechnungsbersicht.getContentPane().setForeground(Color.BLACK);
		frmRechnungsbersicht.setResizable(false);
		frmRechnungsbersicht.setTitle("Rechnung");
		frmRechnungsbersicht.setBounds(100, 100, 800, 600);
		frmRechnungsbersicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechnungsbersicht.getContentPane().setLayout(null);
		
		JLabel lblRechnungsnummer = new JLabel("Rechnungsnummer:");
		lblRechnungsnummer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechnungsnummer.setBounds(33, 26, 166, 45);
		frmRechnungsbersicht.getContentPane().add(lblRechnungsnummer);
		
		JLabel lblRechnungsdatum = new JLabel("Rechnungsdatum:");
		lblRechnungsdatum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechnungsdatum.setBounds(435, 26, 166, 45);
		frmRechnungsbersicht.getContentPane().add(lblRechnungsdatum);
		
		JLabel lblStreckenname = new JLabel("Kartname:");
		lblStreckenname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStreckenname.setBounds(33, 260, 145, 45);
		frmRechnungsbersicht.getContentPane().add(lblStreckenname);
		
		JLabel lblStreckenname_1 = new JLabel("Streckenname:");
		lblStreckenname_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStreckenname_1.setBounds(33, 204, 145, 45);
		frmRechnungsbersicht.getContentPane().add(lblStreckenname_1);
		
		JLabel lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBenutzername.setBounds(33, 82, 145, 45);
		frmRechnungsbersicht.getContentPane().add(lblBenutzername);
		
		JLabel lblArtikel = new JLabel("Artikel");
		lblArtikel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArtikel.setForeground(Color.BLACK);
		lblArtikel.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtikel.setBounds(33, 161, 74, 32);
		frmRechnungsbersicht.getContentPane().add(lblArtikel);
		
		JLabel lblBezahlmethode = new JLabel("Bezahlmethode:");
		lblBezahlmethode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezahlmethode.setBounds(33, 419, 145, 45);
		frmRechnungsbersicht.getContentPane().add(lblBezahlmethode);
		
		JLabel lblRechnungsbetrag = new JLabel("Rechnungsbetrag:");
		lblRechnungsbetrag.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechnungsbetrag.setBounds(31, 475, 182, 45);
		frmRechnungsbersicht.getContentPane().add(lblRechnungsbetrag);
		
		JLabel lblPremium = new JLabel("Premium:");
		lblPremium.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPremium.setBounds(33, 316, 145, 45);
		frmRechnungsbersicht.getContentPane().add(lblPremium);
	}
}
