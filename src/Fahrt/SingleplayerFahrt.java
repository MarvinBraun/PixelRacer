package Fahrt;

import Computergegner.Bot;

public class SingleplayerFahrt extends Fahrt {
private Bot bot;
public Bot getBot() {
	return bot;
}

public void setBot(Bot bot) {
	this.bot = bot;
}

private String schwierigkeit;

public String getSchwierigkeit() {
	return schwierigkeit;
}

public void setSchwierigkeit(String string) {

	schwierigkeit = string;
}

}
