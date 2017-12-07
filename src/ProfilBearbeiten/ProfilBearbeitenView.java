package ProfilBearbeiten;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Nutzer.Nutzerverwaltung;

import javax.swing.JButton;

public class ProfilBearbeitenView {

	private JFrame frmProfilBearbeiten;
	JLabel lblNutzername;
	JLabel lblEmail;
	JLabel lblVorname;
	JLabel lblNachname;
	JLabel lblPasswort;
	JLabel lblGeburtsdatum;
	JLabel lblPunkte;
	JLabel lblNN;
	JLabel lblNutzer;
	JLabel lblMail;
	JLabel lblGebDat;
	JLabel lblPkt;
	JButton btnaendernNN;
	JButton btnaendernPW;
	JButton btnaendernMail;
	JButton btnFertig;
	JLabel lblVn;

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
	public ProfilBearbeitenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfilBearbeiten = new JFrame();
		frmProfilBearbeiten.setResizable(false);
		frmProfilBearbeiten.setTitle("Profil bearbeiten - \u00DCberblick");
		frmProfilBearbeiten.setBounds(100, 100, 800, 600);
		frmProfilBearbeiten.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfilBearbeiten.getContentPane().setLayout(null);
		
		lblNutzername = new JLabel("Nutzername");
		lblNutzername.setBounds(52, 124, 125, 14);
		frmProfilBearbeiten.getContentPane().add(lblNutzername);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(52, 210, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblEmail);
		
		lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(52, 24, 89, 14);
		frmProfilBearbeiten.getContentPane().add(lblVorname);
		
		lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(52, 70, 69, 14);
		frmProfilBearbeiten.getContentPane().add(lblNachname);
		
		lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(52, 169, 105, 14);
		frmProfilBearbeiten.getContentPane().add(lblPasswort);
		
		lblGeburtsdatum = new JLabel("Geburtsdatum");
		lblGeburtsdatum.setBounds(52, 251, 79, 14);
		frmProfilBearbeiten.getContentPane().add(lblGeburtsdatum);
		
		lblPunkte = new JLabel("Punkte");
		lblPunkte.setBounds(52, 299, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblPunkte);
		
		lblNN = new JLabel("Fehler");
		lblNN.setBounds(214, 70, 160, 14);
		frmProfilBearbeiten.getContentPane().add(lblNN);
		
		lblNutzer = new JLabel("Fehler");
		lblNutzer.setBounds(214, 124, 160, 14);
		frmProfilBearbeiten.getContentPane().add(lblNutzer);
		
		lblMail = new JLabel("Fehler");
		lblMail.setBounds(214, 210, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblMail);
		
		lblGebDat = new JLabel("Fehler");
		lblGebDat.setBounds(214, 251, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblGebDat);
		
		lblPkt = new JLabel("Fehler");
		lblPkt.setBounds(214, 299, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblPkt);
		
		btnaendernNN = new JButton("\u00C4ndern");
		btnaendernNN.setBounds(402, 66, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnaendernNN);
		
		btnaendernPW = new JButton("\u00C4ndern");
		btnaendernPW.setBounds(402, 165, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnaendernPW);
		
		btnaendernMail = new JButton("\u00C4ndern");
		btnaendernMail.setBounds(402, 206, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnaendernMail);
		
		btnFertig = new JButton("Fertig");
		btnFertig.setBounds(52, 400, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnFertig);
		
		lblVn = new JLabel("Fehler");
		lblVn.setBounds(214, 24, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblVn);
	}
}
