package com.mobile.store.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.store.dao.PaymentRepository;
import com.mobile.store.dto.Payment;
import com.mobile.store.exception.PaymentException;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	
	@Override
	public Payment addPayment(Payment payment) throws PaymentException {
		Optional<Payment> tempPayment = this.paymentRepository.findById(payment.getPaymentId());
		if (tempPayment.isPresent())
			throw new PaymentException("payment id already exist");
		return this.paymentRepository.save(payment);
	}

	
	@Override
	public Optional<Payment> getPaymentById(Integer paymentId) throws PaymentException {
		Optional<Payment> tempPayment = this.paymentRepository.findById(paymentId);
		if (!tempPayment.isPresent())
			throw new PaymentException("payment id not exist");
		return this.paymentRepository.findById(paymentId);
	}
	

	
	@Override
	public Boolean deletePaymentById(Integer paymentId) throws PaymentException {
		Optional<Payment> tempPayment = this.paymentRepository.findById(paymentId);
		if (!tempPayment.isPresent())
			throw new PaymentException("payment id not exist");
		this.paymentRepository.deleteById(paymentId);
		return true;
	}

}
