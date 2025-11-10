package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReceiptFileManager {

    private static final String RECEIPTS_FOLDER = "receipts";

    /**
     * Saves the order receipt to a file
     * @param orderItems List of items in the order
     * @param total Total price of the order
     * @return The filename where receipt was saved, or null if failed
     */
    public static String saveReceipt(List<MenuItems> orderItems, double total) {
        // Generate filename with timestamp (yyyyMMdd-HHmmss format)
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String filename = RECEIPTS_FOLDER + "/" + now.format(formatter) + ".txt";

        try {
            // Create receipts directory if it doesn't exist
            java.io.File directory = new java.io.File(RECEIPTS_FOLDER);
            if (!directory.exists()) {
                directory.mkdir();
            }

            // Write receipt to file
            writeReceiptToFile(filename, orderItems, total, now);

            return filename;

        } catch (IOException e) {
            System.out.println("ERROR saving receipt: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Writes the formatted receipt to the file
     */
    private static void writeReceiptToFile(String filename, List<MenuItems> orderItems,
                                           double total, LocalDateTime orderTime) throws IOException {

        FileWriter fileWriter = new FileWriter(filename);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Header
        printWriter.println("========================================");
        printWriter.println("          Penn Station       ");
        printWriter.println("========================================");
        printWriter.println("Date: " + orderTime.format(
                DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")));
        printWriter.println("========================================\n");

        // Items section — this now includes toppings for sandwiches
        printWriter.println("ITEMS:");
        printWriter.println("----------------------------------------");
        for (MenuItems item : orderItems) {
            // Print the main menu item (Sandwich, Drink, Chips, etc.)
            printWriter.printf("%-30s $%6.2f%n",
                    item.getDescription(),
                    item.getTotalPrice());

            // 🔽 NEW CODE BELOW — shows sandwich toppings and extras
            // If the item is a sandwich, list all toppings underneath it
            if (item instanceof Sandwich sandwich) {

                // Loop through each topping added to this sandwich
                for (Toppings topping : sandwich.getToppings()) {

                    // If extras were added, label how many
                    String extraText = topping.getExtras() > 0
                            ? " + " + topping.getExtras() + " extra(s)"
                            : "";

                    // Print each topping indented under the sandwich
                    printWriter.printf("   - %-25s $%5.2f%n",
                            topping.getName() + extraText,
                            topping.getPrice());
                }
            }
        }

        // Total
        printWriter.println("----------------------------------------");
        printWriter.printf("%-30s $%6.2f%n", "TOTAL:", total);
        printWriter.println("========================================");
        printWriter.println("\n      Thank you for your order!");
        printWriter.println("========================================");

        // Close the writer to flush data to file
        printWriter.close();
        fileWriter.close();
    }
}