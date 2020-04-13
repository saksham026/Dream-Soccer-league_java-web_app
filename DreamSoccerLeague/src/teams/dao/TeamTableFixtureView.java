package teams.dao;

import java.sql.ResultSet;

import teams.beans.Team;

public interface TeamTableFixtureView
{
	public ResultSet playerTeamView(String t_name);
	public ResultSet leagueTableView();
	public ResultSet viewFixtures();
}
