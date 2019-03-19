package com.petrusenko.dao.user;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import com.petrusenko.task1.connection.ConnectionPool;
import com.petrusenko.task1.entities.User;
import com.petrusenko.task1.resource.ConfigurationManager;

public class UserDAOMySQLImpl implements UserDAO {
	
	 public void addUser(User user) {
		 
		 final String SQLe = "INSERT users(name, password) VALUES (?, ?)";

		 String username = user.getName();
		 String pass = user.getPassword();
		 
		 ResultSet rsObj = null;
			Statement stmt = null;
	        Connection connObj = null;
	        PreparedStatement pstmtObj = null;
	        ConnectionPool jdbcObj = new ConnectionPool();
	        		
	try {
	      			 
	      	         	
	      	         	DataSource dataSource = jdbcObj.setUpPool();
	      	  
	      	             // Database action
	      	             connObj = dataSource.getConnection();
	      	      
	   		        pstmtObj = connObj.prepareStatement(SQLe);
	   				 pstmtObj.setString(1, username);
	   				 pstmtObj.setString(2, pass);
	   				 pstmtObj.executeUpdate();
	      		    	
	      		       
	      	 
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
		 
	 }
	 
public void checkUser(User user) {
		 
		 final String SQLe = "SELECT name, password FROM users WHERE name = ? AND password = ?";
		 
		 String username = user.getName();
		 String pass = user.getPassword();

		 
		 ResultSet rsObj = null;
	     Statement stmt = null;
	     Connection connObj = null;
	     PreparedStatement pstmtObj = null;
	     ConnectionPool jdbcObj = new ConnectionPool();
	        		
	try {
	      			 
	      	         	
	        DataSource dataSource = jdbcObj.setUpPool();
	      	  
	      	             // Database action
	      	connObj = dataSource.getConnection();
	      	      
	   		pstmtObj = connObj.prepareStatement(SQLe);
	   	    pstmtObj.setString(1, username);
	   		pstmtObj.setString(2, pass);
	   		rsObj = pstmtObj.executeQuery();
	   				 
	   			if(rsObj.next()) {
	   	            	
	   				user.setValid(true); 
	   	            
	   			}
	   				
	   				else {
	   					
	   					user.setValid(false);		
	   					
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
		 
	 }

	        
	 } 
	 
