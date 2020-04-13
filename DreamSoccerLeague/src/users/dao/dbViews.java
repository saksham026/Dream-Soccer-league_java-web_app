package users.dao;

import java.sql.ResultSet;

public interface dbViews {

	public ResultSet currentMatchView();
	public ResultSet viewOwnTeam(String userName,String teamName1,String teamName2);
}
