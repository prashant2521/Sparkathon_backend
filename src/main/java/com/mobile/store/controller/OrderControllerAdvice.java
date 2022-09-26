package com.mobile.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mobile.store.exception.OrderException;

@RestControllerAdvice
public class OrderControllerAdvice {

	@ExceptionHandler(OrderException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleOrderException(OrderException e) {
		return e.getMessage();
	}
	
	
}
