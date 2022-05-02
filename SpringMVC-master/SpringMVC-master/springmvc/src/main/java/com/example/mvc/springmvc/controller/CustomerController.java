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
public class CustomerController {

	@Autowired
	JdbcTemplate templete;
	
	@RequestMapping(value="/insert")
	public ModelAndView insert(HttpServletResponse response) throws IOException{
		return new ModelAndView("insertpost");
	}
	
	@RequestMapping(value="/search")
	public ModelAndView search(HttpServletResponse response) throws IOException{
		return new ModelAndView("search");
	}
	
	@RequestMapping(value="/insertpost")
	public ModelAndView test(HttpServletResponse response,HttpServletRequest req) throws IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		String title=req.getParameter("title");
		String auth=req.getParameter("auth");
		String desc=req.getParameter("desc");
		String sql="insert into posts values(?,?,?,?)";
		templete.update(sql, id,title,auth,desc);
		return new ModelAndView("customer");
	}
	
	@RequestMapping(value="/displayResult")
	public ModelAndView displaySearch(HttpServletResponse response,HttpServletRequest req) throws IOException{
		String title=req.getParameter("title");
		String sql="select * from posts where title=? or author=?";
		List<Posts>list=templete.query(sql, new PostRowMapper(), title,title);
		System.out.println(list.size());
		return new ModelAndView("displaysearch","posts",list);
	}
}
