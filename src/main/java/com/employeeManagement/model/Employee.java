package com.employeeManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name Field Is Empty")
	private String name;
	private String employeeId;
	@NotBlank(message = "Designation Field Is Empty")
	private String designation;
	@Enumerated(EnumType.STRING)
	private AccessRole role;
	@NotBlank(message = "Departent Field Is Empty")
	private String department;
	@NotNull(message = "Mobile Field Is Empty")
	private Long mobile;
	@NotBlank(message = "Email Field Is Empty")
	private String email;
	@NotBlank(message = "Address Field Is Empty")
	private String address;
	@NotNull(message = "Pincode Field Is Empty")
	private int pincode;
	@NotNull(message = "Aadhaar Field Is Empty")
	private Long aadhaar;
	private Long accountNo;
	private String joinDate;
	@NotNull(message = "Salary Field Is Empty")
	private double salary;
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Long getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(Long aadhaar) {
		this.aadhaar = aadhaar;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public AccessRole getRole() {
		return role;
	}
	public void setRole(AccessRole role) {
		this.role = role;
	}
	
}
