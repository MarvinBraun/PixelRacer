package Premium;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PremiumKartView {

	private JFrame frame;

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public PremiumKartView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 432, 151);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{182, 38, 194, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 23, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel Frage = new JLabel("  M�chten Sie das Kart wirklich f�rr 4,99� erwerben?");
		GridBagConstraints gbc_Frage = new GridBagConstraints();
		gbc_Frage.anchor = GridBagConstraints.NORTH;
		gbc_Frage.insets = new Insets(0, 0, 5, 0);
		gbc_Frage.gridwidth = 3;
		gbc_Frage.gridx = 0;
		gbc_Frage.gridy = 1;
		frame.getContentPane().add(Frage, gbc_Frage);
		Frage.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JButton best�tigen = new JButton("Best�tigen");
		GridBagConstraints gbc_best�tigen = new GridBagConstraints();
		gbc_best�tigen.anchor = GridBagConstraints.NORTHEAST;
		gbc_best�tigen.insets = new Insets(0, 0, 5, 5);
		gbc_best�tigen.gridx = 0;
		gbc_best�tigen.gridy = 2;
		frame.getContentPane().add(best�tigen, gbc_best�tigen);
		
		JButton abbrechen = new JButton("Abbrechen");
		GridBagConstraints gbc_abbrechen = new GridBagConstraints();
		gbc_abbrechen.insets = new Insets(0, 0, 5, 0);
		gbc_abbrechen.anchor = GridBagConstraints.NORTHWEST;
		gbc_abbrechen.gridx = 2;
		gbc_abbrechen.gridy = 2;
		frame.getContentPane().add(abbrechen, gbc_abbrechen);
	}
}
