//@Author Ferhat Koca
package Computergegner;

public class Bot {
	//Stecke = gib länge
	//geschw. = gib strecke
	//beschl = gib beschl
	//beschl = geschw/beschl
	//Strecke = gib schwierigkeit
	
	//(Strecke/geschw + beschlZeit)*math.random());
	int strecke = Strecke.Strecke.getLaenge();
	int geschw = Kart.Kart.getMaxkmh();
	int beschl = Kart.Kart.getBeschleunigung();
	int schw = Strecke.Strecke.getSchwierigkeit();
	
	
}
