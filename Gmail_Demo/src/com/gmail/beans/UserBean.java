package com.gmail.beans;

public class UserBean {
	private String username;
	private String password;
	private String mobile;
	private int age;
	private int isEligible;

	public int isEligible() {
		return isEligible;
	}

	public void setEligible(int isEligible) {
		this.isEligible = isEligible;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
