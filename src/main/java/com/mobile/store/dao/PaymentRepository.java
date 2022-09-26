package com.mobile.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.store.dto.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
