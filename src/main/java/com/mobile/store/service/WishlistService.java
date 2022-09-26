package com.mobile.store.service;

import java.util.List;
import java.util.Optional;

import com.mobile.store.dto.Product;
import com.mobile.store.dto.Wishlist;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.exception.WishlistException;

public interface WishlistService {

	public String createWishlist(Wishlist wishlist) throws WishlistException, CustomerException, ProductException;

	public String removeProductFromWishlist(Integer customerId, Integer productId)
			throws WishlistException, CustomerException;

	public List<Wishlist> getWishlist(Integer customerId) throws WishlistException, CustomerException;

	public String addProductTOCartFromWishlist(Integer customerId, Integer productId)
			throws WishlistException, CustomerException, CartItemException, ProductException;

}
