package com.example.springmvc.postwebapplication.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@Autowired
	JdbcTemplate template;
	
	@RequestMapping(value="delete")
	public ModelAndView delete(HttpServletResponse response) throws IOException{
		return new ModelAndView("deletepost");
	}
	@RequestMapping(value="deletepost")
	public ModelAndView deletepost(HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String sql = "delete from posts where pid=?";
		template.update(sql,pid);
		return new ModelAndView("adminpage");
	}
	
	

}
