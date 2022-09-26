package com.mobile.store.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.store.dto.Customer;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
   	
	@PostMapping(value = "customer",consumes = {"application/xml","application/json"})
	public String addCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
		return this.customerService.addCustomer(customer);
	}

  
	@DeleteMapping("customer/delete/{customerId}/{password}")
	public String deleteCustomerById(@PathVariable("customerId") Integer customerId,
			@PathVariable("password") String password) throws CustomerException {
		return this.customerService.deleteCustomerById(customerId, password);
	}

	@PutMapping("customer/update/phoneNo/{customerId}/{newPhoneNo}")
	public String updatePhoneNoById(@Valid @PathVariable("customerId") Integer customerId,
			@Valid @PathVariable("newPhoneNo") String newPhoneNo) throws CustomerException {
		return this.customerService.updateCustomerPhone(customerId, newPhoneNo);
	}

  
	@PutMapping("customer/update/address/{customerId}/{newAddress}")
	public String updateCustomerAddress(@Valid @PathVariable("customerId") Integer customerId,
			@Valid @PathVariable("newAddress") String address) throws CustomerException {
		return this.customerService.updateCustomerAddress(customerId, address);

	}

  
	@PutMapping("customer/update/password/{customerId}/{oldPassword}/{newPassword}")
	public String changeCustomerPassword(@Valid @PathVariable Integer customerId,@Valid @PathVariable String oldPassword,
			@Valid @PathVariable String newPassword) throws CustomerException {
		return this.customerService.changeCustomerPassword(customerId, oldPassword, newPassword);
	}

  
	@GetMapping("customer/{customerId}")
	public Customer getCustomerSpe(@PathVariable("customerId") Integer Id) throws CustomerException {
		return this.customerService.getCustomerSpecificDetails(Id);
	}

   
	@GetMapping("customer/count")
	public Long countCustomers() throws CustomerException {
		return this.customerService.countCustomers();
	}

	@GetMapping("all-customer")
	public List<Customer> findAllCustomers() throws CustomerException {
		return this.customerService.findAllCustomers();
	}

 
	@GetMapping("customer-email/{email}")
	public Customer getCustomerByEmail(@PathVariable("email") String email) throws CustomerException, CartItemException, ProductException {
		return this.customerService.findByCustomerEmail(email);
	}
}
