package com.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	public Product findByProductName(String productName);

}
