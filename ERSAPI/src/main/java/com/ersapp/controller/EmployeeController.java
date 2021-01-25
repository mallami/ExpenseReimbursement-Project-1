package com.ersapp.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import com.ersapp.model.Employee;
import com.ersapp.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeController {
	
	final static Logger LOGGY = LogManager.getLogger(EmployeeController.class);
	
	private static EmployeeService empService = new EmployeeService();
	
	private static int uId = 0, rId = 0;
	private static String uName = null;

	public static void employeeLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getMethod().equals("POST")) {
			
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			Employee emp = empService.employeeLogin(username, password);
			
			if(emp != null && emp.getAccountStatus()) {	
				req.getSession().setAttribute("user", emp);
				uId = emp.getEmployeeId();
				rId = emp.getRoleId();
				uName = emp.getFirstName() + " " + emp.getLastName();
								
				resp.setStatus(200); 

				if(rId < 3) {
					RequestDispatcher redisp = req.getRequestDispatcher("/Manager.html");
					redisp.forward(req, resp);

				} else {
					RequestDispatcher redisp = req.getRequestDispatcher("/Employee.html");
					redisp.forward(req, resp);					
				}
				
				LOGGY.info(uName + " : Logged in");
								
			} else {
				resp.setStatus(401); 
				resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
			}
			
		} else {
			resp.setStatus(405);
		}

	}

	public static void employeeLogout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			LOGGY.info(uName + " : Logged out");
			resp.setStatus(200);

			req.getSession().invalidate();
			uId = 0;
			rId = 0;
			uName = null;
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");

	}

	public static void createEmployee(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getMethod().equals("POST") && uName != null) {
			
			ObjectMapper om = new ObjectMapper();			
			//Employee emp = om.readValue(req.getReader(), com.ersapp.model.Employee.class);
			
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			int roleId = Integer.parseInt(req.getParameter("roleId"));
			
			Employee emp = new Employee(0, firstName, lastName, phone, email, password, roleId, true);
			empService.createEmployee(emp);
			
			resp.setStatus(201); 
			LOGGY.info(uName + " : Added new employee - " + emp.getFirstName() + " " + emp.getLastName());
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}

	public static void getEmployeeById(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getMethod().equals("GET") && uName != null) {

			Employee emp = null;
			
			int employeeId = Integer.parseInt(req.getParameter("employeeId"));
			emp = empService.getEmployeeById(employeeId);
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(emp));
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Viewed employee " + emp.getFirstName() + " " + emp.getLastName());
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}

	public static void getAllEmployees(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getMethod().equals("GET") && uName != null) {

			Set<Employee> emp = null;
			
			emp = empService.getAllEmployees();
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(emp));
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Viewed All Employees");
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}

	public static void updateEmployee(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getMethod().equals("PUT") && uName != null) {
			
			ObjectMapper om = new ObjectMapper();
			
			Employee emp = om.readValue(req.getReader(), com.ersapp.model.Employee.class);
			
			empService.updateEmployee(emp);
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Updated employee " + emp.getFirstName() + " " + emp.getLastName());
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}
	
	public static void changePassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getMethod().equals("PUT") && uName != null) {
			
			ObjectMapper om = new ObjectMapper();
			String newPassword = req.getParameter("newPassword");
			
			empService.changePassword(uId, newPassword);
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Changed password");
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}

	public static void deleteEmployee(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getMethod().equals("DELETE") && uName != null) {
			
			int employeeId = Integer.parseInt(req.getParameter("employeeId"));
			empService.deleteEmployee(employeeId);
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Deleted employee " + empService.getEmployeeById(employeeId).getFirstName() + " " + empService.getEmployeeById(employeeId).getLastName());
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}

}
