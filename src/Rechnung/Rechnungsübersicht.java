package Rechnung;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import FontHandler.FontHandler;
import javax.swing.JTextField;


/**
 * Grafische Benutzeroberfläche um eine Rechnungsnummer anzuzeigen. Dort kann der Nutzer außerdem entscheiden, was er mit der Rechnung durchführen möchte.
 * Button Anzeigen, Bezahlen oder Speichern 
 * @author Matthias Westermeyer
 *
 */

public class Rechnungsübersicht {
	
	// benötigte Variablen deklarieren

	JFrame frmRechnungsbersicht;
	JLabel lblRechnung;
	JButton btnAnzeigen;
	JButton btnBezahlen;
	JLabel lblHintergrund;
	JTextField textField;
	private JButton btnZuruck;

	
	
	// getter und setter Methoden der Variablen
	
	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}

	public JFrame getFrmRechnungsbersicht() {
		return frmRechnungsbersicht;
	}

	public void setFrmRechnungsbersicht(JFrame frmRechnungsbersicht) {
		this.frmRechnungsbersicht = frmRechnungsbersicht;
	}

	public JLabel getLblRechnung() {
		return lblRechnung;
	}

	public void setLblRechnung(JLabel lblRechnung) {
		this.lblRechnung = lblRechnung;
	}

	public JButton getBtnAnzeigen() {
		return btnAnzeigen;
	}

	public void setBtnAnzeigen(JButton btnAnzeigen) {
		this.btnAnzeigen = btnAnzeigen;
	}

	public JButton getBtnBezahlen() {
		return btnBezahlen;
	}

	public void setBtnBezahlen(JButton btnBezahlen) {
		this.btnBezahlen = btnBezahlen;
	}


	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * Zugriff auf die View
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rechnungsübersicht window = new Rechnungsübersicht();
					window.frmRechnungsbersicht.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Konstruktor
	 * Create the application.
	 */
	
	 
	
	public Rechnungsübersicht() {
		initialize();
	}

	/**
	 * Fenster / View initialisieren mit den entsprechenden Elementen
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		
		Font customFont12f = FontHandler.registriereSchriftart(12f);
		
		frmRechnungsbersicht = new JFrame();
		frmRechnungsbersicht.setTitle("Rechnungs\u00FCbersicht");
		frmRechnungsbersicht.setBounds(100, 100, 800, 200);
		frmRechnungsbersicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechnungsbersicht.getContentPane().setLayout(null);
		
		lblRechnung = new JLabel("Rechnung:");
		lblRechnung.setFont(customFont12f);
		lblRechnung.setBounds(20, 44, 89, 30);
		frmRechnungsbersicht.getContentPane().add(lblRechnung);
		
		btnAnzeigen = new JButton("anzeigen");
		lblRechnung.setFont(customFont12f);
		btnAnzeigen.setBounds(341, 50, 95, 23);
		frmRechnungsbersicht.getContentPane().add(btnAnzeigen);
		
		btnBezahlen = new JButton("bezahlen");
		lblRechnung.setFont(customFont12f);
		btnBezahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBezahlen.setBounds(457, 50, 95, 23);
		frmRechnungsbersicht.getContentPane().add(btnBezahlen);
	
		lblHintergrund = new JLabel();
		lblHintergrund.setIcon(new ImageIcon(Rechnungsübersicht.class.getResource("/Resources/Hintergrund.png")));
		lblHintergrund.setBounds(0, 0, 800, 600);
		frmRechnungsbersicht.getContentPane().add(lblHintergrund);
		
		btnZuruck = new JButton("Zurück");
		lblRechnung.setFont(customFont12f);
		btnZuruck.setBounds(575, 50, 95, 23);
		frmRechnungsbersicht.getContentPane().add(btnZuruck);
		
		textField = new JTextField();
		textField.setBounds(129, 48, 107, 23);
		frmRechnungsbersicht.getContentPane().add(textField);
		textField.setColumns(10);
	}

	public JButton getBtnZuruck() {
		return btnZuruck;
	}

	public void setBtnZuruck(JButton btnZuruck) {
		this.btnZuruck = btnZuruck;
	}

}
