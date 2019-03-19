package com.petrusenko.task1.dao.question;

public class QuestionDAOFactory {
	
	//QuestionDAO Factory
	
	public QuestionDAO getQuestionDAO(String type) {
        if (type.equalsIgnoreCase("mysql")) {
            return (QuestionDAO) new QuestionDAOMySQLImpl();
        } else {
            return (QuestionDAO) new QuestionDAOMySQLImpl();
        }
    }

}
