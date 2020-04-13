package teams.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import teams.beans.Team;

public class LoginFilter implements Filter 
{

	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		String o=request.getParameter("ownerName");
		String t=request.getParameter("teamName");
		String p=request.getParameter("password");
		request.setAttribute("team", new Team(o,p,t));
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException
	{
		
	}

}
