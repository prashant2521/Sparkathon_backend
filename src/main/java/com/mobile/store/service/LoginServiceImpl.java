package com.mobile.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.store.dto.Login;
import com.mobile.store.exception.AdminException;
import com.mobile.store.exception.CustomerException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	AdminService adminService;

	
	@Override
	public String customerLogin(Integer loginId, String password) throws CustomerException {
		this.customerService.loginById(loginId, password);
		return "login sucessfully";
	}
	
	@Override
	public String adminLogin(Integer adminId, String password) throws AdminException {
		
		this.adminService.login(adminId, password);
		return "login sucessfully";
	}

}
