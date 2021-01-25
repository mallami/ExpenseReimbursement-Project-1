package com.ersapp.dao;

import java.util.Set;

import com.ersapp.model.Employee;

public interface EmployeeDAO {
	
	public void createEmployee(Employee employee);
	public Employee getEmployeeById(Integer employeeId);
	public Employee employeeLogin(String email, String password);
	public Set<Employee> getAllEmployees();
	public void updateEmployee(Employee employee);
	public void changePassword(Integer employeeId, String newPassword);
	public void deleteEmployee(Integer employeeId);

}
