package com.example.mvc.springmvc.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<Users>{

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Users us=new Users();
		us.setUserid(rs.getString(1));
		us.setPassword(rs.getString(2));
		us.setMail(rs.getString(3));
		us.setName(rs.getString(4));
		us.setRole(rs.getString(5));
		return us;
	}

}
