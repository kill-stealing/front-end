package com.lmy.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lmy.demo.domain.Category;

public interface CategoryMapper {
	@Select("select * from category")
	List<Category> getCategories();
}
