package com.murali.letterbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murali.letterbox.model.ErrorList;
import com.murali.letterbox.model.MovieList;
import com.murali.letterbox.service.ListService;

@RestController
@RequestMapping("letterbox")
public class ListsController {
	@Autowired
	ListService service;

	@GetMapping("/lists/{uid}/{uname}")
	public MovieList getList(@PathVariable int uid, @PathVariable String uname) {
		try {
			return service.getList(uid, uname);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorList(e);
		}
	}

	@GetMapping("/lists")
	public List<MovieList> getAllLists() {
		return service.getAllLists();
	}

	@PostMapping("/lists/create")
	public String createList(@RequestBody MovieList list) {
		try {
			return service.createList(list);
		} catch (Exception e) {
			e.printStackTrace();
			return "Not Done";
		}
	}
	
	@PostMapping("/lists/{uid}/{uname}")
	public String addMovieToList(@PathVariable int uid, @PathVariable String uname, @RequestBody String name) {
		return service.addMovieToList(uid,uname,name) ;
	}
}
