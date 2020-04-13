package users.serImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import users.dao.dbFantasy;
import users.daoImplementation.dbUserFantasy;
import users.providers.dbFantasyProvider;
import users.services.Fantasy;

public class userFantasy implements Fantasy
{

	dbFantasy f;
	Connection con;
	
	public userFantasy()
	{
		f=dbFantasyProvider.getObject();
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
		((dbUserFantasy) f).setCon(con);
	}
	
	@Override
	public void userTeamFormations(String userName, String t1,String t2,ArrayList playerName) 
	{
		f.userTeamFormations(userName,t1,t2,playerName);
	}

	
	@Override
	public ResultSet userStandings(String t1,String t2) 
	{
		return f.userStandings(t1,t2);
	}

	@Override
	public ResultSet givePlayers(String team1, String team2) 
	{
		return f.givePlayers(team1, team2);
	}

}
