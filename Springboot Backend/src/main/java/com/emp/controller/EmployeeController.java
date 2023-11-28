package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.response.Response;
import com.emp.service.EmployeeService;

@RestController
@ControllerAdvice
@RequestMapping("/api")
@CrossOrigin(value="http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	@PostMapping("/save-employee")
	public Response saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/get-employee")
	public Response getEmployeeParam(@RequestParam Integer employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@GetMapping(value = "/employees")
	public Response getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@DeleteMapping("/delete-employee")
	public Response deleteEmployee(@RequestParam Integer employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

}
