package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empRepository.EmployeeRepository;
import com.entities.Employee;

@RestController
@RequestMapping ("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/Employee")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee is created into database";
	}

}
