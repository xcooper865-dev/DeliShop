package com.pluralsight;

import java.util.Scanner;

public class Chips extends MenuItems {

    //constructor
    public Chips(String name, double price) {
        super(name, price);
    }

    @Override
    public String getDescription() {
        return getName(); //return name of chips that are selected
    }

    @Override
    public double getTotalPrice() {
        return getPrice(); // returns total price of the chips selected
    }

    public static Chips AddChips() { //the method being static allows cx to add chips to order
        Scanner scanner = new Scanner(System.in); //Scanner reads user input
        System.out.println("\n===== ADD CHIPS ====="); //Chips menu header
        System.out.println("Choose your chips:");


        //All avalible chips for cx
        System.out.println("1) Classic Lays ($2.00)");
        System.out.println("2) Baked Jalapeno Chips ($3.50)");
        System.out.println("3) Cheetos ($2.00)");
        System.out.println("4) Hot Cheetos ($2.75)");
        System.out.println("5) BBQ Chips ($2.00)");
        System.out.println("6) Sour Cream & Onion ($2.50)");

        String choice = scanner.nextLine();//reads out user input
        String chipName = "Classic Lays"; // default Chips
        double price = 2.00;              // default price

        switch (choice) { //sets the Chip name and price accordinly to the users choice
            case "1" -> {
                chipName = "Classic Lays";
                price = 2.00;
            }
            case "2" -> {
                chipName = "Baked Jalapeno";
                price = 3.50;
            }
            case "3" -> {
                chipName = "Cheetos";
                price = 2.00;
            }
            case "4" -> {
                chipName = "Hot Cheetos";
                price = 2.75;
            }
            case "5" -> {
                chipName = "BBQ Chips";
                price = 2.00;
            }
            case "6" -> {
                chipName = "Sour Cream & Onion";
                price = 2.50;
            }
            //if cx eneter anything other than 1-6 system default to lays
            default -> System.out.println("Invalid choice, defaulting to Classic Lays");
        }

        Chips chips = new Chips(chipName, price); //a new Chip object created with the name and price
        System.out.println("Added to cart: " + chips); //tells the cx the chips have been added
        return chips;
    }
}





