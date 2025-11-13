package com.pluralsight.Bonus;

import com.pluralsight.UserInterFace.ConsoleHelper;

public  class SignatureSandwichMenu {

    private String SignatureName;


    public String getSignatureName() {
        return SignatureName;
    }

    @Override
    public String toString() {
        return SignatureName + " - " + super.toString();
    }


    // =============================
    //      Signature Menu Logic
    // =============================
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

        String choice = ConsoleHelper.promptForString("Enter your choice").trim();

        if (choice.equals("0")) {
            System.out.println("Returning to main menu...");
            return null;
        }

        String size = ConsoleHelper.promptForString("Choose size (4\", 8\", or 12\"): ").trim();

        switch (choice) {
            case "1" -> {
                SignatureSandwich blt = SignatureSandwich.createBLT(size);
                System.out.println("\n✓ Created: " + blt.getDescription());
                return blt;
            }
            case "2" -> {
                SignatureSandwich philly = SignatureSandwich.createPhillyCheesesteak(size);
                System.out.println("\n✓ Created: " + philly.getDescription());
                return philly;
            }
            default -> {
                System.out.println("Invalid choice.");
                return null;
            }
        }
    }
}