package com.example.MyCrudApplication.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.MyCrudApplication.Entity.Employee;
import com.example.MyCrudApplication.Exception.EmployeeExistsException;

import com.example.MyCrudApplication.Repository.EmployeeRepository;

@Service
public class EmployeeServices {
	
	@Autowired
	public EmployeeRepository employeeRepository;
	
	public String SaveEmployee(Employee employee) {
		boolean present=false;
		List<Employee> employees = getAll();
		for(int i=0;i<employees.size();i++) {
			if(((employees.get(i).getName()).equals(employee.getName())) && ((employees.get(i).getAge())==(employee.getAge()))){
				present=true;
			}
		}
		if(present==false) {
			employeeRepository.save(employee);
			return "Added Successfully" ;
		}
		throw new EmployeeExistsException("Employee already Exists ! ");
	}
	
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No Costumer with id : " + id));
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee emp = employeeRepository.findById(employee.getId()).orElse(null);
		if(emp == null) {
			throw new NoSuchElementException("There is no Employee with this id : "+employee.getId()+" to update !");
		}
		else {
		emp.setAge(employee.getAge());
		emp.setName(employee.getName());
		return employeeRepository.save(emp);
		}
	}

	
	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return "Entity deleted " + id;
	    
	}
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	
	
	
	
}
