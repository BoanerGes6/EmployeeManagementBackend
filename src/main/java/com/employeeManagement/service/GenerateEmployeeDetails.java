package com.employeeManagement.service;

import java.time.LocalDate;
import java.util.Random;

import com.employeeManagement.model.Employee;

public class GenerateEmployeeDetails {

	private Employee lastEmp;
	
	GenerateEmployeeDetails(Employee lastEmp) {
		this.lastEmp = lastEmp;
	}
	public String employeeID() {
		Long nextId = 1L;
		if (lastEmp != null) {
			nextId = lastEmp.getId() + 1;
		}
		String empCode = String.format("EMP%03d", nextId);
		return empCode;
	}
	
	public String joinDate() {
		
		LocalDate ld = LocalDate.now();
		return ld.toString();
	}
	
	// Auto-Generated password
	public String GenPassword() {
		
		int passwordLength = 6; 
		
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = capitalLetters.toLowerCase();
		String numbers = "0123456789";
		String specialChar = "!@#$%&*";
		
		String allChars = capitalLetters + smallLetters + numbers + specialChar;
		
		StringBuilder pswd = new StringBuilder();
		
		Random rand = new Random();
		
		pswd.append(capitalLetters.charAt(rand.nextInt(capitalLetters.length())));
		pswd.append(specialChar.charAt(rand.nextInt(specialChar.length())));
		
		for (int i = 0; i < passwordLength - 2; i++) {
			pswd.append(allChars.charAt(rand.nextInt(allChars.length())));
		}
		return pswd.toString();
	}
}
