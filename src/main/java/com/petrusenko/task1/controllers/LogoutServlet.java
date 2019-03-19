package com.petrusenko.task1.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petrusenko.dao.user.UserDAO;
import com.petrusenko.dao.user.UserDAOFactory;
import com.petrusenko.task1.entities.User;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	//Remove session and forward to start page
    	
    	HttpSession session = request.getSession();
    	session.removeAttribute("username");
    	session.invalidate();
    	RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
        view.forward(request, response);
             
    }

}
