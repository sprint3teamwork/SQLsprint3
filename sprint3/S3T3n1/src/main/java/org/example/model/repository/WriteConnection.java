package org.example.model.repository;

import org.example.model.domain.Invoice;
import org.example.model.domain.Product;

import java.io.*;
import java.util.List;

public class WriteConnection implements Connector{

    private static File InvoiceLogDB;
    private static File StockListDB;

    @Override
    public void connect() {

        try {

            InvoiceLogDB = new File("InvoiceLogDB.txt");
            StockListDB = new File("StockListDB.txt");

            if (InvoiceLogDB.createNewFile()) {
                System.out.println("New Txt Database created: " + InvoiceLogDB.getName());
            } else {
                System.out.println("File database for invoice already exists.");
            }

            if (StockListDB.createNewFile()) {
                System.out.println("New Txt Database created: " + StockListDB.getName() + "\n\n");
            } else {
                System.out.println("File database for stock already exists.\n\n");
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void invoiceLogWriter(List<Invoice> invoiceLog){
		
    	try {
    		BufferedWriter bw = new BufferedWriter(new FileWriter(InvoiceLogDB,false));
    		for (int i = 0; i < invoiceLog.size(); i++) {
    			bw.write(invoiceLog.get(i).toString() + "\n");
    		}
    		bw.close();
    	} catch (IOException ioe) {
    		System.out.println(ioe.getMessage());
    	}

    }

    public void stockListWriter(List<Product> stockList){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(StockListDB,false));
            for (int i = 0; i < stockList.size(); i++) {
                bw.write(stockList.get(i).toString() + "\n");
            }
            bw.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}