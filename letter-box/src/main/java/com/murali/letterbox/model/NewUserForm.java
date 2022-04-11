package com.murali.letterbox.model;

public class NewUserForm {
	private int userId;
	private String userName;
	private String password;
	private String phoneNumber;
	private String city;
	private String description;

	public NewUserForm(int userId, String userName, String password1, String password2, String phoneNumber, String city,
			String description) {
		super();
		this.userId = userId;
		this.setUserName(userName);
		if (password1.equals(password2))
			this.password = password1;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public String getPassword() {
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

	public void setUserId(int userId) {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
