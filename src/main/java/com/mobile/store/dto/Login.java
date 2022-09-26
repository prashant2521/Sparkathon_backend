package com.mobile.store.dto;

public class Login {

	private Integer loginId;

	private String password;

	public Login(Integer loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
