package com.pluralsight.Bonus;

import com.pluralsight.UserInterFace.ConsoleHelper;
import com.pluralsight.models.SelectToppings;
import com.pluralsight.models.Toppings;

import java.util.ArrayList;


public  class SignatureSandwichMenu {//signaturesandwichmenu handles ordering and customizing predefined signiture sandwih

    private String SignatureName;//name of signature sandwich


    public String getSignatureName() {// getter for the signature sandwich selected BLT,or Philly
        return SignatureName;
    }

    @Override
    public String toString() {
        return SignatureName + " - " + super.toString();
    }


    // =================================
    //      Signature Menu Logic
    // ================================
    public static SignatureSandwich orderSignatureSandwich() {
        System.out.println("""
                =============================
                     Signature Sandwiches
                =============================
                1) BLT
                2) Philly Cheesesteak
                0) Cancel
                -----------------------------
                """);


        int command;
        while (true) {//loop until the user enter a valid sandwich choice
            System.out.println("Choose a signature sandwich");
            System.out.println("1) BLT");
            System.out.println("2) Philly Cheese Steak");

        command = ConsoleHelper.promptForInt("Please entre your choice (1 or 2)");
        // Loop continues until the user enters a valid signature sandwich choice (1 or 2)
        if (command == 1 || command == 2)
            break;// Exit the loop if the input is valid
        System.out.println("Invalid choice! Please select 1 or 2.");
    }

    SignatureSandwich s;//create sandwich object based on cx choice

if (command == 1) s = SignatureSandwich.createBLT();// If 1, create a BLT sandwich
else s = SignatureSandwich.createPhillyCheesesteak();

System.out.println(" Signature sandwich has been selected!");

    // Let the user customize toppings
    customizeToppings(s); // reuse your topping loop
return s;
}


    private static void customizeToppings(SignatureSandwich s) {//customize toppings for the selected sub
        while (true) {
            System.out.println("\nToppings customization menu:");
            System.out.println("1) Add topping");
            System.out.println("2) Remove topping");
            System.out.println("3) Done");
            // Prompt cx to choose an action 1,2,3
            int action = ConsoleHelper.promptForInt("Select action #: ");//prompt cx for their choice

            if (action == 3) {//exit loop if done
                System.out.println("Finished customizing toppings.");
                break;
                // Exit the topping customization loop if user is done
            }

            if (action == 2) {
                // Remove topping section
                ArrayList<Toppings> toppings = s.getToppings(); // Get current toppings from the sandwich
                if (toppings.isEmpty()) {
                    System.out.println("No toppings to remove!"); // Inform if no toppings exist
                    continue; // Go back to the action menu
                }

                System.out.println("Current toppings:"); // List existing toppings
                for (int i = 0; i < toppings.size(); i++) {
                    Toppings t = toppings.get(i);
                    System.out.println((i + 1) + ") " + t.getName() + (t.isExtras() ? " (extra)" : ""));
                    // Display topping number, name, and mark if it's extra
                }

                int removeIndex; // Variable for user's choice to remove
                while (true) {
                    removeIndex = ConsoleHelper.promptForInt("Select topping # to remove: ");
                    if (removeIndex >= 1 && removeIndex <= toppings.size()) break;
                    // Validate input within list range
                    System.out.println("Invalid number! Try again.");
                }

                Toppings removed = toppings.remove(removeIndex - 1);
                // Remove topping from list
                System.out.println(" Removed " + removed.getName() + (removed.isExtras() ? " (extra)" : ""));
                // Confirmation message
                continue; // Return to the action menu
            }

            if (action == 1) {
                // Add topping section
                System.out.println("\nChoose topping type to add:");
                System.out.println("1) MEAT");
                System.out.println("2) CHEESE");
                System.out.println("3) REGULAR");
                System.out.println("4) SAUCE");
                System.out.println("5) SIDE");
                System.out.println("6) Done");

                int typeChoice = ConsoleHelper.promptForInt("Select type #:");
                // Prompt user to select a topping type
                if (typeChoice == 6) continue;
                // If Done is selected, go back to the main action menu

                String type; // Variable to store topping type string
                String[] choices; // Array to store toppings of selected type

                // Map numeric choice to topping type array
                switch (typeChoice) {
                    case 1 -> {
                        type = "MEAT";
                        choices = SelectToppings.Meats;
                    }
                    case 2 -> {
                        type = "CHEESE";
                        choices = SelectToppings.Cheese;
                    }
                    case 3 -> {
                        type = "REGULAR";
                        choices = SelectToppings.Regular;
                    }
                    case 4 -> {
                        type = "SAUCE";
                        choices = SelectToppings.Sauce;
                    }
                    case 5 -> {
                        type = "SIDE";
                        choices = SelectToppings.Sides;
                    }
                    default -> {
                        System.out.println("Invalid choice!");
                        continue; // Invalid selection, back to topping type menu
                    }
                }

                // Display available toppings of selected type
                System.out.println("Available " + type + " toppings:");
                for (int i = 0; i < choices.length; i++) {
                    System.out.println((i + 1) + ") " + choices[i]);
                }

                int toppingChoice; // Variable to store user's topping selection
                while (true) {
                    toppingChoice = ConsoleHelper.promptForInt("Choose topping #: ");
                    if (toppingChoice >= 1 && toppingChoice <= choices.length) break;
                    // Validate input within the topping array bounds
                    System.out.println("Invalid topping number! Try again.");
                }

                boolean extra = false; // Flag to track if this topping is extra
                if (type.equals("MEAT") || type.equals("CHEESE")) {
                    // meat or cheese
                    while (true) {
                        String extraInput = ConsoleHelper.promptForString("Extra? (Y/N): ");
                        // Ask cx if they would like extras
                        if (extraInput.equalsIgnoreCase("Y")) {
                            extra = true; // Mark as extra if true
                            Toppings temp = new Toppings(choices[toppingChoice - 1], type, true);
                            //  temp topping selected to calculate extra price
                            double extraPrice = s.getExtraPrice(temp);
                            System.out.println("Added extra " + choices[toppingChoice - 1] + " (" + type + ") $" + String.format("%.2f", extraPrice));
                            //  price shown for extra toppings
                            break;
                        } else if (extraInput.equalsIgnoreCase("N")) {
                            System.out.println("Added " + choices[toppingChoice - 1] + " (" + type + ")");
                            // Added normally
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter Y or N.");
                            // Retry for valid input
                        }
                    }
                } else {
                    System.out.println("Added " + choices[toppingChoice - 1] + " (" + type + ")");
                    // Non-MEAT/CHEESE toppings added without extra
                }

                // Add the topping to the sandwich
                s.addTopping(new Toppings(choices[toppingChoice - 1], type, extra));
                // Stores topping with name, type, and extra flag
            }
        }

    }
    }