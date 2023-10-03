package org.example.model.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream inputStream = new FileInputStream("SQLsprint3\\S3T3n1\\src\\main\\resources\\application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }//Made the properties loading static so it only loads once, when the DatabaseConnection class is called
    }

    public static Connection getConnection() throws SQLException {//we have to handle this exception in upper level wit try-with-resources
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }
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
