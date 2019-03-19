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
<style>
.w3-myfont {
  font-family: "Comic Sans MS", cursive, sans-serif;
}
</style>
<style>
.logoutLblPos{

   position:fixed;
   right:10px;
   top:5px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin page</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-myfont">
<p align="center" class="w3-xxlarge"><% out.print(message.getProperty("admin.title")); %></p>
</div>
<br>
<h3><% out.print(message.getProperty("admin.choose")); %></h3>
</br>
<br>
<form method="post" action="CreateServlet">
    <input type="submit" name="sub" value="Math" class="w3-btn w3-green w3-round-large w3-margin-bottom">
</form>
</br>
<form action="CreateServlet">
    <input type="submit" name="sub" value="Russian" class="w3-btn w3-green w3-round-large w3-margin-bottom">
</form>
<br>
<form action="CreateServlet">
    <input type="submit" name="sub" value="Physics" class="w3-btn w3-green w3-round-large w3-margin-bottom">
</br>
</form>
 <form align="right" name="form1" method="post" action="LogoutServlet">
  <label class="logoutLblPos">
  <input name="submit" type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom" value="Log out">
  </label>
</form>
</body>
</html>