package com.emp.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.emp.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	Optional<Employee> findByEmployeeName(String employeeName);

}
