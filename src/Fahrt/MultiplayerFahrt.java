package Fahrt;
/**
 * Klasse der Entit�t MultiplayerFahrt. Subtyp der Klasse Fahrt.
 * @author Marvin Braun
 *
 */

public class MultiplayerFahrt extends Fahrt {
private int multiplayerID;

//Gibt die MultiplayerID des Objektes zur�ck
public int getMultiplayerID() {
	return multiplayerID;
}
//Setzt die MultiplayerID des Objektes.
public void setMultiplayerID(int multiplayerID) {
	this.multiplayerID = multiplayerID;
}

	

}
