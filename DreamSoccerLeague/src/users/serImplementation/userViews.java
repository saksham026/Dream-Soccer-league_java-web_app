package users.serImplementation;

import java.sql.Connection;
import java.sql.ResultSet;

import teams.dao.TeamTableFixtureView;
import teams.providers.Teams2DatabaseObjectProvider;
import users.dao.dbViews;
import users.daoImplementation.dbUserViews;
import users.providers.dbViewsProvider;
import users.services.CurrentMatchViewOwn;

public class userViews implements CurrentMatchViewOwn
{
		
	private TeamTableFixtureView tlr;
	
	dbViews dbv;
	
	Connection con;

	public userViews()
	{
		tlr=Teams2DatabaseObjectProvider.getObject();
		
		dbv=dbViewsProvider.getObject();
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
		((dbUserViews) dbv).setCon(con);
	}
	
	@Override
	public ResultSet currentMatchView() 
	{
		return dbv.currentMatchView();		
	}

	@Override
	public ResultSet viewOwnTeam(String userName,String teamName1,String teamName2) 
	{
		
		return dbv.viewOwnTeam(userName,teamName1,teamName2);
		
	}
	
	//extending methods
	@Override
	public ResultSet playerTeamView(String t_name) 
	{
		return tlr.playerTeamView(t_name);
	}

	@Override
	public ResultSet leagueTableView() 
	{
		return tlr.leagueTableView();
	}

	@Override
	public ResultSet viewFixtures() 
	{
		return tlr.viewFixtures();
	}

}
