package com.example.demo.model;


import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.ObjectUtils;


@Document(collection = "People")
public class Person {
	
	@Id
	private UUID id;
	private String name;
	private String email;
	private String phone;
	
	

		
	public Person(UUID id, String name, String email, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() { 
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	

	
	

}
