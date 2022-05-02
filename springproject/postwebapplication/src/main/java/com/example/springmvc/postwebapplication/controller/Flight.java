package com.example.springmvc.postwebapplication.controller;

public class Flight {
	String flight_id;
	String airline_id;
	String airline_name;
	String from_location;
	String to_location;
	String departure_time;
	String arrival_time;
	String duration;
	int seats;
	
	public Flight(String flight_id, String airline_id, String airline_name, String from_location, String to_location,
			String departure_time, String arrival_time, String duration, int seats) {
		super();
		this.flight_id = flight_id;
		this.airline_id = airline_id;
		this.airline_name = airline_name;
		this.from_location = from_location;
		this.to_location = to_location;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.duration = duration;
		this.seats = seats;
	}

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public String getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}

	public String getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(String airline_id) {
		this.airline_id = airline_id;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}

	public String getFrom_location() {
		return from_location;
	}

	public void setFrom_location(String from_location) {
		this.from_location = from_location;
	}

	public String getTo_location() {
		return to_location;
	}

	public void setTo_location(String to_location) {
		this.to_location = to_location;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", airline_id=" + airline_id + ", airline_name=" + airline_name
				+ ", from_location=" + from_location + ", to_location=" + to_location + ", departure_time="
				+ departure_time + ", arrival_time=" + arrival_time + ", duration=" + duration + ", seats=" + seats
				+ "]";
	}	

	
}
