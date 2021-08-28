package com.market.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int cartId;
	String productName;
	float price;
	int Quantity;
	float totalprice;
	public Cart() {
		super();
		
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productName=" + productName + ", price=" + price + ", Quantity=" + Quantity
				+ ", totalprice=" + totalprice + "]";
	}
	public Cart(int cartId, String productName, float price, int quantity, float totalprice) {
		super();
		this.cartId = cartId;
		this.productName = productName;
		this.price = price;
		Quantity = quantity;
		this.totalprice = totalprice;
	}
	public Cart(String productName, float price, int quantity, float totalprice) {
		super();
		this.productName = productName;
		this.price = price;
		Quantity = quantity;
		this.totalprice = totalprice;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

}
