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
 * Die Klasse PremiumKartView füllt das Fenster mit allen dazugehörigen
 * Inhalten (Buttons, Textfelder usw.).
 * 
 * @author Ferhat Koca
 *
 */
public class PremiumKartView extends JFrame {

	JFrame frame;
	JLabel Frage;
	JButton bestätigen;
	JButton abbrechen;

	/**
	 * Führt die GUI aus.
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
	 * Der Konstruktor führt die Methode initialize aus.
	 * 
	 */
	public PremiumKartView() {
		initialize();

	}

	/**
	 * Initialisert das Objekt.
	 * 
	 * @throws IOException wenn ein Fehler beim füllen des 
	 * Frames  ein Fehler entstanden ist.
	 * 
	 */
	private void initialize() {
		
		Font customFont = FontHandler.registriereSchriftart(30f);
		Font customFont22f = FontHandler.registriereSchriftart(22f);
		
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

		Frage = new JLabel("  Möchten Sie das Kart wirklich fürr 4,99€ erwerben?");
		GridBagConstraints gbc_Frage = new GridBagConstraints();
		gbc_Frage.anchor = GridBagConstraints.NORTH;
		gbc_Frage.insets = new Insets(0, 0, 5, 0);
		gbc_Frage.gridwidth = 3;
		gbc_Frage.gridx = 0;
		gbc_Frage.gridy = 1;
		frame.getContentPane().add(Frage, gbc_Frage);
		Frage.setFont(customFont22f);

		bestätigen = new JButton("Bestätigen");
		GridBagConstraints gbc_bestätigen = new GridBagConstraints();
		gbc_bestätigen.anchor = GridBagConstraints.NORTHEAST;
		gbc_bestätigen.insets = new Insets(0, 0, 5, 5);
		gbc_bestätigen.gridx = 0;
		gbc_bestätigen.gridy = 2;
		bestätigen.setFont(customFont);
		frame.getContentPane().add(bestätigen, gbc_bestätigen);

		abbrechen = new JButton("Abbrechen");
		GridBagConstraints gbc_abbrechen = new GridBagConstraints();
		gbc_abbrechen.insets = new Insets(0, 0, 5, 0);
		gbc_abbrechen.anchor = GridBagConstraints.NORTHWEST;
		gbc_abbrechen.gridx = 2;
		gbc_abbrechen.gridy = 2;
		abbrechen.setFont(customFont);
		frame.getContentPane().add(abbrechen, gbc_abbrechen);
	}

}
