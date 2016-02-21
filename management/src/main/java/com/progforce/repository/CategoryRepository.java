package com.progforce.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.progforce.entity.domain.Category;


public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
	 Category findByName(String  name);

}
