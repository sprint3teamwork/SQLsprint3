package org.example.model.repository.invoice;

import org.example.model.domain.Invoice;
import org.example.model.domain.entity.Product;
import org.example.model.repository.DatabaseConnection;
import org.example.model.repository.interfaces.InvoiceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAOImpl implements InvoiceDAO {
    public void insertInvoice(Invoice invoice) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String insertInvoiceSQL = "INSERT INTO invoices (id, totalSale) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertInvoiceSQL);
            statement.setInt(1, invoice.getId());
            statement.setDouble(2, invoice.getTotalSale());
            statement.executeUpdate();

            // Insert associated products
            for (Product product : invoice.getProductList()) {
                product.setInvoiceId(invoice.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Invoice> invoicesRetriever() {
        List<Invoice> invoceLog = new ArrayList<>();
        String query = "SELECT id AS invoice_id, totalSale AS invoice_totalSale FROM invoices";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {

                int id = resultSet.getInt("invoice_id");
                double totalSale = resultSet.getDouble("invoice_totalSale");
                Invoice invoice = new Invoice(id, totalSale);

                invoceLog.add(invoice);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoceLog;

    }

}
