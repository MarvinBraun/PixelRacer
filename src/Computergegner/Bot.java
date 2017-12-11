//@Author Ferhat Koca
package Computergegner;

import Strecke.Strecke;
import Kart.Kart;

public class Bot {

	static int p;
	static int strecke = Strecke.getLaenge();
	static int geschwindigkeit = Kart.getMaxkmh();
	static int beschleunigung = Kart.getBeschleunigung();

	public Bot() {
		p = (int) (((strecke / geschwindigkeit) + (geschwindigkeit / beschleunigung)) * Math.random());
	}

	public static void main(String[] args) {
		Bot bot = new Bot();
		System.out.println(bot);
	}

}
// Stecke = gib länge
// geschw. = gib strecke
// beschl = gib beschl
// beschl = geschw/beschl
// Strecke = gib schwierigkeit

// (Strecke/geschw + beschlZeit)*math.random());
