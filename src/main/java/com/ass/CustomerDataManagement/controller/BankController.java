package com.ass.CustomerDataManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ass.CustomerDataManagement.dto.ResponseStructure;
import com.ass.CustomerDataManagement.entity.BankAccount;
import com.ass.CustomerDataManagement.entity.Person;
import com.ass.CustomerDataManagement.service.BankService;

@Controller
public class BankController {
@Autowired
private BankService service;
@GetMapping("/getByBankId")
public BankAccount getByBankId(int id)
{
	return service.findById(id);
}
@GetMapping("/getbybankname/{name}")
public ResponseStructure<List<BankAccount>> getByBankName(@PathVariable("name") String name) {
	return service.getByBankName(name);
}

}
