package com.ass.CustomerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ass.CustomerDataManagement.dto.PersonDTO;
import com.ass.CustomerDataManagement.dto.ResponseStructure;
import com.ass.CustomerDataManagement.entity.BankAccount;
import com.ass.CustomerDataManagement.entity.Person;
import com.ass.CustomerDataManagement.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService service;
	@PostMapping("/person")
	public @ResponseBody ResponseStructure<Person> save(@RequestBody PersonDTO  dto)
	{
		return service.savePerson(dto);
	}
//	@PostMapping("/update")
//	public Person update(@RequestBody Person person)
//	{
//		return service.updatePerson(person);
//	}
	@PostMapping("/update")
	public Person update(@RequestBody Person person)
	{
		return service.updatePerson(person);
	}
//	@GetMapping("/getall")
//	public List<Person> getAllPersonDetails()
//	{
//		return service.findAll();
//	}
	@GetMapping("/getallp")
	public ResponseStructure<List<Person>> getAllPersonDetails()
	{
		return service.findAll();		
	}
	@GetMapping("/getByName")
	public ResponseStructure<List<Person>> getByPersonName(@RequestParam("name")   String name)
	{
		return service.getByPersonName(name);
		
	}
	@GetMapping("/getByPersonId")
	
	public ResponseStructure<Person> getByPersonId(@RequestParam("id")  int id)
	{
		return service.findById(id);
	}
	@DeleteMapping("/deleteByIdP")
	public Person deletePersonById(int id)
	{
		return service.deletePersonById(id);
	}  

}
