package com.mobile.store.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.store.dto.Product;
import com.mobile.store.dto.Wishlist;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.exception.WishlistException;
import com.mobile.store.service.ProductService;
import com.mobile.store.service.WishlistService;

@RestController
public class WishlistController {

	@Autowired
	WishlistService wishlistService;

  
	@PostMapping("wishlist")
	public String addProductToWishlist(@Valid @RequestBody Wishlist wishlist)
			throws WishlistException, CustomerException, ProductException {
		return this.wishlistService.createWishlist(wishlist);

	}

	@GetMapping("wishlist/{customerId}")
	public List<Product> getWishlistByCusId(@PathVariable("customerId") Integer customerId)
			throws WishlistException, CustomerException {
		List<Wishlist> allWishlist = this.wishlistService.getWishlist(customerId);
		List<Product> products = new ArrayList<Product>();
		for (Wishlist wishlist : allWishlist) {
			products.add(wishlist.getProduct());
		}

		return products;
	}


	@DeleteMapping("wishlist/{customerId}/{productId}")
	public String deleteProductFromWishlist(@PathVariable("customerId") Integer customerId,
			@PathVariable("productId") Integer productId) throws WishlistException, CustomerException {
		this.wishlistService.removeProductFromWishlist(customerId, productId);
		return "product remove sucessfully";
	}


	@PutMapping("wishlist/{customerId}/{productId}")
	public String addProductToCartFromWishlist(@PathVariable("customerId") Integer customerId,
			@PathVariable("productId") Integer productId) throws WishlistException, CustomerException, CartItemException, ProductException {
		return this.wishlistService.addProductTOCartFromWishlist(customerId, productId);
	}
}