package com.ersapp.model;

public class ExpenseType {
	
	private int typeId;
	private String typeName;
	
	public ExpenseType() {
		super();
	}

	public ExpenseType(int typeId, String typeName) {
		this();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "ExpenseType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
