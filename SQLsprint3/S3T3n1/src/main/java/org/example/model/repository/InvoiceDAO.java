package org.example.model.repository;

import org.example.model.domain.Invoice;
import org.example.model.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceDAO {
    public static void insertInvoice(Invoice invoice) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String insertInvoiceSQL = "INSERT INTO invoices (id, Total Sale) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertInvoiceSQL);
            statement.setInt(1, invoice.getId()); // Manually set the invoice ID
            statement.setDouble(2, invoice.getTotalSale());
            statement.executeUpdate();

            // Insert associated products
            for (Product product : invoice.getProductList()) {
               // insertProduct(product, invoice.getId());//We should do products here too maybe so we can access this
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
