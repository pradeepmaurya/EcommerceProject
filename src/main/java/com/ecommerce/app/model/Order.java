package com.ecommerce.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_tbl")
public class Order {

	@Id
	private Integer OrderId;
	private Integer productQty;
	
	@JoinColumn(name = "product_id")
	@ManyToOne
	private Product productId;
	
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User userId;
	
	@JoinColumn(name = "address_id")
	@ManyToOne
	private Address addressId;

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public Integer getProductQty() {
		return productQty;
	}

	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public Order(Integer orderId, Integer productQty, Product productId, User userId, Address addressId) {
		super();
		OrderId = orderId;
		this.productQty = productQty;
		this.productId = productId;
		this.userId = userId;
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Order [OrderId=" + OrderId + ", productQty=" + productQty + ", productId=" + productId + ", userId="
				+ userId + ", addressId=" + addressId + "]";
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
