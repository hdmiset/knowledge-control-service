package com.petrusenko.dao.user;


public class UserDAOFactory {
	
	public UserDAO getUserDAO(String type) {
        if (type.equalsIgnoreCase("mysql")) {
            return (UserDAO) new UserDAOMySQLImpl();
        } else {
            return (UserDAO) new UserDAOMySQLImpl();
        }
    }

}
