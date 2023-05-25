package com.ass.CustomerDataManagement.dto;

import java.io.Serializable;

import com.ass.CustomerDataManagement.entity.BankAccount;
import com.ass.CustomerDataManagement.entity.Person;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class BankDTO implements Serializable {
	private Integer pId;
	private String name;
	private Long accountNumber;
	private Person person;
	
	public BankDTO(BankAccount bankAccount)
	{
		this.pId=bankAccount.getPId();
		this.name=bankAccount.getName();
		this.accountNumber=bankAccount.getAccountNumber();
		this.person=bankAccount.getPerson();
	}

}
