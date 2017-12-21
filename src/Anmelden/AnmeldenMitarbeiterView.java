package Anmelden;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

//Autor Daniel Zeller

public class AnmeldenMitarbeiterView {

	private JFrame frmPixelRacer; //Deklaration der benötigten Variablen
	private JTextField txtId;
	private JPasswordField pwdPasswort;
	private JLabel lblMitarbeiterid;
	private JLabel lblPasswort;
	private JButton btnAnmelden;
	private JButton btnAbbrechen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnmeldenMitarbeiterView window = new AnmeldenMitarbeiterView();
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
	public AnmeldenMitarbeiterView() { //Konstruktor
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //Initialisierung des Fenster und den dazugehörigen Komponenten
		frmPixelRacer = new JFrame();
		frmPixelRacer.setResizable(false);
		frmPixelRacer.setTitle("Pixel Racer - Mitarbeiterlogin");
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.getContentPane().setLayout(null);
		
		lblMitarbeiterid = new JLabel("MitarbeiterID");
		lblMitarbeiterid.setBounds(252, 111, 217, 14);
		frmPixelRacer.getContentPane().add(lblMitarbeiterid);
		
		txtId = new JTextField();
		txtId.setBounds(252, 134, 217, 20);
		frmPixelRacer.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(252, 165, 217, 14);
		frmPixelRacer.getContentPane().add(lblPasswort);
		
		pwdPasswort = new JPasswordField();
		pwdPasswort.setBounds(252, 190, 217, 20);
		frmPixelRacer.getContentPane().add(pwdPasswort);
		
		btnAnmelden = new JButton("Anmelden");
		btnAnmelden.setBounds(252, 247, 118, 23);
		btnAnmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmPixelRacer.getContentPane().add(btnAnmelden);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(380, 247, 131, 23);
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmPixelRacer.getContentPane().add(btnAbbrechen);
	}

	public JFrame getFrmPixelRacer() { //Getter und Setter der Variablen
		return frmPixelRacer;
	}

	public void setFrmPixelRacer(JFrame frmPixelRacer) {
		this.frmPixelRacer = frmPixelRacer;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JPasswordField getPwdPasswort() {
		return pwdPasswort;
	}

	public void setPwdPasswort(JPasswordField pwdPasswort) {
		this.pwdPasswort = pwdPasswort;
	}

	public JLabel getLblMitarbeiterid() {
		return lblMitarbeiterid;
	}

	public void setLblMitarbeiterid(JLabel lblMitarbeiterid) {
		this.lblMitarbeiterid = lblMitarbeiterid;
	}

	public JLabel getLblPasswort() {
		return lblPasswort;
	}

	public void setLblPasswort(JLabel lblPasswort) {
		this.lblPasswort = lblPasswort;
	}

	public JButton getBtnAnmelden() {
		return btnAnmelden;
	}

	public void setBtnAnmelden(JButton btnAnmelden) {
		this.btnAnmelden = btnAnmelden;
	}

	public JButton getBtnAbbrechen() {
		return btnAbbrechen;
	}

	public void setBtnAbbrechen(JButton btnAbbrechen) {
		this.btnAbbrechen = btnAbbrechen;
	}
}
