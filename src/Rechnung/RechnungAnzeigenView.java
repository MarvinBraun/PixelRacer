
package Rechnung;

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

import FontHandler.FontHandler;

import java.awt.Color;


/**
 * Grafische Benutzeroberfläche um die Rechnung mit den einzelnen Positionen und Daten darzustellen
 * @author Matthias Westermeyer
 *
 */
public class RechnungAnzeigenView {

	// benötigte Variablen deklarieren
	
	JFrame frmRechnungsübersicht;
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
	private JButton btnZuruck;
	
	
	// getter und setter Methoden der Variablen

	public JFrame getFrmRechnungsübersicht() {
		return frmRechnungsübersicht;
	}

	public void setFrmRechnungsübersicht(JFrame frmRechnungsübersicht) {
		this.frmRechnungsübersicht = frmRechnungsübersicht;
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
	 * Zugriff auf die View
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechnungAnzeigenView window = new RechnungAnzeigenView();
					window.frmRechnungsübersicht.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktor
	 * Create the application.
	 */
	
	
	public RechnungAnzeigenView() {
		initialize();
	}

	/**
	 * Fenster / View initialisieren mit den entsprechenden Elementen
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
	
		Font customFont12f = FontHandler.registriereSchriftart(12f);
		
		frmRechnungsübersicht = new JFrame();
		frmRechnungsübersicht.getContentPane().setForeground(Color.BLACK);
		frmRechnungsübersicht.setResizable(false);
		frmRechnungsübersicht.setTitle("Rechnung");
		frmRechnungsübersicht.setBounds(100, 100, 800, 600);
		frmRechnungsübersicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechnungsübersicht.getContentPane().setLayout(null);
		
		lblRechnungsnummer = new JLabel("Rechnungsnummer:");
		lblRechnungsnummer.setFont(customFont12f);
		lblRechnungsnummer.setBounds(33, 26, 250, 45);
		frmRechnungsübersicht.getContentPane().add(lblRechnungsnummer);
		
		lblRechnungsdatum = new JLabel("Rechnungsdatum:");
		lblRechnungsdatum.setFont(customFont12f);
		lblRechnungsdatum.setBounds(435, 26, 250, 45);
		frmRechnungsübersicht.getContentPane().add(lblRechnungsdatum);
		
		lblKartname = new JLabel("Kartname:");
		lblKartname.setFont(customFont12f);
		lblKartname.setBounds(33, 260, 250, 45);
		frmRechnungsübersicht.getContentPane().add(lblKartname);
		
		lblStreckenname_1 = new JLabel("Streckenname:");
		lblStreckenname_1.setFont(customFont12f);
		lblStreckenname_1.setBounds(33, 204, 250, 45);
		frmRechnungsübersicht.getContentPane().add(lblStreckenname_1);
		
		lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setFont(customFont12f);
		lblBenutzername.setBounds(33, 82, 250, 45);
		frmRechnungsübersicht.getContentPane().add(lblBenutzername);
		
		lblArtikel = new JLabel("Artikel");
		lblArtikel.setFont(customFont12f);
		lblArtikel.setForeground(Color.BLACK);
		lblArtikel.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtikel.setBounds(33, 161, 74, 32);
		frmRechnungsübersicht.getContentPane().add(lblArtikel);
		
		lblBezahlmethode = new JLabel("Bezahlmethode:");
		lblBezahlmethode.setFont(customFont12f);
		lblBezahlmethode.setBounds(33, 419, 250, 45);
		frmRechnungsübersicht.getContentPane().add(lblBezahlmethode);
		
		lblRechnungsbetrag = new JLabel("Rechnungsbetrag:");
		lblRechnungsbetrag.setFont(customFont12f);
		lblRechnungsbetrag.setBounds(31, 475, 250, 45);
		frmRechnungsübersicht.getContentPane().add(lblRechnungsbetrag);
		
		lblPremium = new JLabel("Premium:");
		lblPremium.setFont(customFont12f);
		lblPremium.setBounds(33, 316, 250, 45);
		frmRechnungsübersicht.getContentPane().add(lblPremium);
		
		lblHintergrund = new JLabel();
		lblHintergrund.setIcon(new ImageIcon(RechnungAnzeigenView.class.getResource("/Resources/Hintergrund.png")));
		lblHintergrund.setBounds(0, 0, 800, 600);
		frmRechnungsübersicht.getContentPane().add(lblHintergrund);
		
		btnZuruck = new JButton("Zurück");
		btnZuruck.setBounds(700, 500, 80, 40);
		frmRechnungsübersicht.getContentPane().add(btnZuruck);
	}

	public JButton getBtnZuruck() {
		return btnZuruck;
	}

	public void setBtnZuruck(JButton btnZuruck) {
		this.btnZuruck = btnZuruck;
	}
}
