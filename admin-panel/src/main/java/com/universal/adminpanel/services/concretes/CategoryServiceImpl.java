package com.universal.adminpanel.services.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universal.adminpanel.dao.CategoryDAO;
import com.universal.adminpanel.entities.Category;
import com.universal.adminpanel.services.abstracts.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDAO categoryDao;
	
	@Override
	public void addCategory(Category category) {
		categoryDao.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public Category findCategoryById(Long categoryId) {
		return categoryDao.findById(categoryId).get();
	}

	@Override
	public void deleteCategoryById(Long categoryId) {
		categoryDao.deleteById(categoryId);
	}

}
