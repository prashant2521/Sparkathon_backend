package com.mobile.store.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class OrderByCustomer {

	@Id
	private Integer OrderId;

	private Integer customerId;

	private LocalDate creationDate;

	@OneToMany
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private List<CartItem> cartItem;

	public OrderByCustomer() {
		super();

	}

	public OrderByCustomer(Integer orderId, Integer customerId) {
		super();
		OrderId = orderId;
		this.customerId = customerId;
	}

	public OrderByCustomer(Integer orderId, Integer customerId, LocalDate creationDate, List<CartItem> cartItem) {
		super();
		OrderId = orderId;
		this.customerId = customerId;
		this.creationDate = creationDate;
		this.cartItem = cartItem;
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

}