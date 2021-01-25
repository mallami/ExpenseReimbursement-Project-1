package com.ersapp.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ersapp.service.EmployeeService;
import com.ersapp.service.ExpenseTicketService;

public class JUnitTest {
	
	static EmployeeService eService;
	static ExpenseTicketService tService;
	
	@BeforeClass
	public static void setUpToSetUp() {
		eService = new EmployeeService();		
		tService = new ExpenseTicketService();		
	}
	
	@Before
	public void setup() {
		eService = new EmployeeService();		
		tService = new ExpenseTicketService();		
	}
	
	@After
	public void reset() {
		eService = new EmployeeService();		
		tService = new ExpenseTicketService();		
	}
	
	@AfterClass
	public static void allDone() {
		eService = new EmployeeService();		
		tService = new ExpenseTicketService();		
	}
	
	@Test
	public void getEmployeeById() {
		
		eService.getEmployeeById(101);
		
		assertNotNull(eService.getEmployeeById(104));
	}

	@Test
	public void getAllEmployees() {
		
		eService.getAllEmployees();
		
		assertNotNull(eService.getAllEmployees());
		
	}

	@Test
	public void employeeLogin() {
		
		eService.employeeLogin("mail1@company.com", "1111");
		
		assertNotNull(eService.employeeLogin("mail1@company.com", "1111"));
	
	}

	@Test
	public void changePassword() {
		
		eService.changePassword(202, "1234");
		
		eService.changePassword(202, "2222");
		
	}
	
	@Test
	public void employeeTicketsView() {
		
		tService.employeeTicketsView(104);
		
		assertNotNull(tService.employeeTicketsView(105));
		
	}

	@Test
	public void managerTicketsView() {
		
		tService.managerTicketsView(2);
		
		assertNotNull(tService.managerTicketsView(1));
		
	}

	@Test
	public void statusTicketsView() {
		
		tService.statusTicketsView(1, "Submitted");
		
		assertNotNull(tService.statusTicketsView(2, "Approved"));
		
	}
	
	@Test
	public void approveTicket() {
		
		tService.approveTicket(2401, 4, "TEST");
		
		tService.approveTicket(2401, 3, "");
		
	}

	@Test
	public void submitTicket() {
		
		tService.submitTicket(2401);
		
		tService.submitTicket(2403);
		
	}

}
