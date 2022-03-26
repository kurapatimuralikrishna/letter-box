package com.murali.letterbox.model;

public class User {
	private String userId;
	private String password;
	private String phoneNumber;
	private String city;
	private String description;

	public User(String userId, String password1, String password2, String phoneNumber, String city,
			String description) {
		super();
		this.userId = userId;
		if (password1.equals(password2))
			this.password = password1;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	private String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public String getDescription() {
		return description;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password, String oldPassword) throws Exception {
		if (getPassword().equals(oldPassword)) {
			this.password = password;
		} else
			throw new Exception("Check password");
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
