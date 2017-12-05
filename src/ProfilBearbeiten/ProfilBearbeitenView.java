package ProfilBearbeiten;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Nutzer.Nutzerverwaltung;

import javax.swing.JButton;

public class ProfilBearbeitenView {

	private JFrame frmProfilBearbeiten;

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
		frmProfilBearbeiten.setTitle("Profil bearbeiten - \u00DCberblick");
		frmProfilBearbeiten.setBounds(100, 100, 800, 600);
		frmProfilBearbeiten.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfilBearbeiten.getContentPane().setLayout(null);
		
		JLabel lblNutzername = new JLabel("Nutzername");
		lblNutzername.setBounds(52, 124, 125, 14);
		frmProfilBearbeiten.getContentPane().add(lblNutzername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(52, 210, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblEmail);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(52, 23, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(52, 70, 69, 14);
		frmProfilBearbeiten.getContentPane().add(lblNachname);
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(52, 169, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblPasswort);
		
		JLabel lblGeburtsdatum = new JLabel("Geburtsdatum");
		lblGeburtsdatum.setBounds(52, 251, 79, 14);
		frmProfilBearbeiten.getContentPane().add(lblGeburtsdatum);
		
		JLabel lblPunkte = new JLabel("Punkte");
		lblPunkte.setBounds(52, 299, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblPunkte);
		
		JLabel labelVN = new JLabel("Fehler");
		labelVN.setBounds(214, 23, 160, 14);
		frmProfilBearbeiten.getContentPane().add(labelVN);
		labelVN.setText(Nutzerverwaltung.getangKunde().getvn());
		
		JLabel lblNN = new JLabel("Fehler");
		lblNN.setBounds(214, 70, 160, 14);
		frmProfilBearbeiten.getContentPane().add(lblNN);
		labelVN.setText(Nutzerverwaltung.getangKunde().getnn());
		
		JLabel lblNutzer = new JLabel("Fehler");
		lblNutzer.setBounds(214, 124, 160, 14);
		frmProfilBearbeiten.getContentPane().add(lblNutzer);
		labelVN.setText(Nutzerverwaltung.getangKunde().getnutzername());
		
		JLabel lblMail = new JLabel("Fehler");
		lblMail.setBounds(214, 210, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblMail);
		labelVN.setText(Nutzerverwaltung.getangKunde().getemail());
		
		JLabel lblGebDat = new JLabel("Fehler");
		lblGebDat.setBounds(214, 251, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblGebDat);
		labelVN.setText(Nutzerverwaltung.getangKunde().getgebdat());
		
		JLabel lblPkt = new JLabel("Fehler");
		lblPkt.setBounds(214, 299, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblPkt);
		labelVN.setText(String.valueOf(Nutzerverwaltung.getangKunde().getpunkte()));
		
		JButton btnaendernNN = new JButton("\u00C4ndern");
		btnaendernNN.setBounds(402, 66, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnaendernNN);
		
		JButton btnaendernPW = new JButton("\u00C4ndern");
		btnaendernPW.setBounds(402, 165, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnaendernPW);
		
		JButton btnaendernMail = new JButton("\u00C4ndern");
		btnaendernMail.setBounds(402, 206, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnaendernMail);
		
		JButton btnFertig = new JButton("Fertig");
		btnFertig.setBounds(52, 400, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnFertig);
	}
}
