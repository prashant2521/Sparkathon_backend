package com.mobile.store;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.store.dao.ProductRepository;
import com.mobile.store.dto.Product;
import com.mobile.store.exception.ProductException;
import com.mobile.store.service.ProductService;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepo;
	
	@Test
	public void getProductByIdTest() throws ProductException{
		Product product = new Product("spice","4 gb ram",7000.0,1);
		Product newProduct = this.productRepo.save(product);
		assertNotNull(this.productService.getProductById(newProduct.getProductId()));
		assertNotNull(this.productService.deleteProductById(newProduct.getProductId()));
	}
	

	
	@Test
	public void getAllProductTest() throws ProductException{
		assertNotNull(this.productService.getAllProduct());
	}
	
	@Test
	public void findAllProductHighToLowTest() throws ProductException{
		assertNotNull(this.productService.findAllProductHighToLow());

	}
	
	@Test
	public void findAllProductLowToHighTest() throws ProductException{
		assertNotNull(this.productService.findAllProductHighToLow());
	}
	
	@Test
	public void findProductByNameTest() throws ProductException{
		Product product = new Product("spice","4 gb ram",7000.0,1);
		Product newProduct = this.productRepo.save(product);
		assertNotNull(this.productService.findProductByName(newProduct.getProductName()));
		assertNotNull(this.productService.deleteProductById(newProduct.getProductId()));
	}
	
	@Test
	public void deleteProductByIdTest() throws ProductException{
		Product product = new Product("spice","4 gb ram",7000.0,1);
		Product newProduct = this.productRepo.save(product);
		assertNotNull(this.productService.deleteProductById(newProduct.getProductId()));
	}
}

