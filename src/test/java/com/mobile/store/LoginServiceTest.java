package com.mobile.store;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.security.auth.login.LoginException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.store.dto.Admin;
import com.mobile.store.dto.Customer;
import com.mobile.store.exception.AdminException;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.service.AdminService;
import com.mobile.store.service.CustomerService;
import com.mobile.store.service.LoginService;

@SpringBootTest
public class LoginServiceTest {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AdminService adminService;
	
	@Test
	public void customerLoginTest() throws LoginException, CustomerException, CartItemException, ProductException{
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertEquals("login sucessfully", this.loginService.customerLogin(newCustomer.getCustomerId(), "123456"));
		
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
	
	@Test
	public void adminLoginTest() throws LoginException, AdminException{
		Admin admin = new Admin(100,"saad","123456");
		assertNotNull(this.adminService.registerAdmin(admin));
		assertEquals("login sucessfully", this.loginService.adminLogin(100, "123456"));
		
		assertEquals("Successful", this.adminService.deleteAdmin(100, "123456"));
	}

}
