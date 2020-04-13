<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ResultSet rs=(ResultSet)session.getAttribute("OwnTeam");
%>
<table>
<tr>
<th>PLAYER NAME 1</th>
<th>PLAYER NAME 2</th>
<th>PLAYER NAME 3</th>
<th>PLAYER NAME 4</th>
<th>PLAYER NAME 5</th>
</tr>	
<%
while(rs.next())
{
%>
<tr>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
<td><%=rs.getString(7) %></td>
<td><%=rs.getString(8) %></td>
</tr>
<%
}
%>
</table>
</body>
</html>