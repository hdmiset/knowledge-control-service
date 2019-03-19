package com.petrusenko.task1.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		// Output Student's name

    String userName = request.getParameter("userName");

    if (userName.equals("")) {
            userName = "User name cannot be empty";
    } else {
            userName = "Good job " + userName;
    }
    response.setContentType("text/plain");
    response.getWriter().write(userName);
}

}

