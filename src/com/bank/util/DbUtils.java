package com.bank.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class DbUtils {
	
	/* Volatile avoid the usage of an existing Connection not really instantiated (equivalent of ThreadLocal on Java 1.2 to 1.4)*/
	public static volatile Connection connection = null;
	
	/* Only the class can instantiate himself. This delete the default public constructor*/
	private DbUtils(){super();}
	
	public final static Connection getConnection() 
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
		
		if (DbUtils.connection == null){
			
			/* Guarantee single connection to the database even with multiple thread */
			synchronized(DbUtils.class){	
				if(DbUtils.connection == null){
					
					/* Retrieve properties file */
					Properties prop = new Properties();
					prop.load((InputStream)new FileInputStream("config.properties"));	
					
					/* Get data from properties file */
					/* Instantiate a new connection with the database*/
					Class.forName(prop.getProperty("DRIVER"));
					
					DbUtils.connection = DriverManager.getConnection(
							prop.getProperty("DB_URL"),
							prop.getProperty("DB_USER"), 
							prop.getProperty("DB_PASSWORD")
					);
				}
			}
		}
		return DbUtils.connection;
	}
}
