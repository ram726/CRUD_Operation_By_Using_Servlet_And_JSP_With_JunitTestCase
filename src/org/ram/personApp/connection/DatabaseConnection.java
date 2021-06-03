package org.ram.personApp.connection;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection
{
	  private static Connection con;
	    public static Connection getConnection() {
	        try {

	            if (con == null) {
	                //driver class load
	                Class.forName("com.mysql.jdbc.Driver");

	                //create a connection..
	                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root", "root");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
}