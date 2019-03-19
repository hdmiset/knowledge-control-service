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
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(RegServlet.class);
     
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
    	
    	//Get parameters from jsp
    	
    	String name = request.getParameter("name");
    	String pass = request.getParameter("pass");
    	
    	//Check for admin status
    	
    	if(name.equals("admin") && pass.equals("admin")) {
    		
    		RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
            //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
            view.forward(request, response);
    		
    	}
    	
    	else {
    		
    		User user = new User(name, pass);
    		user.setName(name);
    		user.setPassword(pass);
    		
    		userDAO.addUser(user);
    		
    		// Create session and forward to test page
    		
    		HttpSession session = request.getSession();
    		session.setAttribute("currentSessionUser", name);
    		RequestDispatcher view = request.getRequestDispatcher("test_complete.jsp");
            //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
            view.forward(request, response);
    		
    	}
             
    }

}
