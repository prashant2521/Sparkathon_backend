package com.mobile.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.store.dao.CartItemRepository;
import com.mobile.store.dao.CustomerRepository;
import com.mobile.store.dao.WishlistRepository;
import com.mobile.store.dto.CartItem;
import com.mobile.store.dto.Customer;
import com.mobile.store.dto.Wishlist;
import com.mobile.store.exception.CustomerException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	WishlistRepository wishlistRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;

    
	@Override
	public String addCustomer(Customer customer) throws CustomerException {
		Integer customerId = customer.getCustomerId();
		Optional<Customer> tempCustomer = this.customerRepository.findById(customerId);
		if (tempCustomer.isPresent()) {
			throw new CustomerException("customer is already present.");
		}
		String email = customer.getCustomerEmail();
		Optional<Customer> xCustomer = this.customerRepository.findCustomerByCustomerEmail(email);
		if(xCustomer.isPresent()) throw new CustomerException("this email id is already in use.\nPlease try with other email.");
		Customer newCustomer = this.customerRepository.save(customer);
		return "customer added sucessfully.\nUser Id is :" + newCustomer.getCustomerId();
	}

	
	@Override
	public String deleteCustomerById(Integer customerId, String password) throws CustomerException {
		Optional<Customer> tempCustomer = this.customerRepository.findById(customerId);
		if (tempCustomer.isEmpty())
			throw new CustomerException("user not found.");

		Customer customer = tempCustomer.get();
		if (!(customer.getPassword().equals(password)))
			throw new CustomerException("enter correct password.");
		this.wishlistRepository.deleteFromWishlist(customerId);
		this.cartItemRepository.deleteFromCartItem(customerId);
		this.customerRepository.deleteById(customerId);
		return "customer delete sucessfully.";
	}

   
	@Override
	public Optional<Customer> getCustomerById(Integer customerId) throws CustomerException {
		Optional<Customer> getCustomer = this.customerRepository.findById(customerId);
		if (getCustomer.isEmpty())
			throw new CustomerException("customer not exits");
		return getCustomer;
	}

   
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Integer customerId = customer.getCustomerId();
		Boolean result = this.customerRepository.existsById(customerId);
		if (!result)
			throw new CustomerException(
					"customer is not available in the customer list.please create account" + "first.");
		return this.customerRepository.save(customer);
	}
	
  
	@Override
	public String updateCustomerPhone(Integer customerId, String phoneNo) throws CustomerException {
		Optional<Customer> getCustomer = this.customerRepository.findById(customerId);
		if (getCustomer.isEmpty())
			throw new CustomerException("customer not exits");
		Customer foundCustomer = getCustomer.get();

		foundCustomer.setCustomerPhoneNo(phoneNo);
		this.customerRepository.save(foundCustomer);
		return "phone number update sucessfully.";
	}
	
   
	@Override
	public String updateCustomerAddress(Integer customerId, String address) throws CustomerException {
		Optional<Customer> tempCustomer = this.customerRepository.findById(customerId);
		if (tempCustomer.isEmpty())
			throw new CustomerException("customer not found.");
		Customer customer = tempCustomer.get();
		customer.setCustomerAddress(address);
		this.customerRepository.save(customer);
		return "address update sucessfully.";
	}
	
   
	@Override
	public String changeCustomerPassword(Integer customerId, String oldPassword, String newPassword)
			throws CustomerException {
		Optional<Customer> tempCustomer = this.customerRepository.findById(customerId);
		if (tempCustomer.isEmpty())
			throw new CustomerException("user not found.");

		Customer customer = tempCustomer.get();
		if (!(customer.getPassword().equals(oldPassword)))
			throw new CustomerException("enter correct existing password.");
		if (newPassword.length() < 6)
			throw new CustomerException("length of password should be more than five.");
		customer.setPassword(newPassword);
		this.customerRepository.save(customer);
		return "password update sucessfully";
	}

  
	@Override
	public Customer loginById(Integer customerId, String password) throws CustomerException {
		Optional<Customer> customer = this.customerRepository.findById(customerId);
		if (customer.isEmpty())
			throw new CustomerException("user not found");
		Customer tempCustomer = customer.get();
		Customer loginCustomer = this.customerRepository.findByCustomerIdAndPassword(customerId, password);
		if (!(tempCustomer.getPassword().contentEquals(password)))
			throw new CustomerException("please enter correct password.");
		return loginCustomer;
	}
	

   
	@Override
	public Customer getCustomerSpecificDetails(Integer customerId) throws CustomerException {
		Optional<Customer> tempCustomer = this.customerRepository.findBycusotmerId(customerId);
		if (tempCustomer.isEmpty())
			throw new CustomerException("user not found");
		Customer customer = tempCustomer.get();
		return customer;
	}
	
	
  
	@Override
	public Long countCustomers() throws CustomerException {
		Long count = this.customerRepository.count();
		if (count <= 0)
			throw new CustomerException("customer is not added.Please add customers.");
		return count;
	}

	@Override
	public List<Customer> findAllCustomers() throws CustomerException {
		List<Customer> tempCustomer = this.customerRepository.findAll();
		if (tempCustomer.isEmpty())
			throw new CustomerException("customers not found.Add new customer.");
		return this.customerRepository.findAll();
	}

	@Override
	public Customer findByCustomerEmail(String email) throws CustomerException {
		Optional<Customer> getCustomer = this.customerRepository.findCustomerByCustomerEmail(email);
		if (getCustomer.isEmpty())
			throw new CustomerException("customer not exits");
		Customer newCustomer = getCustomer.get();
		List<Wishlist> wishlist = this.wishlistRepository.findWishlistByCustomerIdOrderByDateDesc(newCustomer.getCustomerId());
		newCustomer.setWishlist(wishlist);
		//List<CartItem> cartItem = this.cartItemRepository.findCartitemsByCustomerId(newCustomer.getCustomerId());
		//newCustomer.setCartItem(cartItem);
		return newCustomer;
	}

}
