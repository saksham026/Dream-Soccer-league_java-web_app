package users.services;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface Fantasy 
{
	public void userTeamFormations(String userName,String t1,String t2,ArrayList playerName);
	public ResultSet userStandings(String t1,String t2);
	public ResultSet givePlayers(String team1, String team2);
}
