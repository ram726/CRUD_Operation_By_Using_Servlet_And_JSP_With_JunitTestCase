<%@page import="org.ram.personApp.connection.DatabaseConnection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Update</title>
</head>
<body>

    
    <%
    String id=request.getParameter("id");
    System.out.print(id);
    int id1=Integer.parseInt(id);
  	Connection connection = null;
  	PreparedStatement pstmt = null;
  	ResultSet resultSet = null;
  %>
  
  <%
  try{
	  connection = DatabaseConnection.getConnection();
	  String sql ="select * from person where id=?";
	  pstmt=connection.prepareStatement(sql);
	  pstmt.setInt(1,id1);
	  resultSet = pstmt.executeQuery();
  %>
<form method="get" action="updateProcess.jsp">
<%
while(resultSet.next()){
%>
<input type="hidden" name="id" value="<%=resultSet.getInt("id") %>">
<br>
Fullname:<br>
<input type="text" name="name" value="<%=resultSet.getString("name") %>">
<br>
Age:<br>
<input type="number" name="age" value="<%=resultSet.getString("age") %>">
<input type="submit" value="submit">
<%} %>
</form>
<%

} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>