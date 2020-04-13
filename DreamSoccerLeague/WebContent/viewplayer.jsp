<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Player</title>
</head>
<body>
<%
ResultSet rs2=(ResultSet)session.getAttribute("rs2");
%>
<table>
<tr>
<th>NAME</th>
<th>AGE</th>
<th>POSITION</th>
<th>CREDITS</th>
<th>TEAMNAME</th>
</tr>	
<%
while(rs2.next())
{
%>
<tr>
<td><%=rs2.getString(1) %></td>
<td><%=rs2.getInt(2) %></td>
<td><%=rs2.getString(3) %></td>
<td><%=rs2.getInt(4) %></td>
<td><%=rs2.getString(5) %></td>
</tr>
<%
}
%>
</table>
</body>
</html>