package users.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.beans.User;
import users.providers.CurrentMatchViewOwnProvider;
import users.providers.FantasyProvider;
import users.providers.UserLoginRegisterProvider;
import users.serImplementation.userEntry;
import users.serImplementation.userFantasy;
import users.serImplementation.userViews;
import users.services.CurrentMatchViewOwn;
import users.services.Fantasy;
import users.services.UserLoginRegister;

public class UserPortalServ extends HttpServlet {
	UserLoginRegister ulr;
	Fantasy f;
	CurrentMatchViewOwn cmvo;
	String userName = null;

	Connection con;

	String team1, team2;

	ArrayList playerName;

	static int count = 0;

	public void init() {
		playerName = new ArrayList();

		ulr = UserLoginRegisterProvider.getObject();
		f = FantasyProvider.getObject();
		cmvo = CurrentMatchViewOwnProvider.getObject();
		con = (Connection) getServletContext().getAttribute("dbcon");
		((userEntry) ulr).setCon(con);
		((userFantasy) f).setCon(con);
		((userViews) cmvo).setCon(con);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		User u = (User) request.getAttribute("user");

		if (request.getRequestURI().toString().equals("/DreamSoccerLeague/usignup")) {
			ulr.UserRegister(u);
			RequestDispatcher dispatch = request.getRequestDispatcher("/UserLogin.html");
			dispatch.forward(request, response);
		}

		if (request.getRequestURI().toString().equals("/DreamSoccerLeague/usignin")) {
			userName = u.getUserName();
			String temp = ulr.UserLogIn(u);

			if (temp.equals("valid")) 
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("usern", userName);
				RequestDispatcher dispatch = request.getRequestDispatcher("/UserMatchDetails.html");
				dispatch.forward(request, response);
			} else {
				RequestDispatcher dispatch = request.getRequestDispatcher("/UserLogin.html");
				dispatch.include(request, response);
				out.println("Invalid Credentials");
			}

		}

		// new mappings
		if (request.getRequestURI().toString().equals("/DreamSoccerLeague/viewstandings")) {

			ResultSet rs = f.userStandings(request.getParameter("teamName1"), request.getParameter("teamName2"));
			HttpSession session = request.getSession(false);
			session.setAttribute("UserStandings",rs);

			RequestDispatcher dispatch = request.getRequestDispatcher("/viewstandings.jsp");
			dispatch.forward(request, response);
		}

		if (request.getRequestURI().toString().equals("/DreamSoccerLeague/createform")) {

			// session logic
			if (count == 0) 
			{
				ResultSet rs = cmvo.currentMatchView();
				
				try 
				{
					rs.next();
					team1 = rs.getString(1);
					team2 = rs.getString(2);
				}
				catch (SQLException e) {
					e.printStackTrace();
				}

				ResultSet rs1 = f.givePlayers(team1, team2);
				HttpSession session = request.getSession(false);
				session.setAttribute("givePlayers", rs1);
				System.out.println("for count==0");

				RequestDispatcher dispatch = request.getRequestDispatcher("/formTeam.jsp");
				dispatch.forward(request, response);
			}

			
			  String p_name=request.getParameter("playerName"); 
			  playerName.add(p_name);
			  
			  HttpSession session=request.getSession(false);
			  session.setAttribute("playerinfo",playerName); 
			  count++;
			  
			  
			  if(count<=5) 
			  {
				  ResultSet rs = cmvo.currentMatchView();
					
					try 
					{
						rs.next();
						team1 = rs.getString(1);
						team2 = rs.getString(2);
					}
					catch (SQLException e) {
						e.printStackTrace();
					}

					ResultSet rs1 = f.givePlayers(team1, team2);
					session.setAttribute("givePlayers", rs1);
					
				  RequestDispatcher dispatch=request.getRequestDispatcher("/formTeam.jsp");
				  dispatch.forward(request,response); 
			  }
			  
			  else 
			  {
			  
				  f.userTeamFormations((String) session.getAttribute("usern"),team1,team2,(ArrayList)session.getAttribute("playerinfo")); 
				  RequestDispatcher dispatch1=request.getRequestDispatcher("UserMatchDetails.html");
				  dispatch1.include(request,response);
				  out.println("Team is successfully formed....."); 
			  }
		}
			
		if (request.getRequestURI().toString().equals("/DreamSoccerLeague/viewown")) 
		{

			HttpSession session = request.getSession(false);
			ResultSet rs = cmvo.currentMatchView();
			
			try 
			{
				rs.next();
				team1 = rs.getString(1);
				team2 = rs.getString(2);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			String un=(String) session.getAttribute("usern");
			
			ResultSet rs1 = cmvo.viewOwnTeam(un, team1, team2);
			
			session.setAttribute("OwnTeam", rs1);
			RequestDispatcher dispatch = request.getRequestDispatcher("/viewown.jsp");
			dispatch.forward(request, response);
		}

		if (request.getRequestURI().toString().equals("/DreamSoccerLeague/currentview")) 
		{
			ResultSet rs = cmvo.currentMatchView();
			HttpSession session = request.getSession(false);
			session.setAttribute("rs3", rs);
			RequestDispatcher dispatch = request.getRequestDispatcher("/currentview.jsp");
			dispatch.forward(request, response);
		}

		if (request.getRequestURI().toString().equals("/DreamSoccerLeague/terminateuser")) 
		{
			HttpSession session = request.getSession(false);
			session.invalidate();
			RequestDispatcher dispatch = request.getRequestDispatcher("/DLSMain.html");
			dispatch.forward(request, response);
		}

	}

}
