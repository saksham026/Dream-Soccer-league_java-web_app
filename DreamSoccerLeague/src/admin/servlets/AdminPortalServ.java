package admin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.beans.Admin;
import admin.providers.AdminServiceObjectProvider;
import admin.serImplementation.AdminFunctions;
import admin.services.Simulation;


public class AdminPortalServ extends HttpServlet 
{
	Simulation s;
	Connection con;
    
    public void init()
    {
    	s=AdminServiceObjectProvider.getObject();
    	con=(Connection) getServletContext().getAttribute("dbcon");
    	((AdminFunctions) s).setCon(con);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out=response.getWriter();
				
		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/aLogin"))
		{
			String temp=s.validate((Admin) request.getAttribute("admin"));	
			if(temp.equals("valid"))
			{
				HttpSession session=request.getSession(true);
				RequestDispatcher dispatch=request.getRequestDispatcher("/PlayMatch.html");
				dispatch.forward(request,response);
			}
			else
			{
				RequestDispatcher dispatch=request.getRequestDispatcher("/AdministratorLogin.html");
				dispatch.include(request,response);
				out.println("Invalid Credentials");
			}
		}
		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/play"))
		{
			String score=s.simulateMatch();
			HttpSession session=request.getSession(false);
		  	session.setAttribute("score",score);
		  	System.out.println("score is"+session.getAttribute("score"));
			RequestDispatcher dispatch=request.getRequestDispatcher("/SimulateMatch.jsp");
			dispatch.forward(request,response);
			
		}
		
		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/terminateadmin"))
		{
			HttpSession session=request.getSession(false);
	  		session.invalidate();
			RequestDispatcher dispatch=request.getRequestDispatcher("/DLSMain.html");
			dispatch.forward(request,response);
		}
		
			
	}

}

