
package Rechnung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import BackgroundAnimation.Movement;
import FontHandler.FontHandler;

import java.awt.Color;


/**
 * Grafische Benutzeroberfläche um die Rechnung mit den einzelnen Positionen und Daten darzustellen
 * @author Matthias Westermeyer
 *
 */
public class RechnungAnzeigenView {

	// benötigte Variablen deklarieren
	
	private JFrame frame;
	private JLabel lblRechnungsnummer;
	private JLabel lblRechnungsdatum;
	private JLabel lblKartname;
	private JLabel lblStreckenname;
	private JLabel lblBenutzername;
	private JLabel lblArtikel;
	private JLabel lblBezahlmethode;
	private JLabel lblRechnungsbetrag;
	private JLabel lblPremium;
	private JLabel lblHintergrund;
	private JButton btnZuruck;
	
	

	/**
	 * Zugriff auf die View
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechnungAnzeigenView window = new RechnungAnzeigenView();
					window.frame.setVisible(true);
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
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setResizable(false);
		frame.setTitle("Rechnung");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		lblRechnungsnummer = new JLabel("Rechnungsnummer:");
		lblRechnungsnummer.setFont(customFont12f);
		lblRechnungsnummer.setBounds(33, 26, 250, 45);
		frame.getContentPane().add(lblRechnungsnummer);
		
		lblRechnungsdatum = new JLabel("Rechnungsdatum:");
		lblRechnungsdatum.setFont(customFont12f);
		lblRechnungsdatum.setBounds(435, 26, 250, 45);
		frame.getContentPane().add(lblRechnungsdatum);
		
		lblKartname = new JLabel("Kartname:");
		lblKartname.setFont(customFont12f);
		lblKartname.setBounds(33, 260, 250, 45);
		frame.getContentPane().add(lblKartname);
		
		lblStreckenname = new JLabel("Streckenname:");
		lblStreckenname.setFont(customFont12f);
		lblStreckenname.setBounds(33, 204, 250, 45);
		frame.getContentPane().add(lblStreckenname);
		
		lblBenutzername = new JLabel("Benutzername:");
		lblBenutzername.setFont(customFont12f);
		lblBenutzername.setBounds(33, 82, 250, 45);
		frame.getContentPane().add(lblBenutzername);
		
		lblArtikel = new JLabel("Artikel");
		lblArtikel.setFont(customFont12f);
		lblArtikel.setForeground(Color.BLACK);
		lblArtikel.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtikel.setBounds(33, 161, 74, 32);
		frame.getContentPane().add(lblArtikel);
		
		lblBezahlmethode = new JLabel("Bezahlmethode:");
		lblBezahlmethode.setFont(customFont12f);
		lblBezahlmethode.setBounds(33, 419, 250, 45);
		frame.getContentPane().add(lblBezahlmethode);
		
		lblRechnungsbetrag = new JLabel("Rechnungsbetrag:");
		lblRechnungsbetrag.setFont(customFont12f);
		lblRechnungsbetrag.setBounds(31, 475, 250, 45);
		frame.getContentPane().add(lblRechnungsbetrag);
		
		lblPremium = new JLabel("Premium:");
		lblPremium.setFont(customFont12f);
		lblPremium.setBounds(33, 316, 250, 45);
		frame.getContentPane().add(lblPremium);
		
		btnZuruck = new JButton("Zurück");
		btnZuruck.setBounds(700, 500, 80, 40);
		frame.getContentPane().add(btnZuruck);
		
		lblHintergrund = new JLabel("");
		lblHintergrund.setVisible(false);
		lblHintergrund.setOpaque(true);
		lblHintergrund.setBounds(0, 0, 794, 571);
		getFrame().getContentPane().add(lblHintergrund);

		Movement m = new Movement(10);

		BufferedImage image = null;
		try {
			URL url = getClass().getResource("/Resources/Hintergrund.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		m.label.setBufferedImage(image, 0);

		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		getFrame().getContentPane().add(m.label);
	}

	public JButton getBtnZuruck() {
		return btnZuruck;
	}

	public void setBtnZuruck(JButton btnZuruck) {
		this.btnZuruck = btnZuruck;
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
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

	public JLabel getLblStreckenname() {
		return lblStreckenname;
	}

	public void setLblStreckenname(JLabel lblStreckenname) {
		this.lblStreckenname = lblStreckenname;
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
}
