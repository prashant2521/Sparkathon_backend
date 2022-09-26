package com.mobile.store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.store.dto.CartItem;
import com.mobile.store.dto.CartItemPrice;
import com.mobile.store.dto.CartProduct;
import com.mobile.store.dto.Product;
import com.mobile.store.dto.Wishlist;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.exception.WishlistException;
import com.mobile.store.service.CartItemService;

@RestController
public class CartItemController {

	@Autowired
	CartItemService cartItemService;

	@PostMapping("cartitem")
	public String addProductToCart(@Valid @RequestBody CartItem cartItem)
			throws CustomerException, CartItemException, ProductException {
		return this.cartItemService.addProductToCart(cartItem);

	}

	@GetMapping("cartitem/{customerId}")
	public CartItemPrice getCartByCusId(@PathVariable("customerId") Integer customerId)
			throws CustomerException, CartItemException, ProductException {

		return this.cartItemService.getProductByCusId(customerId);

	}

	@GetMapping("cartitem/{customerId}/{productId}")
	public CartProduct getProductFromCart(@PathVariable("customerId") Integer customerId,
			@PathVariable("productId") Integer productId)
			throws CartItemException, CustomerException, ProductException {
		List<CartItem> cartItem = this.cartItemService.getProductByCusIdAndProId(customerId, productId);
		CartItem temp = cartItem.get(0);
		CartProduct cartProduct = new CartProduct(temp.getProduct(), temp.getQuantity(), temp.getTotalPrice());
		return cartProduct;
	}

	@DeleteMapping("cartitem/{customerId}/{productId}")
	public String deleteProductFromCart(@PathVariable("customerId") Integer customerId,
			@PathVariable("productId") Integer productId)
			throws CustomerException, CartItemException, ProductException {
		this.cartItemService.deleteProductFromCart(customerId, productId);
		return "product remove sucessfully";
	}

	@PutMapping("cartitem/update/{customerId}/{productId}/{quantity}")
	public String updateQuantityOfProduct(@PathVariable("customerId") Integer customerId,
			@PathVariable("productId") Integer productId, @PathVariable("quantity") Integer quantity)
			throws CustomerException, CartItemException, ProductException {
		return this.cartItemService.updateQuantityOfCartProduct(customerId, productId, quantity);
	}

}
