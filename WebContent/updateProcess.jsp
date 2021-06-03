<%@page import="org.ram.personApp.connection.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%
int id = Integer.parseInt(request.getParameter("id"));
String name=request.getParameter("name");
int age=Integer.parseInt(request.getParameter("age"));
if(id != 0)
{
Connection con = null;
PreparedStatement ps = null;
try
{
con = DatabaseConnection.getConnection();
String sql="Update person set name=?,age=? where id=?";
ps = con.prepareStatement(sql);
ps.setString(1,name);
ps.setInt(2, age);
ps.setInt(3,id);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
}
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>