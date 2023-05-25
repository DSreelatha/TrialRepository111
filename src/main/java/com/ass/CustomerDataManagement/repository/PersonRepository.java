package com.ass.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ass.CustomerDataManagement.dto.PersonDTO;
import com.ass.CustomerDataManagement.dto.ResponseStructure;
import com.ass.CustomerDataManagement.entity.BankAccount;
import com.ass.CustomerDataManagement.entity.Person;
@Repository
public interface PersonRepository  extends JpaRepository<Person, Integer>{

	List<Person> getByName(String name);
	
}
