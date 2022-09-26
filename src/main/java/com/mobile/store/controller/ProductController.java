package com.mobile.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.store.dto.Product;
import com.mobile.store.exception.ProductException;
import com.mobile.store.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;


	@PostMapping("product")
	public String addProduct(@RequestBody Product product) throws ProductException {
		return this.productService.addProduct(product);
		
	}

	@GetMapping("product/{productId}")
	public Optional<Product> getProductById(@PathVariable("productId") Integer productId) throws ProductException {
		return this.productService.getProductById(productId);
	}


	@PatchMapping("product")
	public Product updateProduct(@RequestBody Product product) throws ProductException {
		return this.productService.updateProduct(product);
	}


	@GetMapping("products/")
	public List<Product> getAllProduct() throws ProductException {
		return this.productService.getAllProduct();
	}


	@DeleteMapping("product/{productId}")
	public String deleteProductById(@PathVariable("productId") Integer productId) throws ProductException {
		this.productService.deleteProductById(productId);
		return "product deleted successfully";
	}


	@GetMapping("product/highToLow")
	public List<Product> findingProductHighToLow() throws ProductException {
		return this.productService.findAllProductHighToLow();
	}
	

	@GetMapping("product/lowToHigh")
	public List<Product> findingProductLowToHigh() throws ProductException {
		return this.productService.findAllProductLowToHigh();
	}

	@GetMapping("products/{productName}")
	public List<Product> findProductByName(@PathVariable("productName") String productName) throws ProductException {
		return this.productService.findProductByName(productName);
	}

}
