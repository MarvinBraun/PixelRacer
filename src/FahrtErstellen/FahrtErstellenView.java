package FahrtErstellen;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;
import FahrtSpielen.FahrtSpielenStrg;
import Kart.Kart;
import MusicHandler.MusicPlayer;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class FahrtErstellenView {

	JFrame frame;
	private JLabel background;
	JButton kartForward;
	JButton kartBackward;
	JButton streckeForward;
	JButton schwierigkeitBtn2;
	JLabel waehleKart;
	JLabel streckeName;
	JLabel kartName;
	JLabel kartBild;
	JButton streckeBackward;
	JButton schwierigkeitBtn1;
	JLabel lblWhleDeineStrecke;
	JButton spielenBtn;
	JLabel schwierigkeitLbl;
	JLabel lblNewLabel;
	JLabel streckeLbl;
	JLabel multiplayerLbl;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrtErstellenView window = new FahrtErstellenView();
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
	public FahrtErstellenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		
		
		kartBackward = new JButton("");
		kartBackward.setFocusable(false);
		kartBackward.setBorderPainted(true);
		kartBackward.setContentAreaFilled(false);
		kartBackward.setOpaque(false);
		kartBackward.setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/backward.png")));
		kartBackward.setBounds(27, 115,60, 60);
		frame.getContentPane().add(kartBackward);
		
		
		streckeForward = new JButton("");
		streckeForward.setBorderPainted(false);
		streckeForward.setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/forward.png")));
		streckeForward.setContentAreaFilled(false);
		streckeForward.setBounds(643, 238, 60, 60);
		frame.getContentPane().add(streckeForward);
		
		schwierigkeitBtn2 = new JButton("");
		schwierigkeitBtn2.setBorderPainted(false);
		schwierigkeitBtn2.setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/forward.png")));
		schwierigkeitBtn2.setContentAreaFilled(false);
		schwierigkeitBtn2.setBounds(345, 489, 60, 60);
		frame.getContentPane().add(schwierigkeitBtn2);
		
		streckeBackward = new JButton("");
		streckeBackward.setBorderPainted(false);
		streckeBackward.setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/backward.png")));
		streckeBackward.setOpaque(false);
		streckeBackward.setContentAreaFilled(false);
		streckeBackward.setBounds(27, 238, 60, 60);
		frame.getContentPane().add(streckeBackward);
		
		schwierigkeitBtn1 = new JButton("");
		schwierigkeitBtn1.setBorderPainted(false);
		schwierigkeitBtn1.setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/backward.png")));
		schwierigkeitBtn1.setOpaque(false);
		schwierigkeitBtn1.setContentAreaFilled(false);
		schwierigkeitBtn1.setBounds(27, 489, 60, 60);
		frame.getContentPane().add(schwierigkeitBtn1);
		
		spielenBtn = new JButton("Spielen!");
		spielenBtn.setBorderPainted(false);
		spielenBtn.setOpaque(false);
		
		spielenBtn.setFont(new Font("pixelmix", Font.PLAIN, 30));
		spielenBtn.setBackground(SystemColor.activeCaption);
		spielenBtn.setBounds(562, 489, 210, 59);
		frame.getContentPane().add(spielenBtn);
		
		
		kartForward = new JButton("");
		kartForward.setFocusable(false);
		kartForward.setBorderPainted(true);
		kartForward.setContentAreaFilled(false);
		kartForward.setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/forward.png")));
		kartForward.setBounds(643, 115, 60, 60);
		frame.getContentPane().add(kartForward);
		
		streckeLbl = new JLabel("");
		streckeLbl.setBounds(211, 285, 300, 200);
		frame.getContentPane().add(streckeLbl);
		
		waehleKart = new JLabel("Dein Kart:");
		waehleKart.setFont(new Font("pixelmix", Font.PLAIN, 30));
		waehleKart.setBounds(153, 16, 210, 50);
		frame.getContentPane().add(waehleKart);
		
		streckeName = new JLabel("Hockenheim");
		streckeName.setFont(new Font("pixelmix", Font.PLAIN, 27));
		streckeName.setBounds(404, 238, 215, 60);
		frame.getContentPane().add(streckeName);
		
		kartName = new JLabel("FireBird");
		kartName.setFont(new Font("pixelmix", Font.PLAIN, 30));
		kartName.setBounds(373, 11, 330, 60);
		frame.getContentPane().add(kartName);
		
		multiplayerLbl = new JLabel("MultiplayerID: ");
		multiplayerLbl.setVisible(false);
		multiplayerLbl.setFont(new Font("pixelmix", Font.PLAIN, 18));
		multiplayerLbl.setBounds(102, 493, 233, 56);
		frame.getContentPane().add(multiplayerLbl);
		
		kartBild = new JLabel("");
		kartBild.setIcon(new ImageIcon("C:\\Users\\Marvin\\OneDrive\\PixelRacer\\src\\Resources\\Car1.png"));
		kartBild.setBounds(88, 69, 545, 122);
		frame.getContentPane().add(kartBild);
		
		lblWhleDeineStrecke = new JLabel("Deine Strecke:");
		lblWhleDeineStrecke.setFont(new Font("pixelmix", Font.PLAIN, 30));
		lblWhleDeineStrecke.setBounds(102, 246, 303, 40);
		frame.getContentPane().add(lblWhleDeineStrecke);
		
		schwierigkeitLbl = new JLabel("Schwierigkeit");
		schwierigkeitLbl.setFont(new Font("pixelmix", Font.PLAIN, 25));
		schwierigkeitLbl.setBounds(105, 495, 233, 40);
		frame.getContentPane().add(schwierigkeitLbl);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setVisible(false);
		
			//	lblNewLabel.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/Rennstrecke1Klein.png")));
			
			
				
				
				lblNewLabel.setBounds(0, 0, 794, 571);
				frame.getContentPane().add(lblNewLabel);
		
				
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
		frame.getContentPane().add(m.label);
		frame.setVisible(true);
	

	
	}
}
