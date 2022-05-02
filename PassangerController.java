package java.com.example.springmvc.postwebapplication.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PassangerController {
	@Autowired
	JdbcTemplate template;

	
	@RequestMapping(value="/update")
	public ModelAndView update(HttpServletResponse response) throws IOException{
		return new ModelAndView("updateuser");
	}
	@RequestMapping(value="/search")
	public ModelAndView search(HttpServletResponse response) throws IOException{
		return new ModelAndView("searchflight");
	}
	@RequestMapping(value="/updateuser")
	public ModelAndView test(HttpServletResponse response,HttpServletRequest req) throws IOException{
		
		String profileid=req.getParameter("profileid");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		int mobile=Integer.parseInt(req.getParameter("mobile"));
		String email=req.getParameter("email");
		String addr=req.getParameter("addr");
		String sql="insert into passenger values(?,?,?,?,?,?)";
		template.update(sql, profileid,fname,lname,mobile,email,addr);
		return new ModelAndView("customer");
	}
	@RequestMapping(value="/delete")
	public ModelAndView delete(HttpServletResponse response) throws IOException{
		return new ModelAndView("deletePassanger");
	}
	@RequestMapping(value="/deletePassanger")
	public ModelAndView deletePassanger(HttpServletResponse response,HttpServletRequest req) throws IOException{
		
		String Passanger_name = req.getParameter("name");
		String sql = "delete from passanger where p_name =?";
		template.update(sql,Passanger_name);
		return new ModelAndView("searchflight");
	}
	

	
}
