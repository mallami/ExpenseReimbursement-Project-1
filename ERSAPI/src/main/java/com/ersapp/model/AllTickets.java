package com.ersapp.model;

import java.time.LocalDate;
import java.util.Arrays;

public class AllTickets {
	
	private int ticketId;
	private int requesterId;
	private String firstName;
	private String lastName;
	private int roleId;
	private String expenseTypeName;
	private String statusName;
	private double expenseAmount;
	private LocalDate ticketDate;
	private LocalDate submitDate;
	private byte[] attachment;
	private LocalDate resultDate;
	private String resultComment;
	private String expenseDescription;
	private LocalDate expenseDate;
	
	public AllTickets() {
		super();
	}

	public AllTickets(int ticketId, int requesterId, String firstName, String lastName, int roleId, String expenseTypeName,
			String statusName, double expenseAmount, LocalDate ticketDate, LocalDate submitDate, byte[] attachment, 
			LocalDate resultDate, String resultComment, String expenseDescription, LocalDate expenseDate) {
		this();
		this.ticketId = ticketId;
		this.requesterId = requesterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = roleId;
		this.expenseTypeName = expenseTypeName;
		this.statusName = statusName;
		this.expenseAmount = expenseAmount;
		this.ticketDate = ticketDate;
		this.submitDate = submitDate;
		this.attachment = attachment;
		this.resultDate= resultDate;
		this.resultComment = resultComment;
		this.expenseDescription = expenseDescription;
		this.setExpenseDate(expenseDate);
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getExpenseTypeName() {
		return expenseTypeName;
	}

	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public LocalDate getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(LocalDate ticketDate) {
		this.ticketDate = ticketDate;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public LocalDate getResultDate() {
		return resultDate;
	}

	public void setResultDate(LocalDate resultDate) {
		this.resultDate = resultDate;
	}

	public String getResultComment() {
		return resultComment;
	}

	public void setResultComment(String resultComment) {
		this.resultComment = resultComment;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}
	
}
