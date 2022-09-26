package com.mobile.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.store.dto.Payment;
import com.mobile.store.exception.PaymentException;
import com.mobile.store.service.PaymentService;

@SpringBootTest
public class PaymentServiceTest {

	@Autowired
	PaymentService paymentService;

	@Test
	void addPaymentTest() throws PaymentException {
		Payment payment = new Payment(500, 100.0, "COD");
		assertNotNull(this.paymentService.addPayment(payment));
		assertEquals(true, this.paymentService.deletePaymentById(500));
	}
	
	
	@Test
	void deletePaymentByIdTest() throws PaymentException {
		Payment payment = new Payment(500,100.0,"COD");
		assertNotNull(this.paymentService.addPayment(payment));
		assertEquals(true, this.paymentService.deletePaymentById(500));
		assertThrows(PaymentException.class, () -> this.paymentService.deletePaymentById(500));
	}

	

	@Test
	void getPaymentByIdTest() throws PaymentException {
		Payment payment = new Payment(500, 100.0,"Samsung");
		assertNotNull(this.paymentService.addPayment(payment));
		assertNotNull(this.paymentService.getPaymentById(500));
		assertEquals(true, this.paymentService.deletePaymentById(500));
		assertThrows(PaymentException.class, () -> this.paymentService.getPaymentById(500));

	}


}
