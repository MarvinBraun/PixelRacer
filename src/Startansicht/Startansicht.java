package Startansicht;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import Anmelden.AnmeldenStrg;
import BackgroundAnimation.Movement;
import FontHandler.FontHandler;

import java.awt.Font;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Grafische Benutzeroberfläche, auf der Buttons sind, worüber man zu anderen Funktionen kommt.
 * @author Daniel Zeller
 *
 */

public class Startansicht {

	private JFrame frmPixelRacer; //Deklarierung der benötigten Variablen
	private JLabel lblPixelRacer;
	private JButton btnSpielen;
	private JButton btnGarage;
	private JButton btnStreckenbersicht;
	private JButton btnProfil;
	private JButton btnAbmelden;
	private JLabel lblAnzeige;
	private JLabel lblHintergrund;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startansicht window = new Startansicht();
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
	public Startansicht() { //Konstruktor
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //Initialisierung des Fensters und den dazugehörigen Komponenten
		Font customFont30f = FontHandler.registriereSchriftart(30f);
		Font customFont18f = FontHandler.registriereSchriftart(18f);
		Font customFont10f = FontHandler.registriereSchriftart(10f);
		
		frmPixelRacer = new JFrame();
		frmPixelRacer.setResizable(false);
		frmPixelRacer.setTitle("Pixel Racer");
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.getContentPane().setLayout(null);
		frmPixelRacer.setLocationRelativeTo(null);
		
		lblPixelRacer = new JLabel("Pixel Racer");
		lblPixelRacer.setFont(customFont30f);
		lblPixelRacer.setBounds(300, 88, 300, 38);
		frmPixelRacer.getContentPane().add(lblPixelRacer);
		
		btnSpielen = new JButton("Spielen");
		btnSpielen.setBounds(30, 404, 127, 45);
		btnSpielen.setFont(customFont18f);
		btnSpielen.setBorderPainted(false);
		btnSpielen.setOpaque(false);
		btnSpielen.setBackground(SystemColor.activeCaption);
		btnSpielen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnSpielen);
		
		btnGarage = new JButton("Garage");
		btnGarage.setBounds(180, 404, 127, 45);
		btnGarage.setFont(customFont18f);
		btnGarage.setBorderPainted(false);
		btnGarage.setOpaque(false);
		btnGarage.setBackground(SystemColor.activeCaption);
		btnGarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnGarage);
		
		btnStreckenbersicht = new JButton("Streckenuebersicht");
		btnStreckenbersicht.setBounds(330, 404, 300, 45);
		btnStreckenbersicht.setFont(customFont18f);
		btnStreckenbersicht.setBorderPainted(false);
		btnStreckenbersicht.setOpaque(false);
		btnStreckenbersicht.setBackground(SystemColor.activeCaption);
		btnStreckenbersicht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnStreckenbersicht);
		
		btnProfil = new JButton("Profil");
		btnProfil.setFont(customFont18f);
		btnProfil.setBorderPainted(false);
		btnProfil.setOpaque(false);
		btnProfil.setBackground(SystemColor.activeCaption);
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		btnProfil.setBounds(650, 404, 127, 45);
		frmPixelRacer.getContentPane().add(btnProfil);
		
		btnAbmelden = new JButton("Abmelden");
		btnAbmelden.setBounds(649, 524, 112, 23);
		btnAbmelden.setFont(customFont10f);
		btnAbmelden.setBorderPainted(false);
		btnAbmelden.setOpaque(false);
		btnAbmelden.setBackground(SystemColor.activeCaption);
		frmPixelRacer.getContentPane().add(btnAbmelden);
		btnAbmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		
		lblAnzeige = new JLabel("Fehler");
		lblAnzeige.setFont(customFont10f);
		lblAnzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnzeige.setBounds(544, 0, 240, 14);
		frmPixelRacer.getContentPane().add(lblAnzeige);
		
		lblHintergrund = new JLabel("");
		lblHintergrund.setVisible(false);		
		lblHintergrund.setBounds(0, 0, 794, 571);
		frmPixelRacer.getContentPane().add(lblHintergrund);
		
				
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
		frmPixelRacer.getContentPane().add(m.label);
		frmPixelRacer.setVisible(true);
	}

	public JFrame getFrmPixelRacer() { //Getter und Setter der Variablen
		return frmPixelRacer;
	}

	public void setFrmPixelRacer(JFrame frmPixelRacer) {
		this.frmPixelRacer = frmPixelRacer;
	}

	public JLabel getLblPixelRacer() {
		return lblPixelRacer;
	}

	public void setLblPixelRacer(JLabel lblPixelRacer) {
		this.lblPixelRacer = lblPixelRacer;
	}

	public JButton getBtnSpielen() {
		return btnSpielen;
	}

	public void setBtnSpielen(JButton btnSpielen) {
		this.btnSpielen = btnSpielen;
	}

	public JButton getBtnGarage() {
		return btnGarage;
	}

	public void setBtnGarage(JButton btnGarage) {
		this.btnGarage = btnGarage;
	}

	public JButton getBtnStreckenbersicht() {
		return btnStreckenbersicht;
	}

	public void setBtnStreckenbersicht(JButton btnStreckenbersicht) {
		this.btnStreckenbersicht = btnStreckenbersicht;
	}

	public JButton getBtnProfil() {
		return btnProfil;
	}

	public void setBtnProfil(JButton btnProfil) {
		this.btnProfil = btnProfil;
	}

	public JButton getBtnAbmelden() {
		return btnAbmelden;
	}

	public void setBtnAbmelden(JButton btnAbmelden) {
		this.btnAbmelden = btnAbmelden;
	}

	public JLabel getLblAnzeige() {
		return lblAnzeige;
	}

	public void setLblAnzeige(JLabel lblAnzeige) {
		this.lblAnzeige = lblAnzeige;
	}

	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}
}
