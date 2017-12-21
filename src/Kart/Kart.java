//@Author Ferhat Koca
package Kart;

import java.awt.image.BufferedImage;

public class Kart {
	private String kartname;
	private static int beschleunigung;
	private static int maxkmh;
	private String premium;
	private int punktewert;
	private BufferedImage grafik;

	public void setKartname(String kartname) {
		this.kartname = kartname;
	}

	public void setBeschleunigung(int beschleunigung) {
		this.beschleunigung = beschleunigung;
	}

	public void setMaxkmh(int maxkmh) {
		this.maxkmh = maxkmh;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public void setPunktewert(int punktewert) {
		this.punktewert = punktewert;
	}

	public void setGrafik(BufferedImage grafik) {
		this.grafik = grafik;
	}

	public String getKartname() {
		return kartname;
	}

	public static int getBeschleunigung() {
		return beschleunigung;
	}

	public static int getMaxkmh() {
		return maxkmh;
	}

	public String getPremium() {
		return premium;
	}

	public int getPunktewert() {
		return punktewert;
	}

	public BufferedImage getGrafik() {
		return grafik;
	}

}
