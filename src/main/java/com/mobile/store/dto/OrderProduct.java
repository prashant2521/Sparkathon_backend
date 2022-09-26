package com.mobile.store.dto;

public class OrderProduct {
	private Product product;

	private Integer productQuantity;

	private Double amount;
	

	public OrderProduct(Product product, Integer productQuantity, Double amount) {
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
