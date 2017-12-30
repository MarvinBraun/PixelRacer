//@Author Ferhat Koca
package Kart;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Strecke.Streckenuebersicht;

public class Kartuebersicht {

	JFrame frame;
	JButton kartForward;
	JButton kartBackward;
	JLabel kartName;
	JLabel kartLbl;
	JLabel lblNewLabel;
	JButton btnDetailView;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kartuebersicht window = new Kartuebersicht();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Kartuebersicht() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		kartForward = new JButton("");
		kartForward.setBorderPainted(false);
		kartForward.setIcon(new ImageIcon(Kartuebersicht.class.getResource("/Resources/forward.png")));
		kartForward.setContentAreaFilled(false);
		kartForward.setBounds(712, 238, 60, 60);
		kartForward.setVisible(true);
		frame.getContentPane().add(kartForward);

		kartBackward = new JButton("");
		kartBackward.setBorderPainted(false);
		kartBackward.setIcon(new ImageIcon(Kartuebersicht.class.getResource("/Resources/backward.png")));
		kartBackward.setOpaque(false);
		kartBackward.setContentAreaFilled(false);
		kartBackward.setBounds(27, 238, 60, 60);
		kartBackward.setVisible(true);
		frame.getContentPane().add(kartBackward);

		kartLbl = new JLabel("", JLabel.CENTER);
		kartLbl.setBounds(247, 144, 300, 200);
		kartLbl.setVisible(true);
		frame.getContentPane().add(kartLbl);

		kartName = new JLabel("Fire Bird", JLabel.CENTER);
		kartName.setFont(new Font("pixelmix", Font.PLAIN, 27));
		kartName.setBounds(296, 355, 215, 60);
		kartName.setVisible(true);
		frame.getContentPane().add(kartName);

		btnDetailView = new JButton("Zeig mir mehr!");
		btnDetailView.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnDetailView.setBounds(282, 428, 229, 35);
		btnDetailView.setVisible(true);
		frame.getContentPane().add(btnDetailView);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getKartForward() {
		return kartForward;
	}

	public JButton getKartBackward() {
		return kartBackward;
	}

	public JLabel getKartName() {
		return kartName;
	}

	public JLabel getKartLbl() {
		return kartLbl;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JButton getBtnDetailView() {
		return btnDetailView;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setKartForward(JButton kartForward) {
		this.kartForward = kartForward;
	}

	public void setKartBackward(JButton kartBackward) {
		this.kartBackward = kartBackward;
	}

	public void setKartName(JLabel kartName) {
		this.kartName = kartName;
	}

	public void setKartLbl(JLabel kartLbl) {
		this.kartLbl = kartLbl;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public void setBtnDetailView(JButton btnDetailView) {
		this.btnDetailView = btnDetailView;
	}

}
