package com.mobile.store.service;

import java.util.ArrayList;
import java.util.List;
import com.mobile.store.dao.WishlistRepository;
import com.mobile.store.dto.Category;
import com.mobile.store.dto.Customer;
import com.mobile.store.dto.Product;
import com.mobile.store.dto.Wishlist;
import com.mobile.store.exception.CategoryException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.mobile.store.dao.CartItemRepository;
import com.mobile.store.dao.CategoryRepository;
import com.mobile.store.dao.ProductRepository;
import com.mobile.store.exception.CustomerException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;


	@Override
	public Category addCategory(Category category) throws CategoryException {		
		String categoryName = category.getCategoryName();
		Optional<List<Category>> tempCategory = Optional.of(this.categoryRepository.findByCategoryNameStartsWith(categoryName));
		if (!(tempCategory.get().isEmpty())) {
			throw new CategoryException("category is already present.");
		}

		return this.categoryRepository.save(category);
	}


	@Override
	public Boolean deleteCategoryById(Integer categoryId) throws CategoryException {
		Boolean result;
		Optional<Category> tempCategory = this.categoryRepository.findById(categoryId);
		if (tempCategory.isPresent()) {
			this.categoryRepository.deleteById(categoryId);
			result = true;
		} else
			result = false;
		return result;

	}


	@Override
	public Category updateCategory(Category category) throws CategoryException {

		return this.categoryRepository.save(category);

	}

	@Override
	public List<Category> getAllCategory() throws CategoryException {
		List<Category> getCategory = this.categoryRepository.findAll();
		if (getCategory.isEmpty())
			throw new CategoryException("category not exits");
		return this.categoryRepository.findAll();

	}


	@Override
	public Optional<Category> getCategoryById(Integer categoryId) throws CategoryException {
		Optional<Category> getCategory = this.categoryRepository.findById(categoryId);
		if (getCategory.isEmpty())
			throw new CategoryException("category not exits");
		return this.categoryRepository.findById(categoryId);
	}


	@Override
	public List<Category> getCategoryByName(String categoryName) {

		return (List<Category>) this.categoryRepository.findByCategoryNameStartsWith(categoryName);
	}

}