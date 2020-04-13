package teams.services;

import teams.beans.Player;
import teams.beans.Team;

public interface TeamEntry 
{
	public String teamLogin(Team t);
	public void teamRegister(Team t);
	public void teamPlayerRegister(String t_name,Player p);
	public String findTeamName(String o_name);
}
