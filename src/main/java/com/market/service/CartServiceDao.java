package com.market.service;

import java.util.List;

import com.market.entity.Cart;

public interface CartServiceDao {

	public List<Cart> getAllCartItems();
	
	public Cart getOneCartItem(int cartId);
	
	public void deleteCart(int cartid);
	
	public void addCart(Cart cart);
	
	public void delete();
	
	
}
