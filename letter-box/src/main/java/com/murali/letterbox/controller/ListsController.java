package com.murali.letterbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murali.letterbox.model.MovieList;
import com.murali.letterbox.service.ListService;

@RestController
@RequestMapping("letterbox")
public class ListsController {
	@Autowired
	ListService service;
	
	@GetMapping("/lists")
	public List<MovieList> getAllLists(){
		return service.getAllLists();
	}
}
