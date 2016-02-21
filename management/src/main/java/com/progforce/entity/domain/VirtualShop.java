package com.progforce.entity.domain;

import java.util.List;

public interface VirtualShop {
	void increasePrice(Product product, double amount);
	void changeStatus(Product product, Status status);
	void addProduct(Product product);
	void addCategory(Category category);
	Product getProduct(Long id);
	List <Product> getAllProducts();
	List <Product> getProductByCategory(Category category);
	List <Category> getCategories();

}
