package Kart;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class KartDetailView {

	JFrame frame;
	
	JLabel lblmaxkmh;
	JLabel lblbesch;
	
	JLabel lblRennenAlsErster;
	JLabel lblRennenAlsZweiter;
	JLabel lblRennenAlsDritter;
	
	JLabel lblSetmaxkmh;
	JLabel lblSetbesch;
	
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
					KartDetailView window = new KartDetailView();
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
	public KartDetailView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		
		lblmaxkmh = new JLabel("Max. Km/h:");
		lblmaxkmh.setBounds(55, 32, 72, 14);
		frame.getContentPane().add(lblmaxkmh);
		
		lblbesch = new JLabel ("Beschleunigung:");
		lblbesch.setBounds(32, 57, 95, 14);
		frame.getContentPane().add(lblbesch);
		
		lblRennenAlsErster = new JLabel("Rennen als Erster abgeschlossen");
		lblRennenAlsErster.setBounds(224, 136, 158, 14);
		frame.getContentPane().add(lblRennenAlsErster);
		
		lblRennenAlsZweiter = new JLabel("Rennen als Zweiter abgeschlossen");
		lblRennenAlsZweiter.setBounds(224, 161, 165, 14);
		frame.getContentPane().add(lblRennenAlsZweiter);
		
		lblRennenAlsDritter = new JLabel("Rennen als Dritter abgeschlossen");
		lblRennenAlsDritter.setBounds(224, 186, 165, 14);
		frame.getContentPane().add(lblRennenAlsDritter);
		
		lblSetmaxkmh= new JLabel("New label");
		lblSetmaxkmh.setBounds(191, 32, 46, 14);
		frame.getContentPane().add(lblSetmaxkmh);
		
		lblSetbesch = new JLabel("New label");
		lblSetbesch.setBounds(191, 57, 46, 14);
		frame.getContentPane().add(lblSetbesch);
		
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
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLblmaxkmh() {
		return lblmaxkmh;
	}

	public void setLblmaxkmh(JLabel lblmaxkmh) {
		this.lblmaxkmh = lblmaxkmh;
	}

	public JLabel getLblbesch() {
		return lblbesch;
	}

	public void setLblbesch(JLabel lblbesch) {
		this.lblbesch = lblbesch;
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

	public JLabel getLblSetmaxkmh() {
		return lblSetmaxkmh;
	}

	public void setLblSetmaxkmh(JLabel lblSetmaxkmh) {
		this.lblSetmaxkmh = lblSetmaxkmh;
	}

	public JLabel getLblSetbesch() {
		return lblSetbesch;
	}

	public void setLblSetbesch(JLabel lblSetbesch) {
		this.lblSetbesch = lblSetbesch;
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
