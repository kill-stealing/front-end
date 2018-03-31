package com.lmy.demo.mapper;

import java.util.List;

import com.lmy.demo.domain.Product;

public interface ProductMapper {
	List<Product> getProducts();
	Product getProductById(int id);
	List<Product> getProductsByTitle(String title);
	List<Product> getProductsByPrice(float price);
	List<Product> getProductsByCategory(int category);
	
	List<Product> getProductsBySearch(Product product);
	
	void doUpdateProduct(Product product);
}
