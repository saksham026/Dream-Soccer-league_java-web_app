package teams.providers;

import teams.serImplementation.TeamViewsLogic;
import teams.services.TeamViews;

public class Teams2ServiceObjectProvider 
{
	public static TeamViews getObject()
	{
		return new TeamViewsLogic();
	}
}
