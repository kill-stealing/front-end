package com.lmy.demo.domain;

public class Product {
	private int id;
	private String title;
	private float rating;
	private float price;
	private String desc;
	private String categories;
	private int category;

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Product() {
		super();
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public Product(int id, String title, float rating, float price,
			String desc, String categories, int category) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
		this.price = price;
		this.desc = desc;
		this.categories = categories;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", rating=" + rating
				+ ", price=" + price + ", desc=" + desc + ", categories="
				+ categories + ", category=" + category + "]";
	}
	
	
}
