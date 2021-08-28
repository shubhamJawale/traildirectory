package com.market.service;

import java.util.List;

import com.market.entity.Product;

public interface ProductServiceDao {
	public List<Product> getAllProduct();
	
	public Product getOneProduct(String productId);
	
	
	
	

}
