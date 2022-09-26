package com.mobile.store;
import com.mobile.store.dao.CategoryRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.store.dto.Category;
import com.mobile.store.exception.CategoryException;
import com.mobile.store.service.CategoryService;

@SpringBootTest

public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void addCategoryTest() throws CategoryException {
		Category addCategory = new Category( 1,"Store");
		assertNotNull(this.categoryService.addCategory(addCategory));
		Category temp = this.categoryRepository.findByCategoryNameStartsWith("Store").get(0);
		Integer temp1 = temp.getCategoryId();
				assertEquals(true, this.categoryService.deleteCategoryById(temp1));
	}
	@Test
	void deleteCategoryByIdTest() throws CategoryException {
		Category addCategory = new Category( 1,"Store");
		assertNotNull(this.categoryService.addCategory(addCategory));
		Category temp = this.categoryRepository.findByCategoryNameStartsWith("Store").get(0);
		Integer temp1 = temp.getCategoryId();
				assertEquals(true, this.categoryService.deleteCategoryById(temp1));
	
}
	@Test
	void getCategoryByIdTest() throws CategoryException {
		Category addCategory = new Category( 1,"Store");
		assertNotNull(this.categoryService.addCategory(addCategory));
		Category temp = this.categoryRepository.findByCategoryNameStartsWith("Store").get(0);
		Integer temp1 = temp.getCategoryId();
		assertNotNull(this.categoryService.getCategoryById(temp1));
		assertEquals(true, this.categoryService.deleteCategoryById(temp1));
	}
	@Test
	void getAllCategoryTest() throws CategoryException {
		Category addCategory = new Category( 1,"Store");
		assertNotNull(this.categoryService.addCategory(addCategory));
		Category temp = this.categoryRepository.findByCategoryNameStartsWith("Store").get(0);
		Integer temp1 = temp.getCategoryId();
		assertNotNull(this.categoryService.getAllCategory());
		assertEquals(true, this.categoryService.deleteCategoryById(temp1));
	}
	@Test
	void getCategoryByNameTest() throws CategoryException {
		Category addCategory = new Category( 1,"Store");
		assertNotNull(this.categoryService.addCategory(addCategory));
		Category temp = this.categoryRepository.findByCategoryNameStartsWith("Store").get(0);
		Integer temp1 = temp.getCategoryId();
		assertNotNull(this.categoryService.getCategoryByName("Store"));
		assertEquals(true, this.categoryService.deleteCategoryById(temp1));
	}
	@Test
	void updateCategoryTest() throws CategoryException {
		Category addCategory = new Category( 1,"Store");
		assertNotNull(this.categoryService.addCategory(addCategory));
		Category temp = this.categoryRepository.findByCategoryNameStartsWith("Store").get(0);
		Integer temp1 = temp.getCategoryId();
		assertEquals(true, this.categoryService.deleteCategoryById(temp1));
}
	}
