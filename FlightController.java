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
public class FlightController {

	@Autowired
	JdbcTemplate template;
	
	@RequestMapping(value="/add")
	public ModelAndView addFlight(HttpServletResponse response) throws IOException{
		return new ModelAndView("addFlight");
	}
	@RequestMapping(value="/addFlight")
	public ModelAndView addFlightdetails(HttpServletResponse response,HttpServletRequest request) throws IOException{
		String flight_id = request.getParameter("flight_id");
		String airline_id = request.getParameter("airline_id");
		String airline_name = request.getParameter("airline_name");
		String from_location = request.getParameter("from_location");
		String to_location = request.getParameter("to_location");
		String departure_time = request.getParameter("departure_time");
		String arrival_time = request.getParameter("arrival_time");
		String duration = request.getParameter("duration");
		String seats = request.getParameter("seats");
		String sql = "insert into flight values(?,?,?,?,?,?,?,?)";
		template.update(sql,flight_id,airline_id,airline_name,from_location,to_location,departure_time,arrival_time,duration,seats);
		
		return new ModelAndView("addFlight");
	}
	@RequestMapping(value="/remove")
	public ModelAndView removeFlight(HttpServletResponse response) throws IOException{
		return new ModelAndView("removeFlight");
	}
	@RequestMapping(value="/removeFlight")
	public ModelAndView removeFlightdetails(HttpServletResponse response,HttpServletRequest request) throws IOException{
		
		String flight_id = request.getParameter("flight_id");
		String sql = "delete from flight where flight_id =?";
		template.update(sql,flight_id);
		return new ModelAndView("removeFlight");
	}
	
}
