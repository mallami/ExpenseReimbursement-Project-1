package com.ersapp.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.ersapp.model.AllTickets;
import com.ersapp.model.Employee;
import com.ersapp.model.ExpenseTicket;
import com.ersapp.model.ViewTicket;
import com.ersapp.service.ExpenseTicketService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TicketController {

	private static ExpenseTicketService expService = new ExpenseTicketService();
	
	final static Logger LOGGY = LogManager.getLogger(TicketController.class);
	
	private static int uId = 0, rId = 0;
	private static String uName = null;

	public static void createTicket(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		getSession(req, resp);
		
		if(req.getMethod().equals("POST") && uName != null) {
			
			ObjectMapper om = new ObjectMapper();
			byte[] attachment = null;
			int ticketStatus = 2;
			//ExpenseTicket ticket = om.readValue(req.getReader(), com.ersapp.model.ExpenseTicket.class);
			
			int expenseType = Integer.parseInt(req.getParameter("expenseType"));
			LocalDate expenseDate = LocalDate.parse(req.getParameter("expenseDate"));
			String expenseDescription = req.getParameter("expenseDescription");
			double expenseAmount = Double.parseDouble(req.getParameter("expenseAmount"));

			ExpenseTicket ticket = new ExpenseTicket(0, LocalDate.now(), expenseType, ticketStatus, expenseDate, expenseDescription, 
										expenseAmount, LocalDate.now(), attachment, LocalDate.now(), "", uId);
			
			expService.createTicket(ticket);
			
			resp.setStatus(201); 
			LOGGY.info(uName + " : Created New Expense Ticket");
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}		
		
	}

	public static void employeeTicketsView(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		getSession(req, resp);
		
		if(req.getMethod().equals("GET") && uName != null) {
			
			Set<AllTickets> exp = null;
			
			exp = expService.employeeTicketsView(uId);
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(exp));
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Viewed My Expense Tickets");
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}
	
	public static void managerTicketsView(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		getSession(req, resp);
		
		if(req.getMethod().equals("GET") && uName != null) {
			
			Set<AllTickets> exp = null;

			exp = expService.managerTicketsView(rId);
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(exp));
			
			resp.setStatus(200); 			
			LOGGY.info(uName + " : Viewed All Expense Tickets");
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}
	
	public static void statusTicketsView(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		getSession(req, resp);
		
		if(req.getMethod().equals("GET") && uName != null) {
			
			Set<AllTickets> exp = null;

			String statusName = req.getParameter("statusName");
			exp = expService.statusTicketsView(rId, statusName);
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(exp));
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Viewed All " + statusName + " Expense Tickets");
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}
	
	public static void getTicketById(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		getSession(req, resp);
		
		if(req.getMethod().equals("GET") && uName != null) {
			
			ViewTicket exp = null;
			
			int ticketId = Integer.parseInt(req.getParameter("ticketId"));
			exp = expService.getTicketById(ticketId);
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(exp));
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Viewed Expense Ticket# " + ticketId);
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}
	
	public static void updateTicket(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		getSession(req, resp);
		
		if(req.getMethod().equals("PUT") && uName != null) {
			
			ObjectMapper om = new ObjectMapper();
			
			ExpenseTicket ticket = om.readValue(req.getReader(), com.ersapp.model.ExpenseTicket.class);
			
			expService.updateTicket(ticket);
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Updated Expense Ticket# " + ticket.getTicketId());
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}
	
	public static void approveTicket(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		getSession(req, resp);
		
		if(req.getMethod().equals("PUT") && uName != null) {
						
			int ticketId = Integer.parseInt(req.getParameter("ticketId"));
			int statusId = Integer.parseInt(req.getParameter("statusId"));
			String comment = req.getParameter("comment");
			expService.approveTicket(ticketId, statusId, comment);
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Approved Expense Ticket# " + ticketId);
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}
	
	public static void submitTicket(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		getSession(req, resp);
		
		if(req.getMethod().equals("POST") && uName != null) {
			
			int ticketId = Integer.parseInt(req.getParameter("ticketId"));
			expService.submitTicket(ticketId);
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Submitted Expense Ticket# " + ticketId);
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}
	
	public static void deleteTicket(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		getSession(req, resp);
		
		if(req.getMethod().equals("DELETE") && uName != null) {
			
			int ticketId = Integer.parseInt(req.getParameter("ticketId"));
			expService.deleteTicket(ticketId);
			
			resp.setStatus(200); 
			LOGGY.info(uName + " : Deleted Expense Ticket# " + ticketId);
			
		} else {
			resp.setStatus(401);
			resp.sendRedirect("http://localhost:8080/ERSAPI/Login.html");
		}

	}

	public static void getSession(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Employee emp = (Employee) req.getSession().getAttribute("user");
		
		if(emp == null) {
			uId = 0;
			rId = 0;
			uName = null;
		} else {
			uId = emp.getEmployeeId();
			rId = emp.getRoleId();
			uName = emp.getFirstName() + " " + emp.getLastName();
		}

	}

}
