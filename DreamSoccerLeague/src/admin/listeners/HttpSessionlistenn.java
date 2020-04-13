package admin.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionlistenn implements HttpSessionListener 
{	
    public void sessionCreated(HttpSessionEvent se)  
    { 
        HttpSession session=se.getSession();
        session.setMaxInactiveInterval(240);
        System.out.println(" session created");   
    }

    public void sessionDestroyed(HttpSessionEvent se)  
    { 
    	 HttpSession session=se.getSession();
    	 System.out.println(" session destroyed : ID="+session.getId());
    }
	
}
