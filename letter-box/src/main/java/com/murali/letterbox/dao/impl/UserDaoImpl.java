package com.murali.letterbox.dao.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.murali.letterbox.dao.UserDao;
import com.murali.letterbox.model.NewUserForm;
import com.murali.letterbox.model.User;

public class UserDaoImpl implements UserDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User newSignUp(NewUserForm form) throws Exception {
		if(form.getPassword()==null) throw new Exception("Check password");
		String sql = "INSERT INTO user_profiles(user_id,username,password,phone_number,city,description)" + " VALUES(?,?,?,?)";
		Object[] obj = { form.getUserId(), form.getUserName(), form.getPassword(), form.getPhoneNumber(), form.getCity(), form.getDescription() };
		int[] types = { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER,Types.VARCHAR,Types.VARCHAR };
		jdbcTemplate.update(sql, obj, types);

		return null;}

}
