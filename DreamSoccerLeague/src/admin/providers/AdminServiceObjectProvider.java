package admin.providers;

import admin.serImplementation.AdminFunctions;
import admin.services.Simulation;

public class AdminServiceObjectProvider 
{
	public static Simulation getObject()
	{
		return new AdminFunctions();
	}
}
