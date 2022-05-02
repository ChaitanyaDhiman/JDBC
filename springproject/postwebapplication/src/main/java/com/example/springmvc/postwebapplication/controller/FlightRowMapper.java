package com.example.springmvc.postwebapplication.controller;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FlightRowMapper implements RowMapper<Flight> {
	
	@Override
	public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Flight f = new Flight();
		f.setFlight_id(rs.getString(1));
		f.setAirline_id(rs.getString(2));
		f.setAirline_name(rs.getString(3));
		f.setFrom_location(rs.getString(4));
		f.setTo_location(rs.getString(5));
		f.setDeparture_time(rs.getString(6));
		f.setArrival_time(rs.getString(7));
		f.setSeats(rs.getInt(8));
		return f;
	}

}
