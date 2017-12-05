package Fahrt;

public abstract class Fahrt {
	private int sitzungsID;
	private int rang;
	private String zeit;
	private String streckenName;
	private String kartName;
	private String benutzername;
	
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
	public String getZeit() {
		return zeit;
	}
	public void setZeit(float zeit) {
		this.zeit = zeit;
	}
	public String getStreckenName() {
		return streckenName;
	}
	public void setStreckenName(String streckenName) {
		this.streckenName = streckenName;
	}
	public String getKartName() {
		return kartName;
	}
	public void setKartName(String kartName) {
		this.kartName = kartName;
	}
	public String getBenutzername() {
		return benutzername;
	}
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}
	
	
	
	
}
