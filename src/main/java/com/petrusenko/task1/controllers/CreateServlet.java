package com.petrusenko.task1.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.petrusenko.task1.connection.ConnectionPool;
import com.petrusenko.task1.dao.question.QuestionDAO;
import com.petrusenko.task1.dao.question.QuestionDAOFactory;
import com.petrusenko.task1.dao.tutor.TutorDAO;
import com.petrusenko.task1.dao.tutor.TutorDAOFactory;
import com.petrusenko.task1.resource.ConfigurationManager;
import com.petrusenko.task1.resource.MessageManager;

/**
 * Servlet implementation class CreateServlet
 */

public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(CreateServlet.class);
    
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
    	
    	PrintWriter out = response.getWriter();

        TutorDAO tutorDAO = new TutorDAOFactory().getTutorDAO("mysql");
        
        //Get subject value
        
        String subject = (String)request.getParameter("sub");
        
        out.println(subject);
        
        switch(subject) {
        
        case "Math": {
        	
        	//Get questions list from db
        	
        	List<String> questions = (ArrayList) tutorDAO.chooseMath();
        	
        	logger.info("Result is " + questions);
            
            request.setAttribute("mathQuestions", questions);
            
            //forward to math page

            RequestDispatcher view = request.getRequestDispatcher("create_math.jsp");
            //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
            view.forward(request, response);
            break;
        	
        }
        
         case "Russian": {
        	 
        	//Get questions list from db
        	
        	List<String> questions = (ArrayList)tutorDAO.chooseRus();
        	
        	logger.info("Result is " + questions);
            
            request.setAttribute("rusQuestions", questions);
            
            //forward to russian page

            RequestDispatcher view = request.getRequestDispatcher("create_rus.jsp");
            //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
            view.forward(request, response);
            break;
        	
        }
         
         case "Physics": {
        	 
        	//Get questions list from db
         	
         	List<String> questions = (ArrayList)tutorDAO.choosePhysics();
         	
         	logger.info("Result is " + questions);
             
             request.setAttribute("physicsQuestions", questions);
             
             //forward to physics page

             RequestDispatcher view = request.getRequestDispatcher("create_physics.jsp");
             //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
             view.forward(request, response);
             break;
         	
         }
        
        
        
        }
        
    }
	

}
