package ProfilKunde;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import BackgroundAnimation.Movement;
import FontHandler.FontHandler;
import Nutzer.Nutzerverwaltung;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Grafische Benutzeroberfläche für das Profil eines Kunden/Spielers. 
 * 
 * @author Robin Demmler
 *
 */

public class ProfilKundeAnsicht{
	/**
	 * Deklarieren benötigter Variablen.
	 */
	private JFrame frmPixelRacer;

	private JLabel lblNewLabel;
	private JLabel lblNachname;
	private JLabel lblStatus;
	private JLabel lblPunktestand;
	private JLabel lblFahrtenAbsolviert;
	private JLabel lblRennenAlsErster;
	private JLabel lblRennenAlsZweiter;
	private JLabel lblRennenAlsDritter;
	private JLabel lblHintergrund;
	
	private JButton btnGetPremium;
	private JButton btnProfilBearbeiten;
	private JButton btnZurueck;
	private JButton btnRechnungsverw;
	
	private JLabel lblSetVorname;
	private JLabel lblSetNachname;
	private JLabel lblSetStatus;
	private JLabel lblSetPunktestand;
	private JLabel lblSetGesFahrten;
	private JLabel lblSetAlsErster;
	private JLabel lblSetAlsZweiter;
	private JLabel lblSetAlsDritter;		
	/**
	 * Main-Methode führt GUI aus.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilKundeAnsicht window = new ProfilKundeAnsicht();
					window.getFrmPixelRacer().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktor initialisiert das Objekt und befüllt es über die initialize()-Methode.
	 */
	public ProfilKundeAnsicht() {
		initialize();
	}
	/**
	 * initialize() Initialisiert das Fenster und die Inhalte des JFrames.
	 */
	private void initialize() {
		
		Font customFont30f = FontHandler.registriereSchriftart(30f); // Laden der Schriftart durch Klasse FontHandler
		
		setFrmPixelRacer(new JFrame());
		getFrmPixelRacer().setTitle("Pixel Racer - Spielerprofil " + Nutzerverwaltung.getangKunde().getnutzername());
		getFrmPixelRacer().setBounds(100, 100, 800, 600);
		getFrmPixelRacer().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmPixelRacer().setResizable(false);
		getFrmPixelRacer().getContentPane().setLayout(null);
		getFrmPixelRacer().setVisible(true);
		
		setLblNewLabel(new JLabel("Vorname:"));
		getLblNewLabel().setFont(customFont30f);
		getLblNewLabel().setBounds(286, 73, 64, 23);
		getFrmPixelRacer().getContentPane().add(getLblNewLabel());
		
		setLblNachname(new JLabel("Nachname:"));
		getLblNachname().setFont(customFont30f);
		getLblNachname().setBounds(278, 98, 72, 23);
		getFrmPixelRacer().getContentPane().add(getLblNachname());
		
		setLblStatus(new JLabel("Status:"));
		getLblStatus().setFont(customFont30f);
		getLblStatus().setBounds(297, 123, 53, 23);
		getFrmPixelRacer().getContentPane().add(getLblStatus());
		
		setLblPunktestand(new JLabel("Punktestand:"));
		getLblPunktestand().setFont(customFont30f);
		getLblPunktestand().setBounds(268, 148, 82, 23);
		getFrmPixelRacer().getContentPane().add(getLblPunktestand());
		
		setLblFahrtenAbsolviert(new JLabel("Fahrten absolviert:"));
		getLblFahrtenAbsolviert().setFont(customFont30f);
		getLblFahrtenAbsolviert().setBounds(240, 213, 110, 23);
		getFrmPixelRacer().getContentPane().add(getLblFahrtenAbsolviert());
		
		setLblRennenAlsErster(new JLabel("Rennen als Erster abgeschlossen:"));
		getLblRennenAlsErster().setFont(customFont30f);
		getLblRennenAlsErster().setBounds(170, 296, 209, 23);
		getFrmPixelRacer().getContentPane().add(getLblRennenAlsErster());
		
		setLblRennenAlsZweiter(new JLabel("Rennen als Zweiter abgeschlossen:"));
		getLblRennenAlsZweiter().setFont(customFont30f);
		getLblRennenAlsZweiter().setBounds(163, 321, 227, 23);
		getFrmPixelRacer().getContentPane().add(getLblRennenAlsZweiter());
		
		setLblRennenAlsDritter(new JLabel("Rennen als Dritter abgeschlossen:"));
		getLblRennenAlsDritter().setFont(customFont30f);
		getLblRennenAlsDritter().setBounds(170, 346, 220, 23);
		getFrmPixelRacer().getContentPane().add(getLblRennenAlsDritter());
		
		setBtnGetPremium(new JButton("Werde jetzt Premium-Kunde!"));
		getBtnGetPremium().setFont(customFont30f);
		getBtnGetPremium().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getBtnGetPremium().setBounds(66, 415, 313, 33);
		getFrmPixelRacer().getContentPane().add(getBtnGetPremium());
		
		setBtnProfilBearbeiten(new JButton("Profil bearbeiten"));
		getBtnProfilBearbeiten().setFont(customFont30f);
		getBtnProfilBearbeiten().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		getBtnProfilBearbeiten().setBounds(481, 415, 179, 33);
		getFrmPixelRacer().getContentPane().add(getBtnProfilBearbeiten());
		
		setBtnZurueck(new JButton("Zur\u00FCck"));
		getBtnZurueck().setFont(customFont30f);
		getBtnZurueck().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getBtnZurueck().setBounds(515, 490, 116, 33);
		getFrmPixelRacer().getContentPane().add(getBtnZurueck());
		
		setBtnRechnungsverw(new JButton("Zur Rechnungsverwaltung"));
		getBtnRechnungsverw().setFont(customFont30f);
		getBtnRechnungsverw().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getBtnRechnungsverw().setBounds(66, 494, 313, 33);
		getFrmPixelRacer().getContentPane().add(getBtnRechnungsverw());
		
		setLblSetVorname(new JLabel("New label"));
		getLblSetVorname().setFont(customFont30f);
		getLblSetVorname().setBounds(481, 75, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetVorname());
		
		setLblSetNachname(new JLabel("New label"));
		getLblSetNachname().setFont(customFont30f);
		getLblSetNachname().setBounds(481, 100, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetNachname());
		
		setLblSetStatus(new JLabel("New label"));
		getLblSetStatus().setFont(customFont30f);
		getLblSetStatus().setBounds(481, 125, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetStatus());
		
		setLblSetPunktestand(new JLabel("New label"));
		getLblSetPunktestand().setFont(customFont30f);
		getLblSetPunktestand().setBounds(481, 150, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetPunktestand());
		
		setLblSetGesFahrten(new JLabel("New label"));
		getLblSetGesFahrten().setFont(customFont30f);
		getLblSetGesFahrten().setBounds(481, 215, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetGesFahrten());
		
		setLblSetAlsErster(new JLabel("New label"));
		getLblSetAlsErster().setFont(customFont30f);
		getLblSetAlsErster().setBounds(481, 296, 212, 23);
		getFrmPixelRacer().getContentPane().add(getLblSetAlsErster());
		
		setLblSetAlsZweiter(new JLabel("New label"));
		getLblSetAlsZweiter().setFont(customFont30f);
		getLblSetAlsZweiter().setBounds(481, 323, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetAlsZweiter());
		
		setLblSetAlsDritter(new JLabel("New label"));
		getLblSetAlsDritter().setFont(customFont30f);
		getLblSetAlsDritter().setBounds(481, 348, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetAlsDritter());
		
		setLblHintergrund(new JLabel(""));
		getLblHintergrund().setFont(customFont30f);
		getLblHintergrund().setVisible(false);		
		getLblHintergrund().setBounds(0, 0, 794, 571);
		getFrmPixelRacer().getContentPane().add(lblHintergrund);
		
				
		Movement m = new Movement(10); // Hintergrund-Image dem Hintergurnd-Label zuweisen, Bewegung festlegen & dem Frame hinzufügen
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/Hintergrund.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		m.label.setBufferedImage(image,0);
		
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		getFrmPixelRacer().getContentPane().add(m.label);		
	}
	/**
	 * Getter & Setter für die verwendeten Variablen 
	 */
	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}

	public JButton getBtnRechnungsverw() {
		return btnRechnungsverw;
	}

	public void setBtnRechnungsverw(JButton btnRechnungsverw) {
		this.btnRechnungsverw = btnRechnungsverw;
	}

	public JFrame getFrmPixelRacer() {
		return frmPixelRacer;
	}

	public void setFrmPixelRacer(JFrame frmPixelRacer) {
		this.frmPixelRacer = frmPixelRacer;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JLabel getLblNachname() {
		return lblNachname;
	}

	public void setLblNachname(JLabel lblNachname) {
		this.lblNachname = lblNachname;
	}

	public JLabel getLblStatus() {
		return lblStatus;
	}

	public void setLblStatus(JLabel lblStatus) {
		this.lblStatus = lblStatus;
	}

	public JLabel getLblPunktestand() {
		return lblPunktestand;
	}

	public void setLblPunktestand(JLabel lblPunktestand) {
		this.lblPunktestand = lblPunktestand;
	}

	public JLabel getLblFahrtenAbsolviert() {
		return lblFahrtenAbsolviert;
	}

	public void setLblFahrtenAbsolviert(JLabel lblFahrtenAbsolviert) {
		this.lblFahrtenAbsolviert = lblFahrtenAbsolviert;
	}

	
	public JLabel getLblRennenAlsErster() {
		return lblRennenAlsErster;
	}

	public void setLblRennenAlsErster(JLabel lblRennenAlsErster) {
		this.lblRennenAlsErster = lblRennenAlsErster;
	}

	public JLabel getLblRennenAlsZweiter() {
		return lblRennenAlsZweiter;
	}

	public void setLblRennenAlsZweiter(JLabel lblRennenAlsZweiter) {
		this.lblRennenAlsZweiter = lblRennenAlsZweiter;
	}

	public JLabel getLblRennenAlsDritter() {
		return lblRennenAlsDritter;
	}

	public void setLblRennenAlsDritter(JLabel lblRennenAlsDritter) {
		this.lblRennenAlsDritter = lblRennenAlsDritter;
	}

	public JButton getBtnGetPremium() {
		return btnGetPremium;
	}

	public void setBtnGetPremium(JButton btnGetPremium) {
		this.btnGetPremium = btnGetPremium;
	}

	public JButton getBtnProfilBearbeiten() {
		return btnProfilBearbeiten;
	}

	public void setBtnProfilBearbeiten(JButton btnProfilBearbeiten) {
		this.btnProfilBearbeiten = btnProfilBearbeiten;
	}

	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
	}

	public JLabel getLblSetVorname() {
		return lblSetVorname;
	}

	public void setLblSetVorname(JLabel lblSetVorname) {
		this.lblSetVorname = lblSetVorname;
	}

	public JLabel getLblSetNachname() {
		return lblSetNachname;
	}

	public void setLblSetNachname(JLabel lblSetNachname) {
		this.lblSetNachname = lblSetNachname;
	}

	public JLabel getLblSetStatus() {
		return lblSetStatus;
	}

	public void setLblSetStatus(JLabel lblSetStatus) {
		this.lblSetStatus = lblSetStatus;
	}

	public JLabel getLblSetPunktestand() {
		return lblSetPunktestand;
	}

	public void setLblSetPunktestand(JLabel lblSetPunktestand) {
		this.lblSetPunktestand = lblSetPunktestand;
	}

	public JLabel getLblSetGesFahrten() {
		return lblSetGesFahrten;
	}

	public void setLblSetGesFahrten(JLabel lblSetGesFahrten) {
		this.lblSetGesFahrten = lblSetGesFahrten;
	}

	public JLabel getLblSetAlsErster() {
		return lblSetAlsErster;
	}

	public void setLblSetAlsErster(JLabel lblSetAlsErster) {
		this.lblSetAlsErster = lblSetAlsErster;
	}

	public JLabel getLblSetAlsZweiter() {
		return lblSetAlsZweiter;
	}

	public void setLblSetAlsZweiter(JLabel lblSetAlsZweiter) {
		this.lblSetAlsZweiter = lblSetAlsZweiter;
	}

	public JLabel getLblSetAlsDritter() {
		return lblSetAlsDritter;
	}

	public void setLblSetAlsDritter(JLabel lblSetAlsDritter) {
		this.lblSetAlsDritter = lblSetAlsDritter;
	}
}
