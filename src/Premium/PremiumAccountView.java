
package Premium;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import FontHandler.FontHandler;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Die Klasse PremiumAccountView fuellt das Fenster mit allen dazugehoerigen
 * Inhalten (Buttons, Textfelder usw.).
 * 
 * @author Ferhat Koca
 *
 */
public class PremiumAccountView extends JFrame {

	private JFrame frame;
	private JButton bestaetigen;
	private JButton abbrechen;
	private JLabel Frage;

	/**
	 * Fuehrt die GUI aus.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremiumAccountView window = new PremiumAccountView();
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
	public PremiumAccountView() {
		initialize();

	}

	/**
	 * Initialisiert das Objekt.
	 * 
	 * @throws IOException
	 *             wenn ein Fehler beim fuellen des Frames ein Fehler entstanden
	 *             ist.
	 * 
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 432, 151);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Premium erwerben");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 182, 38, 194, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 0, 23, 23, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		Frage = new JLabel("Moechten Sie wirklich fuer 4,99€ auf Premium upgraden?");
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

	public JButton getBestaetigen() {
		return bestaetigen;
	}

	public JButton getAbbrechen() {
		return abbrechen;
	}

	public JLabel getFrage() {
		return Frage;
	}

	
}
