package com.mobile.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.store.dao.CustomerRepository;
import com.mobile.store.dto.Customer;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void addCustomeTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertNotNull(newCustomer);
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
	
	@Test
	public void deleteCustomerByIdTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
	
	
	@Test
	public void getCustomerByIdTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertNotNull(this.customerService.getCustomerById(newCustomer.getCustomerId()));
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
	
	@Test
	public void updateCustomerPhoneTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertNotNull(newCustomer);
		assertEquals("phone number update sucessfully.", this.customerService.updateCustomerPhone(newCustomer.getCustomerId(),"0987654321"));
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
	
	@Test
	public void updateCustomerAddressTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertNotNull(newCustomer);
		assertEquals("address update sucessfully.", this.customerService.updateCustomerAddress(newCustomer.getCustomerId(),"mumbai"));
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
	
	@Test
	public void changeCustomerPassword() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertNotNull(newCustomer);
		assertEquals("password update sucessfully", this.customerService.changeCustomerPassword(newCustomer.getCustomerId(),"123456", "123456789"));
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456789"));
	}
	
	@Test
	public void loginByIdTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertNotNull(this.customerService.loginById(newCustomer.getCustomerId(), "123456"));
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
	
	@Test
	public void getCustomerSpecificDetailsTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertNotNull(this.customerService.getCustomerSpecificDetails(newCustomer.getCustomerId()));
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
	
	
	@Test
	public void countCustomersTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertTrue((this.customerService.countCustomers()>0));
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
	
	@Test
	public void findAllCustomersTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertNotNull(this.customerService.findAllCustomers());
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}

	@Test
	public void findByCustomerEmailTest() throws CustomerException, CartItemException, ProductException {
		Customer customer = new Customer("qwert", "qwerty@gmail.com", "1234567890", "asdfghj","123456");
		this.customerService.addCustomer(customer);
		Customer newCustomer = this.customerService.findByCustomerEmail(customer.getCustomerEmail());
		assertNotNull(this.customerService.findByCustomerEmail(newCustomer.getCustomerEmail()));
		assertEquals("customer delete sucessfully.", this.customerService.deleteCustomerById(newCustomer.getCustomerId(), "123456"));
	}
}
