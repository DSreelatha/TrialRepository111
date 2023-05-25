package com.ass.CustomerDataManagement.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ass.CustomerDataManagement.entity.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Integer>{

	List<BankAccount>  getByName();
}
