package org.example.model.repository.invoice;

import org.example.model.repository.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class InvoicesTableInitialization {
    public static void createTable() {
        try (Connection connection = DatabaseConnection.getConnection()){
            String createInvoiceTableSQL = "CREATE SCHEMA IF NOT EXISTS `flowerShop` DEFAULT CHARACTER SET utf8";
            String useSchemaSQL = "USE `flowerShop`";
            String createInvoicesTableSQL = "CREATE TABLE IF NOT EXISTS `invoices` ("
                    + " `id` INT PRIMARY KEY,"
                    + " `Total_Sale` DECIMAL(10, 2) NOT NULL)";
            connection.createStatement().execute(createInvoiceTableSQL);
            connection.createStatement().execute(useSchemaSQL);
            connection.createStatement().execute(createInvoicesTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
