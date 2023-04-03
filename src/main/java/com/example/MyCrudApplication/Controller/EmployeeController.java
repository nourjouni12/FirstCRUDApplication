package com.example.MyCrudApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyCrudApplication.Entity.Employee;
import com.example.MyCrudApplication.Exception.EmployeeExistsException;
import com.example.MyCrudApplication.Exception.ErrorResponse;
import com.example.MyCrudApplication.Service.EmployeeServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	EmployeeServices employeeServices;
	
	@PostMapping //used for inserting
	public String addEmployee(@Valid @RequestBody Employee employee) {
			return employeeServices.SaveEmployee(employee);
	}
	
	@GetMapping(path="/{id}")
	public Employee getEmployee(@PathVariable int id) { //take the passed field from path "/employees/8" for example it takes 8
		return employeeServices.getEmployee(id);
	}
	
	@PutMapping() // used for updating
	public Employee updateEmployee(@RequestBody Employee employee) { // we will give new employee info in body "with old id"
		return employeeServices.updateEmployee(employee);
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeServices.deleteEmployee(id);
	}

	@GetMapping(path="/all")
	public List<Employee> getAllEmployees(){
		return employeeServices.getAll();
	}
	
	@ExceptionHandler(value= EmployeeExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleCustomerAlreadyExistsException(EmployeeExistsException ex)
	{
		return new ErrorResponse(HttpStatus.CONFLICT.value(),ex.getMessage());
	}
	
	public EmployeeServices getEmployeeServices() {
		return employeeServices;
	}

	public void setEmployeeServices(EmployeeServices employeeServices) {
		this.employeeServices = employeeServices;
	}
}
