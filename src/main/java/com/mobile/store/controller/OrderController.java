package com.mobile.store.controller;

import java.sql.SQLException;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.store.dao.OrderRepository;
import com.mobile.store.dto.OrderByCustomer;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.OrderException;
import com.mobile.store.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	

	@PostMapping("order")
	public String addOrder(@RequestBody OrderByCustomer orderByCustomer) throws OrderException, CartItemException, CustomerException {
		return this.orderService.addOrder(orderByCustomer);

	}
	


	@GetMapping("getAllOrders")
	public List<OrderByCustomer> getAllOrders() throws OrderException{
		
		List<OrderByCustomer> foundAllOrders;
		foundAllOrders = this.orderService.getAllOrders();
		
		return foundAllOrders;
	}

	
	@GetMapping("order/{orderId}")
	public Optional<OrderByCustomer> getOrderById(@PathVariable("orderId") Integer orderId) throws OrderException, CartItemException, CustomerException {

		return this.orderService.getOrdersByOrderId1(orderId);

	}
	
	@PutMapping("orders")
	public OrderByCustomer updateOrder(@RequestBody OrderByCustomer orders) throws OrderException {
		return orderService.updateOrder(orders);
		
	}
	
	@DeleteMapping("orders/delete/{id}")
	public String deleteOrders(@PathVariable("id") Integer id) throws OrderException, SQLException{
		String result  = "";
		if(orderService.deleteOrderById(id)) {
			result = "delete Successfully";
		}
		return result;
	}
	

}
