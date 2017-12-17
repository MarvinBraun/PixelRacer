package ProfilKunde;

import java.util.LinkedList;

import Fahrt.Fahrtverwaltung;
import Fahrt.SingleplayerFahrt;

public class AnzeigenProfilKundeStrg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	Fahrtverwaltung v1 = new Fahrtverwaltung();
	LinkedList<SingleplayerFahrt> fahrten1 = v1.gibSingleplayerFahrtenFürBenutzer("DZeller");
	System.out.println("Gesamt sf:" +fahrten1.size());
}
