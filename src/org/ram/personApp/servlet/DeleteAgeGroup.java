package org.ram.personApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ram.personApp.connection.DatabaseConnection;
import org.ram.personApp.dao.PersonDao;
import org.ram.personApp.entity.Person;
@WebServlet("/DeleteAgeGroup")
public class DeleteAgeGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseConnection connection;
	public void init() {
		connection = new DatabaseConnection();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		int age=Integer.parseInt(request.getParameter("age"));
		
		Person person=new Person(age);
		PersonDao dao=new PersonDao(connection);
		if(dao.deleteAgeGroup(person))
		{
			request.getRequestDispatcher("index.jsp").include(request, response); 
            out.println("<br><br>Record Deleted...");
		}
		else
		{
			 request.getRequestDispatcher("index.jsp").include(request, response); 
             out.println("<br><br>Error! Something went wrong...");
		}
	}
}
