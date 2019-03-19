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
<script type = "text/javascript">
function isOneChecked() {
	var check = true;
	  // All <input> tags...
	  var chx = document.getElementsByTagName('input');
	  for (var i=0; i<chx.length; i++) {
	    // If you have more than one radio group, also check the name attribute
	    // for the one you want as in && chx[i].name == 'choose'
	    // Return true from the function on first match of a checked item
	    if (chx[i].type == 'radio' && chx[i].checked) {
	      return true;
	    }
	  }
	  // End of the loop, return false
	  alert("check all radiogroups");
	  return false;
	}
</script>
<title>Complete rus test</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-pale-green">
<h1 align = "center"><% out.print(message.getProperty("test.complete.label.rus")); %></h1>
</div>
    <%
        List<String> questions = (ArrayList<String>) request.getAttribute("rusQuestionsList");
        List<String> answers = (ArrayList<String>) request.getAttribute("answersList");
        request.setAttribute("questions", questions);
        request.setAttribute("answers", answers);
    %>
<c:set var="increment" value="0" scope="request" />
<c:set var="button" value="0" scope="request" />
<c:forEach items="${questions}" var="val">
<div class="w3-panel w3-pale-green">
<c:out value="${val}"/>
</div>
<form action="ProcessServlet" method="POST" name="form1" onsubmit="return isOneChecked()">
              <input type="radio" name="rad+${button}" value="a" id="${button}" /> <li><c:out value="${answers[increment]}"/></li>
                            <c:set var="increment" value="${increment+1}" scope="request" />
              <input type="radio" name="rad+${button}" value="b" id="${button}" /> <li><c:out value="${answers[increment]}"/></li>
                            <c:set var="increment" value="${increment+1}" scope="request" />
              <input type="radio" name="rad+${button}" value="c" id="${button}" /> <li><c:out value="${answers[increment]}"/></li>
              <c:set var="increment" value="${increment+1}" scope="request" />
              <c:set var="button" value="${button+1}" scope="request" />       
</c:forEach>
   <input type="submit" value = "Submit" class="w3-button w3-green">
   <input type="hidden" id="thisField" name="sub" value="rus">
 </form>
<form align="right" name="form1" method="post" action="LogoutServlet">
  <label class="logoutLblPos">
  <input name="submit" type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom" value="Log out">
  </label>
</form>
</body>
</html>