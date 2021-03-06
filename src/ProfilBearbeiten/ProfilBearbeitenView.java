package ProfilBearbeiten;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;

import BackgroundAnimation.Movement;
import FontHandler.FontHandler;
import Nutzer.Nutzerverwaltung;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Grafische Benutzeroberfl�che, wor�ber man bestimmte Sachen des Profils bearbeiten kann.
 * @author Daniel Zeller
 *
 */

public class ProfilBearbeitenView {

	private JFrame frmProfilBearbeiten; //Deklarierung der ben�tigten Variablen
	private JLabel lblNutzername;
	private JLabel lblEmail;
	private JLabel lblVorname;
	private JLabel lblNachname;
	private JLabel lblPasswort;
	private JLabel lblGeburtsdatum;
	private JLabel lblPunkte;
	private JLabel lblVN;
	private JLabel lblNN;
	private JLabel lblNutzer;
	private JLabel lblMail;
	private JLabel lblGebDat;
	private JLabel lblPkt;
	private JButton btnaendernNN;
	private JButton btnaendernPW;
	private JButton btnaendernMail;
	private JButton btnFertig;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilBearbeitenView window = new ProfilBearbeitenView();
					window.frmProfilBearbeiten.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfilBearbeitenView() { //Konstruktor
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //Initialisierung des Fensters und den dazugeh�rigen Komponenten
		Font customFont14f = FontHandler.registriereSchriftart(14f);
		
		frmProfilBearbeiten = new JFrame();
		frmProfilBearbeiten.setResizable(false);
		frmProfilBearbeiten.setTitle("Profil bearbeiten - \u00DCberblick");
		frmProfilBearbeiten.setBounds(100, 100, 800, 600);
		frmProfilBearbeiten.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfilBearbeiten.getContentPane().setLayout(null);
		frmProfilBearbeiten.setLocationRelativeTo(null);
		
		lblNutzername = new JLabel("Nutzername");
		lblNutzername.setBounds(52, 124, 125, 14);
		lblNutzername.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblNutzername);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(52, 210, 70, 14);
		lblEmail.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblEmail);
		
		lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(52, 24, 89, 14);
		lblVorname.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblVorname);
		
		lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(52, 70, 90, 14);
		lblNachname.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblNachname);
		
		lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(52, 169, 105, 14);
		lblPasswort.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblPasswort);
		
		lblGeburtsdatum = new JLabel("Geburtsdatum");
		lblGeburtsdatum.setBounds(52, 251, 150, 14);
		lblGeburtsdatum.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblGeburtsdatum);
		
		lblPunkte = new JLabel("Punkte");
		lblPunkte.setBounds(52, 299, 70, 14);
		lblPunkte.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblPunkte);
		
		lblNN = new JLabel("Fehler");
		lblNN.setBounds(214, 70, 300, 14);
		lblNN.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblNN);
		
		lblNutzer = new JLabel("Fehler");
		lblNutzer.setBounds(214, 124, 300, 14);
		lblNutzer.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblNutzer);
		
		lblMail = new JLabel("Fehler");
		lblMail.setBounds(214, 210, 300, 14);
		lblMail.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblMail);
		
		lblGebDat = new JLabel("Fehler");
		lblGebDat.setBounds(214, 251, 300, 14);
		lblGebDat.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblGebDat);
		
		lblPkt = new JLabel("Fehler");
		lblPkt.setBounds(214, 299, 300, 14);
		lblPkt.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblPkt);
		
		btnaendernNN = new JButton("Aendern");
		btnaendernNN.setBounds(600, 66, 120, 23);
		btnaendernNN.setFont(customFont14f);
		btnaendernNN.setBorderPainted(false);
		btnaendernNN.setOpaque(false);
		btnaendernNN.setBackground(SystemColor.activeCaption);
		btnaendernNN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AnmeldenStrg strg = new AnmeldenStrg();
				frmProfilBearbeiten.dispose();
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnaendernNN);
		
		btnaendernPW = new JButton("Aendern");
		btnaendernPW.setBounds(600, 165, 120, 23);
		btnaendernPW.setFont(customFont14f);
		btnaendernPW.setBorderPainted(false);
		btnaendernPW.setOpaque(false);
		btnaendernPW.setBackground(SystemColor.activeCaption);
		btnaendernPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnaendernPW);
		
		btnaendernMail = new JButton("Aendern");
		btnaendernMail.setBounds(600, 206, 120, 23);
		btnaendernMail.setFont(customFont14f);
		btnaendernMail.setBorderPainted(false);
		btnaendernMail.setOpaque(false);
		btnaendernMail.setBackground(SystemColor.activeCaption);
		btnaendernMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnaendernMail);
		
		btnFertig = new JButton("Fertig");
		btnFertig.setBounds(52, 400, 110, 23);
		btnFertig.setFont(customFont14f);
		btnFertig.setBorderPainted(false);
		btnFertig.setOpaque(false);
		btnFertig.setBackground(SystemColor.activeCaption);
		frmProfilBearbeiten.getContentPane().add(btnFertig);
		btnFertig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblVN = new JLabel("Fehler");
		lblVN.setBounds(214, 24, 300, 14);
		lblVN.setFont(customFont14f);
		frmProfilBearbeiten.getContentPane().add(lblVN);
		
		Movement m = new Movement(10);
		
		BufferedImage image = null;
		try {
			URL url = getClass().getResource("/Resources/Hintergrund.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m.label.setBufferedImage(image,0);
		
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		frmProfilBearbeiten.getContentPane().add(m.label);
		frmProfilBearbeiten.setVisible(true);
	}

	public JFrame getFrmProfilBearbeiten() { //Getter und Setter der Variablen
		return frmProfilBearbeiten;
	}

	public void setFrmProfilBearbeiten(JFrame frmProfilBearbeiten) {
		this.frmProfilBearbeiten = frmProfilBearbeiten;
	}

	public JLabel getLblNutzername() {
		return lblNutzername;
	}

	public void setLblNutzername(JLabel lblNutzername) {
		this.lblNutzername = lblNutzername;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblVorname() {
		return lblVorname;
	}

	public void setLblVorname(JLabel lblVorname) {
		this.lblVorname = lblVorname;
	}

	public JLabel getLblNachname() {
		return lblNachname;
	}

	public void setLblNachname(JLabel lblNachname) {
		this.lblNachname = lblNachname;
	}

	public JLabel getLblPasswort() {
		return lblPasswort;
	}

	public void setLblPasswort(JLabel lblPasswort) {
		this.lblPasswort = lblPasswort;
	}

	public JLabel getLblGeburtsdatum() {
		return lblGeburtsdatum;
	}

	public void setLblGeburtsdatum(JLabel lblGeburtsdatum) {
		this.lblGeburtsdatum = lblGeburtsdatum;
	}

	public JLabel getLblPunkte() {
		return lblPunkte;
	}

	public void setLblPunkte(JLabel lblPunkte) {
		this.lblPunkte = lblPunkte;
	}

	public JLabel getLblVN() {
		return lblVN;
	}

	public void setLblVN(JLabel lblVN) {
		this.lblVN = lblVN;
	}

	public JLabel getLblNN() {
		return lblNN;
	}

	public void setLblNN(JLabel lblNN) {
		this.lblNN = lblNN;
	}

	public JLabel getLblNutzer() {
		return lblNutzer;
	}

	public void setLblNutzer(JLabel lblNutzer) {
		this.lblNutzer = lblNutzer;
	}

	public JLabel getLblMail() {
		return lblMail;
	}

	public void setLblMail(JLabel lblMail) {
		this.lblMail = lblMail;
	}

	public JLabel getLblGebDat() {
		return lblGebDat;
	}

	public void setLblGebDat(JLabel lblGebDat) {
		this.lblGebDat = lblGebDat;
	}

	public JLabel getLblPkt() {
		return lblPkt;
	}

	public void setLblPkt(JLabel lblPkt) {
		this.lblPkt = lblPkt;
	}

	public JButton getBtnaendernNN() {
		return btnaendernNN;
	}

	public void setBtnaendernNN(JButton btnaendernNN) {
		this.btnaendernNN = btnaendernNN;
	}

	public JButton getBtnaendernPW() {
		return btnaendernPW;
	}

	public void setBtnaendernPW(JButton btnaendernPW) {
		this.btnaendernPW = btnaendernPW;
	}

	public JButton getBtnaendernMail() {
		return btnaendernMail;
	}

	public void setBtnaendernMail(JButton btnaendernMail) {
		this.btnaendernMail = btnaendernMail;
	}

	public JButton getBtnFertig() {
		return btnFertig;
	}

	public void setBtnFertig(JButton btnFertig) {
		this.btnFertig = btnFertig;
	}
}
