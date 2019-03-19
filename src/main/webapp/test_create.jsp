<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create test</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<h1 align="center">Create test</h1>
Choose subject:
<form method="POST" action="CreateServlet">
    <input type="submit" value="Mathematics">
</form>
<br><form action="CreateServlet">
    <input type="submit" value="Russian">
</form>
</br>
<form action="CreateServlet">
    <input type="submit" value="Physics">
</form>
</body>
</html>