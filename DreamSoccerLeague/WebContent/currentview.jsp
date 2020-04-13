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
 ResultSet rs=(ResultSet)session.getAttribute("rs3");
%>
<table>
<tr>
<th>Team Name 1</th>
<th>Team Name 2</th>
<th>Match Date</th>
<th>Result</th>
</tr>	
<%
while(rs.next())
{
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getDate(3) %></td>
<td><%=rs.getString(4) %></td>
</tr>
<%
}
%>
</table>
</body>
</html>