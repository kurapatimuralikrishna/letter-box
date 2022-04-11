package com.murali.letterbox.dao.impl;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.murali.letterbox.dao.UserDao;
import com.murali.letterbox.model.NewUserForm;
import com.murali.letterbox.model.User;

@Component
public class UserDaoImpl implements UserDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getUser(int uid) throws Exception {
		Object[] args = {uid};
		int[] types = {Types.INTEGER};
		return jdbcTemplate.query("SELECT * FROM user_profiles WHERE user_id = ?", args, types, (ResultSet rs)->{
			if(rs.next()) return new User(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6));
			else return null;
		});
		}
	@Override
	public List<User> getAllUsers() {
		return jdbcTemplate.query("SELECT * FROM user_profiles",(ResultSet rs)->{
			List<User> list = new ArrayList<>();
			while(rs.next()) list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6)));
			return list;
		});
	}

	@Override
	public User newSignUp(NewUserForm form) throws Exception {
		if(form.getPassword()==null) throw new Exception("Check password");
		String sql = "INSERT INTO user_profiles(username,password,phone_number,city,description)" + " VALUES(?,?,?,?,?)";
		Object[] obj = { form.getUserName(), form.getPassword(), form.getPhoneNumber(), form.getCity(), form.getDescription() };
		int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR };
		jdbcTemplate.update(sql, obj, types);
		return null;
		}

	@Override
	public User updateUser(int uid, NewUserForm form) throws Exception {
		if(getUser(uid)==null) throw new Exception("Check id");
		Object[] args = {form.getUserName(),form.getPhoneNumber(), form.getCity(),form.getDescription(),form.getUserId()};
		int[] types = {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		jdbcTemplate.update("UPDATE user_profiles SET username = ?, phone_number = ?, city = ?, description = ? WHERE user_id = ?", args, types);
		return getUser(uid);
	}

	@Override
	public User changePassword(int uid, String[] passwords) throws Exception {
		if(getUser(uid)==null) throw new Exception("Check id");
		if(!(passwords[1].equals(passwords[2]))) throw new Exception("Passwords do't match with");
		Object[] args = {passwords[1],uid};
		int[] types = {Types.VARCHAR,Types.INTEGER};
		jdbcTemplate.update("UPDATE user_profiles SET password = ? WHERE user_id = ?", args, types);
		return getUser(uid);
	}

	@Override
	public User deleteUser(int uid, String[] passwords) throws Exception {
		User user = getUser(uid);
		if(user==null) throw new Exception("Check id");
		if(!(passwords[1].equals(passwords[0]))) throw new Exception("Passwords do't match with");
		Object[] args = {uid};
		int[] types = {Types.INTEGER};
		jdbcTemplate.update("DELETE FROM user_profiles WHERE user_id=?", args, types);
		return user;
	}


}
