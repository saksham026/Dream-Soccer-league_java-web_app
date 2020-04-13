package teams.services;

import java.sql.ResultSet;

public interface TeamViews 
{
	public ResultSet playerTeamView(String t_name);
	public ResultSet leagueTableView();
	public ResultSet viewFixtures();
}
