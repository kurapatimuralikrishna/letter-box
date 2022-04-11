package com.murali.letterbox.model;

public class User {
	private int userId;
	private String userName;
	private String phoneNumber;
	private String city;
	private String description;

	public User(int userId, String userName, String phoneNumber, String city, String description) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.description = description;
	}

	public int getUserId() {
		return userId;
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

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
