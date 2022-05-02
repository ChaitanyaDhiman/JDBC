<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Flights</title>
</head>
<body>
 <jsp:include page="index.jsp"/>
 <a href="addflights.htm"> Add flight </a>


 <h3>List of flights are:</h3>
  <form>
<table border="1">
<tr>
					<th>Flight Id </th>
					<th>Airplane Id</th>
					<th>Airplane Name</th>
					<th>From</th>
					<th>To</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Total Seats</th>
</tr>

<c:forEach var="flight" items="${flight}">
<tr>
					<td>${flight_id}</td>
                    <td>${flight.airplane_id}</td>
                    <td>${flight.airplane_name}</td>
                    <td>${flight.from_location}</td>
                    <td>${flight.to_location}</td>
                    <td>${flight.departure_time}</td>
                    <td>${flight.arrival_time}</td>
                    <td>${flight.duration}</td>
                    <td>${flight.seats}</td>
                    <td><a href="updateFlights.htm?id=${flight.flight_id}&action=update">Update Flight</a></td>
                    <td><a href="deleteFlights.htm?id=${flight.flight_id}">Delete Flight</a></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>