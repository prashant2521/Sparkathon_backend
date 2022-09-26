package com.mobile.store.service;

import java.util.List;
import java.util.Optional;

import com.mobile.store.dto.Category;
import com.mobile.store.dto.Product;
import com.mobile.store.exception.CategoryException;

public interface CategoryService {

	public Category addCategory(Category category) throws CategoryException;

	public Boolean deleteCategoryById(Integer categoryId) throws CategoryException;

	public Category updateCategory(Category category) throws CategoryException;

	public List<Category> getAllCategory() throws CategoryException;

	public Optional<Category> getCategoryById(Integer categoryId) throws CategoryException;

	public List<Category> getCategoryByName(String categoryName) throws CategoryException;
	
	//public void addProductToCategory(Integer categoryId,Product product) throws CategoryException;

}