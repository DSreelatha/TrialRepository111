package com.ass.CustomerDataManagement.dto;

import java.io.Serializable;
import java.util.List;

import com.ass.CustomerDataManagement.entity.BankAccount;
import com.ass.CustomerDataManagement.entity.Person;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDTO implements Serializable{
	private Integer id;
	private String name;
	private String email;
	private List<BankAccount> accounts;
	public PersonDTO(Person person)
	{
		this.id=person.getId();
		this.name=person.getName();
		this.email=person.getEmail();
		this.accounts=person.getAccounts();
	}

}
