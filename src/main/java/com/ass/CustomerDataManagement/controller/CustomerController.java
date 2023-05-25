package com.ass.CustomerDataManagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ass.CustomerDataManagement.dto.CustomerDTO;
import com.ass.CustomerDataManagement.dto.ResponseStructure;
import com.ass.CustomerDataManagement.entity.Customer;
import com.ass.CustomerDataManagement.service.CustomerService;
@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
//	@PostMapping(value="/save")//==>http://localhost:8080/save(post)
//	public @ResponseBody Customer saveCustomer(@RequestBody Customer customer) {
//		return service.saveCustomer(customer);
//	}
	@PostMapping(value="/save")//==>http://localhost:8080/save(post)
	public @ResponseBody ResponseStructure<Customer> saveCustomer(@RequestBody CustomerDTO dto) {
		return service.saveCustomer(dto);
	}
//	@PutMapping(value="/update")//==>http://localhost:8080/update(PUT)
//	public @ResponseBody Customer updateCustomer(@RequestBody Customer customer)
//	{
//		return service.updateCustomer(customer);		
//	}
	@PutMapping(value="/update")//==>http://localhost:8080/update(PUT)
	public @ResponseBody ResponseStructure<Customer> updateCustomer(@RequestBody Customer customer)
	{
		return service.updateCustomer(customer);		
	}
//	@GetMapping(value="/get")//==>http://localhost:8080/get(GET)
//	public List<Customer>  getAllCustomerData()
//	{
//		return service.getAllCustomerData();		
//	}
	@GetMapping(value="/get")//==>http://localhost:8080/get(GET)
	public ResponseStructure<List<Customer>>  getAllCustomerData()
	{
		return service.getAllCustomerData();		
	}
	@GetMapping("/getById/{id}")//url==>http://localhost:8080/getById/4(GET)
	public @ResponseBody Customer getCustomerDataById(@PathVariable("id") int id) {
		return service.getCustomerDataById(id);
	}
	@DeleteMapping("/deleteById")//url==>http://localhost:8080/deleteById(DELETE)
	public @ResponseBody Customer deleteCustomerDataById(@RequestParam("id")int id)
	{
		return service.deleteCustomerDataById(id);		
	}
	@GetMapping("/getByName/{name}")//url==>http://localhost:8080/getByName/Ammu(GET)
	public @ResponseBody List<Customer> getCustomerByName(@PathVariable("name") String name)
	{
		return service.getCustomerByName(name);		
	}
	@PostMapping("/validateCustomer")//url==>http://localhost:8080/validateCustomer(POST)
	public List<Customer> validateCustomer(@RequestParam("name")String name,@RequestParam("email") String email){
		return service.validateCustomer(name, email);
		
	}
}