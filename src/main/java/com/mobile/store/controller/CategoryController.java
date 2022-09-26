package com.mobile.store.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.store.dto.Category;
import com.mobile.store.dto.Customer;
import com.mobile.store.exception.CategoryException;
import com.mobile.store.exception.CustomerException;
import com.mobile.store.service.CategoryService;
import com.mobile.store.service.CustomerService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	
	@PostMapping("category")
	public Category addCategory(@Valid @RequestBody Category category) throws CategoryException {
		return this.categoryService.addCategory(category);
	}
	
	
	@GetMapping("category/{categoryId}")
	public Optional<Category> getCategoryById(@PathVariable("categoryId") Integer categoryId) throws CategoryException {
		return this.categoryService.getCategoryById(categoryId);
	}

	
	@PatchMapping("category")
	public Category updateCategory(@Valid @RequestBody Category category) throws CategoryException {
		Object Category;
		return this.categoryService.updateCategory(category);
	}

	
	@DeleteMapping("Category/{categoryId}")
	public Boolean deleteCategoryById(@PathVariable("categoryId") Integer categoryId) throws CategoryException {
		return this.categoryService.deleteCategoryById(categoryId);

	}
	
	
	@GetMapping("all-categories")
	public List<Category> getAllCategory() throws CategoryException{
		return this.categoryService.getAllCategory();
	}
	
	
	@GetMapping("categorybyname/{categoryName}")
	public List<Category> findCategoryByCategoryName(@PathVariable("categoryName") String categoryName) throws CustomerException, CategoryException{
		return this.categoryService.getCategoryByName(categoryName);
	}
}
