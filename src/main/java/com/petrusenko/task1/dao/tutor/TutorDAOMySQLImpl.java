package com.petrusenko.task1.dao.tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.sql.DataSource;

import com.petrusenko.task1.connection.ConnectionPool;
import com.petrusenko.task1.dao.question.QuestionDAO;
import com.petrusenko.task1.dao.question.QuestionDAOFactory;
import com.petrusenko.task1.resource.ConfigurationManager;
import com.petrusenko.task1.resource.MessageManager;

public class TutorDAOMySQLImpl implements TutorDAO {
	
	MessageManager message = new MessageManager();
	
	Scanner sc = new Scanner(System.in);
	
	//Get Math questions from db
	
	public List<String> chooseMath() {
		
		List<String> questions = new ArrayList<>();

		ResultSet rsObj = null;
        Connection connObj = null;
        PreparedStatement pstmtObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();

		try {
			
			DataSource dataSource = jdbcObj.setUpPool();
			
			connObj = dataSource.getConnection();
			
			pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("choose.math"));
        	pstmtObj.setString(1, Locale.getDefault().getLanguage());
        	pstmtObj.setString(2, Locale.getDefault().getLanguage());
            rsObj = pstmtObj.executeQuery();
            while (rsObj.next()) {
            	
            	questions.add(rsObj.getString("question"));
                
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
		
		return questions;

	}
	
	//Get Rus questions from db
	
     public List<String> chooseRus() {
		
		List<String> questions = new ArrayList<>();

		ResultSet rsObj = null;
        Connection connObj = null;
        PreparedStatement pstmtObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();

		try {
			
			DataSource dataSource = jdbcObj.setUpPool();
			
			connObj = dataSource.getConnection();

			pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("choose.russian"));
			pstmtObj.setString(1, Locale.getDefault().getLanguage());
        	pstmtObj.setString(2, Locale.getDefault().getLanguage());
            rsObj = pstmtObj.executeQuery();
            while (rsObj.next()) {
            	
            	questions.add(rsObj.getString("question"));
                
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
		
		return questions;

	}
     
   //Get Physics questions from db

    public List<String> choosePhysics() {
	
	List<String> questions = new ArrayList<>();

	ResultSet rsObj = null;
    Connection connObj = null;
    PreparedStatement pstmtObj = null;
    ConnectionPool jdbcObj = new ConnectionPool();

	try {
		
		DataSource dataSource = jdbcObj.setUpPool();
		
		connObj = dataSource.getConnection();
		
		pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("choose.physics"));
    	pstmtObj.setString(1, Locale.getDefault().getLanguage());
    	pstmtObj.setString(2, Locale.getDefault().getLanguage());
        rsObj = pstmtObj.executeQuery();
        while (rsObj.next()) {
        	
        	questions.add(rsObj.getString("question"));
            
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
	
	return questions;

}

    
    //Add selected question to mathtable
	
	public void updateMath(String[] questions) {
		
		final String SQLe = ConfigurationManager.getProperty("insert.mathtable");
		
		ResultSet rsObj = null;
        Connection connObj = null;
        PreparedStatement pstmtObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
		
		List<String> questions_list = (ArrayList<String>)chooseMath();
   	 
   	 if(questions != null) {
   	 
   	 for(String s : questions) {
   		 
   		 int a = Integer.parseInt(s);
   		 String question = questions_list.get(a);
   		 
   		 
   		 try {
   	         	
   	         	DataSource dataSource = jdbcObj.setUpPool();
   	  
   	             // Database action
   	             connObj = dataSource.getConnection();
   		    	
   		        pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("select.questionslist"));
   				 pstmtObj.setString(1, question);
   				 pstmtObj.setString(2, Locale.getDefault().getLanguage());
   				 rsObj = pstmtObj.executeQuery();
   				 while (rsObj.next()) {
   					 pstmtObj.setString(1,question);
   					 pstmtObj = connObj.prepareStatement(SQLe);
   					 String s1 = rsObj.getString("question");
   					 String s2 = rsObj.getString("answer1");
   					 String s3 = rsObj.getString("answer2");
   					 String s4 = rsObj.getString("answer3");
   					 String s5 = rsObj.getString("correct");
   					 pstmtObj.setString(1,s1);
   					 pstmtObj.setString(2,s2);
   					 pstmtObj.setString(3,s3);
   					 pstmtObj.setString(4,s4);
   					 pstmtObj.setString(5,s5);
   					 pstmtObj.executeUpdate();	        
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
		
	}
	
	//Add selected question to rustable
	
    public void updateRus(String[] questions) {
		
		final String SQLe = ConfigurationManager.getProperty("insert.russiantable");
		
		ResultSet rsObj = null;
        Connection connObj = null;
        PreparedStatement pstmtObj = null;
        ConnectionPool jdbcObj = new ConnectionPool();
		
		List<String> questions_list = (ArrayList<String>)chooseRus();
   	 
   	 if(questions != null) {
   	 
   	 for(String s : questions) {
   		 
   		 int a = Integer.parseInt(s);
   		 String question = questions_list.get(a);
   		 
   		 
   		 try {
   	         	
   	         	DataSource dataSource = jdbcObj.setUpPool();
   	  
   	             // Database action
   	             connObj = dataSource.getConnection();
   		    	
   		        pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("select.questionslist"));
   				 pstmtObj.setString(1, question);
   				 pstmtObj.setString(2, Locale.getDefault().getLanguage());
   				 rsObj = pstmtObj.executeQuery();
   				 while (rsObj.next()) {
   					 pstmtObj.setString(1,question);
   					 pstmtObj = connObj.prepareStatement(SQLe);
   					 String s1 = rsObj.getString("question");
   					 String s2 = rsObj.getString("answer1");
   					 String s3 = rsObj.getString("answer2");
   					 String s4 = rsObj.getString("answer3");
   					 String s5 = rsObj.getString("correct");
   					 pstmtObj.setString(1,s1);
   					 pstmtObj.setString(2,s2);
   					 pstmtObj.setString(3,s3);
   					 pstmtObj.setString(4,s4);
   					 pstmtObj.setString(5,s5);
   					 pstmtObj.executeUpdate();	        
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
		
	}
    
    //Add selected question to physicstable

    public void updatePhysics(String[] questions) {
	
	   final String SQLe = ConfigurationManager.getProperty("insert.physicstable");
	
	   ResultSet rsObj = null;
       Connection connObj = null;
       PreparedStatement pstmtObj = null;
       ConnectionPool jdbcObj = new ConnectionPool();
	
	   List<String> questions_list = (ArrayList<String>)choosePhysics();
	 
	 if(questions != null) {
	 
	 for(String s : questions) {
		 
		 int a = Integer.parseInt(s);
		 String question = questions_list.get(a);
		 
		 
		 try {
	         	
	         	DataSource dataSource = jdbcObj.setUpPool();
	  
	             // Database action
	             connObj = dataSource.getConnection();
		    	
		        pstmtObj = connObj.prepareStatement(ConfigurationManager.getProperty("select.questionslist"));
				 pstmtObj.setString(1, question);
				 pstmtObj.setString(2, Locale.getDefault().getLanguage());
				 rsObj = pstmtObj.executeQuery();
				 while (rsObj.next()) {
					 pstmtObj.setString(1,question);
					 pstmtObj = connObj.prepareStatement(SQLe);
					 String s1 = rsObj.getString("question");
					 String s2 = rsObj.getString("answer1");
					 String s3 = rsObj.getString("answer2");
					 String s4 = rsObj.getString("answer3");
					 String s5 = rsObj.getString("correct");
					 pstmtObj.setString(1,s1);
					 pstmtObj.setString(2,s2);
					 pstmtObj.setString(3,s3);
					 pstmtObj.setString(4,s4);
					 pstmtObj.setString(5,s5);
					 pstmtObj.executeUpdate();	        
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
	
}

}
