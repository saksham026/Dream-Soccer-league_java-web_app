package users.providers;

import users.dao.dbFantasy;
import users.daoImplementation.dbUserFantasy;

public class dbFantasyProvider 
{
	public static dbFantasy getObject()
	{
		return new dbUserFantasy();
	}
}
