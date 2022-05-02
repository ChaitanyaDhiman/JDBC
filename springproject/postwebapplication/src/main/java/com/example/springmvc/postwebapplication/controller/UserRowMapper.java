package com.example.springmvc.postwebapplication.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Users usr = new Users();
		usr.setUsername(rs.getString(1));
		usr.setPassword(rs.getString(2));
		usr.setRoles(rs.getString(3));
		return usr;
	}

}