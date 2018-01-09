package Strecke;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import BackgroundAnimation.Movement;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class StreckeDetailView {

	JFrame frame;
	
	JLabel lblHintergrund;
	JLabel lblLaenge;
	JLabel lblGefahreneRennen;
	JLabel lblGefahreneKmGesamt;
	JLabel lblRennenAlsErster;
	JLabel lblRennenAlsZweiter;
	JLabel lblRennenAlsDritter;
	
	JLabel lblSetLaenge;
	JLabel lblSetGesKm;
	JLabel lblSetGesRennen;
	JLabel lblSetAnzErster;
	JLabel lblSetAnzZweiter;
	JLabel lblSetAnzDritter;
		
	JButton btnZurueck; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StreckeDetailView window = new StreckeDetailView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StreckeDetailView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
				
		lblLaenge = new JLabel("Streckenl\u00E4nge:");
		lblLaenge.setBounds(76, 32, 105, 14);
		frame.getContentPane().add(lblLaenge);
		
		lblGefahreneRennen = new JLabel("Gefahrene SP-Rennen:");
		lblGefahreneRennen.setBounds(37, 57, 144, 14);
		frame.getContentPane().add(lblGefahreneRennen);
		
		lblGefahreneKmGesamt = new JLabel("Gefahrene m SP gesamt:");
		lblGefahreneKmGesamt.setBounds(20, 82, 152, 14);
		frame.getContentPane().add(lblGefahreneKmGesamt);
		
		lblRennenAlsErster = new JLabel("Rennen als Erster abgeschlossen");
		lblRennenAlsErster.setBounds(224, 136, 210, 14);
		frame.getContentPane().add(lblRennenAlsErster);
		
		lblRennenAlsZweiter = new JLabel("Rennen als Zweiter abgeschlossen");
		lblRennenAlsZweiter.setBounds(224, 161, 210, 14);
		frame.getContentPane().add(lblRennenAlsZweiter);
		
		lblRennenAlsDritter = new JLabel("Rennen als Dritter abgeschlossen");
		lblRennenAlsDritter.setBounds(224, 186, 210, 14);
		frame.getContentPane().add(lblRennenAlsDritter);
		
		lblSetLaenge = new JLabel("New label");
		lblSetLaenge.setBounds(191, 32, 46, 14);
		frame.getContentPane().add(lblSetLaenge);
		
		lblSetGesRennen = new JLabel("New label");
		lblSetGesRennen.setBounds(191, 57, 46, 14);
		frame.getContentPane().add(lblSetGesRennen);
		
		lblSetGesKm = new JLabel("New label");
		lblSetGesKm.setBounds(191, 82, 46, 14);
		frame.getContentPane().add(lblSetGesKm);
		
		lblSetAnzErster = new JLabel("New label");
		lblSetAnzErster.setBounds(148, 136, 46, 14);
		frame.getContentPane().add(lblSetAnzErster);
		
		lblSetAnzZweiter = new JLabel("New label");
		lblSetAnzZweiter.setBounds(148, 161, 46, 14);
		frame.getContentPane().add(lblSetAnzZweiter);
		
		lblSetAnzDritter = new JLabel("New label");
		lblSetAnzDritter.setBounds(148, 186, 46, 14);
		frame.getContentPane().add(lblSetAnzDritter);
		
		btnZurueck = new JButton("Zur\u00FCck");
		btnZurueck.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnZurueck);
		btnZurueck.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
	
	lblHintergrund = new JLabel("");
	lblHintergrund.setVisible(false);		
	lblHintergrund.setBounds(0, 0, 794, 571);
	frame.getContentPane().add(lblHintergrund);
			
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
	frame.getContentPane().add(m.label);
}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLblLaenge() {
		return lblLaenge;
	}

	public void setLblLaenge(JLabel lblLaenge) {
		this.lblLaenge = lblLaenge;
	}

	public JLabel getLblGefahreneRennen() {
		return lblGefahreneRennen;
	}

	public void setLblGefahreneRennen(JLabel lblGefahreneRennen) {
		this.lblGefahreneRennen = lblGefahreneRennen;
	}

	public JLabel getLblGefahreneKmGesamt() {
		return lblGefahreneKmGesamt;
	}

	public void setLblGefahreneKmGesamt(JLabel lblGefahreneKmGesamt) {
		this.lblGefahreneKmGesamt = lblGefahreneKmGesamt;
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

	public JLabel getLblSetLaenge() {
		return lblSetLaenge;
	}

	public void setLblSetLaenge(JLabel lblSetLaenge) {
		this.lblSetLaenge = lblSetLaenge;
	}

	public JLabel getLblSetGesKm() {
		return lblSetGesKm;
	}

	public void setLblSetGesKm(JLabel lblSetGesKm) {
		this.lblSetGesKm = lblSetGesKm;
	}

	public JLabel getLblSetGesRennen() {
		return lblSetGesRennen;
	}

	public void setLblSetGesRennen(JLabel lblSetGesRennen) {
		this.lblSetGesRennen = lblSetGesRennen;
	}

	public JLabel getLblSetAnzErster() {
		return lblSetAnzErster;
	}

	public void setLblSetAnzErster(JLabel lblSetAnzErster) {
		this.lblSetAnzErster = lblSetAnzErster;
	}

	public JLabel getLblSetAnzZweiter() {
		return lblSetAnzZweiter;
	}

	public void setLblSetAnzZweiter(JLabel lblSetAnzZweiter) {
		this.lblSetAnzZweiter = lblSetAnzZweiter;
	}

	public JLabel getLblSetAnzDritter() {
		return lblSetAnzDritter;
	}

	public void setLblSetAnzDritter(JLabel lblSetAnzDritter) {
		this.lblSetAnzDritter = lblSetAnzDritter;
	}

	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
	}
}
