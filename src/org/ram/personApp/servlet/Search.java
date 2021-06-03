package org.ram.personApp.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
@WebServlet("/search")
public class Search extends HttpServlet{ 
 
 @SuppressWarnings({ "unchecked", "rawtypes" })
public void doPost(HttpServletRequest request, 
  HttpServletResponse response)
  throws ServletException,IOException{
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();

  Connection conn = null;
  String url = "jdbc:mysql://localhost:3306/";
  String dbName = "person";
  String driver = "com.mysql.jdbc.Driver";
  String userName = "root"; 
  String password = "root";

  
  Statement st;
  try {
  Class.forName(driver).newInstance();
  conn = DriverManager.getConnection(url+dbName,userName,password);
  System.out.println("Connected to the database");
  String search  = request.getParameter("search");
  int id=Integer.parseInt(search);
  int age=Integer.parseInt(search);

  ArrayList al=null;
  ArrayList personList =new ArrayList();
  String query = "select * from person where id='"+id+"' or name='"+search+"' or age='"+age+"'order by id";
  System.out.println("query " + query);
  st = conn.createStatement();
  ResultSet  rs = st.executeQuery(query);

  while(rs.next()){
  al  = new ArrayList();
  
  al.add(rs.getInt(1));
  al.add(rs.getString(2));
  al.add(rs.getInt(3));
  personList.add(al);
  }

  request.setAttribute("PersonList",personList);
 System.out.println("PersonList " + personList);

  // out.println("emp_list " + emp_list);

  String nextJSP = "/viewSearch.jsp";
  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
  dispatcher.forward(request,response);
  conn.close();
  System.out.println("Disconnected from database");
  } catch (Exception e) {
  e.printStackTrace();
  }
  }
}