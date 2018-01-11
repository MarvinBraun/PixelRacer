package Premium;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import FontHandler.FontHandler;
import Rechnung.anzeigenRechnung_ansicht2;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Die Klasse PremiumKartView fuellt das Fenster mit allen dazugehoerigen
 * Inhalten (Buttons, Textfelder usw.).
 * 
 * @author Ferhat Koca
 *
 */
public class PremiumKartView extends JFrame {

	JFrame frame;
	JLabel Frage;
	JButton bestaetigen;
	JButton abbrechen;

	/**
	 * Fuehrt die GUI aus.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremiumKartView window = new PremiumKartView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Der Konstruktor fuehrt die Methode initialize aus.
	 * 
	 */
	public PremiumKartView() {
		initialize();

	}

	/**
	 * Initialisert das Objekt.
	 * 
	 * @throws IOException wenn ein Fehler beim fuellen des 
	 * Frames  ein Fehler entstanden ist.
	 * 
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 432, 151);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Premiumkart erwerben");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 182, 38, 194, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 0, 23, 23, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		Frage = new JLabel("  Moechten Sie das Kart wirklich fuerr 4,99€ erwerben?");
		GridBagConstraints gbc_Frage = new GridBagConstraints();
		gbc_Frage.anchor = GridBagConstraints.NORTH;
		gbc_Frage.insets = new Insets(0, 0, 5, 0);
		gbc_Frage.gridwidth = 3;
		gbc_Frage.gridx = 0;
		gbc_Frage.gridy = 1;
		frame.getContentPane().add(Frage, gbc_Frage);

		bestaetigen = new JButton("Bestaetigen");
		GridBagConstraints gbc_bestaetigen = new GridBagConstraints();
		gbc_bestaetigen.anchor = GridBagConstraints.NORTHEAST;
		gbc_bestaetigen.insets = new Insets(0, 0, 5, 5);
		gbc_bestaetigen.gridx = 0;
		gbc_bestaetigen.gridy = 2;
		frame.getContentPane().add(bestaetigen, gbc_bestaetigen);

		abbrechen = new JButton("Abbrechen");
		GridBagConstraints gbc_abbrechen = new GridBagConstraints();
		gbc_abbrechen.insets = new Insets(0, 0, 5, 0);
		gbc_abbrechen.anchor = GridBagConstraints.NORTHWEST;
		gbc_abbrechen.gridx = 2;
		gbc_abbrechen.gridy = 2;
		frame.getContentPane().add(abbrechen, gbc_abbrechen);
	}

}
