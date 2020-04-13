package users.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import users.dao.dbFantasy;

public class dbUserFantasy implements dbFantasy
{
	PreparedStatement pst;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public dbUserFantasy()
	{
		
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
	}
	
	@Override
	public void userTeamFormations(String userName,String t1,String t2,ArrayList playerName) 
	{
		int updatecount;
		try
		{
			pst=con.prepareStatement("insert into UserFantasy values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1,userName);
			pst.setString(2,t1);
			for(int i=0;i<playerName.size();i++)
			{
				pst.setString(i+3,(String) playerName.get(i));
			}
			pst.setInt(9,0);
			pst.setString(3,t2);
			
			updatecount=pst.executeUpdate();
			System.out.println(updatecount+" no. of records inserted");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet userStandings(String t1,String t2) {
		
		
		try
		{
			pst=con.prepareStatement("select * from UserFantasy where teamName1=? and teamName2=?");
			pst.setString(1,t1);
			pst.setString(2,t2);
			rs=pst.executeQuery();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet givePlayers(String team1, String team2) 
	{
		try
		{
			pst=con.prepareStatement("select * from player where teamName=? or teamName=?");
			pst.setString(1,team1);
			pst.setString(2,team2);
			rs=pst.executeQuery();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}

}
