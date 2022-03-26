package com.murali.letterbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.letterbox.dao.ListDao;
import com.murali.letterbox.model.MovieList;
import com.murali.letterbox.service.ListService;

@Service
public class ListServiceImpl implements ListService {
	
	@Autowired
	ListDao dao;
	
	@Override
	public List<MovieList> getAllLists() {
		return dao.getAllMovieLists();
	}

}
