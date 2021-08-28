package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.entity.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

	

}
