package FahrtErstellen;
import java.awt.Component;
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
import javax.swing.SwingConstants;

public class FahrtErstellenView {

	private JFrame frame;
	private JLabel background;
	private JButton kartForward;
	private JButton kartBackward;
	private JButton streckeForward;
	private JButton schwierigkeitBtn2;
	private JLabel waehleKart;
	private JLabel streckeName;
	private JLabel kartName;
	private JLabel kartBild;
	private JButton streckeBackward;
	private JButton schwierigkeitBtn1;
	private JLabel lblWhleDeineStrecke;
	private JButton spielenBtn;
	private JLabel schwierigkeitLbl;
	private JLabel lblNewLabel;
	private JLabel streckeLbl;
	private JLabel multiplayerLbl;
	private 	JButton backBtn;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahrtErstellenView window = new FahrtErstellenView();
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
	public FahrtErstellenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setResizable(false);
		getFrame().setBounds(100, 100, 800, 600);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getFrame().setVisible(true);
		getFrame().getContentPane().setLayout(null);
		
		
		
		setKartBackward(new JButton(""));
		getKartBackward().setFocusable(false);
		getKartBackward().setBorderPainted(false);
		getKartBackward().setContentAreaFilled(false);
		getKartBackward().setOpaque(false);
		getKartBackward().setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/backward.png")));
		getKartBackward().setBounds(27, 115,60, 60);
		getFrame().getContentPane().add(getKartBackward());
		
		
		setStreckeForward(new JButton(""));
		getStreckeForward().setBorderPainted(false);
		getStreckeForward().setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/forward.png")));
		getStreckeForward().setContentAreaFilled(false);
		getStreckeForward().setBounds(712, 238, 60, 60);
		getFrame().getContentPane().add(getStreckeForward());
		
		setSchwierigkeitBtn2(new JButton(""));
		getSchwierigkeitBtn2().setBorderPainted(false);
		getSchwierigkeitBtn2().setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/forward.png")));
		getSchwierigkeitBtn2().setContentAreaFilled(false);
		getSchwierigkeitBtn2().setBounds(345, 489, 60, 60);
		getFrame().getContentPane().add(getSchwierigkeitBtn2());
		
		setStreckeBackward(new JButton(""));
		getStreckeBackward().setBorderPainted(false);
		getStreckeBackward().setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/backward.png")));
		getStreckeBackward().setOpaque(false);
		getStreckeBackward().setContentAreaFilled(false);
		getStreckeBackward().setBounds(27, 238, 60, 60);
		getFrame().getContentPane().add(getStreckeBackward());
		
		setSchwierigkeitBtn1(new JButton(""));
		getSchwierigkeitBtn1().setBorderPainted(false);
		getSchwierigkeitBtn1().setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/backward.png")));
		getSchwierigkeitBtn1().setOpaque(false);
		getSchwierigkeitBtn1().setContentAreaFilled(false);
		getSchwierigkeitBtn1().setBounds(27, 489, 60, 60);
		getFrame().getContentPane().add(getSchwierigkeitBtn1());
		
		backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/backButton2.png")));
		backBtn.setBounds(27, 16, 89, 50);
		backBtn.setOpaque(false);
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		frame.getContentPane().add(backBtn);
		
		setSpielenBtn(new JButton("Spielen!"));
		getSpielenBtn().setBorderPainted(false);
		getSpielenBtn().setOpaque(false);
		
		getSpielenBtn().setFont(new Font("pixelmix", Font.PLAIN, 30));
		getSpielenBtn().setBackground(SystemColor.activeCaption);
		getSpielenBtn().setBounds(562, 489, 210, 59);
		getFrame().getContentPane().add(getSpielenBtn());
		
		
		setKartForward(new JButton(""));
		getKartForward().setFocusable(false);
		getKartForward().setBorderPainted(false);
		getKartForward().setContentAreaFilled(false);
		getKartForward().setIcon(new ImageIcon(FahrtErstellenView.class.getResource("/Resources/forward.png")));
		getKartForward().setBounds(712, 115, 60, 60);
		getFrame().getContentPane().add(getKartForward());
		
		setStreckeLbl(new JLabel(""));
		getStreckeLbl().setBounds(228, 284, 300, 200);
		getFrame().getContentPane().add(getStreckeLbl());
		
		waehleKart = new JLabel("Dein Kart:");
		waehleKart.setFont(new Font("pixelmix", Font.PLAIN, 30));
		waehleKart.setBounds(153, 16, 210, 50);
		getFrame().getContentPane().add(waehleKart);
		
		setStreckeName(new JLabel("Hockenheim"));
		getStreckeName().setHorizontalAlignment(SwingConstants.CENTER);
		getStreckeName().setFont(new Font("pixelmix", Font.PLAIN, 30));
		getStreckeName().setBounds(415, 238, 287, 60);
		getFrame().getContentPane().add(getStreckeName());
		
		setKartName(new JLabel("FireBird"));
		getKartName().setFont(new Font("pixelmix", Font.PLAIN, 30));
		getKartName().setBounds(373, 11, 330, 60);
		getFrame().getContentPane().add(getKartName());
		
		setMultiplayerLbl(new JLabel("MultiplayerID: "));
		getMultiplayerLbl().setHorizontalAlignment(SwingConstants.CENTER);
		getMultiplayerLbl().setVisible(false);
		getMultiplayerLbl().setFont(new Font("pixelmix", Font.PLAIN, 18));
		getMultiplayerLbl().setBounds(102, 493, 233, 56);
		getFrame().getContentPane().add(getMultiplayerLbl());
		
		setKartBild(new JLabel(""));
		getKartBild().setIcon(null);
		getKartBild().setBounds(141, 72, 545, 122);
		getFrame().getContentPane().add(getKartBild());
		
		lblWhleDeineStrecke = new JLabel("Deine Strecke:");
		lblWhleDeineStrecke.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhleDeineStrecke.setFont(new Font("pixelmix", Font.PLAIN, 30));
		lblWhleDeineStrecke.setBounds(102, 246, 303, 40);
		getFrame().getContentPane().add(lblWhleDeineStrecke);
		
		setSchwierigkeitLbl(new JLabel("Schwierigkeit"));
		getSchwierigkeitLbl().setHorizontalAlignment(SwingConstants.CENTER);
		getSchwierigkeitLbl().setFont(new Font("pixelmix", Font.PLAIN, 25));
		getSchwierigkeitLbl().setBounds(105, 495, 233, 40);
		getFrame().getContentPane().add(getSchwierigkeitLbl());
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setVisible(false);
		
			//	lblNewLabel.setIcon(new ImageIcon(SingleplayerFahrtErstellenView.class.getResource("/Resources/Rennstrecke1Klein.png")));
			
			
				
				
				lblNewLabel.setBounds(0, 0, 794, 571);
				getFrame().getContentPane().add(lblNewLabel);
		
				
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
		getFrame().getContentPane().add(m.label);
		getFrame().setVisible(true);
	
	}

	public JButton getBackBtn() {
		return backBtn;
	}





	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}





	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getKartForward() {
		return kartForward;
	}

	public void setKartForward(JButton kartForward) {
		this.kartForward = kartForward;
		kartForward.setBorder(null);
	}

	public JButton getKartBackward() {
		return kartBackward;
	}

	public void setKartBackward(JButton kartBackward) {
		this.kartBackward = kartBackward;
		kartBackward.setBorder(null);
	}

	public JButton getStreckeBackward() {
		return streckeBackward;
	}

	public void setStreckeBackward(JButton streckeBackward) {
		this.streckeBackward = streckeBackward;
	}

	public JButton getStreckeForward() {
		return streckeForward;
	}


	public void setStreckeForward(JButton streckeForward) {
		this.streckeForward = streckeForward;
	}

	public JButton getSpielenBtn() {
		return spielenBtn;
	}

	public void setSpielenBtn(JButton spielenBtn) {
		this.spielenBtn = spielenBtn;
	}

	public JButton getSchwierigkeitBtn1() {
		return schwierigkeitBtn1;
	}

	public void setSchwierigkeitBtn1(JButton schwierigkeitBtn1) {
		this.schwierigkeitBtn1 = schwierigkeitBtn1;
	}

	public JButton getSchwierigkeitBtn2() {
		return schwierigkeitBtn2;
	}

	public void setSchwierigkeitBtn2(JButton schwierigkeitBtn2) {
		this.schwierigkeitBtn2 = schwierigkeitBtn2;
	}

	public JLabel getSchwierigkeitLbl() {
		return schwierigkeitLbl;
	}

	public void setSchwierigkeitLbl(JLabel schwierigkeitLbl) {
		this.schwierigkeitLbl = schwierigkeitLbl;
	}

	public JLabel getMultiplayerLbl() {
		return multiplayerLbl;
	}

	public void setMultiplayerLbl(JLabel multiplayerLbl) {
		this.multiplayerLbl = multiplayerLbl;
	}

	public JLabel getKartBild() {
		return kartBild;
	}

	public void setKartBild(JLabel kartBild) {
		this.kartBild = kartBild;
	}

	public JLabel getKartName() {
		return kartName;
	}

	public void setKartName(JLabel kartName) {
		this.kartName = kartName;
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
}
