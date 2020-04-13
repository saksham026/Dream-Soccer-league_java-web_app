package teams.beans;

import java.util.Arrays;

public class Team 
{
	private String ownerName;
	private String password;
	private String teamName;
	private Player p[]=new Player[5];
	private Record r;	
	
	public Team()
	{
		
	}
	
	public Team(String ownerName, String password, String teamName) {
		super();
		this.ownerName = ownerName;
		this.password = password;
		this.teamName = teamName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Player[] getP() {
		return p;
	}

	public void setP(Player[] p) {
		this.p = p;
	}
	
	public Record getR() {
		return r;
	}

	public void setR(Record r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "Team [ownerName=" + ownerName + ", password=" + password + ", teamName=" + teamName + ", p="
				+ Arrays.toString(p) + ", r=" + r + "]";
	}	
}
