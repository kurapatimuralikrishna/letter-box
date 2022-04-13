package com.murali.letterbox.dao.impl;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.murali.letterbox.constants.CommentConstants;
import com.murali.letterbox.dao.CommentDao;
import com.murali.letterbox.dao.ListDao;
import com.murali.letterbox.dao.UserDao;
import com.murali.letterbox.model.Comment;
import com.murali.letterbox.model.MovieList;
import com.murali.letterbox.model.User;

@Component
public class CommentDaoImpl implements CommentDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	private ListDao listDao;
	@Autowired
	private UserDao userDao;

	@Autowired
	public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Comment getComment(int cid) {
		return jdbcTemplate.query(CommentConstants.GET_COMMENT + cid, (ResultSet rs) -> {
			if (rs.next())
				return new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			else
				return null;
		});
	}

	@Override
	public List<Comment> getReplies(int cid) throws Exception {
		if (getComment(cid) == null)
			throw new Exception("No such comment");
		Object[] args = { cid };
		int[] types = { Types.INTEGER };
		return jdbcTemplate.query(CommentConstants.GET_REPLIES, args, types, (ResultSet rs) -> {
			List<Comment> replies = new ArrayList<>();
			while (rs.next())
				replies.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			return replies;
		});
	}

	@Override
	public List<Comment> getListComments(int uid, String lname) throws Exception {
		MovieList list = listDao.getList(uid, lname);
		if (list == null)
			throw new Exception("No such List");
		int lid = list.getListId();
		Object[] args = { lid };
		int[] types = { Types.INTEGER };
		return jdbcTemplate.query(CommentConstants.GET_LIST_ROOT_COMMENTS, args, types,
				(ResultSet rs) -> {
					List<Comment> replies = new ArrayList<>();
					while (rs.next())
						replies.add(
								new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
					return replies;
				});
	}

	@Override
	public List<Comment> userComments(int uid) throws Exception {
		User user = userDao.getUser(uid);
		if (user == null)
			throw new Exception("No such user");
		Object[] args = { uid };
		int[] types = { Types.INTEGER };
		return jdbcTemplate.query(CommentConstants.GET_USER_COMMENTS, args, types, (ResultSet rs) -> {
			List<Comment> replies = new ArrayList<>();
			while (rs.next())
				replies.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			return replies;
		});
	}

	@Override
	public List<Comment> getAllComments() {
		return jdbcTemplate.query(CommentConstants.GET_ALL_COMMENTS, (ResultSet rs) -> {
			List<Comment> comments = new ArrayList<>();
			while (rs.next())
				comments.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			return comments;
		});
	}

	@Override
	public Comment addRootComment(int listUid, String lname, Comment comment) throws Exception {
		MovieList list = listDao.getList(listUid, lname);
		if (list == null)
			throw new Exception("No such list");
		Object[] args = { comment.getUserId(), listUid, comment.getDescription() };
		int[] types = { Types.INTEGER, Types.INTEGER, Types.VARCHAR };
		jdbcTemplate.update(CommentConstants.ADD_ROOT_COMMENT, args, types);
		int cid = jdbcTemplate.query("SELECT  LAST_INSERT_ID() FROM comments", (ResultSet rs) -> {
			rs.next();
			return rs.getInt(1);
		});
		return getComment(cid);
	}

	@Override
	public Comment addReply(int listUid, String lname, int cid, Comment comment) throws Exception {
		MovieList list = listDao.getList(listUid, lname);
		if (list == null)
			throw new Exception("No such list");
		Comment root = getComment(cid);
		if(root==null || root.getListId()!=list.getListId()) throw new Exception("No such comment");
		Object[] args = { comment.getUserId(), listUid, cid, comment.getDescription() };
		int[] types = { Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR };
		jdbcTemplate.update(CommentConstants.ADD_REPLY, args, types);
		int childId = jdbcTemplate.query("SELECT  LAST_INSERT_ID() FROM comments", (ResultSet rs) -> {
			rs.next();
			return rs.getInt(1);
		});
		return getComment(childId);
	}

	@Override
	public Comment editComment(int listUid, String lname, int cid, Comment comment) throws Exception {
		MovieList list = listDao.getList(listUid, lname);
		if (list == null)
			throw new Exception("No such list");
		Comment ogComment = getComment(cid);
		if(ogComment==null || ogComment.getListId()!=list.getListId()) throw new Exception("No such comment");
		Object[] args = { comment.getDescription(),cid };
		int[] types = { Types.VARCHAR,Types.INTEGER };
		jdbcTemplate.update(CommentConstants.EDIT_COMMENT, args, types);
		return getComment(cid);
	}

	@Override
	public Comment deleteComment(int listUid, String lname, int cid) throws Exception {
		MovieList list = listDao.getList(listUid, lname);
		if (list == null)
			throw new Exception("No such list");
		Comment comment = getComment(cid);
		if(comment==null || comment.getListId()!=list.getListId()) throw new Exception("No such comment");
		List<Comment> replies = getReplies(cid);
		if(replies!=null) throw new Exception("Comments aldready has replies");
		Object[] args = { cid };
		int[] types = { Types.INTEGER };
		jdbcTemplate.update(CommentConstants.DELETE_COMMENT, args, types);
		return comment;
	}
}
