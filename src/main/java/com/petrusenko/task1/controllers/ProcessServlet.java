package com.petrusenko.task1.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

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

import com.google.gson.*;

/**
 * Servlet implementation class ProcessServlet
 */
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger = Logger.getLogger(ProcessServlet.class);
    
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
	    
    	QuestionDAO questionDAO = new QuestionDAOFactory().getQuestionDAO("mysql");
        
        PrintWriter out = response.getWriter();
        
        //Choose subject
        
        String subject = request.getParameter("sub");
        		
        		switch(subject) {
        		
        		case "math": {
        			
        			List<String> answers = new ArrayList<>();
        			List<String> results = new ArrayList<>();
        			
        			//Get parametres from jsp
        			
        			 Enumeration e =request.getParameterNames();
        		        while(e.hasMoreElements()) {
        		        	
        		        	String radio = (String)e.nextElement();
        		        	  if(radio.startsWith("rad")) {
        		        		String rad = request.getParameter(radio);    		        
        		        		answers.add(rad);
        		        			
        			
        		}
        		        	  
        		        }
        		        
        		        // Check student's choose and forward to result page
        		        
        		        results = (ArrayList)questionDAO.checkMath(answers);
        		        
        		        String json = new Gson().toJson(results);
        		        
        		        logger.info("Result is " + answers);
        		        
        		        request.setAttribute("answers", results);
            		    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
                        //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
                        view.forward(request, response);
        		        
        		}
        		        	  
        		        	  break;
        		
                case "rus": {
                	
                	List<String> answers = new ArrayList<>();
        			List<String> results = new ArrayList<>();
        			
        			//Get parametres from jsp
        			
                	 Enumeration e =request.getParameterNames();
                        while(e.hasMoreElements()) {
                     	
                     String radio = (String)e.nextElement();
                       if(radio.startsWith("rad")) {
                    	   String rad = request.getParameter(radio);
   		        		   answers.add(rad);         
        			
        		}
                        }
                        
                        // Check student's choose and forward to result page
                        
                        results = (ArrayList)questionDAO.checkRus(answers);
                        
                        logger.info("Result is " + answers);
                        
                        request.setAttribute("answers", results);
            		    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
                        //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
                        view.forward(request, response);
                        
                }
                       
                       break;
                
                case "physics": {
                	
                	List<String> answers = new ArrayList<>();
        			List<String> results = new ArrayList<>();
        			
        			//Get parametres from jsp
        			
                    Enumeration e =request.getParameterNames();
                     while(e.hasMoreElements()) {
                     	
                     String radio = (String)e.nextElement();
                       if(radio.startsWith("rad")) {
                          String rad = request.getParameter(radio);
                          answers.add(rad);
        			
        		}
        		
        		      }
                     
                     // Check student's choose and forward to result page
                     
                     results = (ArrayList)questionDAO.checkPhysics(answers);
                     
                     logger.info("Result is " + answers);
                     
                     request.setAttribute("answers", results);
         		     RequestDispatcher view = request.getRequestDispatcher("result.jsp");
                     //Use the request dispatcher to ask the Container to crank up the JSP, sending it the request and response.
                     view.forward(request, response);
                     
                }
                     
                     break;
        		
        	}
        	
        }		 
   			 
   		 
   	 }
   		 

