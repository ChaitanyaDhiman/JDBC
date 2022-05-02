package com.example.mvc.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mvc.springmvc.Model.PostRowMapper;
import com.example.mvc.springmvc.Model.Posts;

@Controller
public class AdminController {
	
	@Autowired
	JdbcTemplate templete;
	
	@RequestMapping(value="/delete")
	public ModelAndView insert(HttpServletResponse response) throws IOException{
		String sql="select * from posts";
		List<Posts>p=templete.query(sql, new PostRowMapper());
		return new ModelAndView("delete","posts",p);
	}
	
	@RequestMapping(value="/deletepost")
	public ModelAndView test(HttpServletResponse response,HttpServletRequest req) throws IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		String sql="delete from posts where id=?";
		templete.update(sql, id);
		return new ModelAndView("admin");
	}
	
	@RequestMapping(value="/selectdeletepost")
	public ModelAndView delete(HttpServletResponse response,HttpServletRequest req) throws IOException{
		int id=Integer.parseInt(req.getParameter("idd"));
		String sql="delete from posts where id=?";
		templete.update(sql, id);
		return new ModelAndView("admin");
	}

}
