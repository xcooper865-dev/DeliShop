package com.pluralsight.models;


import com.pluralsight.orders.ReceiptFileManager;
import com.pluralsight.Bonus.SignatureSandwich;
import com.pluralsight.Bonus.SignatureSandwichMenu;
import com.pluralsight.UserInterFace.ConsoleHelper;


import java.util.ArrayList;
import java.util.List;

public class OrderMenu {

    private static final List<MenuItems> currentOrder = new ArrayList<>();
    private static MenuItems SignatureSandwich;

    public static void Ordermenu() {
        while (true) {
            System.out.println(""" 
                    =============================
                           Order menu
                    =============================
                    1) Add Custom Sandwich 😊
                    2) Add Signature Sandwich ⭐
                    3) Add Drink
                    4) Add Chips
                    5) Check out
                    0) Cancel order
                    -----------------------------
                    """);

            String choice = ConsoleHelper.promptForString("Enter your choice").trim().toUpperCase();

            switch (choice) {
                case "1" -> {
                    Sandwich sandwich = AddSandwich.buildSandwich(); // Call your AddSandwich class
                    if (sandwich != null) {
                        currentOrder.add(sandwich);
                        System.out.println("✓ Sandwich added to order!");
                    }
                }
                case "2" -> {
                    SignatureSandwich signature = SignatureSandwichMenu.orderSignatureSandwich();
                    if (signature != null) {
                        currentOrder.add(SignatureSandwich);  // <- fix here
                        System.out.println("✓ Signature sandwich added to order!");
                    }
                }
                case "3" -> {
                    MenuItems drink = Drinks.AddDrink();
                    if (drink != null) {
                        currentOrder.add(drink);
                    }
                }
                case "4" -> {
                    MenuItems chips = Chips.AddChips();
                    if (chips != null) {
                        currentOrder.add(chips);
                    }
                }
                case "5" -> CheckOut();
                case "0" -> {
                    CancelOrder();
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }



    private static void CancelOrder() {
        System.out.println("Order cancelled.");
        currentOrder.clear();
    }

    private static void CheckOut() {
        if (currentOrder.isEmpty()) {
            System.out.println("Your order is empty!");
            return;
        }

        System.out.println("\n===== CHECKOUT =====");
        double total = 0;

        for (MenuItems item : currentOrder) {
            System.out.println(item.getDescription() + " - $" + String.format("%.2f", item.getPrice()));
            total += item.getPrice();
        }

        System.out.printf("\nTOTAL: $%.2f%n", total);
        System.out.println("=====================");

        String filename = ReceiptFileManager.saveReceipt(currentOrder, total);

        if (filename != null) {
            System.out.println("\n✓ Receipt saved to: " + filename);
        } else {
            System.out.println("\n✗ Failed to save receipt");
        }

        currentOrder.clear();
        System.out.println("\nThank you for your order!");
    }

    private static class AddSandwich {
        public static Sandwich buildSandwich() {

            System.out.println("\n--- Add Sandwich ---");

            // ===== BREAD SELECTION =====
            int breadChoice;
            while (true) {
                System.out.println("Please choose a bread type:");
                for (int i = 0; i < Bread.type.length; i++) {
                    System.out.println((i + 1) + ") " + Bread.type[i]);
                }
                breadChoice = ConsoleHelper.promptForInt("Select your bread #: ");
                if (Bread.isValid(breadChoice)) break;
                System.out.println("Invalid choice! Please select an option above.");
            }
            String bread = Bread.type[breadChoice - 1];

            // ===== SIZE SELECTION =====
            System.out.println("\nSandwich Sizes:");
            System.out.println("4\" - $5.50");
            System.out.println("8\" - $7.00");
            System.out.println("12\" - $8.50");

            String size;
            while (true) {
                size = ConsoleHelper.promptForString("Choose your size (4/8/12 inches): ");
                if (size.equals("4") || size.equals("8") || size.equals("12")) break;
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

            Sandwich s = new Sandwich(size, bread, toasted);

            // ===== EXTRA PRICING INFO =====
            System.out.println("\n=== Extra Pricing ===");
            System.out.println("Extra Meat:");
            System.out.println("4\" = $0.50   " +
                    "| 8\" = $1.00  " +
                    " | 12\" = $1.50");
            System.out.println("Extra Cheese:");
            System.out.println("4\" = $0.30 " +
                    "  | 8\" = $0.60   " +
                    "| 12\" = $0.90\n");

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
                    System.out.println("Finished adding toppings.");
                    break;
                }

                String type;
                String[] choices;

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

                // Loop for selecting multiple toppings of the same type
                boolean doneWithThisType = false;
                while (!doneWithThisType) {

                    System.out.println("Available " + type + " toppings:");
                    for (int i = 0; i < choices.length; i++) {
                        System.out.println((i + 1) + ") " + choices[i]);
                    }
                    System.out.println("0) Back to type menu");

                    int toppingChoice = ConsoleHelper.promptForInt("Choose topping #: ");
                    if (toppingChoice == 0) break; // back to type selection
                    if (toppingChoice < 1 || toppingChoice > choices.length) {
                        System.out.println("Invalid topping number! Try again.");
                        continue;
                    }

                    boolean extra = false;
                    if (type.equals("MEAT") || type.equals("CHEESE")) {
                        while (true) {
                            String extraInput = ConsoleHelper.promptForString("Extras? (Y/N): ");
                            if (extraInput.equalsIgnoreCase("Y")) { extra = true; break; }
                            else if (extraInput.equalsIgnoreCase("N")) { extra = false; break; }
                            else System.out.println("Invalid input! Enter Y or N.");
                        }
                    }

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
            System.out.println("     SANDWICH PLACED SUCCESSFULLY!");
            System.out.println("========================================");
            System.out.println(s.getDescription());
            System.out.println("\nTotal Sandwich Price: $" + String.format("%.2f", finalPrice));
            System.out.println("========================================\n");

            return s;
        }

    }
}