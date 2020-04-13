package admin.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import admin.beans.Admin;
import admin.dao.FixtureQueries;
import teams.beans.Record;

public class FixtureFunctions implements FixtureQueries
{
	private Record r;
	private Admin ad;
	PreparedStatement pst;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public FixtureFunctions()
	{
		
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
	}
	
	@Override
	public ResultSet currentMatch() 
	{
		try
		{
			pst=con.prepareStatement("select * from Fixtures where result=? limit 1");
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
	public Record retrieveRecords(String t_name) 
	{
		try
		{
			pst=con.prepareStatement("select * from LeagueTable where teamName=?");
			pst.setString(1,t_name);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				int w=rs.getInt(2);
				int l=rs.getInt(3);
				int d=rs.getInt(4);
				int pts=rs.getInt(5);
				r=new Record(w,l,d,pts);
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public void fixtureUpdate(String result) 
	{
		try
		{
			pst=con.prepareStatement("update Fixtures set result=? where result=? limit 1");
			pst.setString(1,result);
			pst.setString(2,"NA");
			pst.executeUpdate();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void leagueTableUpdate(String t1,String t2,String result)
	{
		try
		{
			if(result==t1)
			{
				pst=con.prepareStatement("update LeagueTable set wins=wins+1,points=points+3 where teamName=?");
				pst.setString(1,t1);
				pst.executeUpdate();
				
				pst=con.prepareStatement("update LeagueTable set losses=losses+1 where teamName=?");
				pst.setString(1,t2);
				pst.executeUpdate();
			}
			
			else if(result==t2)
			{
				pst=con.prepareStatement("update LeagueTable set wins=wins+1,points=points+3 where teamName=?");
				pst.setString(1,t2);
				pst.executeUpdate();
				
				pst=con.prepareStatement("update LeagueTable set losses=losses+1 where teamName=?");
				pst.setString(1,t1);
				pst.executeUpdate();
			}
			
			else
			{
				pst=con.prepareStatement("update LeagueTable set draws=draws+1,points=points+1 where teamName=?");
				pst.setString(1,t1);
				pst.executeUpdate();
				
				pst=con.prepareStatement("update LeagueTable set draws=draws+1,points=points+1 where teamName=?");
				pst.setString(1,t2);
				pst.executeUpdate();
			}
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public String retrieveAdmin(String adminName) 
	{
		String pwd=null;
		try
		{
			pst=con.prepareStatement("select * from Administrator where adminName=?");
			pst.setString(1,adminName);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				pwd=rs.getString(2);
				ad=new Admin(adminName,pwd);
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return pwd;
	}

	@Override
	public void setPlayerPoints(String t1, String t2) {
		// TODO Auto-generated method stub
		
		Random r=new Random();
		int p=0;
		try
		{
			try
			{
				pst=con.prepareStatement("select * from player where teamName=? or teamName=?");
				pst.setString(1,t1);
				pst.setString(2,t2);
				rs=pst.executeQuery();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			while(rs.next())
			{
				p=r.nextInt(10);
				pst=con.prepareStatement("update player set points=? where name=?");
				pst.setInt(1,p);
				pst.setString(2,rs.getString(1));
				pst.executeUpdate();
			}				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}

	@Override
	public void setUserPoints(String t1, String t2) 
	{
		ResultSet rs1;
		try
		{
			pst=con.prepareStatement("select * from userfantasy where teamName1=? and teamName2=?");
			pst.setString(1,t1);
			pst.setString(2,t2);
			rs=pst.executeQuery();

			while(rs.next())
			{
				int points=0;
				pst=con.prepareStatement("select points from player where name=? or name=? or name=? or name=? or name=?");
				pst.setString(1,rs.getString(4));
				pst.setString(2,rs.getString(5));
				pst.setString(3,rs.getString(6));
				pst.setString(4,rs.getString(7));
				pst.setString(5,rs.getString(8));
				rs1=pst.executeQuery();
				while(rs1.next())
				{
					points+=rs1.getInt(1);
				}
				
				pst=con.prepareStatement("update userfantasy set userPoints=? where userName=? and teamName1=? and teamName2=?");
				pst.setInt(1,points);
				pst.setString(2,rs.getString(1));
				pst.setString(3,t1);
				pst.setString(4,t2);
				pst.executeUpdate();
			}				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
}
