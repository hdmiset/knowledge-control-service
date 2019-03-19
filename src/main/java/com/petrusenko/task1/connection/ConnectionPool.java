package com.petrusenko.task1.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

import com.petrusenko.task1.resource.ConfigurationManager;

public class ConnectionPool {
	
	// JDBC Driver Name & Database URL
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/testingdb";
	 
	    // JDBC Database access
	    static final String JDBC_USER = "root";
	    static final String JDBC_PASS = "pass";
	 
	    private static GenericObjectPool gPool = null;
	 
	    @SuppressWarnings("unused")
	    public DataSource setUpPool() throws Exception {
	        Class.forName(JDBC_DRIVER);
	 
	        // Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
	        gPool = new GenericObjectPool();
	        gPool.setMaxActive(5);
	        
	 
	        // Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
	        ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
	 
	        // Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
	        PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
	        return new PoolingDataSource(gPool);
	    }
	 
	    public GenericObjectPool getConnectionPool() {
	        return gPool;
	    }
	 
	    // This Method Is Used To Print The Connection Pool Status
	    public void printDbStatus() {
	        System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
	    }


}
