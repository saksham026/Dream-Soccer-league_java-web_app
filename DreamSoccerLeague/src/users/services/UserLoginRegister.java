package users.services;

import users.beans.User;

public interface UserLoginRegister 
{
	public String UserLogIn(User u);
	public void UserRegister(User u);
}
