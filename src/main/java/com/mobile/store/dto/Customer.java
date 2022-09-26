package com.mobile.store.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.action.internal.EntityAction;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer customerId = 0;

	@NotEmpty(message = "please enter valid name.")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "only can use alphabets.")
	private String customerName;

	@NotEmpty(message = "email field is mandatory.")
	@Email(message = "please enter valid email.")
	private String customerEmail;

	@NotEmpty(message = "number field can not be empty.")
	@Pattern(regexp = "^\\d{10}$", message = "enter valid phone number.")
	private String customerPhoneNo;

	@NotEmpty(message = "address field is mandatory.")
	private String customerAddress;

	private LocalDate creationDate;

	@NotEmpty(message = "password field is mandatory.")
	@Size(min = 6, message = "password should have min 6 char.")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@OneToMany
	@JoinColumn(name = "columnId")
	private List<CartItem> cartItem;

	@OneToMany
	@JoinColumn(name = "columnId")
	private List<Wishlist> wishlist;

	@OneToOne(cascade = CascadeType.ALL)
	private OrderByCustomer order;

	public Customer() {
		super();
		this.creationDate = LocalDate.now();
	}

	public Customer(String customerName, String customerEmail, String customerPhoneNo, String customerAddress,
			String password) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNo = customerPhoneNo;
		this.customerAddress = customerAddress;
		this.creationDate = LocalDate.now();
		this.password = password;
	}

	public Customer(String customerName, String customerEmail, String customerPhoneNo, String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNo = customerPhoneNo;
		this.customerAddress = customerAddress;
	}

	public Customer(Integer customerId, String customerName, String customerEmail, String customerPhoneNo,
			String customerAddress, LocalDate creationDate, CartItem cartItem, List<Wishlist> wishlist,
			OrderByCustomer order) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNo = customerPhoneNo;
		this.customerAddress = customerAddress;
		this.creationDate = creationDate;
		this.cartItem = (List<CartItem>) cartItem;
		this.wishlist = wishlist;
		this.order = order;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Value("#{target.code}")
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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

	public List<Wishlist> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}

	public OrderByCustomer getOrder() {
		return order;
	}

	public void setOrder(OrderByCustomer order) {
		this.order = order;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
