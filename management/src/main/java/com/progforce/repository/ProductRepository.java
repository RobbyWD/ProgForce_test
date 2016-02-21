package com.progforce.repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.progforce.entity.domain.Category;
import com.progforce.entity.domain.Product;
import com.progforce.entity.domain.Status;


public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    List<Product> findByStatus(Status status);
    
    List<Product> findByCategory(Category category);

//    List<Product> findProductEntries(Product product);
    List<Product> findByNameAndCategory(String productName, Category category);

    List<Product> findByName(String productName);
}
