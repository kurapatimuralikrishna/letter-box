package com.murali.letterbox.dao;

import java.util.List;

import com.murali.letterbox.model.Comment;

public interface CommentDao {

	Comment getComment(int cid);

	List<Comment> getReplies(int cid) throws Exception;

}
