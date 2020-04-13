package users.providers;

import users.dao.dbUser;
import users.daoImplementation.dbUserEntry;

public class dbUserProvider 
{
	public static dbUser getObject()
	{
		return new dbUserEntry();
	}
}
