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

@WebServlet("/AddPersonServlet")
public class AddPersonServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private DatabaseConnection connection;

	public void init() {
		connection = new DatabaseConnection();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		
		System.out.println(name);
		System.out.println(age);
		Person person=new Person(name, age);
		PersonDao dao= new PersonDao(connection);
		
		if(dao.addNewPerson(person))
		{
			System.out.println(name);
			 request.getRequestDispatcher("index.jsp").include(request, response); 
             out.println("<br><br>Person Record Added Successfully...");
		}
		else
		{
			 request.getRequestDispatcher("index.jsp").include(request, response); 
             out.println("<br><br>Error! Something Went Wrong...");
		}
	}

}
