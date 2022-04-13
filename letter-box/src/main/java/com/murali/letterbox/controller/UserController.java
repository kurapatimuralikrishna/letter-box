package com.murali.letterbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value="/users/{uid}")
	public User getUser(@PathVariable int uid) {
		try {
			return service.getUser(uid);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ErrorUser(e);
		}
	}
	
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
	
	@PutMapping(value="/users/{uid}/update")
	public User updateUser(@PathVariable int uid, @RequestBody NewUserForm form) {
		try {
			return service.updateUser(uid,form);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ErrorUser(e);
		}
	}
	
	@PutMapping(value="users/{uid}/changepassword")
	public User changePassword(@PathVariable int uid, @RequestBody String[] passwords) {
		try {
			return service.changePassword(uid,passwords);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ErrorUser(e);
		}
	}
	
	@DeleteMapping(value="users/{uid}/delete")
	public User deleteUser(@PathVariable int uid, @RequestBody String[] passwords) {
		try {
			return service.deleteUser(uid,passwords);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ErrorUser(e);
		}
	}
}