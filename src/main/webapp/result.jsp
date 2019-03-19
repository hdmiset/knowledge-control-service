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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Results</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript">
//Get XMLHTTP Object
function getXMLHTTPObject() {
        var xmlhttpObject = null;
        try {
                // For Old Microsoft Browsers
                xmlhttpObject = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
                try {
                        // For Microsoft IE 6.0+
                        xmlhttpObject = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e1) {
                        // No Browser accepts the XMLHTTP Object then false
                        xmlhttpObject = false;
                }
        }
        if (!xmlhttpObject && typeof XMLHttpRequest != 'undefined') {
                // For Mozilla, Opera Browsers
                xmlhttpObject = new XMLHttpRequest();
        }
        // Mandatory Statement returning the ajax object created
        return xmlhttpObject;
}

// Change the value of the outputText field
function setAjaxOutput() {
        document.getElementById('ajaxResponse').innerHTML = xmlhttpObject.responseText;
}

function handleServerResponse() {
        if (xmlhttpObject.readyState == 4) {
                if (xmlhttpObject.status == 200) {
                        setAjaxOutput();
                } else {
                        alert("Error during AJAX call. Please try again");
                }
        }
}

// Implement business logic
function doAjaxCall() {
        xmlhttpObject = getXMLHTTPObject();
        if (xmlhttpObject != null) {
                var URL = "AjaxServlet?userName="
                                + document.getElementById('userName').value;
                xmlhttpObject.open("POST", URL, true);
                xmlhttpObject.send(null);
                xmlhttpObject.onreadystatechange = handleServerResponse;
        }
}
</script>
</head>
<body class="w3-light-grey">
<% out.print(message.getProperty("results")); %>
    <%
        List<String> answers = (ArrayList<String>) request.getAttribute("answers");
    %>
<c:forEach items="${answers}" var="val">
<li><c:out value="${val}"/></li>
</c:forEach>
        <br />
        <div id="ajaxResponse" style="color: red; font-weight: bold"></div>
        <br /> Please Enter your Name :
        <input type="text" id="userName" onblur="doAjaxCall();" />
        <br />
</body>
</html>