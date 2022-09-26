package com.mobile.store.service;

import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.store.dao.CartItemRepository;
import com.mobile.store.dao.CustomerRepository;
import com.mobile.store.dao.OrderRepository;
import com.mobile.store.dto.CartItem;
import com.mobile.store.dto.Customer;
import com.mobile.store.dto.OrderByCustomer;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.OrderException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;

	
	

	@Override
	public String addOrder(OrderByCustomer orderByCustomer) throws OrderException, CartItemException, CustomerException {
		Integer customerId = orderByCustomer.getCustomerId();
		Optional<Customer> customer = this.customerRepository.findBycusotmerId(customerId);
		if (customer.isEmpty())
			throw new CustomerException("user not found.");
		List<CartItem> cartItem = this.cartItemRepository.findCartitemsByCustomerId(customerId);
		if (cartItem.isEmpty())
			throw new CartItemException("Cart Not Found");
		
		OrderByCustomer temp =  this.orderRepository.save(orderByCustomer);
		
		temp.setCartItem(cartItem);
		this.orderRepository.save(temp);
		return "Order Placed Successfully";
			
	}
	
	
	@Override
	public Optional<OrderByCustomer> getOrdersByOrderId1(Integer orderId) throws OrderException, CartItemException, CustomerException {

//		return this.orderRepository.findById(orderId);
		Optional<OrderByCustomer> id = orderRepository.findById(orderId);
		if(id.isEmpty()) {
			throw new OrderException("User with order id : "+ orderId + " does not exist");
		}
		return id;		
		
	}


	
	
	@Override
	public List<OrderByCustomer> getAllOrders() throws OrderException {
		List<OrderByCustomer> allOfOrders = this.orderRepository.findAll();
		if (allOfOrders.isEmpty()) {
			throw new OrderException("No orders found");
		}
		else {
			return allOfOrders;
		}
	}
	
	
	@Override
	public OrderByCustomer updateOrder(OrderByCustomer orders) throws OrderException{
		if( orders == null) {
			throw new OrderException("Order cannot be null");
		}
		Optional<OrderByCustomer> foundOrder = this.orderRepository.findById(orders.getOrderId());
		if(foundOrder.isEmpty()) {
			throw new OrderException("Order does not exists for id : " + orders.getOrderId());
		}
		return this.orderRepository.save(orders);
	}
	
	
	@Override
	public  boolean deleteOrderById(Integer id) throws OrderException, SQLException{
		
		boolean deleteOrder = false;
		if(orderRepository.existsById(id)) {
			orderRepository.deleteById(id);
			if(orderRepository.existsById(id)) {
				throw new OrderException("User not deleted");
				
			}
			deleteOrder = true;
		}
		else {
			throw new OrderException("No order with order ID : " + id + " exists to be deleted"); 
		}
		return deleteOrder;
	}
	

}