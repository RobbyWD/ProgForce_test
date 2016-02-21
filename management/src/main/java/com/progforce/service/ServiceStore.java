package com.progforce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progforce.entity.domain.Category;
import com.progforce.entity.domain.Product;
import com.progforce.entity.domain.Status;
import com.progforce.entity.domain.VirtualShop;
import com.progforce.service.CategoryService;
import com.progforce.service.ProductService;

@Service
public class ServiceStore implements VirtualShop {
	

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	private ArrayList<String> serviceCategories = new ArrayList<String>();
	
	
	
	 private static ServiceStore instance = null;
	   private ServiceStore() {
	   }
	   
	 public static ServiceStore getInstance() {
	      if(instance == null) {
	         instance = new ServiceStore();
	      }
	      return instance;
	   }
	

	public Product getProduct(Long id) {

		return productService.findProduct(id);
	}

	public void addProduct(Product product) {
		productService.saveProduct(product);	
	}

	public List<Product> getAllProducts() {
		ArrayList<Category> categories = (ArrayList<Category>) this.getCategories();
		ArrayList<Product> products = new ArrayList<Product>();
		for (Category c : categories){
			products.addAll(productService.findbyCategory(c));
		}
		return products;
	}

	public List<Category> getCategories() {
		
		ArrayList<Category> categories = new ArrayList<Category>();
		for (String s : serviceCategories){
			categories.add(categoryService.findCategory(s));
		}
		return categories;
		 
	}

	public void increasePrice(Product product, double amount) {
		product.setPrice((long) (product.getPrice()*amount));
		
	}

	public void changeStatus(Product product, Status status) {
			product.setStatus(status);
		
	}

	public List<Product> getProductByCategory(Category category) {
		
		return productService.findbyCategory(category);
	}

	public ArrayList<String> getGoodsCategories() {
		return serviceCategories;
	}

	public void setGoodsCategories(ArrayList<String> serviceCategories) {
		this.serviceCategories = serviceCategories;
	}

	public void addCategory(Category category) {
		serviceCategories.add(category.getName());
		categoryService.saveCategory(category);
		
	}

	

	

}