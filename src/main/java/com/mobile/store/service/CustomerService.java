package com.mobile.store.service;

import java.util.List;
import java.util.Optional;

import com.mobile.store.dto.Customer;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;

public interface CustomerService {

	public String addCustomer(Customer customer) throws CustomerException;

	public String deleteCustomerById(Integer customerId, String password) throws CustomerException;

	public Optional<Customer> getCustomerById(Integer customerId) throws CustomerException;

	public Customer updateCustomer(Customer customer) throws CustomerException;

	public String updateCustomerPhone(Integer customerId, String phoneNo) throws CustomerException;

	public String updateCustomerAddress(Integer customerId, String address) throws CustomerException;

	public String changeCustomerPassword(Integer customerId, String oldPassword, String newPassword)
			throws CustomerException;

	public Customer loginById(Integer customerId, String password) throws CustomerException;

	public Customer getCustomerSpecificDetails(Integer customerId) throws CustomerException;

	public Long countCustomers() throws CustomerException;

	public List<Customer> findAllCustomers() throws CustomerException;

	public Customer findByCustomerEmail(String email) throws CustomerException, CartItemException, ProductException;

}
