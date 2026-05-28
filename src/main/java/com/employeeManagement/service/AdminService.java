package com.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.employeeManagement.model.Employee;
import com.employeeManagement.repository.EmployeeRepository;

@Service
public class AdminService {

	@Autowired
	private EmployeeRepository empRepo;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public ResponseEntity<Employee> addEmpoyee(Employee employee) {
		
		Employee lastEmployee = empRepo.findTopByOrderByIdDesc();
		
		GenerateEmployeeDetails genD = new GenerateEmployeeDetails(lastEmployee);
		employee.setEmployeeId(genD.employeeID());
		employee.setJoinDate(genD.joinDate());
		String pswd = genD.GenPassword();
		System.out.println(pswd.toString());
		
		String encryptedPswd = encoder.encode(pswd);
		employee.setPassword(encryptedPswd);
		
		Employee savedEmployee = empRepo.save(employee);
		
		return ResponseEntity.ok(savedEmployee);
	}
	
}
