
package Premium;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;

import FontHandler.FontHandler;

import java.awt.Font;

import Rechnung.anzeigenRechnung_ansicht2;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Die Klasse PremiumAccountView füllt das Fenster mit allen dazugehörigen
 * Inhalten (Buttons, Textfelder usw.).
 * 
 * @author Ferhat Koca
 *
 */
public class PremiumAccountView extends JFrame {

	JFrame frame;
	JButton bestätigen = new JButton("Bestätigen");
	JButton abbrechen = new JButton("Abbrechen");
	JLabel Frage;
	anzeigenRechnung_ansicht2 rechnung = new anzeigenRechnung_ansicht2();

	/**
	 * Führt die GUI aus.
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
	 * Der Konstruktor führt die Methode initialize aus.
	 * 
	 */
	public PremiumAccountView() {
		initialize();

	}

	/**
	 * Initialisiert das Objekt.
	 * 
	 * @throws IOException wenn ein Fehler beim füllen des 
	 * Frames ein Fehler entstanden ist.
	 * 
	 */
	private void initialize() {
		
		Font customFont = FontHandler.registriereSchriftart(30f);
		Font customFont22f = FontHandler.registriereSchriftart(22f);
		
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

		Frage = new JLabel("Möchten Sie wirklich für 4,99€ auf Premium upgraden?");
		GridBagConstraints gbc_Frage = new GridBagConstraints();
		gbc_Frage.anchor = GridBagConstraints.NORTH;
		gbc_Frage.insets = new Insets(0, 0, 5, 0);
		gbc_Frage.gridwidth = 3;
		gbc_Frage.gridx = 0;
		gbc_Frage.gridy = 1;
		frame.getContentPane().add(Frage, gbc_Frage);
		Frage.setFont(customFont22f);

		GridBagConstraints gbc_bestätigen = new GridBagConstraints();
		gbc_bestätigen.anchor = GridBagConstraints.NORTHEAST;
		gbc_bestätigen.insets = new Insets(0, 0, 5, 5);
		gbc_bestätigen.gridx = 0;
		gbc_bestätigen.gridy = 2;
		bestätigen.setFont(customFont);
		frame.getContentPane().add(bestätigen, gbc_bestätigen);

		GridBagConstraints gbc_abbrechen = new GridBagConstraints();
		gbc_abbrechen.insets = new Insets(0, 0, 5, 0);
		gbc_abbrechen.anchor = GridBagConstraints.NORTHWEST;
		gbc_abbrechen.gridx = 2;
		gbc_abbrechen.gridy = 2;
		abbrechen.setFont(customFont);
		frame.getContentPane().add(abbrechen, gbc_abbrechen);

	}

}
