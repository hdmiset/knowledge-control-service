<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Math test</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript">
function validateform(){
	var checkboxs=document.getElementsByName("question");
    var okay=false;
    for(var i=0,l=checkboxs.length;i<l;i++)
    {
        if(checkboxs[i].checked)
        {
            okay=true;
            break;
        }
    }
    if(okay)alert("Questions added to the database");
    else alert("Please choose at least 1 question");
    return false; 
}
</script>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue">
<h1 align = "center"><% out.print(message.getProperty("admin.create.rus")); %></h1>
</div>
<div class="w3-panel w3-blue w3-card-4">
<% out.print(message.getProperty("admin.choose.rus")); %>
</div>
    <%
        List<String> questions = (ArrayList<String>) request.getAttribute("rusQuestions");
        request.setAttribute("questions", questions);
    %>
<%String subject = "rus"; %>
<%session.setAttribute("sub",subject); %>
<form action="CreateTest" method="POST" name="form1" onsubmit="return validateform()">
<c:set var="button" value="0" scope="request" />
<c:forEach items="${questions}" var="val">
  <input type="checkbox" name="question" value="${button}">
   <label for="check+${button}"><div class="w3-panel w3-leftbar w3-border-blue w3-pale-blue"><c:out value="${val}"/></div></label><br>
   <c:set var="button" value="${button+1}" scope="request" />
</c:forEach>
<input type="submit" value = "<% out.print(message.getProperty("admin.button")); %>" class="w3-button w3-green">
 </form>
 <form align="right" name="form1" method="post" action="LogoutServlet">
  <label class="logoutLblPos">
  <input name="submit" type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom" value="Log out">
  </label>
</form>
</body>
</html>