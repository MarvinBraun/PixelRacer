package Kart;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import BackgroundAnimation.Movement;

public class Kartuebersicht {

	JFrame frmPixelRacer;
	JButton kartForward;
	JButton kartBackward;

	JButton btnZurueck;
	JLabel kartName;
	JLabel kartLbl;
	JLabel lblHintergrund;
	JLabel lblNewLabel;
	JLabel lblKartPunkte;
	JButton btnDetailView;
	JLabel lblKartPunkteLimit;
	JButton btnKartKaufen;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kartuebersicht window = new Kartuebersicht();
					window.frmPixelRacer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Kartuebersicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmPixelRacer = new JFrame();
		frmPixelRacer.setTitle("Pixel Racer - Kartübersicht");
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.setVisible(true);
		frmPixelRacer.setResizable(false);
		frmPixelRacer.getContentPane().setLayout(null);

		kartForward = new JButton("");
		kartForward.setBorderPainted(false);
		kartForward.setIcon(new ImageIcon(Kartuebersicht.class
				.getResource("/Resources/forward.png")));
		kartForward.setContentAreaFilled(false);
		kartForward.setBounds(712, 238, 60, 60);
		kartForward.setVisible(true);
		frmPixelRacer.getContentPane().add(kartForward);

		kartBackward = new JButton("");
		kartBackward.setBorderPainted(false);
		kartBackward.setIcon(new ImageIcon(Kartuebersicht.class
				.getResource("/Resources/backward.png")));
		kartBackward.setOpaque(false);
		kartBackward.setContentAreaFilled(false);
		kartBackward.setBounds(27, 238, 60, 60);
		kartBackward.setVisible(true);
		frmPixelRacer.getContentPane().add(kartBackward);

		kartLbl = new JLabel("", JLabel.CENTER);
		kartLbl.setBounds(247, 144, 300, 200);
		kartLbl.setVisible(true);
		frmPixelRacer.getContentPane().add(kartLbl);

		kartName = new JLabel("FireBird", JLabel.CENTER);
		kartName.setFont(new Font("pixelmix", Font.PLAIN, 27));
		kartName.setBounds(296, 355, 215, 60);
		kartName.setVisible(true);
		frmPixelRacer.getContentPane().add(kartName);

		btnDetailView = new JButton("Zeig mir mehr!");
		btnDetailView.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnDetailView.setBounds(282, 428, 229, 35);
		btnDetailView.setVisible(true);
		frmPixelRacer.getContentPane().add(btnDetailView);

		lblKartPunkte = new JLabel("New label");
		lblKartPunkte.setVisible(false);
		lblKartPunkte.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblKartPunkte.setBounds(282, 474, 229, 65);
		frmPixelRacer.getContentPane().add(lblKartPunkte);

		lblKartPunkteLimit = new JLabel("New label");
		lblKartPunkteLimit.setVisible(false);
		lblKartPunkteLimit.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblKartPunkteLimit.setBounds(165, 474, 478, 76);
		frmPixelRacer.getContentPane().add(lblKartPunkteLimit);

		btnZurueck = new JButton("Zur\u00FCck");
		btnZurueck.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnZurueck.setBounds(27, 510, 102, 29);
		frmPixelRacer.getContentPane().add(btnZurueck);
		btnZurueck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		lblHintergrund = new JLabel("");
		lblHintergrund.setVisible(false);
		lblHintergrund.setBounds(0, 0, 794, 571);
		frmPixelRacer.getContentPane().add(lblHintergrund);

		Movement m = new Movement(10);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/Hintergrund.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		m.label.setBufferedImage(image, 0);

		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		frmPixelRacer.getContentPane().add(m.label);

		btnKartKaufen = new JButton("Kart kaufen!");
		btnKartKaufen.setVisible(false);
		btnKartKaufen.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnKartKaufen.setBounds(568, 428, 181, 33);
		frmPixelRacer.getContentPane().add(btnKartKaufen);

	}

	public JFrame getFrmPixelRacer() {
		return frmPixelRacer;
	}

	public void setFrmPixelRacer(JFrame frmPixelRacer) {
		this.frmPixelRacer = frmPixelRacer;
	}

	public JLabel getLblHintergrund() {
		return lblHintergrund;
	}

	public void setLblHintergrund(JLabel lblHintergrund) {
		this.lblHintergrund = lblHintergrund;
	}

	public JButton getBtnkartKaufen() {
		return btnKartKaufen;
	}

	public void setBtnkartKaufen(JButton btnkartKaufen) {
		this.btnKartKaufen = btnkartKaufen;
	}

	public JFrame getFrame() {
		return frmPixelRacer;
	}

	public void setFrame(JFrame frame) {
		this.frmPixelRacer = frame;
	}

	public JButton getkartForward() {
		return kartForward;
	}

	public void setkartForward(JButton kartForward) {
		this.kartForward = kartForward;
	}

	public JButton getkartBackward() {
		return kartBackward;
	}

	public void setkartBackward(JButton kartBackward) {
		this.kartBackward = kartBackward;
	}

	public JLabel getkartName() {
		return kartName;
	}

	public void setkartName(JLabel kartName) {
		this.kartName = kartName;
	}

	public JLabel getkartLbl() {
		return kartLbl;
	}

	public void setkartLbl(JLabel kartLbl) {
		this.kartLbl = kartLbl;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JButton getBtnDetailView() {
		return btnDetailView;
	}

	public void setBtnDetailView(JButton btnDetailView) {
		this.btnDetailView = btnDetailView;
	}

	public JLabel getlblKartPunkte() {
		return lblKartPunkte;
	}

	public void setlblKartPunkte(JLabel lblKartPunkte) {
		this.lblKartPunkte = lblKartPunkte;
	}

	public JLabel getlblKartPunkteLimit() {
		return lblKartPunkteLimit;
	}

	public void setlblKartPunkteLimit(JLabel lblKartPunkteLimit) {
		this.lblKartPunkteLimit = lblKartPunkteLimit;
	}

	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
	}
}
