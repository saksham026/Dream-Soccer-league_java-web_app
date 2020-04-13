package users.providers;

import users.dao.dbViews;
import users.daoImplementation.dbUserViews;

public class dbViewsProvider 
{
	public static dbViews getObject()
	{
		return new dbUserViews();
	}
}
