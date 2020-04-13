package teams.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import teams.beans.Player;
import teams.beans.Team;
import teams.dao.TeamLoginRegister;

public class TeamEntryQueries implements TeamLoginRegister
{
	PreparedStatement pst;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public TeamEntryQueries()
	{
		
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
	}
	
	@Override
	public void teamRegister(Team t) 
	{
		int updatecount=0;
		try
		{
			pst=con.prepareStatement("update team set ownerName=?, password=? where teamName=?");
			pst.setString(1,t.getOwnerName());
			pst.setString(2,t.getPassword());
			pst.setString(3,t.getTeamName());
			updatecount=pst.executeUpdate();
			System.out.println(updatecount+" no. of records updated");
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public String teamLogin(String ownerName) 
	{
		String pwd=null;
		try
		{
			pst=con.prepareStatement("select * from Team where ownerName=?");
			pst.setString(1,ownerName);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				pwd=rs.getString(2);
			}
			return pwd;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void teamPlayerRegister(String t_name, Player p) 
	{
		int updatecount=0;
		try
		{
			pst=con.prepareStatement("insert into Player values(?,?,?,?,?,?)");
			pst.setString(1,p.getName());
			pst.setInt(2,p.getAge());
			pst.setString(3,p.getPosition());
			pst.setInt(4,p.getCredits());
			pst.setString(5,t_name);
			pst.setInt(6,0);
			
			updatecount=pst.executeUpdate();
			System.out.println(updatecount+" no. of records inserted");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public String findTeamName(String o_name) 
	{
		String team=null;
		try
		{
			pst=con.prepareStatement("select teamName from Team where ownerName=?");
			pst.setString(1,o_name);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				team=rs.getString(1);
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return team;
	}
	
}
