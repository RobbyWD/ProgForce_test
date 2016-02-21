package com.progforce.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progforce.entity.domain.Category;
import com.progforce.entity.domain.Product;
import com.progforce.entity.domain.Status;
import com.progforce.entity.domain.VirtualShop;

@Service
public class StoreService   { 
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	GoodsStore goodsStore;
	
	@Autowired
	ServiceStore serviceStore;
	

	
	private Category service1 = new Category("Cleaning Service","In a blink of an eye!");
	private Category service2 = new Category("Vermin Killers","No one gets away with anything!");
	private Category goods1 = new Category("Fresh meat","Meat is what you like to eat!");
	private Category goods2 = new Category("Drinks","Here you go!");
	

	
	public static VirtualShop getStore() {
        try {
              return  GoodsStore.getInstance();
        } catch ( Exception ex ) {
        	VirtualShop shop = ServiceStore.getInstance();
              return shop;
        }
  }
	
	

	public void upload() {

		service1 = new Category("Cleaning Service","In a blink of an eye!");
		service2 = new Category("Vermin Killers","No one gets away with anything!");
		serviceStore.addCategory(service1);
		serviceStore.addCategory(service2);
		
		goods1 = new Category("Fresh meat","Meat is what you like to eat!");
		goods2 = new Category("Drinks","Here you go!");
		goodsStore.addCategory(goods1);
		goodsStore.addCategory(goods2);
		
		Product product1 = new Product("meat", "fresh", 12);
		product1.setCategory(goods1);
		Product product2 = new Product("chicken", "fresh", 12);
		product2.setCategory(goods1);
		Product product3 = new Product("meat", "roasted", 14);
		product3.setCategory(goods1);
		Product product4 = new Product("chicken", "roasted", 14);
		product4.setCategory(goods1);
		ArrayList<Product> forGoods1 = new ArrayList<Product>();
		forGoods1.add(product1);forGoods1.add(product2);forGoods1.add(product3);forGoods1.add(product4);
		
		goodsStore.addProduct(product1);
		goodsStore.addProduct(product2);
		goodsStore.addProduct(product3);
		goodsStore.addProduct(product4);
		goods1.setProducts(forGoods1);
		
		Product product5 = new Product("cola", "cherry", 12);
		product5.setCategory(goods2);
		Product product6 = new Product("beer", "fresh", 12);
		product6.setCategory(goods2);
		Product product7 = new Product("wine", "chateu", 14);
		product7.setCategory(goods2);
		Product product8 = new Product("water", "mineral", 14);
		product8.setCategory(goods2);
		ArrayList<Product> forGoods2 = new ArrayList<Product>();
		forGoods2.add(product5);forGoods2.add(product6);forGoods2.add(product7);forGoods2.add(product8);
		
		goodsStore.addProduct(product5);
		goodsStore.addProduct(product6);
		goodsStore.addProduct(product7);
		goodsStore.addProduct(product8);
		goods2.setProducts(forGoods2);
		
		
		Product serv1 = new Product("Cleaning", "tidy", 200);
		serv1.setCategory(service1);
		Product serv2 = new Product("Hoovering", "fresh", 200);
		serv2.setCategory(service1);
		Product serv3 = new Product("Washing", "flat+car", 400);
		serv3.setCategory(service1);
		Product serv4 = new Product("Reapiring", "cleaning +minor reapir!", 400);
		serv4.setCategory(service1);
		ArrayList<Product> forService1 = new ArrayList<Product>();
		forService1.add(serv1);forService1.add(serv2);forService1.add(serv3);forService1.add(serv4);
		
		serviceStore.addProduct(serv1);
		serviceStore.addProduct(serv2);
		serviceStore.addProduct(serv3);
		serviceStore.addProduct(serv4);
		service1.setProducts(forService1);
		
		Product serv5 = new Product("Cleaning", "tidy", 200);
		serv5.setCategory(service2);
		Product serv6 = new Product("Hoovering", "fresh", 200);
		serv6.setCategory(service2);
		Product serv7 = new Product("Washing", "flat+car", 400);
		serv7.setCategory(service2);
		Product serv8 = new Product("Reapiring", "cleaning +minor reapir!", 400);
		serv8.setCategory(service2);
		ArrayList<Product> forService2 = new ArrayList<Product>();
		forService2.add(serv5);forService2.add(serv6);forService2.add(serv7);forService2.add(serv8);
		
		serviceStore.addProduct(serv5);
		serviceStore.addProduct(serv6);
		serviceStore.addProduct(serv7);
		serviceStore.addProduct(serv8);
		service2.setProducts(forService2);
		
		categoryService.saveCategory(service1);
		categoryService.saveCategory(service2);
		categoryService.saveCategory(goods1);
		categoryService.saveCategory(goods2);
		
		
		
		
		
	}
	
	public void change(){
		
		for (Product p : service1.getProducts()){
			p.setStatus(Status.ABSENT);
			productService.updateProduct(p);
			
		}
		
		
		ArrayList<Product> changeStatustoExpected = new ArrayList<Product>();
		changeStatustoExpected.addAll(goods1.getProducts());
		changeStatustoExpected.addAll(goods2.getProducts());
		changeStatustoExpected.addAll(service2.getProducts());
		
		for (int i=0; i<changeStatustoExpected.size()/2;i++){
			changeStatustoExpected.get(i).setStatus(Status.EXPECTED);
			productService.updateProduct(changeStatustoExpected.get(i));
		}
		
		for (int i=0; i<changeStatustoExpected.size();i++){
			if (changeStatustoExpected.get(i).getStatus().equals(Status.AVAILIABLE)){
				goodsStore.increasePrice(changeStatustoExpected.get(i), 1.2);
				productService.updateProduct(changeStatustoExpected.get(i));
			}
		}
	}
	
	

}
