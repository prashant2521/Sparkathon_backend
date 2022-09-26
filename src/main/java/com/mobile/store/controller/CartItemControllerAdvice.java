package com.mobile.store.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.mobile.store.exception.CartItemException;
@RestControllerAdvice
public class CartItemControllerAdvice {
	@ExceptionHandler(CartItemException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleCartException(CartItemException e) {
		return e.getMessage();

	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();

		ex
		.getBindingResult()
		.getAllErrors()
		.forEach(
				(error) -> {
							String fieldName = ((FieldError) error).getField();
							String errorMessage = error.getDefaultMessage();
							errors.put(fieldName, errorMessage);
							}
				);
		
		return errors;
	}

}

