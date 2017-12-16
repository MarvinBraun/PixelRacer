package BackgroundAnimation;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ZeigerSpielView implements KeyListener {

 JFrame frame;
JLabel zeigerLbl;
int speed = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZeigerSpielView window = new ZeigerSpielView();
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
	public ZeigerSpielView() {
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
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/Resources/zeiger.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ZeigerMovement zeiger = new ZeigerMovement(1);
		zeiger.balken.setBufferedImage(image, 0);
		zeiger.balken.setVisible(true);
		zeiger.balken.setBounds(0,100,800,600);
		zeiger.balken.setOpaque(false);
		frame.getContentPane().add(zeiger.balken);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ZeigerSpielView.class.getResource("/Resources/ladeBalken.png")));
		lblNewLabel.setBounds(127, 261, 500, 60);
		frame.getContentPane().add(lblNewLabel);
		frame.addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	            	speed = speed+speed;
					zeiger.setSpeed(speed);
	               System.out.println("Hi from KeyListener");
	            
	            }
	         }
	      });
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);

		
		
		
	
	
	
		
		//zeiger.balken.balken = 
		
	
	
		//zeiger.balken.setBounds(lblNewLabel, 0, 800, 600);
}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			System.out.println("Registriert");
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			System.out.println("Registriert");
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		

			
			if(e.getKeyCode()==KeyEvent.VK_SPACE)
			{
				System.out.println("Registriert");
				
			}
			// TODO Auto-generated method stub
			
		
		// TODO Auto-generated method stub
		
	}	
}
