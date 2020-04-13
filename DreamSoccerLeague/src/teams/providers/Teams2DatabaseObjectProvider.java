package teams.providers;

import teams.dao.TeamTableFixtureView;
import teams.daoImplementation.TeamViewQueries;

public class Teams2DatabaseObjectProvider 
{
	public static TeamTableFixtureView getObject()
	{
		return new TeamViewQueries();
	}
}
