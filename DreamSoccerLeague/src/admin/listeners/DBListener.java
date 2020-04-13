package admin.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class DBListener implements ServletContextListener 
{
	 Connection con;
	 
    public DBListener() 
    {
        
    }
    
    public void contextInitialized(ServletContextEvent sce)  
    { 
    	ServletContext context=sce.getServletContext();
    	String driverclass=context.getInitParameter("drivername");
    	String url=context.getInitParameter("url");
    	String username=context.getInitParameter("username");
    	String password=context.getInitParameter("password");
    	
    	try
		{
			Class.forName(driverclass);
			con=DriverManager.getConnection(url,username,password);				
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	
    	context.setAttribute("dbcon",con);
    }
    
    public void contextDestroyed(ServletContextEvent sce)  
    { 
        try 
        {
			con.close();
		} 
        
        catch (SQLException e) 
        {
			e.printStackTrace();
		}
    }
	
}
