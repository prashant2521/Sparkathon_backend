package com.mobile.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.store.dao.CustomerRepository;
import com.mobile.store.dao.ProductRepository;
import com.mobile.store.dao.WishlistRepository;
import com.mobile.store.dto.CartItem;
import com.mobile.store.dto.Customer;
import com.mobile.store.dto.Product;
import com.mobile.store.dto.Wishlist;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.exception.WishlistException;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	WishlistRepository wishlistRepository;

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CartItemService cartItemService;
	
  
	@Override
	public String createWishlist(Wishlist wishlist) throws WishlistException, CustomerException, ProductException {
		Optional<Customer> customer = this.customerRepository.findById(wishlist.getCustomerId());
		if(customer.isEmpty()) throw new CustomerException("user not found.");
		Optional<Product> product = this.productRepository.findById(wishlist.getProductId());
		if(product.isEmpty()) throw new ProductException("product not found");
		
		Integer customerId = wishlist.getCustomerId();
		Integer productId = wishlist.getProductId();
		List<Wishlist> wishlists = this.wishlistRepository.findWishlistByCustomerIdOrderByDateDesc(customerId);
		for (Wishlist iterator : wishlists) {
			if (iterator.getProductId() == productId) {
				return "product already present in wishlist";
			}
		}
		this.wishlistRepository.save(wishlist);
		return "product added sucessfully";
	}
	
   
	@Override
	public List<Wishlist> getWishlist(Integer customerId) throws WishlistException, CustomerException {
		Optional<Customer> customer = this.customerRepository.findBycusotmerId(customerId);
		if(customer.isEmpty()) throw new CustomerException("user not found.");
		return this.wishlistRepository.findWishlistByCustomerIdOrderByDateDesc(customerId);
	}

   
	@Override
	public String removeProductFromWishlist(Integer customerId, Integer productId) throws WishlistException, CustomerException {
		Optional<Customer> customer = this.customerRepository.findBycusotmerId(customerId);
		if(customer.isEmpty()) throw new CustomerException("user not found.");
		List<Wishlist> wishlists = this.wishlistRepository.findWishlistByCustomerIdOrderByDateDesc(customerId);
		Integer temp = null;
		for (Wishlist wishlist : wishlists) {
			if (wishlist.getProductId() == productId) {
				temp = wishlist.getWishlistId();
				this.wishlistRepository.deleteById(temp);
				break;
			}
		}

		if (temp != null)
			return "product delete sucessfully";
		else
			throw new WishlistException("product not found in the wishlist.");
	}
	
   
	@Override
	public String addProductTOCartFromWishlist(Integer customerId, Integer productId)
			throws WishlistException, CustomerException, CartItemException, ProductException {
		Optional<Customer> customer = this.customerRepository.findBycusotmerId(customerId);
		if (customer.isEmpty())
			throw new CustomerException("user not found.");
		List<Wishlist> wishlists = this.wishlistRepository.findWishlistByCustomerIdOrderByDateDesc(customerId);
		Boolean present = false;
		for (Wishlist iterator : wishlists) {
			if (iterator.getProductId() == productId) {
				present = true;
				break;
			}
		}
		if (!present)
			throw new WishlistException("product not found in wishlist.");
		
		
		CartItem cartItem = new CartItem(productId,customerId,1);
		this.cartItemService.addProductToCart(cartItem);

		removeProductFromWishlist(customerId, productId);
		return "product added to cart sucessfully";

	}
}
