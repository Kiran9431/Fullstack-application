package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmployeeManagement {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagement.class, args);
		System.out.println("EMS Application Started Successfully!!!!!");
	}

}
