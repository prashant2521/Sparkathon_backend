package com.mobile.store.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobile.store.dto.Customer;
import com.mobile.store.service.CustomerService;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByCustomerIdAndPassword(Integer customerId, String password);
	
	@Query("select new com.mobile.store.dto.Customer(c.customerName,"
			+ "c.customerEmail,c.customerPhoneNo,c.customerAddress) from Customer c where c.customerId=:customerId")
	Optional<Customer> findBycusotmerId(@Param("customerId") Integer customerId);
	
	Optional<Customer> findCustomerByCustomerEmail(String email);
	
	
	

}
