package com.example.mvc.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mvc.springmvc.Model.UserRowMapper;
import com.example.mvc.springmvc.Model.Users;

@Controller
public class HomeController {

	@Autowired
	JdbcTemplate templete;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value="/validate")
	public ModelAndView validate(HttpServletResponse response,HttpServletRequest req) throws IOException{
		String userid=req.getParameter("userid");
		String pws=req.getParameter("pass");
//		String sql="select * from users where userid= '"+userid+"' and password='"+pws+"'";
//		List<Users>ulist=templete.query(sql, new UserRowMapper());
		
		String sql="select * from users where userid= ? and password=?";
		try {
			Users u=(Users) templete.queryForObject(sql, new Object[] {userid,pws},new UserRowMapper());
			System.out.println(u);
			if(u.getRole()!=null&&u.getRole().equals("admin"))
				return new ModelAndView("admin","username",u.getName());
			else
				return new ModelAndView("customer","username",u.getName());
		}catch(Exception e) {
			return new ModelAndView("register","error",e.getMessage());
	    }
		
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register(HttpServletResponse response,HttpServletRequest req) throws IOException{
		String userid=req.getParameter("userid");
		String pws=req.getParameter("pws");
		String mail=req.getParameter("mail");
		String name=req.getParameter("name");
		String role=req.getParameter("role");
		String sql="insert into users values(?,?,?,?,?)";
		templete.update(sql, userid,pws,mail,name,role);
		return new ModelAndView("login");
	}
}
