package MultiplayerAuswertung;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import FontHandler.FontHandler;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Grafische Benutzeroberfläche der Auswertung einer MultiplayerFahrt. 
 * @author Marvin Braun
 *
 */
public class MultiplayerAuswertungView {

	private JFrame frame;
	private JLabel lblName1;
	private JLabel lblName2;
	private JLabel lblName3;
	private JLabel lblZeit2;
	private JLabel lblZeit1;
	private JLabel MultiplayerIdLbl;
	private JLabel lblZeit3;
	private JButton btn;
	
	
	/**
	 * Main-Methode.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiplayerAuswertungView window = new MultiplayerAuswertungView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialisiert und befüllt das Objekt.
	 */
	public MultiplayerAuswertungView() {
		initialize();
	}

	/**
	 * Initialisiert die Inhalte des JFrames.
	 */
	private void initialize() {
		Font customFont16f = FontHandler.registriereSchriftart(16f);
		Font customFont20f = FontHandler.registriereSchriftart(20f);
		Font customFont30f = FontHandler.registriereSchriftart(30f);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel_3 = new JLabel("Rang");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(customFont20f);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 191, 226, 42);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel label = new JLabel("1.");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(customFont20f);
		label.setBounds(10, 283, 226, 42);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(customFont20f);
		label_1.setBounds(10, 347, 226, 42);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(customFont20f);
		label_2.setBounds(10, 412, 226, 42);
		frame.getContentPane().add(label_2);
		
		lblName1 = new JLabel("Rang");
		lblName1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName1.setForeground(Color.RED);
		lblName1.setFont(customFont20f);
		lblName1.setBounds(302, 283, 226, 42);
		frame.getContentPane().add(lblName1);
		
		lblName2 = new JLabel("---");
		lblName2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName2.setForeground(Color.RED);
		lblName2.setFont(customFont20f);
		lblName2.setBounds(302, 347, 226, 42);
		frame.getContentPane().add(lblName2);
		
		btn = new JButton("Weiter");
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setBorder(null);
		btn.setOpaque(false);

		btn.setBackground(SystemColor.activeCaption);
		btn.setBounds(302, 465, 226, 85);
		btn.setFont(customFont30f);
		frame.getContentPane().add(btn);
		
		lblName3 = new JLabel("---");
		lblName3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName3.setHorizontalAlignment(SwingConstants.CENTER);
		lblName3.setForeground(Color.RED);
		lblName3.setFont(customFont20f);
		lblName3.setBounds(302, 412, 226, 42);
		frame.getContentPane().add(lblName3);
		
	lblZeit1 = new JLabel("Rang");
		lblZeit1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblZeit1.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeit1.setForeground(Color.RED);
		lblZeit1.setFont(customFont20f);
		lblZeit1.setBounds(548, 283, 226, 42);
		frame.getContentPane().add(lblZeit1);
		
		lblZeit2 = new JLabel("---");
		lblZeit2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblZeit2.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeit2.setForeground(Color.RED);
		lblZeit2.setFont(customFont20f);
		lblZeit2.setBounds(548, 347, 226, 42);
		frame.getContentPane().add(lblZeit2);
		
		lblZeit3 = new JLabel("---");
		lblZeit3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblZeit3.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeit3.setForeground(Color.RED);
		lblZeit3.setFont(customFont20f);
		lblZeit3.setBounds(548, 412, 226, 42);
		frame.getContentPane().add(lblZeit3);
		
		JLabel lblZeit = new JLabel("Zeit");
		lblZeit.setForeground(Color.RED);
		lblZeit.setFont(customFont20f);
		lblZeit.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeit.setBounds(548, 191, 226, 42);
		frame.getContentPane().add(lblZeit);
		
		JLabel lblNewLabel_2 = new JLabel("_______________________________________________________________________");
		lblNewLabel_2.setFont(customFont16f);
		lblNewLabel_2.setBounds(0, 166, 784, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
	JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.RED);
		lblName.setFont(customFont20f);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(302, 191, 226, 42);
		frame.getContentPane().add(lblName);
		
		MultiplayerIdLbl = new JLabel("MultiplayerID: XXXXXXX");
		MultiplayerIdLbl.setForeground(Color.RED);
		MultiplayerIdLbl.setFont(customFont30f);
		MultiplayerIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MultiplayerIdLbl.setBounds(0, 75, 784, 90);
		frame.getContentPane().add(MultiplayerIdLbl);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MultiplayerAuswertungView.class.getResource("/Resources/Hintergrund.png")));
		lblNewLabel.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblNewLabel);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getLblName1() {
		return lblName1;
	}

	public void setLblName1(JLabel lblName1) {
		this.lblName1 = lblName1;
	}

	public JLabel getLblName2() {
		return lblName2;
	}

	public void setLblName2(JLabel lblName2) {
		this.lblName2 = lblName2;
	}

	public JLabel getLblName3() {
		return lblName3;
	}

	public void setLblName3(JLabel lblName3) {
		this.lblName3 = lblName3;
	}

	public JLabel getLblZeit2() {
		return lblZeit2;
	}

	public void setLblZeit2(JLabel lblZeit2) {
		this.lblZeit2 = lblZeit2;
	}

	public JLabel getLblZeit1() {
		return lblZeit1;
	}

	public void setLblZeit1(JLabel lblZeit1) {
		this.lblZeit1 = lblZeit1;
	}

	public JLabel getMultiplayerIdLbl() {
		return MultiplayerIdLbl;
	}

	public void setMultiplayerIdLbl(JLabel multiplayerIdLbl) {
		MultiplayerIdLbl = multiplayerIdLbl;
	}

	public JLabel getLblZeit3() {
		return lblZeit3;
	}

	public void setLblZeit3(JLabel lblZeit3) {
		this.lblZeit3 = lblZeit3;
	}

	public JButton getBtn() {
		return btn;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}
}
