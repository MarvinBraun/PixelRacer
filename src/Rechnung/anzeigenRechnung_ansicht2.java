package Rechnung;

//author Matthias Westermeyer

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
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

	// ben�tigte Variablen deklarieren
	
	JFrame frmRechnungs�bersicht;
	JLabel lblRechnungsnummer;
	JLabel lblRechnungsdatum;
	JLabel lblKartname;
	JLabel lblStreckenname_1;
	JLabel lblBenutzername;
	JLabel lblArtikel;
	JLabel lblBezahlmethode;
	JLabel lblRechnungsbetrag;
	JLabel lblPremium;
	JLabel lblHintergrund;
	
	
	// getter und setter Methoden der Variablen

	public JFrame getFrmRechnungs�bersicht() {
		return frmRechnungs�bersicht;
	}

	public void setFrmRechnungs�bersicht(JFrame frmRechnungs�bersicht) {
		this.frmRechnungs�bersicht = frmRechnungs�bersicht;
	}

	public JLabel getLblRechnungsnummer() {
		return lblRechnungsnummer;
	}

	public void setLblRechnungsnummer(JLabel lblRechnungsnummer) {
		this.lblRechnungsnummer = lblRechnungsnummer;
	}

	public JLabel getLblRechnungsdatum() {
		return lblRechnungsdatum;
	}

	public void setLblRechnungsdatum(JLabel lblRechnungsdatum) {
		this.lblRechnungsdatum = lblRechnungsdatum;
	}

	public JLabel getLblKartname() {
		return lblKartname;
	}

	public void setLblKartname(JLabel lblKartname) {
		this.lblKartname = lblKartname;
	}

	public JLabel getLblStreckenname_1() {
		return lblStreckenname_1;
	}

	public void setLblStreckenname_1(JLabel lblStreckenname_1) {
		this.lblStreckenname_1 = lblStreckenname_1;
	}

	public JLabel getLblBenutzername() {
		return lblBenutzername;
	}

	public void setLblBenutzername(JLabel lblBenutzername) {
		this.lblBenutzername = lblBenutzername;
	}

	public JLabel getLblArtikel() {
		return lblArtikel;
	}

	public void setLblArtikel(JLabel lblArtikel) {
		this.lblArtikel = lblArtikel;
	}

	public JLabel getLblBezahlmethode() {
		return lblBezahlmethode;
	}

	public void setLblBezahlmethode(JLabel lblBezahlmethode) {
		this.lblBezahlmethode = lblBezahlmethode;
	}

	public JLabel getLblRechnungsbetrag() {
		return lblRechnungsbetrag;
	}

	public void setLblRechnungsbetrag(JLabel lblRechnungsbetrag) {
		this.lblRechnungsbetrag = lblRechnungsbetrag;
	}

	public JLabel getLblPremium() {
		return lblPremium;
	}

	public void setLblPremium(JLabel lblPremium) {
		this.lblPremium = lblPremium;
	}

	/**
	 * Launch the application.
	 */
	// Zugriff auf die View
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anzeigenRechnung_ansicht2 window = new anzeigenRechnung_ansicht2();
					window.frmRechnungs�bersicht.setVisible(true);
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
	
	public anzeigenRechnung_ansicht2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	// Fenster / View initialisieren mit den entsprechenden Elementen
	
	private void initialize() {
		frmRechnungs�bersicht = new JFrame();
		frmRechnungs�bersicht.getContentPane().setForeground(Color.BLACK);
		frmRechnungs�bersicht.setResizable(false);
		frmRechnungs�bersicht.setTitle("Rechnung");
		frmRechnungs�bersicht.setBounds(100, 100, 800, 600);
		frmRechnungs�bersicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechnungs�bersicht.getContentPane().setLayout(null);
		
		lblRechnungsnummer = new JLabel("Rechnungsnummer:");
		lblRechnungsnummer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechnungsnummer.setBounds(33, 26, 166, 45);
		frmRechnungs�bersicht.getContentPane().add(lblRechnungsnummer);
		
		lblRechnungsdatum = new JLabel("Rechnungsdatum:");
		lblRechnungsdatum.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechnungsdatum.setBounds(435, 26, 166, 45);
		frmRechnungs�bersicht.getContentPane().add(lblRechnungsdatum);
		
		lblKartname = new JLabel("Kartname:");
		lblKartname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKartname.setBounds(33, 260, 145, 45);
		frmRechnungs�bersicht.getContentPane().add(lblKartname);
		
		lblStreckenname_1 = new JLabel("Streckenname:");
		lblStreckenname_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStreckenname_1.setBounds(33, 204, 145, 45);
		frmRechnungs�bersicht.getContentPane().add(lblStreckenname_1);
		
		lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBenutzername.setBounds(33, 82, 145, 45);
		frmRechnungs�bersicht.getContentPane().add(lblBenutzername);
		
		lblArtikel = new JLabel("Artikel");
		lblArtikel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArtikel.setForeground(Color.BLACK);
		lblArtikel.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtikel.setBounds(33, 161, 74, 32);
		frmRechnungs�bersicht.getContentPane().add(lblArtikel);
		
		lblBezahlmethode = new JLabel("Bezahlmethode:");
		lblBezahlmethode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBezahlmethode.setBounds(33, 419, 145, 45);
		frmRechnungs�bersicht.getContentPane().add(lblBezahlmethode);
		
		lblRechnungsbetrag = new JLabel("Rechnungsbetrag:");
		lblRechnungsbetrag.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRechnungsbetrag.setBounds(31, 475, 182, 45);
		frmRechnungs�bersicht.getContentPane().add(lblRechnungsbetrag);
		
		lblPremium = new JLabel("Premium:");
		lblPremium.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPremium.setBounds(33, 316, 145, 45);
		frmRechnungs�bersicht.getContentPane().add(lblPremium);
		
		lblHintergrund = new JLabel();
		lblHintergrund.setIcon(new ImageIcon("src/Resources/Hintergrund.png"));
		lblHintergrund.setBounds(0, 0, 800, 600);
		frmRechnungs�bersicht.getContentPane().add(lblHintergrund);
	}
}
