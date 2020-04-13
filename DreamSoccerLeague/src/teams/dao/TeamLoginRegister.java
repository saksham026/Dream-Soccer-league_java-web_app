package teams.dao;

import teams.beans.Player;
import teams.beans.Team;

public interface TeamLoginRegister 
{
	public void teamRegister(Team t);
	public String teamLogin(String ownerName);
	public void teamPlayerRegister(String t_name,Player p);
	public String findTeamName(String o_name);
}
