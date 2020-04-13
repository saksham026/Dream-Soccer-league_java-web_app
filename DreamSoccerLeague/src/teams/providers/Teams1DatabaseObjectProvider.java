package teams.providers;

import teams.dao.TeamLoginRegister;
import teams.daoImplementation.TeamEntryQueries;

public class Teams1DatabaseObjectProvider 
{
	public static TeamLoginRegister getObject()
	{
		return new TeamEntryQueries();
	}
}
