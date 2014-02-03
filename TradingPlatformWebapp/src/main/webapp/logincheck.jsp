<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<h1>Login Page</h1>

<c:choose>
	<c:when test="${valid eq true}">
	You have successfully logged in!
	</c:when>
	<c:when test="${valid eq false}">
	You Fail!
	</c:when>
	<c:otherwise>
	What are you doing?!?!!?
	</c:otherwise>
</c:choose>
</body>
</html>