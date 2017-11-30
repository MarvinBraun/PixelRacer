package Fahrt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class Fahrtverwaltung {
	
	HashSet<SingleplayerFahrt> singleplayerFahrten;
	HashSet<MultiplayerFahrt> multiplayerFahrten;
	
	public Fahrtverwaltung(ResultSet rs)
	{
		try {
			while(rs.next())
			{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
