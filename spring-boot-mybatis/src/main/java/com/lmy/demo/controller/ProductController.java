package com.lmy.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmy.demo.domain.Product;
import com.lmy.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/all")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@RequestMapping("/id/{id}")
	public Product getProductById(@PathVariable int id){
		return productService.getProductById(id);
	}
	
	@RequestMapping("/title/{title}")
	public List<Product> getProductByTitle(@PathVariable String title){
		return productService.getProductByTitle(title);
	}
	
	@RequestMapping("/price/{price}")
	public List<Product> getProductByTitle(@PathVariable float price){
		List<Product> p=productService.getProductsByPrice(price);
		System.out.println(p);
		return p;
	}
	
	@PostMapping("/search")
	public List<Product> getProductsBySearch(@RequestBody Product product){
		List<Product> p=productService.getProductsBySearch(product);
		System.out.println(p);
		return p;
	}
}
