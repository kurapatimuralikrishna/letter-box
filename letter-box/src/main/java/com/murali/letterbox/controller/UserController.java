package com.murali.letterbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murali.letterbox.model.ErrorUser;
import com.murali.letterbox.model.NewUserForm;
import com.murali.letterbox.model.User;
import com.murali.letterbox.service.UserService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("letterbox")
public class UserController {
	@Autowired
	UserService service;

	@GetMapping(value = "/users")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	
	@PostMapping(value="/users/signup")
	public User newSignup(@RequestBody NewUserForm form) {
		try {
			return service.newSignUp(form);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ErrorUser(e);
		}
	}

}
