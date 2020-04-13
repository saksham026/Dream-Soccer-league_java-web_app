package admin.serImplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import admin.beans.Admin;
import admin.dao.FixtureQueries;
import admin.providers.AdminDatabaseObjectProvider;
import admin.services.Simulation;
import teams.beans.Record;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import admin.daoImplementation.*;

public class AdminFunctions implements Simulation
{
	private FixtureQueries fq;
	private ResultSet rs;
	private Record r;
	Connection con;
	
	public AdminFunctions()
	{
		fq=AdminDatabaseObjectProvider.getObject();
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
		((FixtureFunctions) fq).setCon(con);
	}
	
	public int score()
	{
		Random r=new Random();
		int sc=0;
		
		sc=r.nextInt(2);
		
		return sc;
	}
	
	@Override
	public ResultSet currentMatch() 
	{
		rs=fq.currentMatch();
		return rs;
	}

	@Override
	public Record retrieveRecords(String t_name) 
	{
		r=fq.retrieveRecords(t_name);
		return r;
	}

	@Override
	public String simulateMatch() 
	{
		String t1, t2;
		Record r1,r2;
		int sc1=0,sc2=0;
		ResultSet rs=currentMatch();
		try {
			
			rs.next();
			t1=rs.getString(1);
			t2=rs.getString(2);
			r1=retrieveRecords(t1);
			r2=retrieveRecords(t2);
			
			fq.setPlayerPoints(t1, t2);
			fq.setUserPoints(t1, t2);
			
			for(int i=0;i<9;i++)
			{
				TimeUnit.SECONDS.sleep(1);
			sc1+=score();
			}
			
			for(int i=0;i<9;i++)
			{
				TimeUnit.SECONDS.sleep(1);
			sc2+=score();
			}
			
			if(sc1>sc2)
			{
				fq.fixtureUpdate("t1");
				fq.leagueTableUpdate(t1,t2,t1);
			}
			else if(sc2>sc1)
			{
				fq.fixtureUpdate("t2");
				fq.leagueTableUpdate(t1,t2,t2);
			}
			else
			{
				fq.fixtureUpdate("draw");
				fq.leagueTableUpdate(t1,t2,"draw");
			}
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sc1+"-"+sc2;
	}

	@Override
	public String validate(Admin ad) 
	{
		String pwd=fq.retrieveAdmin(ad.getUserName());
		if(pwd.equals(ad.getPassword()))
		{
			return "valid";
		}
		else
		{
			return "invalid";
		}
	}

}
