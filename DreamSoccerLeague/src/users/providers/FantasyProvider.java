package users.providers;

import users.serImplementation.userFantasy;
import users.services.Fantasy;

public class FantasyProvider 
{
	public static Fantasy getObject()
	{
		return new userFantasy();
	}
}
