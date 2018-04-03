package Rechnung;

import BackgroundAnimation.Movement;
import BackgroundAnimation.MovementBackward;
import FontHandler.FontHandler;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class RechnungsuebersichtView {

	private JFrame frame;
	private JButton btnanz;
	private JButton btnzurück;
	private JComboBox<Integer> drop;
	private JLabel lblHintergrund;
	private JLabel lblrechnung;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechnungsuebersichtView window = new RechnungsuebersichtView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RechnungsuebersichtView() {
		initialize();
	}

	private void initialize() {

		Font customFont = FontHandler.registriereSchriftart(12f);

		setFrame(new JFrame());
		
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setTitle("Rechnungsübersicht");
		getFrame().setResizable(false);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setLocationRelativeTo(null);

		setLblrechnung(new JLabel("Rechnungsnummer auswaehlen:"));
		getLblrechnung().setBounds(150, 100, 1000, 200);
		getLblrechnung().setFont(customFont);
		getFrame().getContentPane().add(lblrechnung);

		setDrop(new JComboBox<Rechnung>());
		getDrop().setBounds(400, 190, 250, 20);
		getFrame().getContentPane().add(drop);

		setBtnanz(new JButton("Anzeigen"));
		getBtnanz().setBounds(225, 240, 150, 35);
		getBtnanz().setFont(customFont);
		getBtnanz().setOpaque(false);
		getFrame().getContentPane().add(btnanz);

		
		setBtnzurück(new JButton("Zurueck"));
		getBtnzurück().setBounds(425, 240, 150, 35);
		getBtnzurück().setFont(customFont);
		getBtnzurück().setOpaque(false);
		getFrame().getContentPane().add(btnzurück);
		
		lblHintergrund = new JLabel("");
		lblHintergrund.setVisible(false);
		lblHintergrund.setOpaque(true);
		lblHintergrund.setBounds(0, 0, 794, 571);
		getFrame().getContentPane().add(lblHintergrund);

		Movement m = new Movement(10);

		BufferedImage image = null;
		try {
			URL url = getClass().getResource("/Resources/Hintergrund.png");
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		m.label.setBufferedImage(image, 0);

		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		getFrame().getContentPane().add(m.label);
		getFrame().setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getBtnanz() {
		return btnanz;
	}

	public void setBtnanz(JButton btnanz) {
		this.btnanz = btnanz;
	}

	public JButton getBtnzurück() {
		return btnzurück;
	}

	public void setBtnzurück(JButton btnzurück) {
		this.btnzurück = btnzurück;
	}

	public JComboBox getDrop() {
		return drop;
	}

	public void setDrop(JComboBox drop) {
		this.drop = drop;
	}

	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}

	public JLabel getLblrechnung() {
		return lblrechnung;
	}

	public void setLblrechnung(JLabel lblrechnung) {
		this.lblrechnung = lblrechnung;
	}
}
