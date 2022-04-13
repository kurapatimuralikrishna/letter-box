package com.murali.letterbox.constants;

public class UserConstants {

	public static final String GET_USER = "SELECT * FROM user_profiles WHERE user_id = ?";
	public static final String GET_ALL_USERS = "SELECT * FROM user_profiles";
	public static final String SIGN_UP = "INSERT INTO user_profiles(username,password,phone_number,city,description)" + " VALUES(?,?,?,?,?)";
	public static final String UPDATE_PROFILE = "UPDATE user_profiles SET username = ?, phone_number = ?, city = ?, description = ? WHERE user_id = ?";
	public static final String CHANGE_PASSWORD = "UPDATE user_profiles SET password = ? WHERE user_id = ?";
	public static final String DELETE_USER = "DELETE FROM user_profiles WHERE user_id=?";

}
