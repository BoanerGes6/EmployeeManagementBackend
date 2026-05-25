package com.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employeeManagement.model.Employee;
import com.employeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public ResponseEntity<Employee> addEmpoyee(Employee employee) {
		
		Employee lastEmployee = empRepo.findTopByOrderByIdDesc();
		
		GenerateEmployeeDetails genD = new GenerateEmployeeDetails(lastEmployee);
		employee.setEmployeeId(genD.employeeID());
		employee.setJoinDate(genD.joinDate());
		employee.setPassword(genD.GenPassword());
		
		Employee savedEmployee = empRepo.save(employee);
		
		return ResponseEntity.ok(savedEmployee);
	}
	
}
