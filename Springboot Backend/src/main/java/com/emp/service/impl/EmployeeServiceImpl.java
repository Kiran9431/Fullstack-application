package com.emp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.emp.constants.CommonConstants;
import com.emp.dao.EmployeeDao;
import com.emp.model.Employee;
import com.emp.response.Response;
import com.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public Response saveEmployee(Employee employee) {
		LOGGER.info("START");
		Response response = new Response();
		try {
			if (isEmployeeRequestInValid(response, employee)) {
				return response;
			}
			LOGGER.debug("Saving employee details: {}", employee);
			Optional<Employee> existingEmployee = employeeDao.findByEmployeeName(employee.getEmployeeName());

			if (existingEmployee.isPresent()) {
				response.setMessage("Employee already exists.");
			} else {
				Employee savedEmployeeDetails1 = employeeDao.save(employee);
				response.setData(savedEmployeeDetails1);
				response.setMessage(CommonConstants.Employee.SAVED_THE_EMPLOYEE_SUCCESS);
			}
			response.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error occurred while saving employee details.", e);
			response.setStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(CommonConstants.Employee.SAVED_THE_EMPLOYEE_FAILED);
			LOGGER.warn(CommonConstants.Employee.SAVED_THE_EMPLOYEE_FAILED);
			e.getLocalizedMessage();
		}
		LOGGER.info("end");
		return response;
	}

	private boolean isEmployeeRequestInValid(Response response, Employee employee) {
		return !isEmployeeRequestValid(response, employee);
	}

	private boolean isEmployeeRequestValid(Response response, Employee employee) {
		if (employee == null) {
			response.setMessage("Oops empty employee data");
			return false;
		} else if (employee.getEmployeeName() == null || employee.getEmployeeName().isEmpty()) {
			response.setMessage("Oops empty employee name");
			return false;
		}
		
		return true;
	}

	@Override
	public Response getEmployee(Integer employeeId) {
		LOGGER.info("Start");
		Response response = new Response();
		try {
			LOGGER.debug("Fetching employee details for employeeId: {}", employeeId);
			Optional<Employee> employee = employeeDao.findById(employeeId);
			if (employee.isPresent()) {
				response.setData(employee.get());
				response.setMessage(CommonConstants.Employee.EMPLOYEE_FOUND);
				response.setStatus(HttpStatus.OK);
				response.setMessage("Employee details found");
			} else {
				response.setMessage(CommonConstants.Employee.EMPLOYEE_NOT_FOUND + employeeId);
				LOGGER.warn(CommonConstants.Employee.EMPLOYEE_NOT_FOUND);
				response.setStatus(HttpStatus.NOT_FOUND);
			}
			response.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error occurred while retrieving Employee details.", e);
			response.setStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(CommonConstants.Employee.EMPLOYEE_FAILED);
			e.getLocalizedMessage();
		}
		LOGGER.info("end");
		return response;
	}

	@Override
	public Response getAllEmployees() {
		LOGGER.info("start");
		Response response = new Response();
		List<Employee> employeesList = new ArrayList<>();
		try {
			LOGGER.debug("Fetching all Employee details");
			employeesList = employeeDao.findAll();

			if (!employeesList.isEmpty()) {
				response.setData(employeesList);
				response.setStatus(HttpStatus.OK);
				response.setMessage(CommonConstants.Employee.EMPLOYEE_LIST_FOUND);
			} else {
				response.setStatus(HttpStatus.EXPECTATION_FAILED);
				response.setMessage(CommonConstants.Employee.EMPLOYEE_LIST_NOT_FOUND);
				LOGGER.warn(CommonConstants.Employee.EMPLOYEE_LIST_NOT_FOUND);
			}

		} catch (Exception e) {
			LOGGER.error("Error occurred while retrieving all employee details.", e);
			response.setStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(CommonConstants.Employee.EMPLOYEE_FAILED);
			e.getLocalizedMessage();
		}
		LOGGER.info("end");
		return response;
	}

	@Override
	public Response deleteEmployee(Integer employeeId) {
		LOGGER.info("start");
		Response response = new Response();
		try {
			LOGGER.debug("Deleting employee with employeeId: {}", employeeId);
			Optional<Employee> employee = employeeDao.findById(employeeId);
			if (employee.isPresent()) {
				employeeDao.deleteById(employeeId);
				response.setMessage(CommonConstants.Employee.EMPLOYEE_DELETED);
			} else {
				LOGGER.warn(CommonConstants.Employee.EMPLOYEE_NOT_FOUND);
				response.setMessage(CommonConstants.Employee.EMPLOYEE_NOT_FOUND + employeeId);
			}

		} catch (Exception e) {
			LOGGER.error("Error occurred while deleting employee details.", e);
			response.setMessage(CommonConstants.Employee.UNABLE_TO_DELETE_EMPLOYEE);
			e.getLocalizedMessage();
		}
		LOGGER.info("end");
		return response;

	}
}
