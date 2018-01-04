package ProfilBearbeiten;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BackgroundAnimation.Movement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Grafische Benutzeroberfl�che, die den Spieler das vorher ausgew�hlte Attribut (ProfilBearbeitenView) �ndern l�sst.
 * @author Daniel Zeller
 *
 */

public class ProfilBearbeitenAttributView { //Deklaration der ben�tigten Variablen

	private JFrame frmProfilBearbeiten;
	private JTextField textFieldNeu;
	private JLabel lblAktAnzeige;
	private JLabel lblAktuell;
	private JLabel lblNeu;
	private JButton btnFertig;
	private JButton btnAbbrechen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilBearbeitenAttributView window = new ProfilBearbeitenAttributView();
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
	public ProfilBearbeitenAttributView() { //Konstruktor
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //Initialisierung des Fensters und den dazugeh�rigen Komponenten
		frmProfilBearbeiten = new JFrame();
		frmProfilBearbeiten.setResizable(false);
		frmProfilBearbeiten.setTitle("Profil Bearbeiten - Attribut");
		frmProfilBearbeiten.setBounds(100, 100, 600, 400);
		frmProfilBearbeiten.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfilBearbeiten.getContentPane().setLayout(null);
		
		lblAktAnzeige = new JLabel("Fehler");
		lblAktAnzeige.setBounds(333, 66, 198, 14);
		frmProfilBearbeiten.getContentPane().add(lblAktAnzeige);
		
		textFieldNeu = new JTextField();
		textFieldNeu.setBounds(333, 91, 198, 20);
		frmProfilBearbeiten.getContentPane().add(textFieldNeu);
		textFieldNeu.setColumns(10);
		
		lblAktuell = new JLabel("Aktuell");
		lblAktuell.setBounds(98, 66, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblAktuell);
		
		lblNeu = new JLabel("Neu");
		lblNeu.setBounds(98, 94, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblNeu);
		
		btnFertig = new JButton("Fertig");
		btnFertig.setBounds(170, 252, 89, 23);
		btnFertig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProfilBearbeiten.dispose();
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnFertig);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(333, 252, 120, 23);
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProfilBearbeiten.dispose();
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnAbbrechen);
		
		Movement m = new Movement(10);
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/Hintergrund.png"));
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

	public JTextField getTextFieldNeu() {
		return textFieldNeu;
	}

	public void setTextFieldNeu(JTextField textFieldNeu) {
		this.textFieldNeu = textFieldNeu;
	}

	public JLabel getLblAktAnzeige() {
		return lblAktAnzeige;
	}

	public void setLblAktAnzeige(JLabel lblAktAnzeige) {
		this.lblAktAnzeige = lblAktAnzeige;
	}

	public JLabel getLblAktuell() {
		return lblAktuell;
	}

	public void setLblAktuell(JLabel lblAktuell) {
		this.lblAktuell = lblAktuell;
	}

	public JLabel getLblNeu() {
		return lblNeu;
	}

	public void setLblNeu(JLabel lblNeu) {
		this.lblNeu = lblNeu;
	}

	public JButton getBtnFertig() {
		return btnFertig;
	}

	public void setBtnFertig(JButton btnFertig) {
		this.btnFertig = btnFertig;
	}

	public JButton getBtnAbbrechen() {
		return btnAbbrechen;
	}

	public void setBtnAbbrechen(JButton btnAbbrechen) {
		this.btnAbbrechen = btnAbbrechen;
	}
}
