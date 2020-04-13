package teams.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import teams.beans.Team;
import teams.dao.TeamTableFixtureView;

public class TeamViewQueries implements TeamTableFixtureView
{
	PreparedStatement pst;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public TeamViewQueries()
	{
		
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
	}
	
	@Override
	public ResultSet playerTeamView(String t_name) 
	{
		try
		{
			pst=con.prepareStatement("select * from Player where teamName=?");
			pst.setString(1,t_name);
			rs=pst.executeQuery();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet leagueTableView() 
	{
		try
		{
			pst=con.prepareStatement("select * from LeagueTable order by points desc");
			rs=pst.executeQuery();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet viewFixtures() 
	{
		try
		{
			pst=con.prepareStatement("select * from Fixtures");
			rs=pst.executeQuery();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
		
	}
}
