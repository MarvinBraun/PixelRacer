package Strecke;

import java.awt.EventQueue;

import java.awt.image.BufferedImage;

import javax.swing.*;

public class Streckenuebersicht {

	JFrame frame;
	Strecke s;
	
	BufferedImage bildStrecke1;
	ImageIcon icon1;
	JLabel lblBildStrecke1;
	JLabel lblTitelStrecke1;
	JLabel labelBeschreibungStrecke1;
	
	JLabel bildStrecke2;
	ImageIcon icon2;
	JLabel lblBildStrecke2;
	JLabel lblTitelStrecke2;
	JLabel labelBeschreibungStrecke2;
	
	JLabel bildStrecke3;
	ImageIcon icon3;
	JLabel lblBildStrecke3;
	JLabel lblTitelStrecke3;
	JLabel labelBeschreibungStrecke3;
	
	JLabel bildStrecke4;
	ImageIcon icon4;
	JLabel lblBildStrecke4;
	JLabel lblTitelStrecke4;
	JLabel labelBeschreibungStrecke4;
	
	JLabel bildStrecke5;
	ImageIcon icon5;
	JLabel lblBildStrecke5;
	JLabel lblTitelStrecke5;
	JLabel labelBeschreibungStrecke5;
	
	JLabel bildStrecke6;
	ImageIcon icon6;
	JLabel lblBildStrecke6;
	JLabel lblTitelStrecke6;
	JLabel labelBeschreibungStrecke6;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Streckenuebersicht window = new Streckenuebersicht();
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
	public Streckenuebersicht() {
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
		frame.setVisible(true);
		frame.invalidate();
		frame.revalidate();
		frame.validate();
	
	}
	
	public void setlblBildStrecke1(){
		BufferedImage bildStrecke1 = s.getGrafik();
		ImageIcon icon1 = new ImageIcon(bildStrecke1);
		//JLabel lblBildStrecke1 = new JLabel(icon1); 2. Möglichkeit Image zu adden, funzt auch nicht
		lblBildStrecke1.setIcon(icon1);
		frame.getContentPane().add(lblBildStrecke1);
		lblBildStrecke1.setBounds(47, 132, 100, 50);
		lblBildStrecke1.setVisible(true);
	}
	
	public void setTitelStrecke1(String titelStrecke1){
		JLabel lblTitelStrecke1 = new JLabel(s.getStreckenname());
		lblTitelStrecke1.setBounds(100, 100, 100, 300);
		frame.getContentPane().add(lblTitelStrecke1);
		lblTitelStrecke1.setVisible(true);
	}
	
	public void setBeschreibungStrecke1(String beschreibungStrecke1){
		JLabel labelBeschreibungStrecke1 = new JLabel(beschreibungStrecke1);
		labelBeschreibungStrecke1.setBounds(47, 203, 46, 14);
		frame.getContentPane().add(labelBeschreibungStrecke1);
		labelBeschreibungStrecke1.setVisible(true);
	}

	public void setlblBildStrecke2(){
		BufferedImage bildStrecke2 = s.getGrafik();
		ImageIcon icon2 = new ImageIcon(bildStrecke2);
		JLabel lblBildStrecke2 = new JLabel(icon2);
		frame.getContentPane().add(lblBildStrecke2);
		lblBildStrecke2.setBounds(457, 44, 46, 14);
		lblBildStrecke2.setVisible(true);
	}
	
	public void setTitelStrecke2(String titelStrecke2){
		JLabel lblTitelStrecke2 = new JLabel(s.getStreckenname());
		lblTitelStrecke2.setBounds(457, 132, 46, 14);
		frame.getContentPane().add(lblTitelStrecke2);
		lblTitelStrecke2.setVisible(true);
	}
	
	public void setBeschreibungStrecke2(String beschreibungStrecke2){
		JLabel labelBeschreibungStrecke2 = new JLabel(beschreibungStrecke2);
		labelBeschreibungStrecke2.setBounds(457, 203, 46, 14);
		frame.getContentPane().add(labelBeschreibungStrecke2);
		labelBeschreibungStrecke2.setVisible(true);
	}
	
	public void setlblBildStrecke3(){
		BufferedImage bildStrecke3 = s.getGrafik();
		ImageIcon icon3 = new ImageIcon(bildStrecke3);
		JLabel lblBildStrecke3 = new JLabel(icon3);
		frame.getContentPane().add(lblBildStrecke3);
		lblBildStrecke3.setBounds(457, 44, 46, 14);
		lblBildStrecke3.setVisible(true);
	}
	
	public void setTitelStrecke3(String titelStrecke3){
		JLabel lblTitelStrecke3 = new JLabel(s.getStreckenname());
		lblTitelStrecke3.setBounds(457, 132, 46, 14);
		frame.getContentPane().add(lblTitelStrecke3);
		lblTitelStrecke3.setVisible(true);
	}
	
	public void setBeschreibungStrecke3(String beschreibungStrecke3){
		JLabel labelBeschreibungStrecke3 = new JLabel(beschreibungStrecke3);
		labelBeschreibungStrecke3.setBounds(457, 203, 46, 14);
		frame.getContentPane().add(labelBeschreibungStrecke3);
		labelBeschreibungStrecke3.setVisible(true);
	}
	
	public void setlblBildStrecke4(){
		BufferedImage bildStrecke4 = s.getGrafik();
		ImageIcon icon4 = new ImageIcon(bildStrecke4);
		JLabel lblBildStrecke4 = new JLabel(icon4);
		frame.getContentPane().add(lblBildStrecke4);
		lblBildStrecke4.setBounds(457, 44, 46, 14);
		lblBildStrecke4.setVisible(true);
	}
	
	public void setTitelStrecke4(String titelStrecke4){
		JLabel lblTitelStrecke4 = new JLabel(s.getStreckenname());
		lblTitelStrecke4.setBounds(457, 132, 46, 14);
		frame.getContentPane().add(lblTitelStrecke4);
		lblTitelStrecke4.setVisible(true);
	}
	
	public void setBeschreibungStrecke4(String beschreibungStrecke4){
		JLabel labelBeschreibungStrecke4 = new JLabel(beschreibungStrecke4);
		labelBeschreibungStrecke4.setBounds(457, 203, 46, 14);
		frame.getContentPane().add(labelBeschreibungStrecke4);
		labelBeschreibungStrecke4.setVisible(true);
	}
	
	public void setlblBildStrecke5(){
		BufferedImage bildStrecke5 = s.getGrafik();
		ImageIcon icon5 = new ImageIcon(bildStrecke5);
		JLabel lblBildStrecke5 = new JLabel(icon5);
		frame.getContentPane().add(lblBildStrecke5);
		lblBildStrecke5.setBounds(457, 44, 46, 14);
		lblBildStrecke5.setVisible(true);
	}
	
	public void setTitelStrecke5(String titelStrecke5){
		JLabel lblTitelStrecke5 = new JLabel(s.getStreckenname());
		lblTitelStrecke5.setBounds(457, 132, 46, 14);
		frame.getContentPane().add(lblTitelStrecke5);
		lblTitelStrecke5.setVisible(true);
	}
	
	public void setBeschreibungStrecke5(String beschreibungStrecke5){
		JLabel labelBeschreibungStrecke5 = new JLabel(beschreibungStrecke5);
		labelBeschreibungStrecke5.setBounds(457, 203, 46, 14);
		frame.getContentPane().add(labelBeschreibungStrecke5);
		labelBeschreibungStrecke5.setVisible(true);
	}
	
	public void setlblBildStrecke6(){
		BufferedImage bildStrecke6 = s.getGrafik();
		ImageIcon icon6 = new ImageIcon(bildStrecke6);
		JLabel lblBildStrecke6 = new JLabel(icon6);
		frame.getContentPane().add(lblBildStrecke6);
		lblBildStrecke6.setBounds(457, 44, 46, 14);
		lblBildStrecke6.setVisible(true);
	}
	
	public void setTitelStrecke6(String titelStrecke6){
		JLabel lblTitelStrecke6 = new JLabel(s.getStreckenname());
		lblTitelStrecke6.setBounds(457, 132, 46, 14);
		frame.getContentPane().add(lblTitelStrecke6);
		lblTitelStrecke6.setVisible(true);
	}
	
	public void setBeschreibungStrecke6(String beschreibungStrecke6){
		JLabel labelBeschreibungStrecke6 = new JLabel(beschreibungStrecke6);
		labelBeschreibungStrecke6.setBounds(457, 203, 46, 14);
		frame.getContentPane().add(labelBeschreibungStrecke6);
		labelBeschreibungStrecke6.setVisible(true);
	}

	
	
	
}
