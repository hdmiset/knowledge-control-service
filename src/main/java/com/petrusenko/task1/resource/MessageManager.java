package com.petrusenko.task1.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
	
	Locale current = Locale.getDefault();
	ResourceBundle rb = ResourceBundle.getBundle("com.petrusenko.task1.resource.messages", current);
	
	public String getProperty(String key) {
	return rb.getString(key);

} 
	}
