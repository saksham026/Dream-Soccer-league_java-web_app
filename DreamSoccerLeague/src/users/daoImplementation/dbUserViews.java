package users.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import users.dao.dbViews;

public class dbUserViews implements dbViews{
	
	PreparedStatement pst;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public dbUserViews()
	{
		
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
	}

	@Override
	public ResultSet currentMatchView() 
	{	
		try
		{
			pst=con.prepareStatement("select * from fixtures where result=? limit 1");
			pst.setString(1,"NA");
			rs=pst.executeQuery();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public ResultSet viewOwnTeam(String userName,String teamName1,String teamName2) 
	{
		try
		{
			pst=con.prepareStatement("select * from UserFantasy where userName=? and teamName1=? and teamName2=?");
			pst.setString(1, userName);
			pst.setString(2,teamName1);
			pst.setString(3,teamName2);
			rs=pst.executeQuery();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

}
