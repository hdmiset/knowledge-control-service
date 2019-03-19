package com.petrusenko.task1.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;
import com.petrusenko.task1.connection.ConnectionPool;
import com.petrusenko.task1.dao.question.QuestionDAO;
import com.petrusenko.task1.dao.question.QuestionDAOFactory;
import com.petrusenko.task1.dao.tutor.TutorDAO;
import com.petrusenko.task1.dao.tutor.TutorDAOFactory;
import com.petrusenko.task1.resource.ConfigurationManager;
import com.petrusenko.task1.resource.MessageManager;

/**
 * Servlet implementation class CompleteServlet
 */
public class CompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(CompleteServlet.class);
       
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
    	
    	QuestionDAO questionDAO = new QuestionDAOFactory().getQuestionDAO("mysql");
    	
    	//Get subject value
    	
        String subject = (String)request.getParameter("sub");
        
        switch(subject) { 
        
        case "Math": {
        	
        	//Get questions from math test
        	
        	List<List<String>> result = (ArrayList<List<String>>)questionDAO.readMath();
    		
    		List<String> questions_list = (ArrayList<String>)result.get(0); 
    		List<String> answers_list = (ArrayList<String>)result.get(1);
    		
    		logger.info("Result is " + questions_list);
    		logger.info("Result is " + answers_list);
    		
    		//Set questions and answers as attribute
    		
    		request.setAttribute("mathQuestionsList", questions_list);
     		request.setAttribute("answersList", answers_list);
     		
     		logger.debug("This is debug message");
     		
     		//forward to math page

            RequestDispatcher view = request.getRequestDispatcher("complete_math.jsp");
            //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
            view.forward(request, response);
        	break;
        	
        }
        
        case "Rus": {
        	
        	//Get questions from rus test
        	
        	List<List<String>> result = (ArrayList<List<String>>)questionDAO.readRus();
        	
        	List<String> questions_list = (ArrayList<String>)result.get(0); 
    		List<String> answers_list = (ArrayList<String>)result.get(1);
    		
    		//Set questions and answers as attribute
        	
        	request.setAttribute("rusQuestionsList", questions_list);
    		request.setAttribute("answersList", answers_list);
    		
    		//forward to rus page

            RequestDispatcher view = request.getRequestDispatcher("complete_rus.jsp");
            //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
            view.forward(request, response);
        	break;
        	
        }
        
        case "Physics": {
        	
        	//Get questions from physics test
        	
        	List<List<String>> result = (ArrayList<List<String>>)questionDAO.readPhysics();
        	
        	List<String> questions_list = (ArrayList<String>)result.get(0); 
    		List<String> answers_list = (ArrayList<String>)result.get(1);
    		
    		//Set questions and answers as attribute
        	
        	request.setAttribute("physicsQuestionsList", questions_list);
    		request.setAttribute("answersList", answers_list);
    		
    		//forward to physics page

            RequestDispatcher view = request.getRequestDispatcher("complete_physics.jsp");
            //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
            view.forward(request, response);
        	break;
        	
        }
        
        }
        
    }
    
}
