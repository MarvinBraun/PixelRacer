package Strecke;

import java.awt.image.BufferedImage;

public class Strecke {

	String streckenname;
	private static int laenge;
	private int schwierigkeit;
	private String premium = "false";
	private int punktewert;
	private BufferedImage grafik;
	
	
	
	
	public String getStreckenname() {
		return streckenname;
	}
	public void setStreckenname(String streckenname) {
		this.streckenname = streckenname;
	}
	public void setLaenge(int laenge) {
		Strecke.laenge = laenge;
	}
	public static int getLaenge() {
		return laenge;
	}
	public int getSchwierigkeit() {
		return schwierigkeit;
	}
	public void setSchwierigkeit(int schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String string) {
		this.premium = string;
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
	
	
}
