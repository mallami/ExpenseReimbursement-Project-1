package com.ersapp.service;

import java.util.List;
import java.util.Set;

import com.ersapp.dao.ExpenseTicketDAO;
import com.ersapp.dao.ExpenseTicketDAOImpl;
import com.ersapp.model.AllTickets;
import com.ersapp.model.ExpenseTicket;
import com.ersapp.model.ViewTicket;

public class ExpenseTicketService {

	public void createTicket(ExpenseTicket ticket) {
		
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		expDao.createTicket(ticket);
		
	}
	
	public Set<AllTickets> employeeTicketsView(Integer employeeId) {

		Set<AllTickets> ticket = null;
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		ticket = expDao.employeeTicketsView(employeeId);
		
		return ticket;
		
	}
	
	public Set<AllTickets> managerTicketsView(Integer roleId) {
		
		Set<AllTickets> ticket = null;
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		ticket = expDao.managerTicketsView(roleId);
		
		return ticket;
		
	}
	
	public Set<AllTickets> statusTicketsView(Integer roleId, String statusName) {
		
		Set<AllTickets> ticket = null;
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		ticket = expDao.statusTicketsView(roleId, statusName);
		
		return ticket;
		
	}

	public ViewTicket getTicketById(Integer ticketId) {
		
		ViewTicket ticket = null;
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		ticket = expDao.getTicketById(ticketId);
		
		return ticket;

	}
	
	public void updateTicket(ExpenseTicket ticket) {
		
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		expDao.updateTicket(ticket);

	}
	
	public void approveTicket(Integer ticketId, Integer statusId, String resultComment) {
		
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		expDao.approveTicket(ticketId, statusId, resultComment);

	}
	
	public void submitTicket(Integer ticketId) {
		
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		expDao.submitTicket(ticketId);

	}
	
	public void deleteTicket(Integer ticketId) {
		
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		expDao.deleteTicket(ticketId);

	}

}
