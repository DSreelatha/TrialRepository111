package com.ass.CustomerDataManagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ass.CustomerDataManagement.dto.ResponseStructure;
import com.ass.CustomerDataManagement.entity.BankAccount;
import com.ass.CustomerDataManagement.entity.Person;
import com.ass.CustomerDataManagement.repository.BankDAO;

@Service
public class BankService {
	@Autowired
	private BankDAO dao;

	public BankAccount findById(int id) {
		BankAccount  bank=dao.findById(id);
		ResponseStructure<Object> rsp = new ResponseStructure<>();
		if(bank.getPId()!=404)
		{
			rsp.setData(bank);
			rsp.setStatusCode(HttpStatus.FOUND.value());
			rsp.setTimeStamp(LocalDateTime.now());
			rsp.setMessage("Customer entry found in database");
			
		}
		else
		{
			rsp.setData(bank);
			rsp.setStatusCode(HttpStatus.NOT_FOUND.value());
			rsp.setTimeStamp(LocalDateTime.now());
			rsp.setMessage("Customer entry not found in database");			
		}
		return bank;
				
	}
	public ResponseStructure<List<BankAccount>> getByBankName(String name)
	{
		List<BankAccount> list = dao.getByBankName(name);
		ResponseStructure<List<BankAccount>>  rs = new ResponseStructure<>();
		rs.setData(list);
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setTimeStamp(LocalDateTime.now());
		rs.setMessage("successfully get the name from Bank");
		return rs;
	}
	

}
