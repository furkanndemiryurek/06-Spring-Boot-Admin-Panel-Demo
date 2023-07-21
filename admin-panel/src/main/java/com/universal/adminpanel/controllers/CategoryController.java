package com.universal.adminpanel.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universal.adminpanel.entities.Category;
import com.universal.adminpanel.services.abstracts.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public String findAllCategories(Model model){
		model.addAttribute("categories",categoryService.findAll());
		return "/categories/list-categories.html";
	}
	
	@GetMapping("/{categoryId}")
	public Category findCategoryById(@PathVariable("categoryId") Long categoryId) {
		return categoryService.findCategoryById(categoryId);
	}
	
	@GetMapping("/newCategory")
	public String newCategory(Model model) {
		Category category = new Category();
		model.addAttribute(category);
		return "/categories/new-category.html";
	}
	
	@GetMapping("/updateCategory/{categoryId}")
	public String updateCategory(@PathVariable("categoryId") Long categoryId ,Model model) {
		Category category = categoryService.findCategoryById(categoryId);
		model.addAttribute(category);
		return "/categories/new-category.html";
	}
	
	@PostMapping("/save")
	public String addCategory(@ModelAttribute Category category) {
		categoryService.addCategory(category);
		return "redirect:/categories";
	}
	
	@GetMapping("delete/{categoryId}")
	public String deleteCategoryById(@PathVariable("categoryId") Long categoryId) {
		categoryService.deleteCategoryById(categoryId);
		return "redirect:/categories";
	}
}
