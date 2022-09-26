package com.mobile.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.mobile.store.dto.Category;
import com.mobile.store.dto.Payment;
import com.mobile.store.dto.Product;
import com.mobile.store.exception.PaymentException;
import com.mobile.store.exception.ProductException;
import com.mobile.store.dao.CategoryRepository;
import com.mobile.store.dao.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	CategoryService catigoryService;

	@Autowired
	CategoryRepository categoryRepository;

	
	@Override
	public String addProduct(Product product) throws ProductException {
		if (product == null) {
			throw new ProductException("Payment not Added");
		}
		Optional<Product> foundProduct = this.productRepository.findById(product.getProductId());
		if (foundProduct.isPresent()) {
			throw new ProductException("Product Id already Present");
		} else {
			Product newProduct = this.productRepository.save(product);
			Integer categoryId = newProduct.getCategoryId();
			Optional<Category> category = this.categoryRepository.findById(categoryId);
			if (category.isEmpty()) {
				Integer xproductId = newProduct.getProductId();
				this.productRepository.deleteById(xproductId);
				throw new ProductException("category not found for product");
			}
			Category newCategory = category.get();
			List<Product> xProduct = newCategory.getProduct();
			xProduct.add(newProduct);
			newCategory.setProduct(xProduct);
			this.categoryRepository.save(newCategory);
		}
		return "product added successfully";
	}

	
	@Override
	public Optional<Product> getProductById(Integer productId) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> foundProduct = this.productRepository.findById(productId);
		if (foundProduct.isEmpty()) {
			throw new ProductException("Product Id not found in record");
		}
		return foundProduct;
	}

	
	@Override
	public List<Product> getAllProduct() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> productList = this.productRepository.findAll();
		if (productList.isEmpty()) {
			throw new ProductException("Product List not found");
		}
		return productList;
	}

	
	@Override
	public Boolean deleteProductById(Integer productId) throws ProductException {
		Optional<Product> foundProduct = this.productRepository.findById(productId);
		if (foundProduct.isEmpty()) {
			throw new ProductException("Product Id not found in record");
		}
		this.productRepository.deleteById(productId);
		return true;
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		return this.productRepository.save(product);
	}

	
	@Override
	public List<Product> findAllProductHighToLow() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> productList = this.productRepository.findAll();
		if (productList.isEmpty()) {
			throw new ProductException("Product List not found");
		}
		return this.productRepository.findAllByOrderByProductPriceDesc();
	}

	
	@Override
	public List<Product> findAllProductLowToHigh() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> productList = this.productRepository.findAll();
		if (productList.isEmpty()) {
			throw new ProductException("Product List not found");
		}
		return this.productRepository.findAllByOrderByProductPriceAsc();

	}

	
	@Override
	public List<Product> findProductByName(String productName) throws ProductException {
		// TODO Auto-generated method stub
		List<Product> foundProduct = this.productRepository.findProductByProductNameStartsWith(productName);

		if (foundProduct.isEmpty()) {
			throw new ProductException("Product Id not found in record");
		}
		return this.productRepository.findProductByProductNameStartsWith(productName);

	}

}