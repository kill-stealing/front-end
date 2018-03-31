package com.lmy.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmy.demo.domain.Category;
import com.lmy.demo.mapper.CategoryMapper;

@Service
public class CategoryService {
	@Autowired
	CategoryMapper categoryMapper;

	public List<Category> getCategories() {
		return categoryMapper.getCategories();
	}
}
