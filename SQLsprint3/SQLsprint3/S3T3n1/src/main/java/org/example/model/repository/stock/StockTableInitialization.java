package org.example.model.repository.stock;

import org.example.model.repository.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class StockTableInitialization {
	
	public static void createTable() {
		
		try (Connection newConnect = DatabaseConnection.getConnection()){
			String createSchemaSQL = "CREATE SCHEMA IF NOT EXISTS `flowerShop` DEFAULT CHARACTER SET utf8";
			String useSchemaSQL = "USE `flowerShop`";
			String createTableSQL = "CREATE TABLE IF NOT EXISTS `flowershop`.`stockList` (" +
					"  `product_id` INT PRIMARY KEY," +
					"  `name` VARCHAR(255) NOT NULL," +
					"  `price` DECIMAL NOT NULL," +
					"  `type` VARCHAR(20) NOT NULL," +
					"  `height` DECIMAL," +
					"  `color` VARCHAR(255)," +
					"  `material_is_wood` ENUM('true', 'false')," +
					"  `invoice_id` INT, " +
					"  FOREIGN KEY (`invoice_id`) REFERENCES `invoices`(`id`)" +
					");";
			
			newConnect.createStatement().execute(createSchemaSQL);
			newConnect.createStatement().execute(useSchemaSQL);
			newConnect.createStatement().execute(createTableSQL);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
	}

}
