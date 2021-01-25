package com.ersapp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.ersapp.model.Employee;
import com.ersapp.util.ConnectionFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void createEmployee(Employee employee) {

		String sql = "INSERT INTO employee (first_name, last_name, phone, email, passwd, role_id, account_status) "
				+ "VALUES (?, ?, ?, ?, CRYPT(?, gen_salt('md5')), ?, ?)";
		
		try (Connection conn = ConnectionFactory.getConnection()) {
	
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPassword());
			ps.setInt(6, employee.getRoleId());
			ps.setBoolean(7, employee.getAccountStatus());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		
		Employee employee = null;
		
		String sql = "SELECT * FROM employee WHERE employee_id = ?";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.getInt("employee_id");
			
				employee = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("passwd"),
						rs.getInt("role_id"),
						rs.getBoolean("account_status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}

		return employee;
		
	}

	@Override
	public Employee employeeLogin(String email, String password) {
		
		Employee employee = null;
		
		String sql = "SELECT * FROM employee " 
					+ "WHERE email = ? AND passwd = CRYPT(?, passwd)";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rs.getInt("employee_id");
			
				employee = new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("passwd"),
						rs.getInt("role_id"),
						rs.getBoolean("account_status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}

		return employee;
		
	}

	@Override
	public Set<Employee> getAllEmployees() {
		
		Set<Employee> employees = new HashSet<>();
		
		String sql = "SELECT * FROM employee ORDER BY employee_id";
		
		try (Connection conn = ConnectionFactory.getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				employees.add(new Employee(
						rs.getInt("employee_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"),
						rs.getString("phone"),
						rs.getString("email"),
						rs.getString("passwd"),
						rs.getInt("role_id"),
						rs.getBoolean("account_status")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}

		return employees;
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE employee SET first_name = ?, last_name = ?, phone = ?, email = ?, "
						+ "passwd = CRYPT(?, gen_salt('md5')), role_id = ?, account_status = ? "
						+ "WHERE employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPassword());
			ps.setInt(6, employee.getRoleId());
			ps.setBoolean(7, employee.getAccountStatus());
			ps.setInt(8, employee.getEmployeeId());
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void changePassword(Integer employeeId, String newPassword) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "CALL change_password(?, ?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, employeeId);
			cs.setString(2, newPassword);
			
			cs.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "DELETE FROM employee WHERE employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeId);
			
			ps.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
