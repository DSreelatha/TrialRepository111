package com.ass.CustomerDataManagement.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.ass.CustomerDataManagement.entity.Customer;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CustomerDTO implements Serializable{
	
	private Integer id;
	
	private String name;
	
	private String email;
	
	public CustomerDTO(Customer customer)
	{
		this.id=customer.getId();
		this.name=customer.getName();
		this.email=customer.getEmail();
	}


}
