package com.mobile.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.store.dto.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findAllByOrderByProductPriceDesc();

	List<Product> findAllByOrderByProductPriceAsc();

	List<Product> findProductByProductNameStartsWith(String productName);
}
