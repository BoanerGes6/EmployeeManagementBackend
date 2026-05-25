package com.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.model.Employee;
import com.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee employee) {
		
		return empService.addEmpoyee(employee);
	}
	
}
