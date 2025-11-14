package com.pluralsight.models;

import com.pluralsight.orders.ReceiptFileManager;
import com.pluralsight.Bonus.SignatureSandwich;
import com.pluralsight.Bonus.SignatureSandwichMenu;
import com.pluralsight.UserInterFace.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;

public class OrderMenu {

    // ===== CURRENT ORDER LIST =====
    // This list holds all items the user has added to their current order.
    private static final List<MenuItems> currentOrder = new ArrayList<>();

    // Temporary variable for signature sandwich (optional, could be removed if not used)
    private static MenuItems SignatureSandwich;

    // ================================
    // MAIN ORDER MENU LOOP METHOD
    // ================================
    public static void Ordermenu() {
        while (true) {
            // Display the menu options to the user
            System.out.println(""" 
                    =============================
                           Order menu
                    =============================
                    1) Add Custom Sandwich 😊
                    2) Add Signature Sandwich ⭐
                    3) Add Drink 🥤
                    4) Add Chips 🍟
                    5) Check out  💳
                    0) Cancel order ❌
                    -----------------------------
                    page 2
                    """);

            // Prompt the user for input and normalize it
            String choice = ConsoleHelper.promptForString("Enter your choice").trim().toUpperCase();

            // Switch statement handles user's choice
            switch (choice) {
                case "1" -> {
                    // User chooses to add a custom sandwich
                    Sandwich sandwich = AddSandwich.buildSandwich(); // Call helper method to build sandwich
                    if (sandwich != null) {
                        currentOrder.add(sandwich); // Add sandwich to order list
                        System.out.println("✓ Sandwich added to order!"); // Confirmation
                    }
                }

                    // User chooses a pre-defined signature sandwich
                    case "2" -> {
                        SignatureSandwich signature = SignatureSandwichMenu.orderSignatureSandwich();
                        if (signature != null) {
                            currentOrder.add(signature);  // Add the actual object
                            System.out.println("✓ Signature sandwich added to order!");
                        }
                    }


                case "3" -> {
                    // User chooses to add a drink
                    MenuItems drink = Drinks.AddDrink();
                    if (drink != null) {
                        currentOrder.add(drink); // Add drink to order
                    }
                }
                case "4" -> {
                    // User chooses to add chips
                    MenuItems chips = Chips.AddChips();
                    if (chips != null) {
                        currentOrder.add(chips); // Add chips to order
                    }
                }
                case "5" -> CheckOut(); // User wants to check out
                case "0" -> {
                    CancelOrder(); // User cancels order
                    return; // Exit menu loop
                }
                default -> System.out.println("Invalid choice, please try again."); // Invalid input handler
            }
        }
    }

    // ========================
    // CANCEL ORDER METHOD
    // ========================
    public static void CancelOrder() {
        System.out.println("Order cancelled."); // Inform the user
        currentOrder.clear(); // Clear the order list
    }

    // ========================
    // CHECKOUT METHOD
    // ========================
    public static void CheckOut() {
        if (currentOrder.isEmpty()) {
            // No items in order
            System.out.println("Your order is empty!");
            return;
        }

        System.out.println("\n===== CHECKOUT =====");
        double total = 0; // Total price accumulator

        // Loop through each item in the current order
        for (MenuItems item : currentOrder) {
            // Print description and price of each item
            System.out.println(item.getDescription() + " - $" + String.format("%.2f", item.getPrice()));
            total += item.getPrice(); // Add item price to total
        }

        // Display the total
        System.out.printf("\nTOTAL: $%.2f%n", total);
        System.out.println("=====================");

        // Save the receipt to a file
        String filename = ReceiptFileManager.saveReceipt(currentOrder, total);
        if (filename != null) {
            System.out.println("\n Receipt saved to: " + filename); // Success message
        } else {
            System.out.println("\n Failed to save receipt"); // Failure message
        }

        // Clear the order after checkout
        currentOrder.clear();
        System.out.println("\nThank you for your order!"); // Friendly closing
    }

    // ==================================
    // NESTED CLASS: ADD CUSTOM SANDWICH
    // ==================================
    private static class AddSandwich {

        public static Sandwich buildSandwich() {
            System.out.println("\n--- Add Sandwich ---");

            // ===== BREAD SELECTION =====
            int breadChoice;
            while (true) {
                System.out.println("Please choose a bread type:");
                for (int i = 0; i < Bread.type.length; i++) {
                    System.out.println((i + 1) + ") " + Bread.type[i]); // Display bread options
                }
                breadChoice = ConsoleHelper.promptForInt("Select your bread #: ");
                if (Bread.isValid(breadChoice)) break; // Validate user input
                System.out.println("Invalid choice! Please select an option above.");
            }
            String bread = Bread.type[breadChoice - 1]; // Assign chosen bread

            // ===== SIZE SELECTION =====
            System.out.println("\nSandwich Sizes:");
            System.out.println("4\" - $5.50");
            System.out.println("8\" - $7.00");
            System.out.println("12\" - $8.50");

            String size;
            while (true) {
                size = ConsoleHelper.promptForString("Choose your size (4/8/12 inches): ");
                if (size.equals("4") || size.equals("8") || size.equals("12")) break; // Validate size
                System.out.println("Invalid size! Please enter only 4, 8, or 12.");
            }

            // ===== TOASTED OPTION =====
            boolean toasted;
            while (true) {
                String t = ConsoleHelper.promptForString("Toasted? (Y/N): ");
                if (t.equalsIgnoreCase("Y")) {
                    toasted = true;
                    break;
                } else if (t.equalsIgnoreCase("N")) {
                    toasted = false;
                    break;
                } else {
                    System.out.println("Invalid input! Please enter Y or N.");
                }
            }

            // Create sandwich object
            Sandwich s = new Sandwich(size, bread, toasted);

            // ===== EXTRA PRICING INFO =====   //pricing info
            System.out.println("""
                            === Pricing ===
                    
                    Base Price           Extra Pricing
                                 🍗Meats 🍗
                    4"  -> $1.00;         4"  -> $0.50;
                    8"  -> $2.00;         8"  -> $1.00;
                    12" -> $3.00;         12" -> $1.50;
              
                                🧀 Cheeses 🧀
                    4"  -> $0.75;          4"  -> $0.30;
                    8"  -> $1.50;          8"  -> $0.60;
                    12" -> $2.25;          12" -> $0.90;
                    """);



            // ===== TOPPINGS SELECTION =====
            boolean addingToppings = true;
            while (addingToppings) {
                System.out.println("\nChoose topping type:");
                System.out.println("1) MEAT");
                System.out.println("2) CHEESE");
                System.out.println("3) REGULAR");
                System.out.println("4) SAUCE");
                System.out.println("5) SIDE");
                System.out.println("6) DONE");

                int typeChoice = ConsoleHelper.promptForInt("Select type #: ");
                if (typeChoice == 6) {
                    System.out.println("Finished adding toppings."); // Exit toppings loop
                    break;
                }

                String type;
                String[] choices;

                // Map typeChoice to actual topping array
                switch (typeChoice) {
                    case 1 -> { type = "MEAT"; choices = SelectToppings.Meats; }
                    case 2 -> { type = "CHEESE"; choices = SelectToppings.Cheese; }
                    case 3 -> { type = "REGULAR"; choices = SelectToppings.Regular; }
                    case 4 -> { type = "SAUCE"; choices = SelectToppings.Sauce; }
                    case 5 -> { type = "SIDE"; choices = SelectToppings.Sides; }
                    default -> {
                        System.out.println("Invalid choice! Please select 1–6.");
                        continue;
                    }
                }

                // Allow multiple toppings of the same type
                boolean doneWithThisType = false;
                while (!doneWithThisType) {
                    System.out.println("Available " + type + " toppings:");
                    for (int i = 0; i < choices.length; i++) {
                        System.out.println((i + 1) + ") " + choices[i]);
                    }
                    System.out.println("0) Back to type menu");

                    int toppingChoice = ConsoleHelper.promptForInt("Choose topping #: ");
                    if (toppingChoice == 0) break; // Go back to type selection
                    if (toppingChoice < 1 || toppingChoice > choices.length) {
                        System.out.println("Invalid topping number! Try again.");
                        continue;
                    }

                    boolean extra = false;
                    // Extra pricing only applies to MEAT and CHEESE
                    if (type.equals("MEAT") || type.equals("CHEESE")) {
                        while (true) {
                            String extraInput = ConsoleHelper.promptForString("Extras? (Y/N): ");
                            if (extraInput.equalsIgnoreCase("Y")) { extra = true; break; }
                            else if (extraInput.equalsIgnoreCase("N")) { extra = false; break; }
                            else System.out.println("Invalid input! Enter Y or N.");
                        }
                    }

                    // Add topping to sandwich
                    s.addTopping(new Toppings(choices[toppingChoice - 1], type, extra));
                    System.out.println(choices[toppingChoice - 1] + " (" + type + (extra ? ", extra" : "") + ") added!");

                    // Ask if user wants to pick another topping of same type
                    String more = ConsoleHelper.promptForString("Pick another " + type + "? (Y/N): ");
                    if (more.equalsIgnoreCase("N")) doneWithThisType = true;
                }
            }

            // ===== FINAL SUMMARY =====
            double finalPrice = s.getPrice();
            System.out.println("\n========================================");
            System.out.println("     SANDWICH PLACED SUCCESSFULLY!"); // Confirmation message
            System.out.println("  \uD83E\uDD6A Thank you for choosing Penn station \uD83E\uDD6A  ");
            System.out.println("========================================");
            System.out.println(s.getDescription()); // Print sandwich details
            System.out.println("\nTotal Sandwich Price: Extra $" + String.format("%.2f", finalPrice));
            System.out.println("========================================\n");

            return s; // Return completed sandwich
        }
    }
}
