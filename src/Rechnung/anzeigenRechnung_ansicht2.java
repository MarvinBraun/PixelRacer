package Rechnung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class anzeigenRechnung_ansicht2 {

	private JFrame frmRechnungsbersicht;
	private JTextField txtXyz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anzeigenRechnung_ansicht2 window = new anzeigenRechnung_ansicht2();
					window.frmRechnungsbersicht.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public anzeigenRechnung_ansicht2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRechnungsbersicht = new JFrame();
		frmRechnungsbersicht.setResizable(false);
		frmRechnungsbersicht.setTitle("Rechnungs\u00FCbersicht");
		frmRechnungsbersicht.setBounds(100, 100, 800, 600);
		frmRechnungsbersicht.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRechnungsbersicht.getContentPane().setLayout(null);
		
		JLabel lblRechnung = new JLabel("Rechnung");
		lblRechnung.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRechnung.setBounds(35, 48, 148, 44);
		frmRechnungsbersicht.getContentPane().add(lblRechnung);
		
		JButton btnAnzeigen = new JButton("anzeigen");
		btnAnzeigen.setBounds(410, 65, 89, 23);
		frmRechnungsbersicht.getContentPane().add(btnAnzeigen);
		
		JButton btnBezahlen = new JButton("bezahlen");
		btnBezahlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBezahlen.setBounds(530, 65, 89, 23);
		frmRechnungsbersicht.getContentPane().add(btnBezahlen);
		
		JButton btnSpeichern = new JButton("speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSpeichern.setBounds(654, 65, 89, 23);
		frmRechnungsbersicht.getContentPane().add(btnSpeichern);
		
		txtXyz = new JTextField();
		txtXyz.setText("xyz");
		txtXyz.setBounds(219, 66, 86, 20);
		frmRechnungsbersicht.getContentPane().add(txtXyz);
		txtXyz.setColumns(10);
	}
}
