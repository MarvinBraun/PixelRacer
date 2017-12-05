package AccountAnlegen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class AccountAnlegenView {

	private JFrame frmPixelRacer;
	private JTextField txtVorname;
	private JTextField txtNachname;
	private JTextField txtGeburtsdatum;
	private JTextField txtEmail;
	private JTextField txtNutzername;
	private JPasswordField passwordField;

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
		
		JButton btnAnlegen = new JButton("Anlegen");
		btnAnlegen.setBounds(223, 390, 127, 45);
		frmPixelRacer.getContentPane().add(btnAnlegen);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(362, 390, 127, 45);
		frmPixelRacer.getContentPane().add(btnAbbrechen);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(300, 330, 86, 20);
		frmPixelRacer.getContentPane().add(passwordField);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(300, 28, 46, 14);
		frmPixelRacer.getContentPane().add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(300, 82, 86, 14);
		frmPixelRacer.getContentPane().add(lblNachname);
		
		JLabel lblGeburtsdatum = new JLabel("Geburtsdatum");
		lblGeburtsdatum.setBounds(300, 137, 127, 14);
		frmPixelRacer.getContentPane().add(lblGeburtsdatum);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(300, 193, 46, 14);
		frmPixelRacer.getContentPane().add(lblEmail);
		
		JLabel lblBenutzername = new JLabel("Benutzername");
		lblBenutzername.setBounds(300, 249, 149, 14);
		frmPixelRacer.getContentPane().add(lblBenutzername);
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(300, 305, 109, 14);
		frmPixelRacer.getContentPane().add(lblPasswort);
	}
}