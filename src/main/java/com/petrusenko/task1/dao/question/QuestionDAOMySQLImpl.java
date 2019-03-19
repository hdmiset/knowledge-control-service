package com.petrusenko.task1.dao.question;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import com.petrusenko.task1.connection.ConnectionPool;
import com.petrusenko.task1.dao.tutor.TutorDAO;
import com.petrusenko.task1.dao.tutor.TutorDAOFactory;
import com.petrusenko.task1.resource.ConfigurationManager;
import com.petrusenko.task1.resource.MessageManager;

public class QuestionDAOMySQLImpl implements QuestionDAO {
	
	MessageManager message = new MessageManager();
	
	TutorDAO tutorDAO = new TutorDAOFactory().getTutorDAO("mysql");
	
	//Get mathquestions from test
	
	public List<List<String>> readMath() {
		
		ResultSet rsObj = null;
		Statement stmt = null;
	    Connection connObj = null;
	    PreparedStatement pstmtObj = null;
	    ConnectionPool jdbcObj = new ConnectionPool();
	    
	    List<String> questions_list = new ArrayList<String>();
	    List<String> answers_list = new ArrayList<String>();
		
try {
        	       	
        	DataSource dataSource = jdbcObj.setUpPool();
 
        	// Database Action
            connObj = dataSource.getConnection();
		 
		 // Choose test and student's answer
	
			 pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("select.mathtable"));
			 rsObj = pstmtObj.executeQuery();
			 while (rsObj.next()) {
				 
				 String ans = rsObj.getString("correct");
	                questions_list.add(rsObj.getString("question"));
	                answers_list.add(rsObj.getString("answer1"));
	                answers_list.add(rsObj.getString("answer2"));
	                answers_list.add(rsObj.getString("answer3"));
	                
	            }
			 
        } catch(Exception sqlException) {

            sqlException.printStackTrace();
        } finally {
            try {
            	// Closing ResultSet Object
                if(rsObj != null) {
                    rsObj.close();
                }
                // Closing PreparedStatement Object
                if(pstmtObj != null) {
                    pstmtObj.close();
                }
                // Closing Connection Object
                if(connObj != null) {
                    connObj.close();
                }
            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }
        }

          List<List<String>> result = new ArrayList<List<String>>();
          result.add(questions_list);
          result.add(answers_list);
          return result;
		
	}
	
	//Get rusquestions from test
	
	public List<List<String>> readRus() {
		
		ResultSet rsObj = null;
		Statement stmt = null;
	    Connection connObj = null;
	    PreparedStatement pstmtObj = null;
	    ConnectionPool jdbcObj = new ConnectionPool();
	    
	    List<String> questions_list = new ArrayList<>();
	    List<String> answers_list = new ArrayList<>();
		
try {
	
        	       	
        	DataSource dataSource = jdbcObj.setUpPool();
 
        	// Database Action
            connObj = dataSource.getConnection();
		 
		 // Choose test and student's answer
	
			 pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("select.russiantable"));
			 rsObj = pstmtObj.executeQuery();
			 while (rsObj.next()) {
				 
				 String ans = rsObj.getString("correct");
	                questions_list.add(rsObj.getString("question"));
	                answers_list.add(rsObj.getString("answer1"));
	                answers_list.add(rsObj.getString("answer2"));
	                answers_list.add(rsObj.getString("answer3"));
	                
	            }
			 
        } catch(Exception sqlException) {

            sqlException.printStackTrace();
        } finally {
            try {
            	// Closing ResultSet Object
                if(rsObj != null) {
                    rsObj.close();
                }
                // Closing PreparedStatement Object
                if(pstmtObj != null) {
                    pstmtObj.close();
                }
                // Closing Connection Object
                if(connObj != null) {
                    connObj.close();
                }
            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }
        }

         List<List<String>> result = new ArrayList<List<String>>();
         result.add(questions_list);
         result.add(answers_list);
         return result;
		
	}
	
	//Get physicsquestions from test
	
	public List<List<String>> readPhysics() {
		
		ResultSet rsObj = null;
		Statement stmt = null;
	    Connection connObj = null;
	    PreparedStatement pstmtObj = null;
	    ConnectionPool jdbcObj = new ConnectionPool();
	    
	    List<String> questions_list = new ArrayList<>();
	    List<String> answers_list = new ArrayList<>();
		
try {
        	       	
        	DataSource dataSource = jdbcObj.setUpPool();
 
        	// Database Action
            connObj = dataSource.getConnection();
		 
		 // Choose test and student's answer
	
			 pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("select.physicstable"));
			 rsObj = pstmtObj.executeQuery();
			 while (rsObj.next()) {
				 
				 String ans = rsObj.getString("correct");
	                questions_list.add(rsObj.getString("question"));
	                answers_list.add(rsObj.getString("answer1"));
	                answers_list.add(rsObj.getString("answer2"));
	                answers_list.add(rsObj.getString("answer3"));
	                
	            }
			 
        } catch(Exception sqlException) {

            sqlException.printStackTrace();
        } finally {
            try {
            	// Closing ResultSet Object
                if(rsObj != null) {
                    rsObj.close();
                }
                // Closing PreparedStatement Object
                if(pstmtObj != null) {
                    pstmtObj.close();
                }
                // Closing Connection Object
                if(connObj != null) {
                    connObj.close();
                }
            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }
        }

           List<List<String>> result = new ArrayList<List<String>>();
           result.add(questions_list);
           result.add(answers_list);
           return result;
		
	}
	
	//Compare correct math answer and  users's answer
	
	public List<String> checkMath(List<String> rad) {
		
		
		String correct = "";
		
		String answer = "";
		
		List<String> answers = new ArrayList<>();
		
		List<String> list = new ArrayList<>();
		
		ResultSet rsObj = null;
		Statement stmt = null;
	    Connection connObj = null;
	    PreparedStatement pstmtObj = null;
	    ConnectionPool jdbcObj = new ConnectionPool();
		
		try {
 			 
	         	
	         	DataSource dataSource = jdbcObj.setUpPool();
	  
	             // Database action
	             connObj = dataSource.getConnection();
		    	
		        pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("select.mathcorrect"));
				 rsObj = pstmtObj.executeQuery();
				 while (rsObj.next()) {
					 correct = rsObj.getString("correct");
					 
					 list.add(correct);
					 
					 
		            }
				
				 }
	  catch(Exception sqlException) {

	 sqlException.printStackTrace();
	} finally {
	 try {
	 	// Closing ResultSet Object
	     if(rsObj != null) {
	         rsObj.close();
	     }
	     // Closing PreparedStatement Object
	     if(pstmtObj != null) {
	         pstmtObj.close();
	     }
	     // Closing Connection Object
	     if(connObj != null) {
	         connObj.close();
	     }
	 } catch(Exception sqlException) {
	     sqlException.printStackTrace();
	 }
	}
		
		for(int i=0;i<rad.size();i++)
		
		if(list.get(i).equals(rad.get(i))) {
			 
			 answers.add(message.getProperty("question.answer") + " " + i + " " + message.getProperty("question.answer1"));
			 
		 }
		 
		 else {
			 
			 answers.add(message.getProperty("question.answer.wrong") + " " + i + " " + message.getProperty("question.answer1"));
			 
		 }
	    
	    return answers;
	    
	}
	
	//Compare correct rus answer and  users's answer
	
	public List<String> checkRus(List<String> rad) {
		
        String correct = "";
		
		String answer = "";
		
		List<String> answers = new ArrayList<>();
		
		List<String> list = new ArrayList<>();
		
		ResultSet rsObj = null;
		Statement stmt = null;
	    Connection connObj = null;
	    PreparedStatement pstmtObj = null;
	    ConnectionPool jdbcObj = new ConnectionPool();
		
		try {
 			 
	         	
	         	DataSource dataSource = jdbcObj.setUpPool();
	  
	             // Database action
	             connObj = dataSource.getConnection();
		    	
		        pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("select.ruscorrect"));
				 rsObj = pstmtObj.executeQuery();
				 while (rsObj.next()) {
					 correct = rsObj.getString("correct");
					 list.add(correct);
					 
		            }
	 
	} catch(Exception sqlException) {

	 sqlException.printStackTrace();
	} finally {
	 try {
	 	// Closing ResultSet Object
	     if(rsObj != null) {
	         rsObj.close();
	     }
	     // Closing PreparedStatement Object
	     if(pstmtObj != null) {
	         pstmtObj.close();
	     }
	     // Closing Connection Object
	     if(connObj != null) {
	         connObj.close();
	     }
	 } catch(Exception sqlException) {
	     sqlException.printStackTrace();
	 }
	}
		
		for(int i=0;i<rad.size();i++)
			
			if(list.get(i).equals(rad.get(i))) {
				 
				answers.add(message.getProperty("question.answer") + " " + i + " " + message.getProperty("question.answer1"));
				 
			 }
			 
			 else {
				 
				 answers.add(message.getProperty("question.answer.wrong") + " " + i + " " + message.getProperty("question.answer1"));
				 
			 }
		
		return answers;	
		
	}
	
	//Compare correct physics answer and  users's answer
	
	public List<String> checkPhysics(List<String> rad) {
		
        String correct = "";
		
		String answer = "";
		
		List<String> answers = new ArrayList<>();
		
		List<String> list = new ArrayList<>();
		
		ResultSet rsObj = null;
		Statement stmt = null;
	    Connection connObj = null;
	    PreparedStatement pstmtObj = null;
	    ConnectionPool jdbcObj = new ConnectionPool();
		
		try {
	         	
	        DataSource dataSource = jdbcObj.setUpPool();
	  
	             // Database action
	        connObj = dataSource.getConnection();
		    	
		    pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("select.physicscorrect"));
			rsObj = pstmtObj.executeQuery();
			while (rsObj.next()) {
				correct = rsObj.getString("correct");
				list.add(correct);
					 
		            }
	 
	} catch(Exception sqlException) {

	 sqlException.printStackTrace();
	} finally {
	 try {
	 	// Closing ResultSet Object
	     if(rsObj != null) {
	         rsObj.close();
	     }
	     // Closing PreparedStatement Object
	     if(pstmtObj != null) {
	         pstmtObj.close();
	     }
	     // Closing Connection Object
	     if(connObj != null) {
	         connObj.close();
	     }
	 } catch(Exception sqlException) {
	     sqlException.printStackTrace();
	 }
	}
		
for(int i=0;i<rad.size();i++)
			
			if(list.get(i).equals(rad.get(i))) {
				 
				answers.add(message.getProperty("question.answer") + " " + i + " " + message.getProperty("question.answer1"));
				 
			 }
			 
			 else {
				 
				 answers.add(message.getProperty("question.answer.wrong") + " " + i + " " + message.getProperty("question.answer1"));
				 
			 }
		
		return answers;
		
	}
    
}
