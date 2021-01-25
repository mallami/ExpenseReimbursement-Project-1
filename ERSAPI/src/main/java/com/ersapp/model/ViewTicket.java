package com.ersapp.model;

import java.time.LocalDate;
import java.util.Arrays;

public class ViewTicket {
	
	private int ticketId;
	private LocalDate ticketDate;
	private int expenseType;
	private int ticketStatus;
	private LocalDate expenseDate;
	private String expenseDescription;
	private double expenseAmount;
	private LocalDate submitDate;
	private byte[] attachment;
	private LocalDate resultDate;
	private String resultComment;
	private int requesterId;
	
	private String firstName;
	private String lastName;
	private String expenseTypeName;
	private String statusName;
	
	public ViewTicket() {
		super();
	}

	public ViewTicket(int ticketId, LocalDate ticketDate, int expenseType, int ticketStatus, LocalDate expenseDate,
			String expenseDescription, double expenseAmount, LocalDate submitDate, byte[] attachment,
			LocalDate resultDate, String resultComment, int requesterId, String firstName, String lastName,
			String expenseTypeName, String statusName) {
		this();
		this.ticketId = ticketId;
		this.ticketDate = ticketDate;
		this.expenseType = expenseType;
		this.ticketStatus = ticketStatus;
		this.expenseDate = expenseDate;
		this.expenseDescription = expenseDescription;
		this.expenseAmount = expenseAmount;
		this.submitDate = submitDate;
		this.attachment = attachment;
		this.resultDate = resultDate;
		this.resultComment = resultComment;
		this.requesterId = requesterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.expenseTypeName = expenseTypeName;
		this.statusName = statusName;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public LocalDate getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(LocalDate ticketDate) {
		this.ticketDate = ticketDate;
	}

	public int getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(int expenseType) {
		this.expenseType = expenseType;
	}

	public int getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public LocalDate getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(LocalDate expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
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

	@Override
	public String toString() {
		return "ViewTicket [ticketId=" + ticketId + ", ticketDate=" + ticketDate + ", expenseType=" + expenseType
				+ ", ticketStatus=" + ticketStatus + ", expenseDate=" + expenseDate + ", expenseDescription="
				+ expenseDescription + ", expenseAmount=" + expenseAmount + ", submitDate=" + submitDate
				+ ", attachment=" + Arrays.toString(attachment) + ", resultDate=" + resultDate + ", resultComment="
				+ resultComment + ", requesterId=" + requesterId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", expenseTypeName=" + expenseTypeName + ", statusName=" + statusName + "]";
	}

}
