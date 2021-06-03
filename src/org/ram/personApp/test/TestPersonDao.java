package org.ram.personApp.test;
import static org.junit.Assert.assertNotNull;

import javax.crypto.spec.PBEParameterSpec;

import org.junit.Before;
import org.junit.Test;
import org.ram.personApp.dao.PersonDao;
import org.ram.personApp.entity.Person;

public class TestPersonDao 
{
	private PersonDao dao;
	private Person person;
	@Before
	public void setUp()
	{
		dao=new PersonDao();
		person=new Person();
	}
	
//	//test case for adding a person record
//	@Test
//	public void testAddNewPerson()
//	{
//		person.setName("Amrender");
//		person.setAge(25);
//		assertNotNull("Person is added sucessfully",dao.addNewPerson(person));
//	}
	
//	//test case for delete a person record by id
//	@Test
//	public void testDeletePersonById()
//	{
//		assertNotNull("Person record deleted by id",dao.deletePersonById(new Person(11)));
//	}
	
//	//test case for delete  person record by an age group
//	@Test
//	public void testDeleteAgeGroup()
//	{
//		assertNotNull(dao.deleteAgeGroup(new Person(26)));
//	}
	
	//test case for searching the person record by id
	@Test
	public void testSeacrhPerson()
	{
		assertNotNull(dao.seacrhPerson(new Person(3)));
	}
}