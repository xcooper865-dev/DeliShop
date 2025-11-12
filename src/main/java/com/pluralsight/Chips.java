package com.pluralsight;

import java.util.Scanner;

public class Chips extends MenuItems {

    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;

    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getDescription() {
        return"chips("+ flavor + ")"; //return name of chips that are selected
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
        String flavor = "Classic Lays"; // default Chips
                    // default price

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
            //if cx eneter anything other than 1-6 system default to lays
            default -> System.out.println("Invalid choice, defaulting to Classic Lays chips");
        }

        Chips chips = new Chips(flavor); //a new Chip object created with the name and price
        System.out.println("Added to cart: " + chips); //tells the cx the chips have been added
        return chips;
    }
}





