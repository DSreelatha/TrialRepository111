package com.ass.CustomerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ass.CustomerDataManagement.dto.CustomerDTO;
import com.ass.CustomerDataManagement.dto.PersonDTO;
import com.ass.CustomerDataManagement.dto.ResponseStructure;
import com.ass.CustomerDataManagement.entity.BankAccount;
import com.ass.CustomerDataManagement.entity.Customer;
import com.ass.CustomerDataManagement.entity.Person;
import com.ass.CustomerDataManagement.repository.PersonDAO;

@Service
public class PersonService {
	@Autowired
	private PersonDAO dao;
	
//	public Person savePerson(Person person)
//	{
//		return dao.save(person);
//	}
	public ResponseStructure<Person> savePerson(PersonDTO dto)
	{
		Person per = new Person(dto);
		Person person = dao.savePerson(per);
		ResponseStructure<Person> rsp=new ResponseStructure<>();
		rsp.setData(person);
		rsp.setStatusCode(HttpStatus.ACCEPTED.value());
		rsp.setTimeStamp(LocalDateTime.now());
		rsp.setMessage(HttpStatus.ACCEPTED.name());
		return rsp;
		
	}
//	public Person updatePerson(Person person)
//	{
//		return dao.save(person);		
//	}
	public Person updatePerson(Person person)
	{		
		
		Person son = dao.savePerson(person);
		ResponseStructure<Person> rsp=new ResponseStructure<>();
		rsp.setData(person);
		rsp.setStatusCode(HttpStatus.ACCEPTED.value());
		rsp.setTimeStamp(LocalDateTime.now());
		rsp.setMessage(HttpStatus.ACCEPTED.name());
		return son;
		
	}
//	public List<Person> findAll()
//	{
//		return dao.getAllPersonDetails();
//	}
	public ResponseStructure<List<Person>> findAll() {
		List<Person> list=dao.findAll();
		ResponseStructure<List<Person>> rs=new ResponseStructure<>();
		if(list.size()!=0)
		{
			rs.setStatusCode(HttpStatus.FOUND.value());
			rs.setData(list);
			rs.setTimeStamp(LocalDateTime.now());
			rs.setMessage("Customer entry found in database");
		}
		else
		{
			rs.setStatusCode(HttpStatus.NOT_FOUND.value());
			rs.setData(list);
			rs.setTimeStamp(LocalDateTime.now());
			rs.setMessage("No Customer entry found in database");
		}
		return rs;
	}
//	public Person getByPersonName(String name)
//	{
//		return dao.getByPersonName(name);
//		
//	}
	public ResponseStructure<List<Person>> getByPersonName(String name)
	{
		List<Person> son=dao.getByPersonName(name);
		ResponseStructure<List<Person>> rsp=new ResponseStructure<>();
		rsp.setData(son);
		rsp.setStatusCode(HttpStatus.ACCEPTED.value());
		rsp.setTimeStamp(LocalDateTime.now());
		rsp.setMessage(HttpStatus.ACCEPTED.name());
		return rsp;
	}
      public Person getByPersonId(int id)
	  {
		return dao.findById(id);
				
	}
	public ResponseStructure<Person> findById(int id) {
		Person son=dao.findById(id);
		ResponseStructure<Person> rsp=new ResponseStructure<>();
		if(son.getId()!=404)
		{
			rsp.setData(son);
			rsp.setStatusCode(HttpStatus.FOUND.value());
			rsp.setTimeStamp(LocalDateTime.now());
			rsp.setMessage("Customer entry found in database");
			
		}
		else
		{
			rsp.setData(son);
			rsp.setStatusCode(HttpStatus.NOT_FOUND.value());
			rsp.setTimeStamp(LocalDateTime.now());
			rsp.setMessage("Customer entry not found in database");			
		}
		
		return rsp;
	}
	public Person deletePersonById(int id) {
		Person son=dao.findById(id);
		ResponseStructure<Object> rsp = new ResponseStructure<>();
		if(son.getId()!=404)
		{
			rsp.setData(son);
			rsp.setStatusCode(HttpStatus.FOUND.value());
			rsp.setTimeStamp(LocalDateTime.now());
			rsp.setMessage("Customer entry found in database");
			
		}
		else
		{
			rsp.setData(son);
			rsp.setStatusCode(HttpStatus.NOT_FOUND.value());
			rsp.setTimeStamp(LocalDateTime.now());
			rsp.setMessage("Customer entry not found in database");			
		}
		
		return null;
	}
	
}
