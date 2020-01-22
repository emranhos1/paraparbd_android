package com.eh.paraparbd.model;

public class LoginTable {

	private int loginTableId;
	private int allUserId;
	private String phoneNo;
	private String password;

	public int getLoginTableId() {
		return loginTableId;
	}

	public void setLoginTableId(int loginTableId) {
		this.loginTableId = loginTableId;
	}

	public int getAllUserId() {
		return allUserId;
	}

	public void setAllUserId(int allUserId) {
		this.allUserId = allUserId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
