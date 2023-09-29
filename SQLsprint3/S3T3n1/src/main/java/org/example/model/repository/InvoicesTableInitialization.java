package org.example.model.repository;

import java.sql.Connection;
import java.sql.SQLException;

public class InvoicesTableInitialization {
    public static void createTables() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String createInvoiceTableSQL = "CREATE TABLE IF NOT EXISTS invoices ("
                    + "id INT PRIMARY KEY, "
                    + "Total Sale DECIMAL(10, 2) NOT NULL"
                    + ")";
            connection.createStatement().executeUpdate(createInvoiceTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
