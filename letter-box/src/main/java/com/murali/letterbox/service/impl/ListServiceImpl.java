package com.murali.letterbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.letterbox.dao.ListDao;
import com.murali.letterbox.model.Movie;
import com.murali.letterbox.model.MovieList;
import com.murali.letterbox.service.ListService;

@Service
public class ListServiceImpl implements ListService {
	
	@Autowired
	ListDao dao;
	
	@Override
	public List<MovieList> getAllLists() {
		return dao.getAllLists();
	}

	@Override
	public String createList(MovieList list) throws Exception {
		return dao.createList(list);
	}

	@Override
	public MovieList getList(int userId, String name) throws Exception {
		return dao.getList(userId, name);
	}

	@Override
	public MovieList updateList(String name, Movie movie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieList deleteList(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addMovieToList(int userId, String listName, String name) {
		return dao.addMovieToList(userId,listName,name);
	}

}
