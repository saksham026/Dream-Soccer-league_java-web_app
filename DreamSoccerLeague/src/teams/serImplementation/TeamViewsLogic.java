package teams.serImplementation;

import java.sql.Connection;
import java.sql.ResultSet;

import teams.beans.Team;
import teams.dao.TeamTableFixtureView;
import teams.daoImplementation.TeamViewQueries;
import teams.providers.Teams2DatabaseObjectProvider;
import teams.services.TeamViews;

public class TeamViewsLogic implements TeamViews
{
	private TeamTableFixtureView tlr;
	Connection con;
	
	public TeamViewsLogic()
	{
		tlr=Teams2DatabaseObjectProvider.getObject();
	}
	public void setCon(Connection con)
	{
		this.con=con;
		((TeamViewQueries)tlr).setCon(con);
	}
	
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
