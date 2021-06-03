package org.ram.personApp.dao;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.ram.personApp.connection.DatabaseConnection;
import org.ram.personApp.entity.Person;
public class PersonDao 
{
	private DatabaseConnection connection;
	private Person person;
	public PersonDao(DatabaseConnection connection) {
		this.connection = connection;
	}
	public PersonDao() {
		// TODO Auto-generated constructor stub
	}
	//add aperson record
	public boolean addNewPerson(Person person)
	{
		boolean b=false;
		try {
			String query="insert into person(name,age) values (?,?)";
			PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(query);
			pstmt.setString(1, person.getName());
			pstmt.setInt(2, person.getAge());
			pstmt.executeUpdate();
			b=true;
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	// delete a person record by id
	public boolean deletePersonById(Person person)
	{
		boolean b=false;
		try {
			String sql="DELETE from person where id=?";
			PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql);
			pstmt.setInt(1, person.getId());
			pstmt.executeUpdate();
			b=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	// delete record of an age group
		public boolean deleteAgeGroup(Person person)
		{
			boolean b=false;
			try {
				String sql="DELETE from person where age=?";
				PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql);
				pstmt.setInt(1, person.getId());
				pstmt.executeUpdate();
				b=true;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return b;
		}
		
		//Search person
		 public boolean seacrhPerson(Person person)
		 {
			 boolean b=false;
			 try {
				String sql= "select * from person where id=? or name=? or age=? order by id";
				PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql);
				pstmt.setInt(1, person.getId());
				pstmt.setString(2,person.getName());
				pstmt.setInt(3, person.getAge());
				pstmt.executeUpdate();
				b=true;
			 
			 } catch (Exception e) {
				// TODO: handle exception
			}
			return b;
			 
		 }
}
