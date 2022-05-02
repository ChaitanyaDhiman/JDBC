package com.example.mvc.springmvc.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PostRowMapper implements RowMapper<Posts>{

	@Override
	public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Posts p=new Posts();
		p.setId(rs.getInt(1));
		p.setTitle(rs.getString(2));
		p.setAuth(rs.getString(3));
		p.setDesc(rs.getString(4));
		return p;
	}

}
