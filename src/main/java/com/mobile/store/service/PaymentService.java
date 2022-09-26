package com.mobile.store.service;

import java.util.Optional;

import com.mobile.store.dto.Payment;
import com.mobile.store.exception.PaymentException;

public interface PaymentService {

	public Payment addPayment(Payment payment) throws PaymentException;
	
	public Optional<Payment> getPaymentById(Integer paymentId) throws PaymentException;
	
	public Boolean deletePaymentById(Integer paymentId) throws PaymentException;
	
}
