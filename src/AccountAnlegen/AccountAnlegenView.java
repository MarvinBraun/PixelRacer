package AccountAnlegen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountAnlegenView {

	private JFrame frmPixelRacer;
	private JTextField txtVorname;
	private JTextField txtNachname;
	private JTextField txtGeburtsdatum;
	private JTextField txtEmail;
	private JTextField txtNutzername;
	private JTextField txtPasswort;

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
		txtVorname.setText("Vorname");
		txtVorname.setBounds(300, 100, 86, 20);
		frmPixelRacer.getContentPane().add(txtVorname);
		txtVorname.setColumns(10);
		
		txtNachname = new JTextField();
		txtNachname.setText("Nachname");
		txtNachname.setBounds(300, 131, 86, 20);
		frmPixelRacer.getContentPane().add(txtNachname);
		txtNachname.setColumns(10);
		
		txtGeburtsdatum = new JTextField();
		txtGeburtsdatum.setText("Geburtsdatum");
		txtGeburtsdatum.setBounds(300, 162, 86, 20);
		frmPixelRacer.getContentPane().add(txtGeburtsdatum);
		txtGeburtsdatum.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(300, 193, 86, 20);
		frmPixelRacer.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtNutzername = new JTextField();
		txtNutzername.setText("Nutzername");
		txtNutzername.setBounds(300, 224, 86, 20);
		frmPixelRacer.getContentPane().add(txtNutzername);
		txtNutzername.setColumns(10);
		
		txtPasswort = new JTextField();
		txtPasswort.setText("Passwort");
		txtPasswort.setBounds(300, 255, 86, 20);
		frmPixelRacer.getContentPane().add(txtPasswort);
		txtPasswort.setColumns(10);
		
		JButton btnAnlegen = new JButton("Anlegen");
		btnAnlegen.setBounds(224, 333, 127, 45);
		frmPixelRacer.getContentPane().add(btnAnlegen);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(361, 333, 127, 45);
		frmPixelRacer.getContentPane().add(btnAbbrechen);
	}
}