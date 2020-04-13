package admin.dao;

import java.sql.ResultSet;

import teams.beans.Record;

public interface FixtureQueries 
{
	public String retrieveAdmin(String adminName);
	public ResultSet currentMatch();
	public Record retrieveRecords(String t_name);
	public void fixtureUpdate(String result);
	public void leagueTableUpdate(String t1,String t2,String result);
	public void setPlayerPoints(String t1,String t2);
	public void setUserPoints(String t1,String t2);
	
}
