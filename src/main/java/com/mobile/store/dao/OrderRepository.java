package com.mobile.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.store.dto.OrderByCustomer;

@Repository
public interface OrderRepository extends JpaRepository<OrderByCustomer, Integer>{


}
