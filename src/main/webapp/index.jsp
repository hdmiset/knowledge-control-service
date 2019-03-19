<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.petrusenko.task1.resource.MessageManager" %>

<%
   //Get the client's Locale
   MessageManager message = new MessageManager();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web application</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<h1 align = "center"><% out.print(message.getProperty("index.title")); %></h1>
<form action="login.jsp">
    <input type="submit" value="<% out.print(message.getProperty("index.login")); %>" class="w3-btn w3-green w3-round-large w3-margin-bottom">
</form>
<form action="registration.jsp">
    <input type="submit" value="<% out.print(message.getProperty("index.signup")); %>" class="w3-btn w3-green w3-round-large w3-margin-bottom">
</form>
</body>
</html>