package com.pluralsight.models;

import java.util.Scanner;

public class Chips extends MenuItems { // chips clas represents bag of chips that can be added to a order

    private String flavor;//instance variable to store flavor & type of chips

    public Chips(String flavor) {//constructor
        this.flavor = flavor;

    }

    @Override
    public double getPrice() {
        return 1.50;//return price of chips all chips have a flat rate of $1.50
    }

    @Override
    public String getDescription() { //return description and the flavor
        return"chips("+ flavor + ")"; //return name of chips that are selected
    }


    @Override
    public String toString() {
        return "Chips{" +
                "flavor='" + flavor + '\'' +
                '}';
    }

    public static Chips AddChips() { //the method being static allows cx to add chips to order
        Scanner scanner = new Scanner(System.in); //Scanner reads user input
        System.out.println("\n===== ADD CHIPS ====="); //Chips menu header
        System.out.println("Choose your chips:");
        System.out.println("""
              ===== ADD CHIPS: All chips are $1.50!!! =====
              1) Classic Lays
              2) Baked Jalapeno Chips
              3) Cheetos
              4) Hot Cheetos
              5) BBQ Chips
              6) Sour Cream & Onion
              """);


        String choice = scanner.nextLine();//reads out user input
        String flavor = "Classic Lays"; // default Chips


        switch (choice) { //sets the Chip name and price accordinly to the users choice
            case "1" -> {
               flavor  = "Classic Lays";
              break;
            }
            case "2" -> {
                flavor = "Baked Jalapeno";
                break;
            }
            case "3" -> {
                flavor = "Cheetos";
                break;
            }
            case "4" -> {
                flavor = "Hot Cheetos";
                 break;
            }
            case "5" -> {
                flavor = "BBQ Chips";
                break;
            }
            case "6" -> {
                flavor = "Sour Cream & Onion";
                break;
            }
            //if cx enter anything other than 1-6 system default to lays
            default -> System.out.println("Invalid choice, defaulting to Classic Lays chips");
        }

        Chips chips = new Chips(flavor); //a new Chip object created with the name and price
        System.out.println("Added to cart: " + chips); //tells the cx the chips have been added
        return chips;
    }
}





