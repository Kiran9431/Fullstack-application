package com.emp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "empd")
	private Long empd;
	@Column(name= "employee_name")
	private String employeeName;
	@Column(name = "age")
	private int age;
	@Column(name = "designation")
	private String designation;
	@Column(name = "role")
	private String role;

	public Long getEmpd() {
		return empd;
	}

	public void setEmpd(Long empd) {
		this.empd = empd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	@Override
	public String toString() {
		return "Employee [empd=" + empd + ", employeeName=" + employeeName + ", age=" + age + ", designation="
				+ designation + ", role=" + role + "]";
	}
}
