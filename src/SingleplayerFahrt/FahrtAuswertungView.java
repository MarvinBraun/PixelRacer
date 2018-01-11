package SingleplayerFahrt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import BackgroundAnimation.Movement;
import BackgroundAnimation.MovementY;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class FahrtAuswertungView {

	private JFrame frame;
	private JButton btnNewButton;
	private JLabel lblDeinPlatz;
	private JLabel lblNewLabel ;
	private JLabel lblDeineZeit;
	private JLabel lblGewonnenPunkte;
	private JLabel lblBackground;
	private JLabel lblConfetti;
	private MovementY m;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrtAuswertungView window = new FahrtAuswertungView();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FahrtAuswertungView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		setBtnNewButton(new JButton("Weiter"));
		getBtnNewButton().setBackground(new Color(60, 179, 113));
		getBtnNewButton().setBorder(null);
		getBtnNewButton().setFont(new Font("pixelmix", Font.BOLD, 34));
		getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getBtnNewButton().setBounds(226, 451, 325, 67);
		getFrame().getContentPane().add(getBtnNewButton());
		
		setLblDeinPlatz(new JLabel("Dein Platz: "));
		getLblDeinPlatz().setForeground(Color.RED);
		getLblDeinPlatz().setFont(new Font("pixelmix", Font.BOLD, 30));
		getLblDeinPlatz().setBounds(10, 0, 541, 112);
		getFrame().getContentPane().add(getLblDeinPlatz());
		
		setLblDeineZeit(new JLabel("Deine Zeit: "));
		getLblDeineZeit().setForeground(Color.RED);
		getLblDeineZeit().setFont(new Font("pixelmix", Font.BOLD, 30));
		getLblDeineZeit().setBounds(10, 87, 541, 112);
		getFrame().getContentPane().add(getLblDeineZeit());
		
		setLblGewonnenPunkte(new JLabel("Gewonnene Punkte: "));
		getLblGewonnenPunkte().setForeground(Color.RED);
		getLblGewonnenPunkte().setFont(new Font("pixelmix", Font.BOLD, 30));
		getLblGewonnenPunkte().setBounds(10, 171, 541, 124);
		getFrame().getContentPane().add(getLblGewonnenPunkte());
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FahrtAuswertungView.class.getResource("/Resources/trophae.png")));
		lblNewLabel.setBounds(285, 266, 198, 200);
		getFrame().getContentPane().add(lblNewLabel);
		
		lblConfetti = new JLabel("");
		lblConfetti.setBounds(0, 0, 784, 561);
		getFrame().getContentPane().add(lblConfetti);
		
		m = new MovementY(13);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/konfetti.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m.label.setBufferedImage(image,0);
		m.label.setOpaque(false);
		m.label.setBounds(100, 100, 800, 600);
		m.label.setVisible(true);
		
		getFrame().getContentPane().add(m.label);
		
		setLblBackground(new JLabel(""));
		getLblBackground().setBounds(0, 0, 784, 561);
		getFrame().getContentPane().add(getLblBackground());
		
		
		getFrame().setVisible(true);
		
	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLblDeineZeit() {
		return lblDeineZeit;
	}

	public void setLblDeineZeit(JLabel lblDeineZeit) {
		this.lblDeineZeit = lblDeineZeit;
	}

	public JLabel getLblDeinPlatz() {
		return lblDeinPlatz;
	}

	public void setLblDeinPlatz(JLabel lblDeinPlatz) {
		this.lblDeinPlatz = lblDeinPlatz;
	}

	public JLabel getLblBackground() {
		return lblBackground;
	}

	public void setLblBackground(JLabel lblBackground) {
		this.lblBackground = lblBackground;
	}

	public JLabel getLblGewonnenPunkte() {
		return lblGewonnenPunkte;
	}

	public void setLblGewonnenPunkte(JLabel lblGewonnenPunkte) {
		this.lblGewonnenPunkte = lblGewonnenPunkte;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
		btnNewButton.setFocusPainted(false);
	}

}
