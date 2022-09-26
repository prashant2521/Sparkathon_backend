package com.mobile.store.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.mobile.store.dto.CartItem;
import com.mobile.store.dto.Customer;
import com.mobile.store.dto.OrderByCustomer;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.OrderException;

public interface OrderService {

	String addOrder(OrderByCustomer orderByCustomer) throws OrderException, CartItemException, CustomerException;

	List<OrderByCustomer> getAllOrders() throws OrderException;

	Optional<OrderByCustomer> getOrdersByOrderId1(Integer orderId) throws OrderException, CartItemException, CustomerException;

	OrderByCustomer updateOrder(OrderByCustomer orders) throws OrderException;

	boolean deleteOrderById(Integer id) throws OrderException, SQLException;


}