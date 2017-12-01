package Fahrt;

public abstract class Fahrt {
	private int sitzungsID;
	private int rang;
	private float zeit;
	private String Strecke;
	private String kart;
	
	public int getSitzungsID() {
		return sitzungsID;
	}
	public void setSitzungsID(int sitzungsID) {
		this.sitzungsID = sitzungsID;
	}
	public int getRang() {
		return rang;
	}
	public void setRang(int rang) {
		this.rang = rang;
	}
	public float getZeit() {
		return zeit;
	}
	public void setZeit(float zeit) {
		this.zeit = zeit;
	}
	public String getStrecke() {
		return Strecke;
	}
	public void setStrecke(String strecke) {
		Strecke = strecke;
	}
	public String getKart() {
		return kart;
	}
	public void setKart(String kart) {
		this.kart = kart;
	}
	
	
	
}
