package com.petrusenko.task1.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.petrusenko.dao.user.UserDAO;
import com.petrusenko.dao.user.UserDAOFactory;
import com.petrusenko.task1.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	
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
    	
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");
    		
       
	UserDAO userDAO = new UserDAOFactory().getUserDAO("mysql");
	
	PrintWriter out = response.getWriter();
	
	//Get name and password from form
	
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	
	if(name.equals("admin") && pass.equals("admin")) {
		
		//Create session and forward to admin page
		
		logger.info("Result is " + name);
		
        HttpSession session = request.getSession();
		session.setAttribute("currentSessionAdmin", name);
		RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
        //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
        view.forward(request, response);
		
	}
	
	else {
		
		User user = new User(name, pass);
		user.setName(name);
		user.setPassword(pass);
		
		userDAO.checkUser(user);
		
		if(user.isValid()) {
			
			//Create session and forward to student page
			
			logger.info("Result is " + name);
			
			HttpSession session = request.getSession();
			session.setAttribute("currentSessionUser", name);
			RequestDispatcher view = request.getRequestDispatcher("test_complete.jsp");
	        //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
	        view.forward(request, response);
		
	}
		
		else {
			
			RequestDispatcher view = request.getRequestDispatcher("login_error.jsp");
	        //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
	        view.forward(request, response);
	
		}
		
	}
	
    }
    
}
         


