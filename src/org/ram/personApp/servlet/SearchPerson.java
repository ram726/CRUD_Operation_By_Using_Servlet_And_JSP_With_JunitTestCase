package org.ram.personApp.servlet;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ram.personApp.connection.DatabaseConnection;
import org.ram.personApp.dao.PersonDao;
import org.ram.personApp.entity.Person;

@WebServlet("/SearchPerson")
public class SearchPerson extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "person";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        java.sql.Statement st=null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("connected!.....");
            String name = request.getParameter("search");
            int id=Integer.parseInt(name);
            int age=Integer.parseInt(name);
            ArrayList al = null;
            ArrayList pid_list = new ArrayList();
            String query = "select * from person";
            System.out.println(name);
            if(name!=null && !name.equals("") ||id!=0 ||age!=0 ){
                query = "select * from person where id='" + id + "' or name='"+name+"' or age='"+age+"'order by id";
            }
            System.out.println("query " + query);
            st = conn.createStatement();
            ResultSet rs = ((java.sql.Statement) st).executeQuery(query);

            while (rs.next()) {
                al = new ArrayList();

                al.add(rs.getInt(1));
                al.add(rs.getString(2));
                al.add(rs.getInt(3));
                System.out.println("al :: " + al);
                pid_list.add(al);
            }

            request.setAttribute("piList", pid_list);
            RequestDispatcher view = request.getRequestDispatcher("view.jsp");
            view.forward(request, response);
            conn.close();
            System.out.println("Disconnected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "getting records from database through servlet controller";
    }}
