package com.ecommerce.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address_tbl")
public class Address {
	@Id
	private Integer addressId;
	private String addressName;
	private String landmark;
	private String zipCode;
	private String state;
	private String phoneNo;
	
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user_id;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Address(Integer addressId, String addressName, String landmark, String zipCode, String state, String phoneNo,
			User user_id) {
		super();
		this.addressId = addressId;
		this.addressName = addressName;
		this.landmark = landmark;
		this.zipCode = zipCode;
		this.state = state;
		this.phoneNo = phoneNo;
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressName=" + addressName + ", landmark=" + landmark
				+ ", zipCode=" + zipCode + ", state=" + state + ", phoneNo=" + phoneNo + ", user_id=" + user_id + "]";
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
