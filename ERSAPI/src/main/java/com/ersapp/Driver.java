package com.ersapp;

import java.time.LocalDate;

import com.ersapp.dao.EmployeeDAO;
import com.ersapp.dao.EmployeeDAOImpl;
import com.ersapp.dao.ExpenseTicketDAO;
import com.ersapp.dao.ExpenseTicketDAOImpl;
import com.ersapp.model.ExpenseTicket;
import com.ersapp.service.EmployeeService;
import com.ersapp.service.ExpenseTicketService;

public class Driver {

	public static void main(String[] args) {
		
		//Employee emp = new Employee(104, "Michael", "Paul", "123456", "mail3@company.com", "3333", 3, true);

		EmployeeDAO empDao = new EmployeeDAOImpl();
		
		//empDao.createEmployee(emp);
		//empDao.updateEmployee(emp);
		//System.out.println(empDao.getEmployeeById(101));
		//System.out.println(empDao.getAllEmployees());
		//System.out.println(empDao.employeeLogin("mail2@company.com", "2222"));
		//empDao.changePassword(102, "2222");

		
		//ExpenseTicket ticket = new ExpenseTicket(2404, LocalDate.parse("2020-12-30"), 1, 1, LocalDate.parse("2020-12-15"), "", 162.5, LocalDate.parse("2020-12-30"), null, LocalDate.parse("2020-12-30"), "", 104);
		
		ExpenseTicketDAO expDao = new ExpenseTicketDAOImpl();
		
		//expDao.createTicket(ticket);
		//expDao.updateTicket(ticket);
		//System.out.println(expDao.getTicketById(2402));
		//System.out.println(expDao.managerTicketsView(2));
		//System.out.println(expDao.statusTicketsView(2, "Submitted"));
		//System.out.println(expDao.employeeTicketsView(101));
		//expDao.approveTicket(2401, 3, "");
		//expDao.submitTicket(2402);
		
		EmployeeService es = new EmployeeService();
		
		//es.createEmployee(emp);
		//es.updateEmployee(emp);
		//System.out.println(es.getEmployeeById(104));
		//System.out.println(es.getAllEmployees());
		//System.out.println(es.employeeLogin("mail3@company.com", "3333"));
		//es.changePassword(104, "3333");
		
		ExpenseTicketService ets = new ExpenseTicketService();
		
		//ets.createTicket(ticket);
		//ets.updateTicket(ticket);
		//System.out.println(ets.getTicketById(2404));
		//System.out.println(ets.managerTicketsView(2));
		//System.out.println(ets.statusTicketsView(2, "Approved"));
		//System.out.println(ets.employeeTicketsView(104));
		//ets.submitTicket(2404);
		//ets.approveTicket(2404, 3, "");

	}

}
