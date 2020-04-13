package admin.services;

import java.sql.ResultSet;

import admin.beans.Admin;
import teams.beans.Record;

public interface Simulation 
{
	public String validate(Admin ad);
	public ResultSet currentMatch();
	public Record retrieveRecords(String t_name);
	public String simulateMatch();
}
