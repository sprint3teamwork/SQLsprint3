package org.example.model.repository.stock;

import org.example.model.repository.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class StockTableInitialization {
	
	public static void createTable() {
		
		try (Connection newConnect = DatabaseConnection.getConnection()){
			
			String stockTable = "CREATE SCHEMA IF NOT EXISTS `flowerShop` "
					+ "DEFAULT CHARACTER SET utf8 ;"
					+ "USE `flowerShop` ;"
					+ "CREATE TABLE IF NOT EXISTS `SQLsprint3`.`stockList` ("
					+ "  `product_id` INT NOT NULL,"
					+ "  `name` VARCHAR(255) NOT NULL,"
					+ "  `price` DECIMAL NOT NULL,"
					+ "  `type` VARCHAR(20) NOT NULL,"
					+ "  `height` DECIMAL NULL,"
					+ "  `color` VARCHAR(255) NULL,"
					+ "  `material_is_wood` SET(`true`,`false`) NOT NULL,"
					+ "	 FOREIGN KEY (`invoice_id`) REFERENCES invoices(`id`) NULL"
					+ "  PRIMARY KEY (`product_id`));";
			
			newConnect.createStatement().execute(stockTable);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
	}

}
