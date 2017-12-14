package Startansicht;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import Anmelden.AnmeldenStrg;
import BackgroundAnimation.Movement;

import java.awt.Font;

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

//Autor Daniel Zeller

public class Startansicht {

	JFrame frmPixelRacer;
	JLabel lblPixelRacer;
	JButton btnSpielen;
	JButton btnGarage;
	JButton btnStreckenbersicht;
	JButton btnProfil;
	JButton btnAbmelden;
	JLabel lblAnzeige;
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
	public Startansicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPixelRacer = new JFrame();
		frmPixelRacer.setResizable(false);
		frmPixelRacer.setTitle("Pixel Racer");
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.getContentPane().setLayout(null);
		
		lblPixelRacer = new JLabel("Pixel Racer");
		lblPixelRacer.setFont(new Font("Kartika", Font.BOLD | Font.ITALIC, 26));
		lblPixelRacer.setBounds(300, 88, 161, 38);
		frmPixelRacer.getContentPane().add(lblPixelRacer);
		
		btnSpielen = new JButton("Spielen");
		btnSpielen.setBounds(30, 404, 127, 45);
		btnSpielen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnSpielen);
		
		btnGarage = new JButton("Garage");
		btnGarage.setBounds(245, 404, 127, 45);
		btnGarage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnGarage);
		
		btnStreckenbersicht = new JButton("Strecken\u00FCbersicht");
		btnStreckenbersicht.setBounds(425, 404, 127, 45);
		btnStreckenbersicht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		frmPixelRacer.getContentPane().add(btnStreckenbersicht);
		
		btnProfil = new JButton("Profil");
		btnProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		btnProfil.setBounds(634, 404, 127, 45);
		frmPixelRacer.getContentPane().add(btnProfil);
		
		btnAbmelden = new JButton("Abmelden");
		btnAbmelden.setBounds(672, 524, 89, 23);
		frmPixelRacer.getContentPane().add(btnAbmelden);
		btnAbmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPixelRacer.dispose();
			}
		});
		
		lblAnzeige = new JLabel("Fehler");
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
}