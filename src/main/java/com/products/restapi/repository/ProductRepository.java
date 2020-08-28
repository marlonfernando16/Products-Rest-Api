package com.products.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.restapi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findById(long id);
	
	void deleteById(long id);
}
 