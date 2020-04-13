package teams.serImplementation;

import java.sql.Connection;

import teams.beans.Player;
import teams.beans.Team;
import teams.dao.TeamLoginRegister;
import teams.daoImplementation.TeamEntryQueries;
import teams.providers.Teams1DatabaseObjectProvider;
import teams.services.TeamEntry;

public class TeamRegisterLogic implements TeamEntry
{

	private TeamLoginRegister tlr;
	Connection con;
	
	public TeamRegisterLogic() 
	{
		tlr=Teams1DatabaseObjectProvider.getObject();
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
		((TeamEntryQueries)tlr).setCon(con);
		
	}

	@Override
	public String teamLogin(Team t) 
	{
		String pswd;
		pswd=tlr.teamLogin(t.getOwnerName());
		if(pswd.equals(t.getPassword()))
		{
			return "valid";
		}
		return "invalid";
		
	}

	@Override
	public void teamRegister(Team t) 
	{
		tlr.teamRegister(t);	
	}

	@Override
	public void teamPlayerRegister(String t_name, Player p) 
	{
		tlr.teamPlayerRegister(t_name, p);
		
	}

	@Override
	public String findTeamName(String o_name) 
	{
		return tlr.findTeamName(o_name);
	}

}
