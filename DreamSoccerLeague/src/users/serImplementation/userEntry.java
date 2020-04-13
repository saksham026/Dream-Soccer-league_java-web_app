package users.serImplementation;

import java.sql.Connection;

import users.beans.User;
import users.dao.dbUser;
import users.daoImplementation.dbUserEntry;
import users.providers.dbUserProvider;
import users.services.UserLoginRegister;

public class userEntry implements UserLoginRegister{

	dbUser ur;
	
	Connection con;
	
	
	public userEntry()
	{
		ur=dbUserProvider.getObject();
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
		((dbUserEntry) ur).setCon(con);
	}
	
	@Override
	public String UserLogIn(User u) {
		
		String pwd=ur.UserLogIn(u.getUserName());
		if(pwd.equals(u.getPassword()))
		{
			return "valid";
		}
		return "invalid";
	}

	@Override
	public void UserRegister(User u) {
		
		ur.UserRegister(u);
		
	}

}
