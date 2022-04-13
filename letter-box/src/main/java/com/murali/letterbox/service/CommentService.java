package com.murali.letterbox.service;

import java.util.List;

import com.murali.letterbox.model.Comment;

public interface CommentService {

	Comment getComment(int cid) throws Exception;

	List<Comment> getReplies(int cid) throws Exception;

	List<Comment> getListComments(int uid, String lname) throws Exception;

	List<Comment> getUserComments(int uid) throws Exception;

	List<Comment> getAllComments();

	Comment addRootComment(int listUid, String lname, Comment comment) throws Exception;

	Comment addReply(int listUid, String lname, int cid, Comment comment) throws Exception;

	Comment editComment(int listUid, String lname, int cid, Comment comment) throws Exception;

	Comment deleteComment(int listUid, String lname, int cid) throws Exception;

}
