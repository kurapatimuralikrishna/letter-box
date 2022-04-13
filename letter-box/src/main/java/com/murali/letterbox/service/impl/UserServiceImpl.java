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

	@Override
	public User updateUser(int uid, NewUserForm form) throws Exception {
		return dao.updateUser(uid,form);
	}

	@Override
	public User getUser(int uid) throws Exception {
		User user = dao.getUser(uid);
		if(user!=null) return user;
		else throw new Exception("Check user id");
	}

	@Override
	public User changePassword(int uid, String[] passwords) throws Exception {
		return dao.changePassword(uid,passwords);
	}

	@Override
	public User deleteUser(int uid, String[] passwords) throws Exception {
		return dao.deleteUser(uid,passwords);
	}

}
