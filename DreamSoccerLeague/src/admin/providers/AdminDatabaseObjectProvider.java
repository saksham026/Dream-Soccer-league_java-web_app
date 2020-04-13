package admin.providers;

import java.sql.Connection;

import admin.dao.FixtureQueries;
import admin.daoImplementation.FixtureFunctions;

public class AdminDatabaseObjectProvider 
{
	public static FixtureQueries getObject()
	{
		return new FixtureFunctions();
	}
}


