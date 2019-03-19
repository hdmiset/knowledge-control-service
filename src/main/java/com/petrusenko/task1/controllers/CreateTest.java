package com.petrusenko.task1.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;
import com.petrusenko.task1.connection.ConnectionPool;
import com.petrusenko.task1.dao.tutor.TutorDAO;
import com.petrusenko.task1.dao.tutor.TutorDAOFactory;
import com.petrusenko.task1.resource.ConfigurationManager;
import com.petrusenko.task1.resource.MessageManager;

/**
 * Servlet implementation class CreateTest
 */
public class CreateTest extends HttpServlet {
private static final long serialVersionUID = 1L;

    final static Logger logger = Logger.getLogger(CreateTest.class);
    
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
    	
    	
    	TutorDAO tutorDAO = new TutorDAOFactory().getTutorDAO("mysql");
    	
    	response.setContentType("text/plain; charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
    	PrintWriter out = response.getWriter();
    	
    	HttpSession userSession = request.getSession();
    	
    	//Get subject value
    	
    	String subject = (String) userSession.getAttribute("sub");
    	
    	//Get selected questions
    	
    	String[] questions = request.getParameterValues("question");
    	
    	String question = "You added question";
    	
    	//Choose subject
    	
        switch(subject) {
        
          case "math": {
        	
        	//Add questions to the test
        	  
        	tutorDAO.updateMath(questions);
        	
        	logger.info("Result is " + questions);
            
            request.setAttribute("mathQuestions", questions);

            break;
        	
          }
        
          case "rus": {
        	  
        	//Add questions to the test
        	
        	tutorDAO.updateRus(questions);
        	
        	logger.info("Result is " + questions);
            
            request.setAttribute("rusQuestions", questions);

            break;
        	
          }
         
           case "physics": {
        	   
        	 //Add questions to the test
         	
         	 tutorDAO.updatePhysics(questions);
         	 
         	 logger.info("Result is " + questions);
             
             request.setAttribute("physicsQuestions", questions);

             break;
         	
         }
        
        
        
        }

    }
}
