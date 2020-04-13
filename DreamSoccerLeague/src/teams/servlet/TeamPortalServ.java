package teams.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teams.beans.Player;
import teams.beans.Team;
import teams.daoImplementation.TeamEntryQueries;
import teams.providers.Teams1ServiceObjectProvider;
import teams.providers.Teams2ServiceObjectProvider;
import teams.serImplementation.TeamRegisterLogic;
import teams.serImplementation.TeamViewsLogic;
import teams.services.TeamEntry;
import teams.services.TeamViews;

public class TeamPortalServ extends HttpServlet 
{
	TeamEntry t;
	TeamViews tv;
	Connection con;
	String teamName=null;
	
    public void init() 
    {
        t=Teams1ServiceObjectProvider.getObject();
        tv=Teams2ServiceObjectProvider.getObject();
        con=(Connection) getServletContext().getAttribute("dbcon");
        ((TeamRegisterLogic)t).setCon(con);
        ((TeamViewsLogic)tv).setCon(con);
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();

		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/tsignup"))
		{
	  		t.teamRegister((Team) request.getAttribute("team"));
	  		RequestDispatcher dispatch=request.getRequestDispatcher("/DLSTeam.html");
			dispatch.forward(request,response);
		}
		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/tsignin"))
		{
			HttpSession session=request.getSession(true);
			Team te=(Team) request.getAttribute("team");
			
			//db logic for setting team name
			te.setTeamName(t.findTeamName(te.getOwnerName()));
			
			session.setAttribute("sessionteam",te);
			t.teamLogin((Team) request.getAttribute("team"));
			
			//checking logic
			RequestDispatcher dispatch=request.getRequestDispatcher("/TeamMatchDetails.html");
			dispatch.forward(request,response);	
		}
		
		
		
		//new mappings
		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/viewfix"))
		{
			
	  		ResultSet rs=tv.viewFixtures();
	  		HttpSession session=request.getSession(false);
	  		session.setAttribute("rs", rs);
	  		RequestDispatcher dispatch=request.getRequestDispatcher("/viewfix.jsp");
			dispatch.forward(request,response);
	  		
		}
		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/viewLtable"))
		{
			ResultSet rs=tv.leagueTableView();
			HttpSession session=request.getSession(false);
	  		session.setAttribute("rs1", rs);
			RequestDispatcher dispatch=request.getRequestDispatcher("/viewLtable.jsp");
			dispatch.forward(request,response);
		}
		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/viewplayer"))
		{
			HttpSession session=request.getSession(false);
			Team team=(Team) session.getAttribute("sessionteam");
	  		ResultSet rs=tv.playerTeamView(team.getTeamName());
	  		session.setAttribute("rs2", rs);
	  		
			RequestDispatcher dispatch=request.getRequestDispatcher("/viewplayer.jsp");
			dispatch.forward(request,response);
		}
		
		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/terminateteam"))
		{
			HttpSession session=request.getSession(false);
	  		session.invalidate();
			RequestDispatcher dispatch=request.getRequestDispatcher("/DLSMain.html");
			dispatch.forward(request,response);
		}
		

		if(request.getRequestURI().toString().equals("/DreamSoccerLeague/signin"))
		{
			HttpSession session=request.getSession(false);		
			Team team=(Team) session.getAttribute("sessionteam");
			Player p=(Player) request.getAttribute("player");
			
			t.teamPlayerRegister(team.getTeamName(),p);
			RequestDispatcher dispatch=request.getRequestDispatcher("/TeamMatchDetails.html");
			dispatch.forward(request,response);
		}
		
	}

}
