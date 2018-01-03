package ProfilKunde;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ProfilKundeAnsicht{

	JFrame frmPixelRacer;

	JLabel lblNewLabel;
	JLabel lblNachname;
	JLabel lblStatus;
	JLabel lblPunktestand;
	JLabel lblFahrtenAbsolviert;
	JLabel lblRennenAlsErster;
	JLabel lblRennenAlsZweiter;
	JLabel lblRennenAlsDritter;
	
	JButton btnGetPremium;
	JButton btnProfilBearbeiten;
	JButton btnZurueck;
	
	JLabel lblSetVorname;
	JLabel lblSetNachname;
	JLabel lblSetStatus;
	JLabel lblSetPunktestand;
	JLabel lblSetGesFahrten;
	JLabel lblSetAlsErster;
	JLabel lblSetAlsZweiter;
	JLabel lblSetAlsDritter;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilKundeAnsicht window = new ProfilKundeAnsicht();
					window.frmPixelRacer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfilKundeAnsicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPixelRacer = new JFrame();
		frmPixelRacer.setTitle("Pixel Racer - ");
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.setResizable(false);
		frmPixelRacer.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Vorname:");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		lblNewLabel.setBounds(292, 73, 87, 23);
		frmPixelRacer.getContentPane().add(lblNewLabel);
		
		lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Impact", Font.PLAIN, 20));
		lblNachname.setBounds(278, 98, 101, 23);
		frmPixelRacer.getContentPane().add(lblNachname);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Impact", Font.PLAIN, 20));
		lblStatus.setBounds(315, 123, 64, 23);
		frmPixelRacer.getContentPane().add(lblStatus);
		
		lblPunktestand = new JLabel("Punktestand:");
		lblPunktestand.setFont(new Font("Impact", Font.PLAIN, 20));
		lblPunktestand.setBounds(262, 148, 124, 23);
		frmPixelRacer.getContentPane().add(lblPunktestand);
		
		lblFahrtenAbsolviert = new JLabel("Fahrten absolviert:");
		lblFahrtenAbsolviert.setFont(new Font("Impact", Font.PLAIN, 20));
		lblFahrtenAbsolviert.setBounds(210, 213, 169, 23);
		frmPixelRacer.getContentPane().add(lblFahrtenAbsolviert);
		
		lblRennenAlsErster = new JLabel("Rennen als Erster abgeschlossen:");
		lblRennenAlsErster.setFont(new Font("Impact", Font.PLAIN, 20));
		lblRennenAlsErster.setBounds(81, 296, 298, 23);
		frmPixelRacer.getContentPane().add(lblRennenAlsErster);
		
		lblRennenAlsZweiter = new JLabel("Rennen als Zweiter abgeschlossen:");
		lblRennenAlsZweiter.setFont(new Font("Impact", Font.PLAIN, 20));
		lblRennenAlsZweiter.setBounds(66, 321, 313, 23);
		frmPixelRacer.getContentPane().add(lblRennenAlsZweiter);
		
		lblRennenAlsDritter = new JLabel("Rennen als Dritter abgeschlossen:");
		lblRennenAlsDritter.setFont(new Font("Impact", Font.PLAIN, 20));
		lblRennenAlsDritter.setBounds(75, 346, 304, 23);
		frmPixelRacer.getContentPane().add(lblRennenAlsDritter);
		
		btnGetPremium = new JButton("Werde jetzt Premium-Kunde!");
		btnGetPremium.setFont(new Font("Impact", Font.PLAIN, 20));
		btnGetPremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGetPremium.setBounds(66, 415, 313, 33);
		frmPixelRacer.getContentPane().add(btnGetPremium);
		
		btnProfilBearbeiten = new JButton("Profil bearbeiten");
		btnProfilBearbeiten.setFont(new Font("Impact", Font.PLAIN, 20));
		btnProfilBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnProfilBearbeiten.setBounds(481, 415, 179, 33);
		btnProfilBearbeiten.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
			}
		
		});
		
		frmPixelRacer.getContentPane().add(btnProfilBearbeiten);
		
		btnZurueck = new JButton("Zur\u00FCck");
		btnZurueck.setFont(new Font("Impact", Font.PLAIN, 20));
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnZurueck.setBounds(658, 517, 116, 33);
		frmPixelRacer.getContentPane().add(btnZurueck);
		
		lblSetVorname = new JLabel("New label");
		lblSetVorname.setFont(new Font("Impact", Font.PLAIN, 20));
		lblSetVorname.setBounds(481, 75, 212, 19);
		frmPixelRacer.getContentPane().add(lblSetVorname);
		
		lblSetNachname = new JLabel("New label");
		lblSetNachname.setFont(new Font("Impact", Font.PLAIN, 20));
		lblSetNachname.setBounds(481, 100, 212, 19);
		frmPixelRacer.getContentPane().add(lblSetNachname);
		
		lblSetStatus = new JLabel("New label");
		lblSetStatus.setFont(new Font("Impact", Font.PLAIN, 20));
		lblSetStatus.setBounds(481, 125, 212, 19);
		frmPixelRacer.getContentPane().add(lblSetStatus);
		
		lblSetPunktestand = new JLabel("New label");
		lblSetPunktestand.setFont(new Font("Impact", Font.PLAIN, 20));
		lblSetPunktestand.setBounds(481, 150, 212, 19);
		frmPixelRacer.getContentPane().add(lblSetPunktestand);
		
		lblSetGesFahrten = new JLabel("New label");
		lblSetGesFahrten.setFont(new Font("Impact", Font.PLAIN, 20));
		lblSetGesFahrten.setBounds(481, 215, 212, 19);
		frmPixelRacer.getContentPane().add(lblSetGesFahrten);
		
		lblSetAlsErster = new JLabel("New label");
		lblSetAlsErster.setFont(new Font("Impact", Font.PLAIN, 20));
		lblSetAlsErster.setBounds(481, 296, 212, 23);
		frmPixelRacer.getContentPane().add(lblSetAlsErster);
		
		lblSetAlsZweiter = new JLabel("New label");
		lblSetAlsZweiter.setFont(new Font("Impact", Font.PLAIN, 20));
		lblSetAlsZweiter.setBounds(481, 323, 212, 19);
		frmPixelRacer.getContentPane().add(lblSetAlsZweiter);
		
		lblSetAlsDritter = new JLabel("New label");
		lblSetAlsDritter.setFont(new Font("Impact", Font.PLAIN, 20));
		lblSetAlsDritter.setBounds(481, 348, 212, 19);
		frmPixelRacer.getContentPane().add(lblSetAlsDritter);
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
