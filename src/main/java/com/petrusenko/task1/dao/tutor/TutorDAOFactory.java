package com.petrusenko.task1.dao.tutor;

public class TutorDAOFactory {
	
	//TutorDAO Factory
	
	public TutorDAO getTutorDAO(String type) {
        if (type.equalsIgnoreCase("mysql")) {
            return (TutorDAO) new TutorDAOMySQLImpl();
        } else {
            return (TutorDAO) new TutorDAOMySQLImpl();
        }
    }

}
