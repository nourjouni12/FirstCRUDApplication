package com.example.MyCrudApplication.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull(message = "Name cannot be null")
	@Size(min = 2, message = "First Name must include 2 characters at least")
	private String name;
	
	@NotNull
	@Min(value = 18, message = "age must be more than 17 because our company is for adults")
	@Max(value = 50, message = "age must be less than 51 because our company is for adults")
	private int age;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
