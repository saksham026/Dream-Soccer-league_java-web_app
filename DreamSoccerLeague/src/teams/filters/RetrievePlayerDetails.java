package teams.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import teams.beans.Player;
import teams.beans.Team;

public class RetrievePlayerDetails implements Filter 
{

	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		String n=request.getParameter("name");
		int a=Integer.parseInt(request.getParameter("age"));
		String p=request.getParameter("position");
		int c=Integer.parseInt(request.getParameter("credits"));
		request.setAttribute("player", new Player(n,a,p,c));
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException
	{
		
	}
}
