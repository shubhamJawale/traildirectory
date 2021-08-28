package com.market.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	String prodId;
	String productName;
	String productCategory;
	float price;
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Product() {
		super();
		
	}
	public Product(String productName, String productCategory, float price) {
		super();
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
	}
	public Product(String prodId, String productName, String productCategory, float price) {
		super();
		this.prodId = prodId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", price=" + price + "]";
	}
	
	
}
