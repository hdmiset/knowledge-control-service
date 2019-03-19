package com.petrusenko.task1.resource;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigurationManager {
	
	private static ConfigurationManager instance;
	
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("com.petrusenko.task1.resource.config");
	// Get information from config.properties
	private ConfigurationManager() { }
	
	//Get instance of ConfigurationManager
	
	public static ConfigurationManager getInstance(){
        if(instance == null){
            instance = new ConfigurationManager();	
        }
        return instance;
    }
	
	public static String getProperty(String key) {
	return resourceBundle.getString(key);
	}

}
