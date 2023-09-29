package org.example.model.repository.invoice;

import org.example.model.repository.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class InvoicesTableInitialization {
    public static void createTables() {
        try (Connection connection = DatabaseConnection.getConnection()){
            String createInvoiceTableSQL = "CREATE SCHEMA IF NOT EXISTS `flowerShop` "
                    + "DEFAULT CHARACTER SET utf8 ;"
                    + "USE `flowerShop` ;"
                    + "CREATE TABLE IF NOT EXISTS invoices ("
                    + "id INT PRIMARY KEY, "
                    + "Total Sale DECIMAL(10, 2) NOT NULL"
                    + ")";
            connection.createStatement().executeUpdate(createInvoiceTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
