<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Registration</title>
</head>
<body>
<div style="float:left; width:40%">
<h2>Registration Form</h2>
    <form method="post" action="RegConfirm">
        <input  style="float:right" type="text" name="Username" id="username">
        <label style="float:right" for="username">Username: </label>
        <br>

        <input style="float:right" type="password" name="Password" id="password">
        <label style="float:right" for="password">Password: </label>
        <br>
        
        <input style="float:right" type="text" name="Email" id="email">
        <label style="float:right" for="email">Email: </label>
        <br>

        <input style="float:right" type="text" name="Firstname" id="firstname">
        <label style="float:right" for="firstname">First Name: </label>
        <br>

        <input style="float:right" type="text" name="Lastname" id="lastname">
        <label style="float:right" for="lastname">Last Name:</label>
        <br>
        <br>
        
        <input style="float:right" type="checkbox" name="Shareholder" value="1">
        <label style="float:right" for="lastname">Shareholder</label>

        <input style="float:right" type="checkbox" name="Broker" value="1">
        <label style="float:right" for="lastname">Broker</label>
        <br>
        <br>
        
        <input style="float:right" type="checkbox" name="Manager" value="1">
        <label style="float:right" for="lastname">Stock Manager</label>

        <input style="float:right" type="checkbox" name="Admin" value="1">
        <label style="float:right" for="lastname">Admin</label>
        <br>
        <br>
        
        <input style="float:right" type="submit" name="submit" value="Register"><br>
    </form><br>
    <form  method="get" action="homepage" style="float:right">
        <input style="float:right" type="submit" value="Back" />
    </form>
</div>
</body>
</html>
