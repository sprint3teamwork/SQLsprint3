package org.example.model.repository;

//import java.io.IOException; needed for inputstream
//import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	
    private static Connection connection;
    private static Properties pr = new Properties(); 
    private static String url = "jdbc:mysql://localhost:3306/SQLsprint3";
    private static String username = "testUsername";
    private static String password = "testPassword";
    //private static InputStream stream;
    

    public static Connection getConnection() {
    	
        if (connection == null) {
            try (Connection newConnect = DatabaseConnection.getConnection()) {
            		//InputStream stream = getClass().getResourceAsStream("application.properties"))
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) { // | IOException needed in catch block if inputstream is implemented
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    /*
     * Singleton pattern needed for connection or is it already in use with the first null?
     * 
     * private DatabaseConnection() {} 
     * 
     * public static Connection getConnection() {	
		Connection result = connection;
		if (result == null) {								//first null instance is to avoid multithreading issue, if instance exists already skips creation process below
			synchronized (DatabaseConnection.class) {
				result = instance;
				if (result == null) {						//if instance is null, ie new, it will go within method
					instance = result = new DatabaseConnection();
				}
			}
		}
		return result;
	}
     * 
     * 
     */
}