<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

<h1>Welcome Page</h1>
<br>Please enter your login details

<form method="post" action="loginAuthenticate">
	<br><input type="text" name="Username">
	<br><input type="text" name="Password">
	<br><input type="submit" value="Login">
</form>

<form method="get" action="register">
	<br><input type="submit" value="Register">
</form>

</body>
</html>