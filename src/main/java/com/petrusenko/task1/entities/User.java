package com.petrusenko.task1.entities;

public class User {
	
	private String name;
    private String password;
    public boolean valid;

    //User's constructors
    
    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    //User's getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //Override toString()

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
    //Check valid
    
    public boolean isValid() {
        return valid;
	}

     public void setValid(boolean newValid) {
        valid = newValid;
	}
     
     //Override equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }
    
    //Override hashCode

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

}
