package com.murali.letterbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.letterbox.dao.UserDao;
import com.murali.letterbox.model.NewUserForm;
import com.murali.letterbox.model.User;
import com.murali.letterbox.service.UserService;

@Service
public class UserServiceImpl implements  UserService{
	
	@Autowired
	UserDao dao;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}

	@Override
	public User newSignUp(NewUserForm form) throws Exception{
		// TODO Auto-generated method stub
		return dao.newSignUp(form);
	}

}
