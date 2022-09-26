package com.mobile.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.store.dao.OrderRepository;
import com.mobile.store.dto.OrderByCustomer;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.OrderException;
import com.mobile.store.service.OrderService;

@SpringBootTest
public class OrderServiceTest {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderRepository orderRepo;
	
	@Test
	public void addOrderTest() throws OrderException, CartItemException, CustomerException{
		OrderByCustomer orderByCustomer = new OrderByCustomer(3,1);
		assertNotNull(orderService.addOrder(orderByCustomer));
		this.orderRepo.deleteById(3);
		
	}
	
	
	@Test
	public void getAllOrders() throws OrderException, CartItemException, CustomerException{
		OrderByCustomer orderByCustomer = new OrderByCustomer(3,1);
		assertNotNull(orderService.addOrder(orderByCustomer));
		assertNotNull(this.orderService.getAllOrders());
		this.orderRepo.deleteById(3);
	}
	
	@Test
	public void getOrderByIdTest() throws OrderException, CartItemException, CustomerException{
		OrderByCustomer orderByCustomer = new OrderByCustomer(3,1);
		assertNotNull(orderService.addOrder(orderByCustomer));
		assertNotNull(this.orderService.getOrdersByOrderId1(orderByCustomer.getOrderId()));
		this.orderRepo.deleteById(3);
	}
	
	@Test
	public void deleteOrderByIdTest() throws OrderException, SQLException{
		OrderByCustomer orderByCustomer = new OrderByCustomer(3,1);
		this.orderRepo.deleteById(3);
//		assertEquals("Successful", this.orderService.deleteOrderById(3));
//		assertThrows(OrderException.class, ()-> this.orderService.deleteOrderById(3));
		
		
	}

}

