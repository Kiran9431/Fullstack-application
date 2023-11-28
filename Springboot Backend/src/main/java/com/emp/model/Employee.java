package com.emp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empd;
	@Column(columnDefinition = "VARCHAR(50)")
	private String employeeName;
	@Column(columnDefinition = "INT")
	private double age;
	@Column(columnDefinition = "VARCHAR(50)")
	private String designation;
	@Column(columnDefinition = "VARCHAR(50)")
	private String role;

	public String getEmployeeName() {
		return employeeName;
	}

	@Override
	public String toString() {
		return "Employee [empd=" + empd + ", employeeName=" + employeeName + ", age=" + age + ", designation="
				+ designation + ", role=" + role + "]";
	}
}
