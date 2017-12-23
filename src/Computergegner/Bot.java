//@Author Ferhat Koca
package Computergegner;

import Strecke.Strecke;
import Kart.Kart;

public class Bot {

	int zeit;
	public int getZeit() {
		return zeit;
	}

	public void setZeit(int zeit) {
		this.zeit = zeit;
	}

	int l‰nge;
	int geschwindigkeit;
	int beschleunigung;
	int schwierigkeit;

	public Bot(int streckenl‰nge, int geschwindigkeit, int beschleunigung, int schwierigkeit) {
		
		this.l‰nge = streckenl‰nge;
		this.geschwindigkeit = geschwindigkeit;
		this.beschleunigung = beschleunigung;
		float schwierigkeit2 = 0;
		
		if(schwierigkeit==1)
			schwierigkeit2 = (float) (0.9 +(Math.random() * 1.4)); 
		else if(schwierigkeit==2)
			schwierigkeit2 = (float) (0.7 +(Math.random() * 1.3)); 
		else	if(schwierigkeit==3)
			schwierigkeit2 = (float) (0.5 +(Math.random() * 1.2)); 
					
		

		zeit = (int) ((int) (((l‰nge/geschwindigkeit)+(geschwindigkeit/beschleunigung))*schwierigkeit2)*0.4);
		System.out.println("Gefahrene Zeit des Bots:"+zeit);
	}

	public static void main(String[] args) {
		
		
	}

}
// Stecke = gib l√§nge
// geschw. = gib strecke
// beschl = gib beschl
// beschl = geschw/beschl
// Strecke = gib schwierigkeit

// (Strecke/geschw + beschlZeit)*math.random());
