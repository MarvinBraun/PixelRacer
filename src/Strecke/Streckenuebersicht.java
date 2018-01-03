package Strecke;

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



public class Streckenuebersicht {

	JFrame frmPixelRacer;
	JButton streckeForward;
	JButton streckeBackward;
	JButton btnZurueck;
	JLabel streckeName;
	JLabel streckeLbl;
	JLabel lblHintergrund;
	JLabel lblNewLabel;
	JLabel lblStreckePunkte;
	JButton btnDetailView;
	JLabel lblStreckePunkteLimit;
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Streckenuebersicht window = new Streckenuebersicht();
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
	public Streckenuebersicht() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmPixelRacer = new JFrame();
		frmPixelRacer.setTitle("Pixel Racer - Strecken\u00FCbersicht");
		frmPixelRacer.setBounds(100, 100, 800, 600);
		frmPixelRacer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPixelRacer.setVisible(true);
		frmPixelRacer.setResizable(false);
		frmPixelRacer.getContentPane().setLayout(null);
		
		streckeForward = new JButton("");
		streckeForward.setBorderPainted(false);
		streckeForward.setIcon(new ImageIcon(Streckenuebersicht.class.getResource("/Resources/forward.png")));
		streckeForward.setContentAreaFilled(false);
		streckeForward.setBounds(712, 238, 60, 60);
		streckeForward.setVisible(true);
		frmPixelRacer.getContentPane().add(streckeForward);
		
		streckeBackward = new JButton("");
		streckeBackward.setBorderPainted(false);
		streckeBackward.setIcon(new ImageIcon(Streckenuebersicht.class.getResource("/Resources/backward.png")));
		streckeBackward.setOpaque(false);
		streckeBackward.setContentAreaFilled(false);
		streckeBackward.setBounds(27, 238, 60, 60);
		streckeBackward.setVisible(true);
		frmPixelRacer.getContentPane().add(streckeBackward);
		
		streckeLbl = new JLabel("", JLabel.CENTER);
		streckeLbl.setBounds(247, 144, 300, 200);
		streckeLbl.setVisible(true);
		frmPixelRacer.getContentPane().add(streckeLbl);
		
		
		streckeName = new JLabel("Hockenheim", JLabel.CENTER);
		streckeName.setFont(new Font("pixelmix", Font.PLAIN, 27));
		streckeName.setBounds(296, 355, 215, 60);
		streckeName.setVisible(true);
		frmPixelRacer.getContentPane().add(streckeName);
		
		btnDetailView = new JButton("Zeig mir mehr!");
		btnDetailView.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnDetailView.setBounds(282, 428, 229, 35);
		btnDetailView.setVisible(true);
		frmPixelRacer.getContentPane().add(btnDetailView);
		
		lblStreckePunkte = new JLabel("New label");
		lblStreckePunkte.setVisible(false);
		lblStreckePunkte.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblStreckePunkte.setBounds(282, 474, 229, 65);
		frmPixelRacer.getContentPane().add(lblStreckePunkte);
		
		lblStreckePunkteLimit = new JLabel("New label");
		lblStreckePunkteLimit.setVisible(false);
		lblStreckePunkteLimit.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblStreckePunkteLimit.setBounds(165, 474, 478, 76);
		frmPixelRacer.getContentPane().add(lblStreckePunkteLimit);
		
		btnZurueck = new JButton("Zur\u00FCck");
		btnZurueck.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnZurueck.setBounds(27, 510, 102, 29);
		frmPixelRacer.getContentPane().add(btnZurueck);
		btnZurueck.addActionListener(new ActionListener(){

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
		
		m.label.setBufferedImage(image,0);
		
		m.label.setOpaque(false);
		m.label.setBounds(0, 0, 800, 600);
		frmPixelRacer.getContentPane().add(m.label);
		
	}

	public JFrame getFrame() {
		return frmPixelRacer;
	}

	public void setFrame(JFrame frame) {
		this.frmPixelRacer = frame;
	}

	public JButton getStreckeForward() {
		return streckeForward;
	}

	public void setStreckeForward(JButton streckeForward) {
		this.streckeForward = streckeForward;
	}

	public JButton getStreckeBackward() {
		return streckeBackward;
	}

	public void setStreckeBackward(JButton streckeBackward) {
		this.streckeBackward = streckeBackward;
	}

	public JLabel getStreckeName() {
		return streckeName;
	}

	public void setStreckeName(JLabel streckeName) {
		this.streckeName = streckeName;
	}

	public JLabel getStreckeLbl() {
		return streckeLbl;
	}

	public void setStreckeLbl(JLabel streckeLbl) {
		this.streckeLbl = streckeLbl;
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
	public JLabel getLblStreckePunkte() {
		return lblStreckePunkte;
	}

	public void setLblStreckePunkte(JLabel lblStreckePunkte) {
		this.lblStreckePunkte = lblStreckePunkte;
	}
	
	public JLabel getLblStreckePunkteLimit() {
		return lblStreckePunkteLimit;
	}

	public void setLblStreckePunkteLimit(JLabel lblStreckePunkteLimit) {
		this.lblStreckePunkteLimit = lblStreckePunkteLimit;
	}
	public JButton getBtnZurueck() {
		return btnZurueck;
	}

	public void setBtnZurueck(JButton btnZurueck) {
		this.btnZurueck = btnZurueck;
	}
}
