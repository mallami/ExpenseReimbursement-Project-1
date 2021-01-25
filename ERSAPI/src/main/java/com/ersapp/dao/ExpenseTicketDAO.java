package com.ersapp.dao;

import java.util.Set;

import com.ersapp.model.AllTickets;
import com.ersapp.model.ExpenseTicket;
import com.ersapp.model.ViewTicket;

public interface ExpenseTicketDAO {
	
	public void createTicket(ExpenseTicket ticket);
	public Set<AllTickets> employeeTicketsView(Integer employeeId);
	public Set<AllTickets> managerTicketsView(Integer roleId);
	public Set<AllTickets> statusTicketsView(Integer roleId, String statusName);
	public ViewTicket getTicketById(Integer ticketId);
	public void updateTicket(ExpenseTicket ticket);
	public void approveTicket(Integer ticketId, Integer statusId, String resultComment);
	public void submitTicket(Integer ticketId);
	public void deleteTicket(Integer ticketId);

}
