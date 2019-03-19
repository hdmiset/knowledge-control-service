<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.petrusenko.task1.resource.MessageManager" %>
<%@ page isELIgnored="false" %>
<%
   //Get the client's Locale
   MessageManager message = new MessageManager();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.logoutLblPos{

   position:fixed;
   right:10px;
   top:5px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose test to complete</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<h1 align="center"><% out.print(message.getProperty("test.complete.title")); %></h1>
<% String currentUser = (String)(session.getAttribute("currentSessionUser"));%>
<br><% out.print(message.getProperty("test.complete.welcome")); %> <div class="w3-panel w3-pale-green"> <%=currentUser%> </div> </br>
<h2 align = "center"><% out.print(message.getProperty("test.complete.choose")); %></h2>
<center>
<form method="POST" action="CompleteServlet">
    <input type="submit" name="sub" value="Math" class="w3-button w3-blue-grey">
</form>
<br><form method="POST" action="CompleteServlet">
    <input type="submit" name="sub" value="Rus" class="w3-button w3-blue-grey">
</form>
</br>
<form method="POST" action="CompleteServlet">
    <input type="submit" name="sub" value="Physics" class="w3-button w3-blue-grey">
</form>
<form align="right" name="form1" method="post" action="LogoutServlet">
  <label class="logoutLblPos">
  <input name="submit" type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom" value="Log out">
  </label>
</form>
</center>
</body>
</html>