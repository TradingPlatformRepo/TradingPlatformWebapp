<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Trading Platform</h1>

	<div style="float:left; width:40%">
		<form method= "post" action="loginAuthenticate">
		    
		    <input style="float:right" type="text" name="Username">
		    <label style="float:right">Username: </label>
		    <br>
		        
		    <input style="float:right" type="text" name="Password">
		    <label style="float:right">Password: </label>
		    <br>
		    <br>
		    
		    <input style="float:right" type="submit" value="Login"/>
		    <br>    
		</form>
		<br>
		
		<form style="float:right" method="get" action="register">
		    <input type="submit" value="Register"/>
		</form>
	</div>
</body>
</html>