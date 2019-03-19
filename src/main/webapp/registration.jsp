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
<meta charset="UTF-8">
<title>Web application</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript">
function validateform(){  
	var name=document.myform.name.value;  
	var password=document.myform.pass.value;  
	  
	if (name==null || name==""){  
	  alert("Name can't be blank");  
	  return false;  
	}else if(password.length<6){  
	  alert("Password must be at least 6 characters long.");  
	  return false;  
	  }  
	}
</script>
</head>
<body class="w3-light-grey">
<h1 align = "center"><% out.print(message.getProperty("reg.label.title")); %></h1>
<form name = "myform" method="post" action = "RegServlet" onsubmit="return validateform()">
    <label><% out.print(message.getProperty("reg.label.username")); %>
        <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large" id="a" style="width: 30%"><br />
    </label>

    <label><% out.print(message.getProperty("reg.label.password")); %>
        <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" id="b" style="width: 30%"><br />
    </label>
    <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom"><% out.print(message.getProperty("reg.sumbit.name")); %></button>
</form>
</body>
</html>