package MultiplayerFahrtSpielen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MultiplayerAuswertungView {

	JFrame frame;
	JLabel lblName1;
	JLabel lblName2;
	JLabel lblName3;
	JLabel lblZeit2;
	JLabel lblZeit1;
	JLabel MultiplayerIdLbl;
	JLabel lblZeit3;
	JButton btn;
	
	
	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public MultiplayerAuswertungView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel_3 = new JLabel("Rang");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("pixelmix", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 191, 226, 42);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel label = new JLabel("1.");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("pixelmix", Font.BOLD, 20));
		label.setBounds(10, 283, 226, 42);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("pixelmix", Font.BOLD, 20));
		label_1.setBounds(10, 347, 226, 42);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("pixelmix", Font.BOLD, 20));
		label_2.setBounds(10, 412, 226, 42);
		frame.getContentPane().add(label_2);
		
		lblName1 = new JLabel("Rang");
		lblName1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName1.setForeground(Color.RED);
		lblName1.setFont(new Font("pixelmix", Font.BOLD, 20));
		lblName1.setBounds(302, 283, 226, 42);
		frame.getContentPane().add(lblName1);
		
		lblName2 = new JLabel("---");
		lblName2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName2.setForeground(Color.RED);
		lblName2.setFont(new Font("pixelmix", Font.BOLD, 20));
		lblName2.setBounds(302, 347, 226, 42);
		frame.getContentPane().add(lblName2);
		
		btn = new JButton("OK");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn.setBounds(302, 465, 226, 85);
		frame.getContentPane().add(btn);
		
		lblName3 = new JLabel("---");
		lblName3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName3.setHorizontalAlignment(SwingConstants.CENTER);
		lblName3.setForeground(Color.RED);
		lblName3.setFont(new Font("pixelmix", Font.BOLD, 20));
		lblName3.setBounds(302, 412, 226, 42);
		frame.getContentPane().add(lblName3);
		
	lblZeit1 = new JLabel("Rang");
		lblZeit1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblZeit1.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeit1.setForeground(Color.RED);
		lblZeit1.setFont(new Font("pixelmix", Font.BOLD, 20));
		lblZeit1.setBounds(548, 283, 226, 42);
		frame.getContentPane().add(lblZeit1);
		
		lblZeit2 = new JLabel("---");
		lblZeit2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblZeit2.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeit2.setForeground(Color.RED);
		lblZeit2.setFont(new Font("pixelmix", Font.BOLD, 20));
		lblZeit2.setBounds(548, 347, 226, 42);
		frame.getContentPane().add(lblZeit2);
		
		lblZeit3 = new JLabel("---");
		lblZeit3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblZeit3.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeit3.setForeground(Color.RED);
		lblZeit3.setFont(new Font("pixelmix", Font.BOLD, 20));
		lblZeit3.setBounds(548, 412, 226, 42);
		frame.getContentPane().add(lblZeit3);
		
		JLabel lblZeit = new JLabel("Zeit");
		lblZeit.setForeground(Color.RED);
		lblZeit.setFont(new Font("pixelmix", Font.BOLD, 20));
		lblZeit.setHorizontalAlignment(SwingConstants.CENTER);
		lblZeit.setBounds(548, 191, 226, 42);
		frame.getContentPane().add(lblZeit);
		
		JLabel lblNewLabel_2 = new JLabel("_______________________________________________________________________");
		lblNewLabel_2.setFont(new Font("pixelmix", Font.BOLD, 16));
		lblNewLabel_2.setBounds(0, 166, 784, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
	JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.RED);
		lblName.setFont(new Font("pixelmix", Font.BOLD, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(302, 191, 226, 42);
		frame.getContentPane().add(lblName);
		
		MultiplayerIdLbl = new JLabel("MultiplayerID: XXXXXXX");
		MultiplayerIdLbl.setForeground(Color.RED);
		MultiplayerIdLbl.setFont(new Font("pixelmix", Font.BOLD, 30));
		MultiplayerIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		MultiplayerIdLbl.setBounds(0, 75, 784, 90);
		frame.getContentPane().add(MultiplayerIdLbl);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MultiplayerAuswertungView.class.getResource("/Resources/Hintergrund.png")));
		lblNewLabel.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblNewLabel);
		
	}
}