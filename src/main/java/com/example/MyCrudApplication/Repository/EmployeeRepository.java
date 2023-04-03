package com.example.MyCrudApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MyCrudApplication.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
