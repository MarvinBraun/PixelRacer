
package Computergegner;

import Strecke.Strecke;
import Kart.Kart;

/**
 * Die Klasse Bot generiert je nach ausgewählter Schwierigkeit eine generierte
 * Zeit aus, die der Computergegner gefahren ist.
 * 
 * @author Ferhat Koca
 *
 */
public class Bot {

	int zeit;

	public int getZeit() {
		return zeit;
	}

	public void setZeit(int zeit) {
		this.zeit = zeit;
	}

	int länge;
	int geschwindigkeit;
	int beschleunigung;
	int schwierigkeit;

	/**
	 * Erzeugt ein Objekt der Klasse und simuliert eine Zeit anhand der übergebenen Werte.
	 * @param streckenlänge Länge der Strecke
	 * @param geschwindigkeit Geschwindigkeit des Karts
	 * @param beschleunigung Beschleunigung des Karts
	 * @param schwierigkeit Schwierigkeit der Fahrt
	 */
	
	public Bot(int streckenlänge, int geschwindigkeit, int beschleunigung, int schwierigkeit) {

		this.länge = streckenlänge;
		this.geschwindigkeit = geschwindigkeit;
		this.beschleunigung = beschleunigung;
		float schwierigkeit2 = 0;

		if (schwierigkeit == 1)
			schwierigkeit2 = (float) (0.9 + (Math.random() * 1.4));
		else if (schwierigkeit == 2)
			schwierigkeit2 = (float) (0.7 + (Math.random() * 1.3));
		else if (schwierigkeit == 3)
			schwierigkeit2 = (float) (0.5 + (Math.random() * 1.2));

		zeit = (int) ((int) (((länge / geschwindigkeit) + (geschwindigkeit / beschleunigung)) * schwierigkeit2) * 0.4);

	}

	public static void main(String[] args) {

	}

}
