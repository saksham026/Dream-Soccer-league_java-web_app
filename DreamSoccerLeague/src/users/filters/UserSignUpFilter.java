package users.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import users.beans.User;

public class UserSignUpFilter implements Filter 
{

	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		String u=request.getParameter("userName");
		String p=request.getParameter("password");
		String m=request.getParameter("mail");
		long ph=Long.parseLong(request.getParameter("phoneNo"));
		long pa=Long.parseLong(request.getParameter("panNo"));
		User u1=new User(u,p,m,ph,pa);
		u1.setCredits(100);
		request.setAttribute("user",u1);
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException
	{
		
	}


}
