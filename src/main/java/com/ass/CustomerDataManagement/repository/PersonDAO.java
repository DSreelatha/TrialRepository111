package com.ass.CustomerDataManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.ass.CustomerDataManagement.dto.PersonDTO;
import com.ass.CustomerDataManagement.dto.ResponseStructure;
import com.ass.CustomerDataManagement.entity.BankAccount;
import com.ass.CustomerDataManagement.entity.Customer;
import com.ass.CustomerDataManagement.entity.Person;

@Repository
public class PersonDAO {
	@Autowired
	private PersonRepository repository;
	
	public Person savePerson(Person per)
	{
		return repository.save(per);
	}
//	public Person updatePerson(Person person)	
//	{
//		return repository.save(person);
//	}

	public List<Person> findAll() {
		return repository.findAll();
	}

	public List<Person> getByPersonName(String name){
		return repository.getByName(name);
	}

	public Person findById(int id) {
		PersonDTO dto = new PersonDTO();
		return repository.findById(id).orElse(new Person(dto));
	}
	public Person deleteById(int id)
	{
		return repository.getById(id);
	}

	
}
