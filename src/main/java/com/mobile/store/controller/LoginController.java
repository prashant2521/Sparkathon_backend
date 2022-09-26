package com.mobile.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.store.dto.Login;
import com.mobile.store.exception.AdminException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;


	@PostMapping("login-customer")
	public String customerLogin(@RequestBody Login login) throws CustomerException {
		Integer loginId = login.getLoginId();
		String password = login.getPassword();
		return this.loginService.customerLogin(loginId, password);
	}
	
	@PostMapping("login-admin")
	public String adminLogin(@RequestBody Login login) throws AdminException {

		Integer adminId = login.getLoginId();
		String password = login.getPassword();
		return this.loginService.adminLogin(adminId, password);
	}

}
