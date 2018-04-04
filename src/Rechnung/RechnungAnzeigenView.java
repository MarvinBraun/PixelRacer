
package Rechnung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
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
 * Grafische Benutzeroberfläche um die Rechnung mit den einzelnen Positionen und
 * Daten darzustellen
 * 
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
	private JButton btnZuruck;

	private JLabel lblRechnungsnummerfeld;
	private JLabel lblRechnungsdatumfeld;
	private JLabel lblKartnamefeld;
	private JLabel lblStreckennamefeld;
	private JLabel lblBenutzernamefeld;
	private JLabel lblArtikelfeld;
	private JLabel lblBezahlmethodefeld;
	private JLabel lblRechnungsbetragfeld;

	/**
	 * Zugriff auf die View Launch the application.
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
	 * Konstruktor Create the application.
	 */

	public RechnungAnzeigenView() {
		initialize();
	}

	/**
	 * Fenster / View initialisieren mit den entsprechenden Elementen Initialize
	 * the contents of the frame.
	 */

	private void initialize() {

		Font customFont12f = FontHandler.registriereSchriftart(12f);

		setFrame(new JFrame());
		getFrame().getContentPane().setForeground(Color.BLACK);
		getFrame().setResizable(false);
		getFrame().setTitle("Rechnung");
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);
		getFrame().setVisible(true);

		setLblRechnungsnummer(new JLabel("Rechnungsnummer:"));
		getLblRechnungsnummer().setFont(customFont12f);
		getLblRechnungsnummer().setBounds(33, 26, 250, 45);
		getFrame().getContentPane().add(lblRechnungsnummer);

		setLblRechnungsdatum(new JLabel("Rechnungsdatum:"));
		getLblRechnungsdatum().setFont(customFont12f);
		getLblRechnungsdatum().setBounds(435, 26, 250, 45);
		getFrame().getContentPane().add(lblRechnungsdatum);

		setLblKartname(new JLabel("Kartname:"));
		getLblKartname().setFont(customFont12f);
		getLblKartname().setBounds(33, 260, 250, 45);
		getFrame().getContentPane().add(lblKartname);

		setLblStreckenname(new JLabel("Streckenname:"));
		getLblStreckenname().setFont(customFont12f);
		getLblStreckenname().setBounds(33, 204, 250, 45);
		getFrame().getContentPane().add(lblStreckenname);

		setLblBenutzername(new JLabel("Benutzername:"));
		getLblBenutzername().setFont(customFont12f);
		getLblBenutzername().setBounds(33, 82, 250, 45);
		getFrame().getContentPane().add(lblBenutzername);

		setLblArtikel(new JLabel("Artikel:"));
		getLblArtikel().setFont(customFont12f);
		getLblArtikel().setForeground(Color.BLACK);
		getLblArtikel().setHorizontalAlignment(SwingConstants.LEFT);
		getLblArtikel().setBounds(33, 161, 74, 32);
		getFrame().getContentPane().add(lblArtikel);

		setLblBezahlmethode(new JLabel("Bezahlmethode:"));
		getLblBezahlmethode().setFont(customFont12f);
		getLblBezahlmethode().setBounds(33, 419, 250, 45);
		getFrame().getContentPane().add(lblBezahlmethode);

		setLblRechnungsbetrag(new JLabel("Rechnungsbetrag:"));
		getLblRechnungsbetrag().setFont(customFont12f);
		getLblRechnungsbetrag().setBounds(31, 475, 250, 45);
		getFrame().getContentPane().add(lblRechnungsbetrag);

		setLblRechnungsnummerfeld(new JLabel());
		getLblRechnungsnummerfeld().setFont(customFont12f);
		getLblRechnungsnummerfeld().setBounds(200, 26, 250, 45);
		getFrame().getContentPane().add(lblRechnungsnummerfeld);

		setLblRechnungsdatumfeld(new JLabel());
		getLblRechnungsdatumfeld().setFont(customFont12f);
		getLblRechnungsdatumfeld().setBounds(590, 26, 250, 45);
		getFrame().getContentPane().add(lblRechnungsdatumfeld);

		setLblKartnamefeld(new JLabel());
		getLblKartnamefeld().setFont(customFont12f);
		getLblKartnamefeld().setBounds(200, 260, 250, 45);
		getFrame().getContentPane().add(lblKartnamefeld);

		setLblStreckennamefeld(new JLabel());
		getLblStreckennamefeld().setFont(customFont12f);
		getLblStreckennamefeld().setBounds(200, 204, 250, 45);
		getFrame().getContentPane().add(lblStreckennamefeld);

		setLblBenutzernamefeld(new JLabel());
		getLblBenutzernamefeld().setFont(customFont12f);
		getLblBenutzernamefeld().setBounds(200, 82, 250, 45);
		getFrame().getContentPane().add(lblBenutzernamefeld);

		setLblArtikelfeld(new JLabel());
		getLblArtikelfeld().setFont(customFont12f);
		getLblArtikelfeld().setBounds(200, 161, 250, 45);
		getFrame().getContentPane().add(lblArtikelfeld);

		setLblBezahlmethodefeld(new JLabel());
		getLblBezahlmethodefeld().setFont(customFont12f);
		getLblBezahlmethodefeld().setBounds(200, 419, 250, 45);
		getFrame().getContentPane().add(lblBezahlmethodefeld);

		setLblRechnungsbetragfeld(new JLabel());
		getLblRechnungsbetragfeld().setFont(customFont12f);
		getLblRechnungsbetragfeld().setBounds(200, 475, 250, 45);
		getFrame().getContentPane().add(lblRechnungsbetragfeld);
		
		setBtnZuruck(new JButton("Zurueck"));
		getBtnZuruck().setBounds(650, 500, 100, 40);
		getBtnZuruck().setFont(customFont12f);
		getBtnZuruck().setFocusable(false);
		getBtnZuruck().setBorderPainted(false);
		getBtnZuruck().setOpaque(false);
		getBtnZuruck().setBackground(SystemColor.activeCaption);
		getFrame().getContentPane().add(btnZuruck);

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

	public void setLblKartname(JLabel jLabel) {
		this.lblKartname = jLabel;
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

	public JLabel getLblRechnungsnummerfeld() {
		return lblRechnungsnummerfeld;
	}

	public JLabel getLblRechnungsdatumfeld() {
		return lblRechnungsdatumfeld;
	}

	public JLabel getLblKartnamefeld() {
		return lblKartnamefeld;
	}

	public JLabel getLblStreckennamefeld() {
		return lblStreckennamefeld;
	}

	public JLabel getLblBenutzernamefeld() {
		return lblBenutzernamefeld;
	}

	public JLabel getLblArtikelfeld() {
		return lblArtikelfeld;
	}

	public JLabel getLblBezahlmethodefeld() {
		return lblBezahlmethodefeld;
	}

	public JLabel getLblRechnungsbetragfeld() {
		return lblRechnungsbetragfeld;
	}

	public void setLblRechnungsnummerfeld(JLabel lblRechnungsnummerfeld) {
		this.lblRechnungsnummerfeld = lblRechnungsnummerfeld;
	}

	public void setLblRechnungsdatumfeld(JLabel lblRechnungsdatumfeld) {
		this.lblRechnungsdatumfeld = lblRechnungsdatumfeld;
	}

	public void setLblKartnamefeld(JLabel lblKartnamefeld) {
		this.lblKartnamefeld = lblKartnamefeld;
	}

	public void setLblStreckennamefeld(JLabel lblStreckennamefeld) {
		this.lblStreckennamefeld = lblStreckennamefeld;
	}

	public void setLblBenutzernamefeld(JLabel lblBenutzernamefeld) {
		this.lblBenutzernamefeld = lblBenutzernamefeld;
	}

	public void setLblArtikelfeld(JLabel lblArtikelfeld) {
		this.lblArtikelfeld = lblArtikelfeld;
	}

	public void setLblBezahlmethodefeld(JLabel lblBezahlmethodefeld) {
		this.lblBezahlmethodefeld = lblBezahlmethodefeld;
	}

	public void setLblRechnungsbetragfeld(JLabel lblRechnungsbetragfeld) {
		this.lblRechnungsbetragfeld = lblRechnungsbetragfeld;
	}
}
