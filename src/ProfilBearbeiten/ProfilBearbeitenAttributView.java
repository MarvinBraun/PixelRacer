package ProfilBearbeiten;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProfilBearbeitenAttributView {

	private JFrame frmProfilBearbeiten;
	private JTextField textFieldNeu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilBearbeitenAttributView window = new ProfilBearbeitenAttributView();
					window.frmProfilBearbeiten.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfilBearbeitenAttributView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfilBearbeiten = new JFrame();
		frmProfilBearbeiten.setTitle("Profil Bearbeiten - Attribut");
		frmProfilBearbeiten.setBounds(100, 100, 600, 400);
		frmProfilBearbeiten.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfilBearbeiten.getContentPane().setLayout(null);
		
		JLabel lblAktAnzeige = new JLabel("Fehler");
		lblAktAnzeige.setBounds(333, 66, 99, 14);
		frmProfilBearbeiten.getContentPane().add(lblAktAnzeige);
		
		textFieldNeu = new JTextField();
		textFieldNeu.setBounds(333, 91, 198, 20);
		frmProfilBearbeiten.getContentPane().add(textFieldNeu);
		textFieldNeu.setColumns(10);
		
		JLabel lblAktuell = new JLabel("Aktuell");
		lblAktuell.setBounds(98, 66, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblAktuell);
		
		JLabel lblNeu = new JLabel("Neu");
		lblNeu.setBounds(98, 94, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblNeu);
		
		JButton btnFertig = new JButton("Fertig");
		btnFertig.setBounds(170, 252, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnFertig);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(333, 252, 89, 23);
		frmProfilBearbeiten.getContentPane().add(btnAbbrechen);
	}
}
