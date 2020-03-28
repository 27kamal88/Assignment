package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Item {

	@Id
	private int id;
	@NotEmpty(message = "Name of item must not be empty")
	private String name;
	@NotEmpty(message = "Email must not be empty")
	private String email;
	@NotEmpty(message = "Enter Valid Description")
	private String description;
	
	
	public Item() {
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Item(int id, String name, String email, String description) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.description = description;
	}
	
	
}
