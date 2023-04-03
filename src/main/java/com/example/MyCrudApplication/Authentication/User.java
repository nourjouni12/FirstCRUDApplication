package com.example.MyCrudApplication.Authentication;



import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
@DiscriminatorValue("Users")
public class User{
	
	@Id
	@GeneratedValue
	@Column
	private int UserId;
	
	@Column(name="UserName",nullable=false,unique=true)
	private String UserName;
	
	@Column(name="Password",nullable=false)
	private String Password;
	
	@Column(name="FirstName",nullable=false)
	private String FirstName;
	
	@Column(name="LastName",nullable=false)
	private String LastName;
	
	@jakarta.validation.constraints.Email
	@Column(name="Email",nullable=false,unique=true)
	private String Email;
	

	public User(String userName, String password, String firstName, String lastName, String email) {
		super();
		this.UserName = userName;
		this.Password = password;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
}
