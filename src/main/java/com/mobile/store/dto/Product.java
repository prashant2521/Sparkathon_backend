package com.mobile.store.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer productId = 0;
	private String productName;
	private String productDescription;
	private Double productPrice;
	private Integer categoryID;

	public Product() {
		super();
	}

	public Product(Integer productId) {
		super();
		this.productId = productId;
	}
	
//	public Product(String productName, String productDescription, Double productPrice) {
//		super();
//		this.productName = productName;
//		this.productDescription = productDescription;
//		this.productPrice = productPrice;
//	}

	public Product(String productName, String productDescription, Double productPrice, Integer categoryId) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.categoryID = categoryId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getCategoryId() {
		return categoryID;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryID = categoryId;
	}

}
