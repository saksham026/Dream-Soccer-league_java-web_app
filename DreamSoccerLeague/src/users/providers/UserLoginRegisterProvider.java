package users.providers;

import users.serImplementation.userEntry;
import users.services.UserLoginRegister;

public class UserLoginRegisterProvider 
{
	public static UserLoginRegister getObject()
	{
		return new userEntry();
	}
}
