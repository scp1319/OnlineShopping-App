package com.lti.dto;

public class ChangeRetailerPasswordInfo {
private int retailerId;
	public int getRetailerId() {
	return retailerId;
}

public void setRetailerId(int retailerId) {
	this.retailerId = retailerId;
}

	private String password;
	private String newpassword;

	public ChangeRetailerPasswordInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
}
