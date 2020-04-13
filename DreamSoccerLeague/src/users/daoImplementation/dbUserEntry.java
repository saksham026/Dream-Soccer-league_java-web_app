package users.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import users.beans.User;
import users.dao.dbUser;

public class dbUserEntry implements dbUser{

	PreparedStatement pst;
	Connection con;
	//Statement stmt;
	ResultSet rs;
	
	public dbUserEntry()
	{
		
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
	}

	@Override
	public void UserRegister(User u) {
		int updatecount=0;
		try
		{
			pst=con.prepareStatement("insert into User values(?,?,?,?,?)");
			pst.setString(1,u.getUserName());
			pst.setString(2,u.getPassword());
			pst.setString(3,u.getMail());
			pst.setLong(4,u.getPhoneNo());
			pst.setLong(5,u.getPanNo());
			
			updatecount=pst.executeUpdate();
			System.out.println(updatecount+" no. of records updated");
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public String UserLogIn(String uname) {
		String pwd=null;
		try
		{
			pst=con.prepareStatement("select * from User where userName=?");
			pst.setString(1,uname);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				pwd=rs.getString(2);
			
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return pwd;
	}
	


}
