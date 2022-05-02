<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h3>Please enter your credentials</h3>
<form name="login" action="validate">

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
    <td>Role :        
        <label> 
        <select>
           <option value = "admin"> Admin </option>
           <option value = "passanger"> Passenger</option>
         </select>  
        </label>
    </td>
  
</tr>

<tr>
<td colspan="2"><input type="submit" value="Login" /></td>
</tr>

</table>
</form><br>
     <form action = "register"> 
        <button type="Submit" value="submit">New Register!</button>
     </form><br>
    
 
<form action="index.jsp" >
    <button>Go back to Home</button>
</form>

</body>
</html>