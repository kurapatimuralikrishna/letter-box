package com.murali.letterbox.dao;

import java.util.List;

import com.murali.letterbox.model.Movie;
import com.murali.letterbox.model.NewUserForm;
import com.murali.letterbox.model.User;

public interface UserDao {

	List<User> getAllUsers();

	User newSignUp(NewUserForm form) throws Exception;

}
