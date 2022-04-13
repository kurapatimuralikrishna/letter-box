package com.murali.letterbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/lists/{uid}/{lname}")
	public MovieList getList(@PathVariable("uid") int uid, @PathVariable("lname") String lname) {
		try {
			return service.getList(uid, lname);
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
	
	@PostMapping("/lists/{uid}/{lname}/addmovie/{mname}")
	public String addMovieToList(@PathVariable("uid") int uid, @PathVariable("lname") String lname, @PathVariable("mname") String name) {
		try {
			return service.addMovieToList(uid,lname,name);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@PutMapping("/lists/{uid}/{lname}/removemovie/{mname}")
	public String removeMovieFromList(@PathVariable("uid") int uid, @PathVariable("lname") String lname, @PathVariable("mname") String movieName) {
		try {
			return service.removeMovieFromList(uid,lname,movieName);
		}
		catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@PutMapping("/lists/{uid}/{lname}/update")
	public MovieList updateList(@PathVariable("uid") int uid, @PathVariable("lname") String lname, @RequestBody MovieList list) {
		try {
			return service.updateList(uid,lname,list);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorList(e);
		}
	}
	
	@DeleteMapping("/lists/{uid}/{lname}/delete")
	public MovieList deleteList(@PathVariable("uid") int uid, @PathVariable("lname") String lname) {
		try {
			return service.deleteList(uid,lname);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorList(e);
		}
	}
}
