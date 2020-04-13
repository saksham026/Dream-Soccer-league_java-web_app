<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="createform" method="post">
<%
 ResultSet rs=(ResultSet)session.getAttribute("givePlayers");
%>
<select name="playerName">	
<%
while(rs.next())
{
%>

<option value=<%=rs.getString(1) %>><%=rs.getString(1) %></option>

<%
}
%>
</select>
<input type="submit" name="submit"/>
</form>
</body>
</html>