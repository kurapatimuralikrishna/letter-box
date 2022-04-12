package com.murali.letterbox.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.murali.letterbox.dao.CommentDao;
import com.murali.letterbox.model.Comment;

public class CommentDaoImpl implements CommentDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Comment getComment(int cid) {
		return jdbcTemplate.query("SELECT * FROM comments WHERE comment_id = " + cid, (ResultSet rs) -> {
			if (rs.next())
				return new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			else
				return null;
		});
	}

	@Override
	public List<Comment> getReplies(int cid) throws Exception {
		if(getComment(cid)==null) throw new Exception("No such comment");
		
	}

}
