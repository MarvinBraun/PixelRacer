/**
 @author Sean Cartner
*/

package MitarbeiterHinzugügen;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;
import javax.swing.JPasswordField;


public class MitarbeiterHinzufügenView extends JPanel{

	protected JPanel frmPixelRacer;
	protected JTextField textFieldVorname;
	protected JTextField textFieldNachname;
	protected JTextField textFieldGeburtsdatum;
	protected JTextField textFieldJob;
	protected JTextField textFieldBenutzername;
	protected JButton btnAbsenden;
	protected JButton btnAbbrechen;
	protected JFileChooser fc;
	protected FileFilter filter;
	private JLabel lblMitarbeiterHinzufgen;
	private JTextField textFieldEmail;
	private JLabel lblPasswort;
	private JPasswordField passwordField;



	/**
	 * Create the application.
	 */
	public MitarbeiterHinzufügenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		frmPixelRacer = new JPanel();
		setSize(624, 570);
		setLayout(null);
		
		JLabel lblVorname = new JLabel("Vorname:");
		lblVorname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVorname.setBounds(77, 97, 64, 14);
		add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNachname.setBounds(77, 148, 82, 19);
		add(lblNachname);
		
		JLabel lblGeburtsdatum = new JLabel("Geburtsdatum:");
		lblGeburtsdatum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGeburtsdatum.setBounds(77, 201, 112, 19);
		add(lblGeburtsdatum);
		
		JLabel lblJob = new JLabel("Job:");
		lblJob.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJob.setBounds(78, 256, 36, 14);
		add(lblJob);
		
		textFieldVorname = new JTextField();
		textFieldVorname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldVorname.setColumns(10);
		textFieldVorname.setBounds(265, 89, 175, 30);
		add(textFieldVorname);
		
		textFieldNachname = new JTextField();
		textFieldNachname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNachname.setBounds(265, 142, 175, 30);
		add(textFieldNachname);
		textFieldNachname.setColumns(10);
		
		textFieldGeburtsdatum = new JTextField();
		textFieldGeburtsdatum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldGeburtsdatum.setBounds(265, 195, 175, 30);
		add(textFieldGeburtsdatum);
		textFieldGeburtsdatum.setColumns(10);
		
		textFieldJob = new JTextField();
		textFieldJob.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldJob.setBounds(265, 248, 175, 30);
		add(textFieldJob);
		textFieldJob.setColumns(10);;
		
		JLabel lbBenutzername = new JLabel("Benutzername:");
		lbBenutzername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbBenutzername.setBounds(77, 311, 106, 19);
		add(lbBenutzername);
		
		textFieldBenutzername = new JTextField();
		textFieldBenutzername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldBenutzername.setBounds(265, 301, 175, 30);
		add(textFieldBenutzername);
		textFieldBenutzername.setColumns(10);
		
		fc = new JFileChooser();
		filter = new FileNameExtensionFilter("Portable Network Graphics (*.png)", "png");
		
		btnAbsenden = new JButton("absenden");
		btnAbsenden.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbsenden.setBounds(345, 479, 95, 23);
		add(btnAbsenden);
		
		lblMitarbeiterHinzufgen = new JLabel("Mitarbeiter Hinzuf\u00FCgen");
		lblMitarbeiterHinzufgen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMitarbeiterHinzufgen.setBounds(78, 30, 242, 30);
		add(lblMitarbeiterHinzufgen);
		
		btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbbrechen.setBounds(225, 479, 101, 23);
		add(btnAbbrechen);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(77, 366, 46, 14);
		add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldEmail.setBounds(265, 354, 175, 29);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPasswort.setBounds(77, 421, 76, 14);
		add(lblPasswort);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(265, 407, 175, 30);
		add(passwordField);
	}
}
