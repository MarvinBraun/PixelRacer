package ProfilBearbeiten;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

//Autor Daniel Zeller

public class ProfilBearbeitenAttributView {

	JFrame frmProfilBearbeiten;
	JTextField textFieldNeu;
	JLabel lblAktAnzeige;
	JLabel lblAktuell;
	JLabel lblNeu;
	JButton btnFertig;
	JButton btnAbbrechen;

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
		frmProfilBearbeiten.setResizable(false);
		frmProfilBearbeiten.setTitle("Profil Bearbeiten - Attribut");
		frmProfilBearbeiten.setBounds(100, 100, 600, 400);
		frmProfilBearbeiten.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProfilBearbeiten.getContentPane().setLayout(null);
		
		lblAktAnzeige = new JLabel("Fehler");
		lblAktAnzeige.setBounds(333, 66, 99, 14);
		frmProfilBearbeiten.getContentPane().add(lblAktAnzeige);
		
		textFieldNeu = new JTextField();
		textFieldNeu.setBounds(333, 91, 198, 20);
		frmProfilBearbeiten.getContentPane().add(textFieldNeu);
		textFieldNeu.setColumns(10);
		
		lblAktuell = new JLabel("Aktuell");
		lblAktuell.setBounds(98, 66, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblAktuell);
		
		lblNeu = new JLabel("Neu");
		lblNeu.setBounds(98, 94, 46, 14);
		frmProfilBearbeiten.getContentPane().add(lblNeu);
		
		btnFertig = new JButton("Fertig");
		btnFertig.setBounds(170, 252, 89, 23);
		btnFertig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AnmeldenStrg strg = new AnmeldenStrg();
				frmProfilBearbeiten.dispose();
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnFertig);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setBounds(333, 252, 89, 23);
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AnmeldenStrg strg = new AnmeldenStrg();
				frmProfilBearbeiten.dispose();
			}
		});
		frmProfilBearbeiten.getContentPane().add(btnAbbrechen);
	}
}
