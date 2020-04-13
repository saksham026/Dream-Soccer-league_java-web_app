package users.providers;

import users.serImplementation.userViews;
import users.services.CurrentMatchViewOwn;

public class CurrentMatchViewOwnProvider 
{
	public static CurrentMatchViewOwn getObject()
	{
		return new userViews();
	}
}
