package com.ass.CustomerDataManagement.dto;

import java.time.LocalDateTime;

import com.ass.CustomerDataManagement.entity.Person;

import lombok.Data;

@Data
public class ResponseStructure<T>{
	
	private Integer statusCode;
	
	private T data;
	
	private String message;
	
	private LocalDateTime timeStamp;

	
}