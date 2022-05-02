package com.example.springmvc.postwebapplication.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	JdbcTemplate template;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("index");
	}
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/validate")
	public ModelAndView validate(HttpServletResponse response, HttpServletRequest request) throws IOException, SQLException {
		boolean isFound = false;
		
		

		String uname = request.getParameter("user");
		String passwd = request.getParameter("pwd");
		
		//String getRoles = "select roles from users where=?";
		
		List<Users> users = template.query("select * from users", new UserRowMapper());
	    String temp = null;
		for (Users u : users) {
			if (uname.equals(u.getUsername()) && passwd.equals(u.getPassword())) {
				isFound = true;
				temp= uname;
				break;
			}
		}
		if (isFound) {
			if(temp.equals("admin"))
				return new ModelAndView("admin-page","username",uname);
			else
				return new ModelAndView("user-page","username",uname);
		}
		else
			return new ModelAndView("new register");
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register(HttpServletResponse response, HttpServletRequest request) throws IOException{
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("pwd");
		String role = request.getParameter("role");
		
		String sql = "insert into users values(?,?,?)";
		template.update(sql,uname,passwd,role);
		
		return new ModelAndView("index");
	}
}
