package com.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employeeManagement.config.JwtUtil;
import com.employeeManagement.model.Employee;
import com.employeeManagement.model.EmployeeLogin;
import com.employeeManagement.repository.EmployeeRepository;

@Service
public class LoginService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public String login(EmployeeLogin empLogin) {
		
		Employee findEmployee = empRepo.findByEmployeeId(empLogin.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("No Employee Found"));
		
		boolean isMatch = encoder.matches(empLogin.getPassword(), findEmployee.getPassword());
		System.out.println(findEmployee.getEmployeeId());
		System.out.println(isMatch);
		
		if (isMatch && findEmployee != null) 
			return jwtUtil.generateToken(findEmployee.getEmployeeId());
			
		return "Invalid Credentials";
	}
}
