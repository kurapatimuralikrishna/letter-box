package com.murali.letterbox.constants;

public class CommentConstants {

	public static final String GET_COMMENT = "SELECT * FROM comments WHERE comment_id = ";
	public static final String GET_REPLIES = "SELECT * FROM comments WHERE root_comment_id = ?";
	public static final String GET_LIST_ROOT_COMMENTS = "SELECT * FROM comments WHERE list_id=? AND root_comment_id=null;";
	public static final String GET_USER_COMMENTS = "SELECT * FROM comments WHERE user_id = ?";
	public static final String GET_ALL_COMMENTS = "SELECT * FROM comments WHERE user_id = ?";
	public static final String ADD_ROOT_COMMENT = "SELECT * FROM comments WHERE user_id = ?";
	public static final String ADD_REPLY = "INSERT INTO comments(user_id,list_id,root_comment_id,desctiption) VALUES (?,?,?,?)";
	public static final String EDIT_COMMENT = "UPDATE comments SET description = ? WHERE comment_id = ?";
	public static final String DELETE_COMMENT = "DELETE FROM comments WHERE cid=?";

}
