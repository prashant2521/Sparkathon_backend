package com.mobile.store.service;

import java.util.List;

import com.mobile.store.dto.CartItem;
import com.mobile.store.dto.CartItemPrice;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;

public interface CartItemService {

	public String addProductToCart(CartItem cartItem) throws CartItemException,CustomerException,ProductException;
	
	public CartItemPrice getProductByCusId(Integer customerId) throws CartItemException,CustomerException,ProductException;
	
	public List<CartItem> getProductByCusIdAndProId(Integer customerId,Integer productId) throws CartItemException,CustomerException,ProductException;
	
	public String deleteProductFromCart(Integer customerId,Integer productId) throws CartItemException,CustomerException,ProductException;

	public String updateQuantityOfCartProduct(Integer customerId,Integer productId,Integer quantity) throws CartItemException,CustomerException,ProductException;
}
