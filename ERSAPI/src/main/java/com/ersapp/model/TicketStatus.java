package com.ersapp.model;

public class TicketStatus {

	private int statusId;
	private String statusName;
	
	public TicketStatus() {
		super();
	}

	public TicketStatus(int statusId, String statusName) {
		this();
		this.statusId = statusId;
		this.statusName = statusName;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "TicketStatus [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	
}
