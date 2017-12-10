package Strecke;

import java.awt.image.BufferedImage;

public class Strecke {

	private String streckenname;
	private static final int lange;
	private int schwierigkeit;
	private boolean premium = false;
	private int punktewert;
	private BufferedImage grafik;
	
	
	
	
	public String getStreckenname() {
		return streckenname;
	}
	public void setStreckenname(String streckenname) {
		this.streckenname = streckenname;
	}
	public int getSchwierigkeit() {
		return schwierigkeit;
	}
	public void setSchwierigkeit(int schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	public int getPunktewert() {
		return punktewert;
	}
	public void setPunktewert(int punktewert) {
		this.punktewert = punktewert;
	}
	public BufferedImage getGrafik() {
		return grafik;
	}
	public void setGrafik(BufferedImage grafik) {
		this.grafik = grafik;
	}
	public static int getLange() {
		return lange;
	}
	
}
