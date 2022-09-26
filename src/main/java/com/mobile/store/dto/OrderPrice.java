package com.mobile.store.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderPrice {

	private List<OrderProduct> orderProduct;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Double totalAmount;

	public List<OrderProduct> getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(List<OrderProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
