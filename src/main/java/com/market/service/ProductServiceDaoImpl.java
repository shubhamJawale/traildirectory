package com.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.entity.Product;
import com.market.repository.ProductRepo;
@Service
public class ProductServiceDaoImpl implements ProductServiceDao {
	@Autowired
	ProductRepo repo;
	
	
	@Override
	public List<Product> getAllProduct() {
		
		return this.repo.findAll();
	}

	@Override
	public Product getOneProduct(String productId) {
		
		Product product = this.repo.getById(productId);
		System.out.println(product);
		
		return this.repo.getById(productId);
	}

}
