package com.murali.letterbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.murali.letterbox.dao.CommentDao;
import com.murali.letterbox.model.Comment;
import com.murali.letterbox.service.CommentService;

public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao dao;
	
	@Override
	public Comment getComment(int cid) {
		return dao.getComment(cid);
	}

	@Override
	public List<Comment> getReplies(int cid) throws Exception {
		return dao.getReplies(cid);
	}
}
