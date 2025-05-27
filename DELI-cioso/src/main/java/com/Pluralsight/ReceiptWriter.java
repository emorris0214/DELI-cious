package com.Pluralsight;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Handles writing order receipts to disk
public class ReceiptWriter {

    private static final String RECEIPT_FOLDER = "receipts";

    public static void writeReceipt(Order order) {
        try {
            File folder = new File(RECEIPT_FOLDER);
            if (!folder.exists()) {
                folder.mkdir();
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String filename = RECEIPT_FOLDER + File.separator + timestamp + ".txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(order.getDetails());
            writer.close();

            System.out.println("Receipt written to: " + filename);

        } catch (IOException e) {
            System.err.println("Failed to write receipt: " + e.getMessage());
        }
    }
}
