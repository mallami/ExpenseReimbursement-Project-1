package com.ersapp.controller;

import com.ersapp.util.ConnectionFactory;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ERSRequestHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String endpoint = req.getRequestURI();

		
/************************************************  LOGIN  *********************************************************/		
		if(endpoint.equals("/ERSAPI/api/login")) {
			
			switch(req.getMethod()) {
				case "POST":
					EmployeeController.employeeLogin(req, resp);
					break;
				case "PUT":
					EmployeeController.changePassword(req, resp);
					break;
				default: resp.setStatus(405);
			}
		} 

		
/************************************************  LOGOUT  *********************************************************/		
		if(endpoint.equals("/ERSAPI/api/logout")) {
			EmployeeController.employeeLogout(req, resp);			
		}

		if(endpoint.equals("/ERSAPI/api/session") && req.getMethod().equals("GET")) {
			TicketController.getSession(req, resp);			
		}
		
/************************************************  Employee - Add/View All Tickets  *********************************/		
		if(endpoint.equals("/ERSAPI/api/employee/ticket")) {
			switch(req.getMethod()) {
				case "POST":
					TicketController.createTicket(req, resp);
					break;
				case "GET":
					TicketController.employeeTicketsView(req, resp);
					break;
				case "PUT":
					TicketController.updateTicket(req, resp);
					break;
				default: resp.setStatus(405);
			}
		} else if(endpoint.equals("/ERSAPI/api/employee/ticket")) {
			resp.setStatus(405);
		}

		
/************************************************  Employee - Submit Ticket  *****************************************/		
		if(endpoint.equals("/ERSAPI/api/employee/ticketsubmit") && req.getMethod().equals("POST")) {
			TicketController.submitTicket(req, resp);
		} else if(endpoint.equals("/ERSAPI/api/employee/ticketsubmit")) {
			resp.setStatus(405);
		}
		
		
/************************************************  Employee/Manager - View Ticket  ***********************************/		
		if(endpoint.equals("/ERSAPI/api/ticket") && req.getMethod().equals("GET")) {
			TicketController.getTicketById(req, resp);
		} else if(endpoint.equals("/ERSAPI/api/ticket")) {
			resp.setStatus(405);
		}

		
/************************************************  Manager - Add/View Employee  **************************************/		
		if(endpoint.equals("/ERSAPI/api/manager/employee")) {
			switch(req.getMethod()) {
				case "POST":
					EmployeeController.createEmployee(req, resp);
					break;
				case "GET":
					EmployeeController.getEmployeeById(req, resp);
					break;
				case "PUT":
					EmployeeController.updateEmployee(req, resp);
					break;
				case "DELETE":
					EmployeeController.deleteEmployee(req, resp);
					break;
				default: resp.setStatus(405);
			}
		}
		

/************************************************  Manager - View All/Delete Ticket  **************************************/		
		if(endpoint.equals("/ERSAPI/api/manager/ticket")) {
			switch(req.getMethod()) {
				case "POST":
					TicketController.createTicket(req, resp);
					break;
				case "GET":
					TicketController.managerTicketsView(req, resp);
					break;
				case "DELETE":
					TicketController.deleteTicket(req, resp);
					break;
				default: resp.setStatus(405);
			}
		}

		
/************************************************  Manager - View Tickets Ordered by Status  ********************************/		
		if(endpoint.equals("/ERSAPI/api/manager/ticketstatus") && req.getMethod().equals("GET")) {
			TicketController.statusTicketsView(req, resp);
		} else if(endpoint.equals("/ERSAPI/api/manager/ticketstatus")) {
			resp.setStatus(405);
		}
		

/************************************************  Manager - Approve/Reject Ticket  *****************************************/		
		if(endpoint.equals("/ERSAPI/api/manager/ticketapprove") && req.getMethod().equals("PUT")) {
			TicketController.approveTicket(req, resp);
		} else if(endpoint.equals("/ERSAPI/api/manager/ticketapprove")) {
			resp.setStatus(405);
		}

		
/************************************************  Manager - View All Employees  *****************************************/		
		if(endpoint.equals("/ERSAPI/api/manager/allemployees") && req.getMethod().equals("GET")) {
			EmployeeController.getAllEmployees(req, resp);
		} else if(endpoint.equals("/ERSAPI/api/manager/allemployees")) {
			resp.setStatus(405);
		}

	}

}
