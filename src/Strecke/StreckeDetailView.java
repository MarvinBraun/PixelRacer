package Strecke;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class StreckeDetailView {

	JFrame frame;
	
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		
		lblLaenge = new JLabel("Streckenl\u00E4nge:");
		lblLaenge.setBounds(55, 32, 72, 14);
		frame.getContentPane().add(lblLaenge);
		
		lblGefahreneRennen = new JLabel("Gefahrene Rennen:");
		lblGefahreneRennen.setBounds(32, 57, 95, 14);
		frame.getContentPane().add(lblGefahreneRennen);
		
		lblGefahreneKmGesamt = new JLabel("Gefahrene km gesamt:");
		lblGefahreneKmGesamt.setBounds(18, 82, 109, 14);
		frame.getContentPane().add(lblGefahreneKmGesamt);
		
		lblRennenAlsErster = new JLabel("Rennen als Erster abgeschlossen");
		lblRennenAlsErster.setBounds(224, 136, 158, 14);
		frame.getContentPane().add(lblRennenAlsErster);
		
		lblRennenAlsZweiter = new JLabel("Rennen als Zweiter abgeschlossen");
		lblRennenAlsZweiter.setBounds(224, 161, 165, 14);
		frame.getContentPane().add(lblRennenAlsZweiter);
		
		lblRennenAlsDritter = new JLabel("Rennen als Dritter abgeschlossen");
		lblRennenAlsDritter.setBounds(224, 186, 165, 14);
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
	}

}
