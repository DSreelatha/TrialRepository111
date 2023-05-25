package com.ass.CustomerDataManagement.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ass.CustomerDataManagement.entity.BankAccount;

@Repository
public class BankDAO {
	@Autowired
	private BankRepository repository;

	public BankAccount findById(int id) {
		
		return repository.getById(id);
	}
	public List<BankAccount> getByBankName(String name) {
		return repository.getByName();
	}
}


