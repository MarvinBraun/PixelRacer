//@Author Ferhat Koca
package Premium;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import FontHandler.FontHandler;
import Rechnung.anzeigenRechnung_ansicht2;

/**
 * Die Klasse PremiumKartView fuellt das Fenster mit allen dazugehoerigen Inhalten
 * (Buttons, Textfelder usw.).
 * 
 * @author Ferhat Koca
 *
 */
public class PremiumStreckeView extends JFrame {

	private JFrame frame;
	private JLabel Frage;
	private JButton bestaetigen;
	private JButton abbrechen;

	/**
	 * Fuehrt die GUI aus.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremiumStreckeView window = new PremiumStreckeView();
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
	public PremiumStreckeView() {
		initialize();

	}

	/**
	 * Initialisiert das Objekt
	 * 
	 * @throws IOException
	 *             wenn ein Fehler beim fuellen des Frames ein Fehler
	 *             entstanden ist.
	 * 
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 432, 151);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Premiumstrecke erwerben");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 182, 38, 194, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 0, 23, 23, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		Frage = new JLabel("  Moechten Sie die Strecke wirklich fuer 4,99€ erwerben?");
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

	public JFrame getFrame() {
		return frame;
	}

	public JLabel getFrage() {
		return Frage;
	}

	public JButton getBestaetigen() {
		return bestaetigen;
	}

	public JButton getAbbrechen() {
		return abbrechen;
	}

}
