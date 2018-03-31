package com.lmy.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmy.demo.domain.Category;
import com.lmy.demo.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/api/categories")
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}
}
