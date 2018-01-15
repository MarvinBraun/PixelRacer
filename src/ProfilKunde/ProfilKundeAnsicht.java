package ProfilKunde;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BackgroundAnimation.Movement;
import FontHandler.FontHandler;
import Nutzer.Nutzerverwaltung;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

/**
 * Grafische Benutzeroberflaeche fuer das Profil eines Kunden/Spielers. 
 * 
 * @author Robin Demmler
 *
 */

public class ProfilKundeAnsicht{
	/**
	 * Deklarieren benoetigter Variablen.
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
	 * Main-Methode fuehrt GUI aus.
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
	 * Konstruktor ruft initialize()-Methode auf.
	 */
	public ProfilKundeAnsicht() {
		initialize();
	}
	/**
	 * initialize() Initialisiert das Fenster und die Inhalte des JFrames.
	 */
	private void initialize() {
		
		Font customFont20f = FontHandler.registriereSchriftart(15f); // Laden der Schriftart durch Klasse FontHandler
		
		setFrmPixelRacer(new JFrame());
		getFrmPixelRacer().setTitle("Pixel Racer - Spielerprofil " + Nutzerverwaltung.getangKunde().getnutzername());
		getFrmPixelRacer().setBounds(100, 100, 800, 600);
		getFrmPixelRacer().setDefaultCloseOperation(getFrmPixelRacer().DO_NOTHING_ON_CLOSE);
		getFrmPixelRacer().setResizable(false);
		getFrmPixelRacer().getContentPane().setLayout(null);
		getFrmPixelRacer().setVisible(true);
		getFrmPixelRacer().addWindowListener(new WindowAdapter() {

			  @Override
			  public void windowClosing(WindowEvent we)
			  { 
				  int result = JOptionPane.showConfirmDialog(null,"Moechten sie Pixcel Racer wirklich schliessen?", "Pixcel Racer schliessen?", JOptionPane.YES_NO_OPTION);
				  switch(result) {
				  case JOptionPane.YES_OPTION:
					  System.exit(0);
				  case JOptionPane.NO_OPTION:
					  
				  }
			  }
			});
		
		setLblNewLabel(new JLabel("Vorname:"));
		getLblNewLabel().setFont(customFont20f);
		getLblNewLabel().setBounds(346, 107, 93, 23);
		getFrmPixelRacer().getContentPane().add(getLblNewLabel());
		
		setLblNachname(new JLabel("Nachname:"));
		getLblNachname().setFont(customFont20f);
		getLblNachname().setBounds(338, 132, 101, 23);
		getFrmPixelRacer().getContentPane().add(getLblNachname());
		
		setLblStatus(new JLabel("Status:"));
		getLblStatus().setFont(customFont20f);
		getLblStatus().setBounds(357, 157, 82, 23);
		getFrmPixelRacer().getContentPane().add(getLblStatus());
		
		setLblPunktestand(new JLabel("Punktestand:"));
		getLblPunktestand().setFont(customFont20f);
		getLblPunktestand().setBounds(305, 180, 216, 23);
		getFrmPixelRacer().getContentPane().add(getLblPunktestand());
		
		setLblFahrtenAbsolviert(new JLabel("Fahrten absolviert:"));
		getLblFahrtenAbsolviert().setFont(customFont20f);
		getLblFahrtenAbsolviert().setBounds(236, 253, 241, 23);
		getFrmPixelRacer().getContentPane().add(getLblFahrtenAbsolviert());
		
		setLblRennenAlsErster(new JLabel("Rennen als Erster abgeschlossen:"));
		getLblRennenAlsErster().setFont(customFont20f);
		getLblRennenAlsErster().setBounds(98, 277, 368, 23);
		getFrmPixelRacer().getContentPane().add(getLblRennenAlsErster());
		
		setLblRennenAlsZweiter(new JLabel("Rennen als Zweiter abgeschlossen:"));
		getLblRennenAlsZweiter().setFont(customFont20f);
		getLblRennenAlsZweiter().setBounds(91, 302, 375, 23);
		getFrmPixelRacer().getContentPane().add(getLblRennenAlsZweiter());
		
		setLblRennenAlsDritter(new JLabel("Rennen als Dritter abgeschlossen:"));
		getLblRennenAlsDritter().setFont(customFont20f);
		getLblRennenAlsDritter().setBounds(91, 327, 368, 23);
		getFrmPixelRacer().getContentPane().add(getLblRennenAlsDritter());
		
		setBtnGetPremium(new JButton("Werde jetzt Premium-Kunde!"));
		getBtnGetPremium().setFont(customFont20f);
		getBtnGetPremium().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getBtnGetPremium().setBounds(10, 459, 316, 33);
		getBtnGetPremium().setBorderPainted(false);
		getBtnGetPremium().setOpaque(false);
		getBtnGetPremium().setBackground(SystemColor.activeCaption);
		getBtnGetPremium().setFocusable(false);
		getFrmPixelRacer().getContentPane().add(getBtnGetPremium());
		
		setBtnProfilBearbeiten(new JButton("Profil bearbeiten"));
		getBtnProfilBearbeiten().setFont(customFont20f);
		getBtnProfilBearbeiten().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		getBtnProfilBearbeiten().setBounds(568, 459, 216, 33);
		getBtnProfilBearbeiten().setBorderPainted(false);
		getBtnProfilBearbeiten().setOpaque(false);
		getBtnProfilBearbeiten().setBackground(SystemColor.activeCaption);
		getBtnProfilBearbeiten().setFocusable(false);
		getFrmPixelRacer().getContentPane().add(getBtnProfilBearbeiten());
		
		setBtnZurueck(new JButton("Zurueck"));
		getBtnZurueck().setFont(customFont20f);
		getBtnZurueck().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getBtnZurueck().setBounds(668, 527, 116, 33);
		getBtnZurueck().setBorderPainted(false);
		getBtnZurueck().setOpaque(false);
		getBtnZurueck().setBackground(SystemColor.activeCaption);
		getBtnZurueck().setFocusable(false);
		getFrmPixelRacer().getContentPane().add(getBtnZurueck());
		
		setBtnRechnungsverw(new JButton("Zur Rechnungsverwaltung"));
		getBtnRechnungsverw().setFont(customFont20f);
		getBtnRechnungsverw().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getBtnRechnungsverw().setBounds(10, 527, 288, 33);
		getBtnRechnungsverw().setBorderPainted(false);
		getBtnRechnungsverw().setOpaque(false);
		getBtnRechnungsverw().setBackground(SystemColor.activeCaption);
		getBtnRechnungsverw().setFocusable(false);
		getFrmPixelRacer().getContentPane().add(getBtnRechnungsverw());
		
		setLblSetVorname(new JLabel("New label"));
		getLblSetVorname().setFont(customFont20f);
		getLblSetVorname().setBounds(490, 107, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetVorname());
		
		setLblSetNachname(new JLabel("New label"));
		getLblSetNachname().setFont(customFont20f);
		getLblSetNachname().setBounds(492, 132, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetNachname());
		
		setLblSetStatus(new JLabel("New label"));
		getLblSetStatus().setFont(customFont20f);
		getLblSetStatus().setBounds(492, 157, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetStatus());
		
		setLblSetPunktestand(new JLabel("New label"));
		getLblSetPunktestand().setFont(customFont20f);
		getLblSetPunktestand().setBounds(492, 182, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetPunktestand());
		
		setLblSetGesFahrten(new JLabel("New label"));
		getLblSetGesFahrten().setFont(customFont20f);
		getLblSetGesFahrten().setBounds(487, 255, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetGesFahrten());
		
		setLblSetAlsErster(new JLabel("New label"));
		getLblSetAlsErster().setFont(customFont20f);
		getLblSetAlsErster().setBounds(489, 277, 212, 23);
		getFrmPixelRacer().getContentPane().add(getLblSetAlsErster());
		
		setLblSetAlsZweiter(new JLabel("New label"));
		getLblSetAlsZweiter().setFont(customFont20f);
		getLblSetAlsZweiter().setBounds(489, 304, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetAlsZweiter());
		
		setLblSetAlsDritter(new JLabel("New label"));
		getLblSetAlsDritter().setFont(customFont20f);
		getLblSetAlsDritter().setBounds(489, 329, 212, 19);
		getFrmPixelRacer().getContentPane().add(getLblSetAlsDritter());
		
		setLblHintergrund(new JLabel(""));
		getLblHintergrund().setFont(customFont20f);
		getLblHintergrund().setVisible(false);		
		getLblHintergrund().setBounds(-61, 11, 794, 571);
		getFrmPixelRacer().getContentPane().add(lblHintergrund);
		
				
		Movement m = new Movement(10); // Hintergrund-Image dem Hintergurnd-Label zuweisen, Bewegung festlegen & dem Frame hinzufuegen
		
		BufferedImage image = null;
		try {
			URL url = getClass().getResource("/Resources/Hintergrund.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		m.label.setBufferedImage(image,0);
		
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		getFrmPixelRacer().getContentPane().add(m.label);		
	}

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
		btnRechnungsverw.setForeground(Color.RED);
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
		btnGetPremium.setForeground(Color.RED);
	}

	public JButton getBtnProfilBearbeiten() {
		return btnProfilBearbeiten;
	}

	public void setBtnProfilBearbeiten(JButton btnProfilBearbeiten) {
		this.btnProfilBearbeiten = btnProfilBearbeiten;
		btnProfilBearbeiten.setForeground(Color.RED);
	}

	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
		btnZurueck.setForeground(Color.RED);
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
