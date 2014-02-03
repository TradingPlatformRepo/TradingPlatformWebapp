<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Confirmation</title>
</head>
<body>

<h1>Registration Confirmation</h1>

<br><label>You have registered the following details</label>
<br><c:out value="${usern}"/>
<br><c:out value="${userp}"/>
<br><c:out value="${fname}"/>
<br><c:out value="${lname}"/>
<br><c:out value="${email}"/>
</body>
</html>