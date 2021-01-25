package com.ersapp.model;

public class EmployeeRole {
	
	private int roleId;
	private String roleName;
	
	public EmployeeRole() {
		super();
	}

	public EmployeeRole(int roleId, String roleName) {
		this();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "EmployeeRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
}
