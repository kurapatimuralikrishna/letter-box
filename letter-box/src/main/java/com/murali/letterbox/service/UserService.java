package com.murali.letterbox.service;

import java.util.List;

import com.murali.letterbox.model.NewUserForm;
import com.murali.letterbox.model.User;

public interface UserService {

	List<User> getAllUsers();

	User newSignUp(NewUserForm form) throws Exception;

	User updateUser(int uid, NewUserForm form) throws Exception;

	User getUser(int uid) throws Exception;

	User changePassword(int uid, String[] passwords) throws Exception;

	User deleteUser(int uid, String[] passwords) throws Exception;

}
