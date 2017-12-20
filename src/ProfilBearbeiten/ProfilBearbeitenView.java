package ProfilBearbeiten;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Nutzer.Nutzerverwaltung;

import javax.swing.ImageIcon;
import javax.swing.JButton;

//Autor Daniel Zeller

public class ProfilBearbeitenView {

	private JFrame frmProfilBearbeiten;
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
		lblGeburtsdatum.setBounds(52, 251, 105, 14);
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
		lblMail.setBounds(214, 210, 178, 14);
		frmProfilBearbeiten.getContentPane().add(lblMail);
		
		lblGebDat = new JLabel("Fehler");
		lblGebDat.setBounds(214, 251, 178, 14);
		frmProfilBearbeiten.getContentPane().add(lblGebDat);
		
		lblPkt = new JLabel("Fehler");
		lblPkt.setBounds(214, 299, 142, 14);
		frmProfilBearbeiten.getContentPane().add(lblPkt);
		
		btnaendernNN = new JButton("\u00C4ndern");
		btnaendernNN.setBounds(402, 66, 89, 23);
		btnaendernNN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AnmeldenStrg strg = new AnmeldenStrg();
				frmProfilBearbeiten.dispose();
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnaendernNN);
		
		btnaendernPW = new JButton("\u00C4ndern");
		btnaendernPW.setBounds(402, 165, 89, 23);
		btnaendernPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AnmeldenStrg strg = new AnmeldenStrg();
				frmProfilBearbeiten.dispose();
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnaendernPW);
		
		btnaendernMail = new JButton("\u00C4ndern");
		btnaendernMail.setBounds(402, 206, 89, 23);
		btnaendernMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AnmeldenStrg strg = new AnmeldenStrg();
				frmProfilBearbeiten.dispose();
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnaendernMail);
		
		btnFertig = new JButton("Fertig");
		btnFertig.setBounds(52, 400, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnFertig);
		btnFertig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AnmeldenStrg strg = new AnmeldenStrg();
				frmProfilBearbeiten.dispose();
			}
		});
		
		lblVN = new JLabel("Fehler");
		lblVN.setBounds(214, 24, 178, 14);
		frmProfilBearbeiten.getContentPane().add(lblVN);
		
		JLabel lblHintergrund = new JLabel();
		lblHintergrund.setIcon(new ImageIcon("src/Resources/Hintergrund.png"));
		lblHintergrund.setBounds(0, 0, 800, 600);
		frmProfilBearbeiten.getContentPane().add(lblHintergrund);
	}

	public JFrame getFrmProfilBearbeiten() {
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
