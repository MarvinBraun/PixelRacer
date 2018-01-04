// @Author Marvin Braun
package Backup;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import BackgroundAnimation.LabelBackgroundX;
import BackgroundAnimation.Movement;

import javax.swing.JButton;

public class BackgroundX {


	static int backgroundSpeed = 1;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackgroundX window = new BackgroundX();
					Movement m = new Movement(5);
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
	public BackgroundX() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSpielen = new JButton("Spielen");
		btnSpielen.setBounds(334, 164, 89, 23);
		frame.getContentPane().add(btnSpielen);
		LabelBackgroundX l = new LabelBackgroundX();
		l.setBounds(0,0,800,600);
		frame.getContentPane().add(l);
		
		
	
		
	}
}
