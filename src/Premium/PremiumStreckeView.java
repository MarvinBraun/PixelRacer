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

import Rechnung.anzeigenRechnung_ansicht2;

/**
 * Die Klasse PremiumKartView füllt das Fenster mit allen dazugehörigen Inhalten
 * (Buttons, Textfelder usw.).
 * 
 * @author Ferhat Koca
 *
 */
public class PremiumStreckeView extends JFrame {

	JFrame frame;
	JLabel Frage;
	JButton bestätigen;
	JButton abbrechen;

	/**
	 * Die main-Methode ruft die Klasse, durch den Konstruktor selber, auf und setzt
	 * das Fenster auf sichtbar.
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
	 * Der Konstruktor führt die Methode initialize aus.
	 * 
	 */
	public PremiumStreckeView() {
		initialize();

	}

	/**
	 * Die Methode initialize füllt den Inhalt des Frames.
	 * 
	 * @throws IOException
	 *             wenn ein Fehler beim füllen des Frames mit Werten ein Fehler
	 *             entstanden ist.
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 432, 151);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Premiumstrecke erwerben");
		frame.setResizable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 182, 38, 194, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 0, 23, 23, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		Frage = new JLabel("  Möchten Sie die Strecke wirklich für 4,99€ erwerben?");
		GridBagConstraints gbc_Frage = new GridBagConstraints();
		gbc_Frage.anchor = GridBagConstraints.NORTH;
		gbc_Frage.insets = new Insets(0, 0, 5, 0);
		gbc_Frage.gridwidth = 3;
		gbc_Frage.gridx = 0;
		gbc_Frage.gridy = 1;
		frame.getContentPane().add(Frage, gbc_Frage);
		Frage.setFont(new Font("Calibri", Font.PLAIN, 18));

		bestätigen = new JButton("Bestätigen");
		GridBagConstraints gbc_bestätigen = new GridBagConstraints();
		gbc_bestätigen.anchor = GridBagConstraints.NORTHEAST;
		gbc_bestätigen.insets = new Insets(0, 0, 5, 5);
		gbc_bestätigen.gridx = 0;
		gbc_bestätigen.gridy = 2;
		frame.getContentPane().add(bestätigen, gbc_bestätigen);

		abbrechen = new JButton("Abbrechen");
		GridBagConstraints gbc_abbrechen = new GridBagConstraints();
		gbc_abbrechen.insets = new Insets(0, 0, 5, 0);
		gbc_abbrechen.anchor = GridBagConstraints.NORTHWEST;
		gbc_abbrechen.gridx = 2;
		gbc_abbrechen.gridy = 2;
		frame.getContentPane().add(abbrechen, gbc_abbrechen);
	}

}
