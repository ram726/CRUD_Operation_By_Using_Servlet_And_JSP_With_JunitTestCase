<%@page import="org.ram.personApp.connection.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<!-- Search Person record by Id,Age -->
<form method="post" name="frm" action="SearchPerson">
<h3 style="color: blue">Search Person record by Id,Name,Age</h3>
<input type ="number" name="search" required="required">
<input  type="submit" name="submit" value="Search">
</form>

<table border=1>
<tr>
<!-- Inserting record -->
<td>
<form action="AddPersonServlet" method ="post">
<h3 style="color: green">Add Person Details</h2>
FullName:<input type="text" name="name" required><br>
Age:<input type="number" name="age" required><br>
<input type="submit" value="add">
</form>
</td>

<!-- Deleting person record -->
<td>
<h3 style="color: red">Delete a Person by using Id</h2>
<form action="DeletePersonById" method="post">
Id:<input type="number" name="id" required="required">
<input type="submit" value="delete by id">
</form>
<hr>
<h3 style="color: red">Delete an age group record</h2>
<form action="DeleteAgeGroup" method="post">
Age:<input type="number" name="age" required="required">
<input type="submit" value="delete by age">
</form>
</td>
<!-- Update Person Details -->
<td></td>
</tr>
</table>

<!-- All Person Details -->
<form action="">
<h3 style="color: hotpink">All Person Details</h3>
<table>
<tr>
<td>Id</td><td>Name</td><td>Age</td><td>Action</td>
</tr>
<%
Connection connection=null;
Statement statement=null;
ResultSet resultSet=null;

try{
	connection= DatabaseConnection.getConnection();
	statement=connection.createStatement();
	String sql="select * from person";
	resultSet = statement.executeQuery(sql);	
	while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getInt("id") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getInt("age") %></td>
<td>
<a href="update.jsp?id=<%=resultSet.getInt("id") %>">Update</a>
</td>
</tr>
<%
	}}
catch(Exception e)
{
	e.printStackTrace();
}
%>
<tr>
</tr>
</table>
</form>
</body>
</html>