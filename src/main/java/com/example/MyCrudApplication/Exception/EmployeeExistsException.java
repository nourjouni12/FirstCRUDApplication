package com.example.MyCrudApplication.Exception;

public class EmployeeExistsException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public EmployeeExistsException() {
	}
	
	public EmployeeExistsException(String message) {
		super(message); // it can be treated in getMessage()
		this.message=message;
	}
}
