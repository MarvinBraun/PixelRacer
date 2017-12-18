package AccountAnlegen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

//Autor Daniel Zeller

public class AccountAnlegenView {

	private JFrame frmPixelRacer;
	private JTextField txtVorname;
	private JTextField txtNachname;
	private JTextField txtGeburtsdatum;
	private JTextField txtEmail;
	private JTextField txtNutzername;
	private JPasswordField passwordField;
	private JButton btnAnlegen;
	private JButton btnAbbrechen;
	private JLabel lblVorname;
	private JLabel lblNachname;
	private JLabel lblGeburtsdatum;
	private JLabel lblEmail;
	private JLabel lblBenutzername;
	private JLabel lblPasswort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountAnlegenView window = new AccountAnlegenView();
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
	public AccountAnlegenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPixelRacer = new JFrame();
		frmPixelRacer.setResizable(false);
		frmPixelRacer.setTitle("Pixel Racer - Account Anlegen");
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setLocationRelativeTo(null);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.getContentPane().setLayout(null);
		
		txtVorname = new JTextField();
		txtVorname.setBounds(300, 53, 86, 20);
		frmPixelRacer.getContentPane().add(txtVorname);
		txtVorname.setColumns(10);
		
		txtNachname = new JTextField();
		txtNachname.setBounds(300, 107, 86, 20);
		frmPixelRacer.getContentPane().add(txtNachname);
		txtNachname.setColumns(10);
		
		txtGeburtsdatum = new JTextField();
		txtGeburtsdatum.setBounds(300, 162, 86, 20);
		frmPixelRacer.getContentPane().add(txtGeburtsdatum);
		txtGeburtsdatum.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(300, 218, 86, 20);
		frmPixelRacer.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtNutzername = new JTextField();
		txtNutzername.setBounds(300, 274, 86, 20);
		frmPixelRacer.getContentPane().add(txtNutzername);
		txtNutzername.setColumns(10);
		
		btnAnlegen = new JButton("Anlegen");
		btnAnlegen.setBounds(223, 390, 127, 45);
		frmPixelRacer.getContentPane().add(btnAnlegen);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(362, 390, 127, 45);
		frmPixelRacer.getContentPane().add(btnAbbrechen);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(300, 330, 86, 20);
		frmPixelRacer.getContentPane().add(passwordField);
		
		lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(300, 28, 189, 14);
		frmPixelRacer.getContentPane().add(lblVorname);
		
		lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(300, 82, 86, 14);
		frmPixelRacer.getContentPane().add(lblNachname);
		
		lblGeburtsdatum = new JLabel("Geburtsdatum");
		lblGeburtsdatum.setBounds(300, 137, 127, 14);
		frmPixelRacer.getContentPane().add(lblGeburtsdatum);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(300, 193, 46, 14);
		frmPixelRacer.getContentPane().add(lblEmail);
		
		lblBenutzername = new JLabel("Benutzername");
		lblBenutzername.setBounds(300, 249, 149, 14);
		frmPixelRacer.getContentPane().add(lblBenutzername);
		
		lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(300, 305, 109, 14);
		frmPixelRacer.getContentPane().add(lblPasswort);
		
		JLabel lblHintergrund = new JLabel();
		lblHintergrund.setIcon(new ImageIcon("src/Resources/Hintergrund.png"));
		lblHintergrund.setBounds(0, 0, 800, 600);
		frmPixelRacer.getContentPane().add(lblHintergrund);
	}

	public JFrame getFrmPixelRacer() {
		return frmPixelRacer;
	}

	public void setFrmPixelRacer(JFrame frmPixelRacer) {
		this.frmPixelRacer = frmPixelRacer;
	}

	public JTextField getTxtVorname() {
		return txtVorname;
	}

	public void setTxtVorname(JTextField txtVorname) {
		this.txtVorname = txtVorname;
	}

	public JTextField getTxtNachname() {
		return txtNachname;
	}

	public void setTxtNachname(JTextField txtNachname) {
		this.txtNachname = txtNachname;
	}

	public JTextField getTxtGeburtsdatum() {
		return txtGeburtsdatum;
	}

	public void setTxtGeburtsdatum(JTextField txtGeburtsdatum) {
		this.txtGeburtsdatum = txtGeburtsdatum;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtNutzername() {
		return txtNutzername;
	}

	public void setTxtNutzername(JTextField txtNutzername) {
		this.txtNutzername = txtNutzername;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getBtnAnlegen() {
		return btnAnlegen;
	}

	public void setBtnAnlegen(JButton btnAnlegen) {
		this.btnAnlegen = btnAnlegen;
	}

	public JButton getBtnAbbrechen() {
		return btnAbbrechen;
	}

	public void setBtnAbbrechen(JButton btnAbbrechen) {
		this.btnAbbrechen = btnAbbrechen;
	}

	public JLabel getLblVorname() {
		return lblVorname;
	}

	public void setLblVorname(JLabel lblVorname) {
		this.lblVorname = lblVorname;
	}

	public JLabel getLblNachname() {
		return lblNachname;
	}

	public void setLblNachname(JLabel lblNachname) {
		this.lblNachname = lblNachname;
	}

	public JLabel getLblGeburtsdatum() {
		return lblGeburtsdatum;
	}

	public void setLblGeburtsdatum(JLabel lblGeburtsdatum) {
		this.lblGeburtsdatum = lblGeburtsdatum;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblBenutzername() {
		return lblBenutzername;
	}

	public void setLblBenutzername(JLabel lblBenutzername) {
		this.lblBenutzername = lblBenutzername;
	}

	public JLabel getLblPasswort() {
		return lblPasswort;
	}

	public void setLblPasswort(JLabel lblPasswort) {
		this.lblPasswort = lblPasswort;
	}
}
