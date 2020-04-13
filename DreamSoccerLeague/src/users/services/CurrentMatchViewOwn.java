package users.services;

import java.sql.ResultSet;
import teams.services.TeamViews;

public interface CurrentMatchViewOwn extends TeamViews
{
	public ResultSet currentMatchView();
	public ResultSet viewOwnTeam(String userName,String teamName1,String teamName2);
}
