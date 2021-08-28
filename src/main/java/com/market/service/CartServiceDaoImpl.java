package com.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.entity.Cart;
import com.market.repository.CartRepo;
@Service
public class CartServiceDaoImpl implements CartServiceDao {
	@Autowired
	CartRepo repo;
	
	@Override
	public List<Cart> getAllCartItems() {
		
		return this.repo.findAll();
	}

	@Override
	public Cart getOneCartItem(int cartId) {
		
		return this.repo.getById(cartId);
	}

	@Override
	public void deleteCart(int cartid) {
		Cart cart =this.repo.getById(cartid);
		this.repo.delete(cart);
	}

	@Override
	public void addCart(Cart cart) {
		
		this.repo.save(cart);
		
		
	}

	@Override
	public void delete() {
		this.repo.deleteAll();
		
	}

}
