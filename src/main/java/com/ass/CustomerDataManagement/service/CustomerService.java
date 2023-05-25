package com.ass.CustomerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ass.CustomerDataManagement.dto.CustomerDTO;
import com.ass.CustomerDataManagement.dto.ResponseStructure;
import com.ass.CustomerDataManagement.entity.Customer;
import com.ass.CustomerDataManagement.repository.CustomerDao;


@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	
//	public Customer saveCustomer(Customer customer) {
//		return dao.saveCustomer(customer);
//	}
	public ResponseStructure<Customer> saveCustomer(CustomerDTO dto) {
		Customer cus=new Customer(dto);
		
		Customer customer= dao.saveCustomer(cus);
		ResponseStructure<Customer> rs=new ResponseStructure<>();
		rs.setData(customer);
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Customer data save sucessfully");
		rs.setTimeStamp(LocalDateTime.now());
		return rs;
	}

//	public Customer updateCustomer(Customer customer) {
//		
//		return dao.saveCustomer(customer);
//	}
	
	public ResponseStructure<Customer> updateCustomer(Customer customer) {
		
		Customer cus=dao.saveCustomer(customer);
		ResponseStructure<Customer> rs=new ResponseStructure<>();
		rs.setData(cus);
		rs.setStatusCode(HttpStatus.ACCEPTED.value());
		rs.setTimeStamp(LocalDateTime.now());
		rs.setMessage(HttpStatus.ACCEPTED.name());		
		return rs;
	}
	
//	public List<Customer> getAllCustomerData()
//	{
//		return dao.getAllCustomerData();		
//	}
	public ResponseStructure<List<Customer>> getAllCustomerData()
	{
		List<Customer> list =dao.getAllCustomerData();
		ResponseStructure<List<Customer>> rs=new ResponseStructure<>();
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
	public Customer getCustomerDataById(int id)
	{
		return dao.getCustomerDataById(id);
		
	}
	public Customer deleteCustomerDataById(int id)
	{
		return dao.deleteCustomerDataById(id);
		
	}
	public List<Customer> getCustomerByName(String name)
	{
		return dao.getCustomerByName(name);
	}
	public List<Customer> validateCustomer(String name, String email)
	{
		return dao.validateCustomer(name, email);
	}

}
//same the method it will be used the save the data and update the data.