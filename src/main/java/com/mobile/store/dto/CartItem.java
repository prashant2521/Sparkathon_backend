package com.mobile.store.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer cartitemId = 0;

	private Integer customerId;

	private Integer productId;

	private LocalDate creationDate;

	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "customerId", insertable = false, updatable = false)
	private Customer customer;

	public CartItem() {
		super();
	}

	public CartItem(Product productId, Customer customerId, Integer quantity) {
		super();
		this.product = productId;
		this.customer = customerId;
		this.quantity = quantity;
		this.creationDate = creationDate;
	}

	public CartItem(Integer productId, Integer customerId, Integer quantity) {
		super();
		this.productId = productId;
		this.customerId = customerId;
		this.quantity = quantity;
	}

	public Integer getCartitemId() {
		return cartitemId;
	}

	public void setCartitemId(Integer cartitemId) {
		this.cartitemId = cartitemId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Transient
	public double getTotalPrice() {
		return product.getProductPrice() * quantity;
	}

}
