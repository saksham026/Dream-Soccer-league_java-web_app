package users.dao;

import users.beans.User;

public interface dbUser {

	public String UserLogIn(String uname);
	public void UserRegister(User u);
}
