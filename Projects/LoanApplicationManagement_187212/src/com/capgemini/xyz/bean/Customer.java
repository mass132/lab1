package com.capgemini.xyz.bean;

public class Customer {
	private long custId;
	private String custName;
	private String address;
	private long mobile;

	public Customer(String custName, String address, String email) {
		super();
		this.custName = custName;
		this.address = address;
		this.email = email;
	}

	private String email;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
