package com.mobile.store.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.mobile.store.dto.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{

	public List<Wishlist> findWishlistByCustomerIdOrderByDateDesc(Integer customerId);
	
	@Transactional
	@Query("DELETE FROM Wishlist w where w.customerId=?1")
	@Modifying
	public void deleteFromWishlist(Integer Id);
} 
