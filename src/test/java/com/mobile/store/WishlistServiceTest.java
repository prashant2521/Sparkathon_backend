package com.mobile.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.store.dao.CustomerRepository;
import com.mobile.store.dao.ProductRepository;
import com.mobile.store.dto.Customer;
import com.mobile.store.dto.Product;
import com.mobile.store.dto.Wishlist;
import com.mobile.store.exception.CartItemException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.exception.WishlistException;
import com.mobile.store.service.CartItemService;
import com.mobile.store.service.WishlistService;

@SpringBootTest
public class WishlistServiceTest {

	
	@Autowired(required=true)
	WishlistService wishlistService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartItemService cartItemService;
	
	@Test
	public void createWishlistTest() throws WishlistException, CustomerException, ProductException {	
		Customer customer = this.customerRepository.findCustomerByCustomerEmail("saad@gmail.com").get();
		Product product = this.productRepository.findAllByOrderByProductPriceDesc().get(0);
		Integer customerId = customer.getCustomerId();
		Integer productId = product.getProductId();
     	Wishlist wishlist = new Wishlist();
		wishlist.setCustomerId(customerId);
		wishlist.setProductId(productId);
		assertEquals("product added sucessfully", this.wishlistService.createWishlist(wishlist));
		assertNotNull(this.wishlistService.getWishlist(customerId));
		assertEquals("product delete sucessfully", this.wishlistService.removeProductFromWishlist(customerId,productId));
	}

	@Test
	public void removeProductFromWishlistTest() throws WishlistException, CustomerException, ProductException {
		Customer customer = this.customerRepository.findCustomerByCustomerEmail("saad@gmail.com").get();
		Product product = this.productRepository.findAllByOrderByProductPriceDesc().get(0);
		Integer customerId = customer.getCustomerId();
		Integer productId = product.getProductId();
     	Wishlist wishlist = new Wishlist();
		wishlist.setCustomerId(customerId);
		wishlist.setProductId(productId);
		assertEquals("product added sucessfully", this.wishlistService.createWishlist(wishlist));
		assertEquals("product delete sucessfully", this.wishlistService.removeProductFromWishlist(customerId, productId));

	}
	@Test
	public void getWishlistTest() throws WishlistException, CustomerException, ProductException {
		Customer customer = this.customerRepository.findCustomerByCustomerEmail("saad@gmail.com").get();
		Product product = this.productRepository.findAllByOrderByProductPriceDesc().get(0);
		Integer customerId = customer.getCustomerId();
		Integer productId = product.getProductId();
     	Wishlist wishlist = new Wishlist();
		wishlist.setCustomerId(customerId);
		wishlist.setProductId(productId);
		assertEquals("product added sucessfully", this.wishlistService.createWishlist(wishlist));
		assertNotNull(this.wishlistService.getWishlist(customerId));
		assertEquals("product delete sucessfully", this.wishlistService.removeProductFromWishlist(customerId, productId));
	}
	
	@Test
	public void addProductTOCartFromWishlistTest() throws WishlistException, CustomerException, ProductException, CartItemException {
		Customer customer = this.customerRepository.findCustomerByCustomerEmail("saad@gmail.com").get();
		Product product = this.productRepository.findAllByOrderByProductPriceDesc().get(0);
		Integer customerId = customer.getCustomerId();
		Integer productId = product.getProductId();
     	Wishlist wishlist = new Wishlist();
		wishlist.setCustomerId(customerId);
		wishlist.setProductId(productId);
		assertEquals("product added sucessfully", this.wishlistService.createWishlist(wishlist));
		assertEquals("product added to cart sucessfully",this.wishlistService.addProductTOCartFromWishlist(customerId, productId));
		assertEquals("product delete sucessfully", this.cartItemService.deleteProductFromCart(customerId, productId));
	}
}
