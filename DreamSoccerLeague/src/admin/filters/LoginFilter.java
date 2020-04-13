package admin.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import admin.beans.Admin;
import users.beans.User;

public class LoginFilter implements Filter 
{

	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		String u=request.getParameter("userName");
		String p=request.getParameter("password");
		request.setAttribute("admin",new Admin(u,p));
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException
	{
		
	}

}
