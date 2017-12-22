package MultiplayerFahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FahrtAuswertungMultiplayer {

	private JFrame frame;

	private JButton best�tigenBtn;
	private JLabel lblDeinPlatz;
	private JLabel lblDeineZeit;
	private JLabel lblGewonnenPunkte;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrtAuswertungMultiplayer window = new FahrtAuswertungMultiplayer();
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
	public FahrtAuswertungMultiplayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		best�tigenBtn = new JButton("Best�tigen");
	
		best�tigenBtn.setBounds(291, 483, 192, 67);
		frame.getContentPane().add(best�tigenBtn);
		
		lblDeinPlatz = new JLabel("Dein Platz:");
		lblDeinPlatz.setBounds(291, 11, 142, 41);
		frame.getContentPane().add(lblDeinPlatz);
		
		lblDeineZeit = new JLabel("Deine Zeit:");
		lblDeineZeit.setBounds(291, 60, 142, 34);
		frame.getContentPane().add(lblDeineZeit);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\podest.png"));
		lblNewLabel.setBounds(193, 266, 404, 200);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBest�tigenBtn() {
		return best�tigenBtn;
	}

	public void setBest�tigenBtn(JButton best�tigenBtn) {
		this.best�tigenBtn = best�tigenBtn;
	}

	public JLabel getLblDeinPlatz() {
		return lblDeinPlatz;
	}

	public void setLblDeinPlatz(JLabel lblDeinPlatz) {
		this.lblDeinPlatz = lblDeinPlatz;
	}

	public JLabel getLblDeineZeit() {
		return lblDeineZeit;
	}

	public void setLblDeineZeit(JLabel lblDeineZeit) {
		this.lblDeineZeit = lblDeineZeit;
	}

	public JLabel getLblGewonnenPunkte() {
		return lblGewonnenPunkte;
	}

	public void setLblGewonnenPunkte(JLabel lblGewonnenPunkte) {
		this.lblGewonnenPunkte = lblGewonnenPunkte;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}


}
