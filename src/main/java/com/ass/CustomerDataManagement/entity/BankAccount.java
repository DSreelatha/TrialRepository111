package com.ass.CustomerDataManagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ass.CustomerDataManagement.dto.BankDTO;

import lombok.Data;

@Entity
@Data
public class BankAccount implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="p_id")
	private Integer pId;
	private String name;
	@Column(name="account_number")

	private Long accountNumber;
	@ManyToOne
	@JoinColumn
	private Person person;
	public BankAccount(BankDTO dto)
	{
		this.pId=dto.getPId();
		this.name=dto.getName();
		this.accountNumber=dto.getAccountNumber();
		this.person=dto.getPerson();
	}
	
}
