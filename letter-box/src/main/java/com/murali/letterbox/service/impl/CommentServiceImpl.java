package com.murali.letterbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.letterbox.dao.CommentDao;
import com.murali.letterbox.model.Comment;
import com.murali.letterbox.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao dao;

	@Override
	public Comment getComment(int cid) throws Exception{
		Comment comment = dao.getComment(cid);
		if (comment == null)
			throw new Exception("No such comment exists");
		return comment;
	}

	@Override
	public List<Comment> getReplies(int cid) throws Exception {
		return dao.getReplies(cid);
	}

	@Override
	public List<Comment> getListComments(int uid, String lname) throws Exception {
		return dao.getListComments(uid, lname);
	}

	@Override
	public List<Comment> getUserComments(int uid) throws Exception {
		return dao.userComments(uid);
	}

	@Override
	public List<Comment> getAllComments() {
		return dao.getAllComments();
	}

	@Override
	public Comment addRootComment(int listUid, String lname, Comment comment) throws Exception {
		return dao.addRootComment(listUid, lname, comment);
	}

	@Override
	public Comment addReply(int listUid, String lname, int cid, Comment comment) throws Exception {
		return dao.addReply(listUid, lname, cid, comment);
	}

	@Override
	public Comment editComment(int listUid, String lname, int cid, Comment comment) throws Exception {
		return dao.editComment(listUid, lname, cid, comment);
	}

	@Override
	public Comment deleteComment(int listUid, String lname, int cid) throws Exception {
		return dao.deleteComment(listUid,lname,cid);
	}
}
