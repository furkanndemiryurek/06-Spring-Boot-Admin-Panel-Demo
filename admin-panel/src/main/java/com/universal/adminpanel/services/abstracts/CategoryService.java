package com.universal.adminpanel.services.abstracts;

import java.util.List;

import com.universal.adminpanel.entities.Category;

public interface CategoryService {
	void addCategory(Category category);
	
	List<Category> findAll();
	
	Category findCategoryById(Long categoryId);
	
	void deleteCategoryById(Long categoryId);
}
