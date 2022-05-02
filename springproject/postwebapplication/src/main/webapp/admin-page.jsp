<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body style="background-color:powderblue;">
<h3>Please enter your credentials</h3>
<form action="login.htm" method="post">

<table>
<tr>
    <td>UserName:</td>
    <td><input type="text" name="username" size="30" required/></td>
</tr>

<tr>
    <td>Password:</td>
    <td><input type="password" name="password" size="30"  required/></td>
</tr>

<tr>
<td colspan="2"><input type="submit" value="Login" /></td>
</tr>

</table>
</form>
<form action="admin-home.jsp" >
    <button>Bypass to admin home</button>
</form>

<form action="index.jsp" >
    <button>Go back to Home</button>
</form>

</body>
</html>
