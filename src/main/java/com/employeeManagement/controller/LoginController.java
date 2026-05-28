package com.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.model.EmployeeLogin;
import com.employeeManagement.service.LoginService;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/employeeLogin")
	public String employeeLogin(@RequestBody EmployeeLogin empLogin) {
		
		return loginService.login(empLogin);
	}
	
}
