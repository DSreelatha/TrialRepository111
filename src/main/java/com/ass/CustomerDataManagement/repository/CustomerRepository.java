package com.ass.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ass.CustomerDataManagement.dto.CustomerDTO;
import com.ass.CustomerDataManagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	List<Customer>findByName(String name);
	
	@Query("SELECT c From Customer c WHERE c.name=:name AND c.email=:email ")
	List<Customer> validateCustomer(@Param("name") String name,@Param("email") String email);

	
}
