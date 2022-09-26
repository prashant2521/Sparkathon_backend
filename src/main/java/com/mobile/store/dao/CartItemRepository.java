package com.mobile.store.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobile.store.dto.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	
	List<CartItem> findCartitemsByCustomerId(Integer customerId);
	
	List<CartItem> findCartitemsByCustomerIdAndProductId(Integer customerId,Integer productId);
	
	@Transactional
	@Query("UPDATE CartItem c SET c.quantity=?1 where c.customerId=?2 and c.productId=?3")
	@Modifying(clearAutomatically = true)
	public void updateQuantity(Integer quantity,Integer customerId,Integer productId);
	
	@Transactional
	@Query("DELETE FROM CartItem w where w.customerId=?1")
	@Modifying
	public void deleteFromCartItem(Integer Id);
}
