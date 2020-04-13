package teams.providers;

import teams.serImplementation.TeamRegisterLogic;
import teams.services.TeamEntry;

public class Teams1ServiceObjectProvider 
{
	public static TeamEntry getObject()
	{
		return new TeamRegisterLogic();
	}
}
