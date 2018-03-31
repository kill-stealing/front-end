package com.lmy.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lmy.demo.mapper.ProductMapper;
import com.lmy.demo.domain.Product;

@Service
public class ProductService {

	@Autowired
	ProductMapper productMapper;

	public List<Product> getProducts() {
		return productMapper.getProducts();
	}
	
	public List<Product> getProductByTitle(String title){
		return productMapper.getProductsByTitle(title);
	}
	
	public List<Product> getProductsByPrice(float price){
		return productMapper.getProductsByPrice(price);
	}
	
	public Product getProductById(int id){
		return productMapper.getProductById(id);
	}
	
	public List<Product> getProductsBySearch(Product product){
		return productMapper.getProductsBySearch(product);
	}
	
	public void doUpdateProduct(Product product){
		productMapper.doUpdateProduct(product);
	}
}