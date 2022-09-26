package com.mobile.store.dto;

import java.util.List;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartItemPrice {

	private List<CartProduct> cartProduct;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Double totalAmount;

	public CartItemPrice(List<CartProduct> cartProduct2, Double totalAmount) {
		super();
		this.cartProduct = cartProduct2;
		this.totalAmount = totalAmount;
	}

	public List<CartProduct> getProduct() {
		return cartProduct;
	}

	public void setProduct(List<CartProduct> product) {
		this.cartProduct = product;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
