package com.ersapp.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Level;

import com.ersapp.controller.TicketController;
import com.ersapp.dao.EmployeeDAO;
import com.ersapp.dao.EmployeeDAOImpl;
import com.ersapp.model.Employee;

public class EmployeeService {

	public void createEmployee(Employee employee) {
		
		EmployeeDAO empDao = new EmployeeDAOImpl();
		empDao.createEmployee(employee);
		
	}

	public Employee getEmployeeById(Integer employeeId) {
		
		Employee emp = null;
		EmployeeDAO empDao = new EmployeeDAOImpl();
		emp = empDao.getEmployeeById(employeeId);
		
		return emp;
		
	}
	
	public Employee employeeLogin(String email, String password) {
		
		Employee emp = null;
		EmployeeDAO empDao = new EmployeeDAOImpl();
		emp = empDao.employeeLogin(email, password);
		
		return emp;
		
	}
	
	public Set<Employee> getAllEmployees() {
		
		Set<Employee> emp = null;
		EmployeeDAO empDao = new EmployeeDAOImpl();
		emp = empDao.getAllEmployees();
		
		return emp;
		
	}
	
	public void updateEmployee(Employee employee) {
		
		EmployeeDAO empDao = new EmployeeDAOImpl();
		empDao.updateEmployee(employee);
		
	}
	
	public void changePassword(Integer employeeId, String newPassword) {
		
		EmployeeDAO empDao = new EmployeeDAOImpl();
		empDao.changePassword(employeeId, newPassword);
		
	}
	
	public void deleteEmployee(Integer employeeId) {
		
		EmployeeDAO empDao = new EmployeeDAOImpl();
		empDao.deleteEmployee(employeeId);
		
	}

}
