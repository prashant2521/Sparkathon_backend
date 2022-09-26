package com.mobile.store.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private Integer adminId;
	private String adminName;
	private String adminPassword;
	
	public Admin() {
		super();
	}

	public Admin(Integer adminID, String adminName, String adminPassword) {
		super();
		this.adminId = adminID;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminID(Integer adminID) {
		this.adminId = adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	 @Override
	public String toString() {
		return "Admin [adminID=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}
	
	
}
