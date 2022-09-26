package com.mobile.store.dto;

import javax.persistence.Transient;

public class CartProduct {

	private Product product;

	private Integer productQuantity;

	private Double amount;

	public CartProduct(Product product, Integer productQuantity, Double amount) {
		super();
		this.product = product;
		this.productQuantity = productQuantity;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
