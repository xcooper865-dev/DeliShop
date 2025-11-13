package com.pluralsight.models;

import java.util.Scanner;

public class Drinks extends MenuItems {// extends Menuitems and inherits its base items

    private String size; // variables that store the size and flavor of the drink
    private String flavor;



    //======Constructor======
    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public static Drinks AddDrink() { //static allwos cx to add drink to their order

        Scanner scanner = new Scanner(System.in); //Scanner created to read cx input

        System.out.println("Choose Size");//displays size and also gives diffrent choices
        System.out.println("1) Small ($2.00)");
        System.out.println("2) Medium ($2.50)");
        System.out.println("3) Large  ($3.00)");
        String sizeChoice = scanner.nextLine();

        String size; // size choice and sets the size name and price of each size
        double price;
        switch (sizeChoice) {
            case "1" -> { size = "(Small)"; price = 2.00; }
            case "2" -> { size = "(Medium)"; price = 2.50; }
            case "3" -> { size = "(Large)"; price = 3.00; }
            //default size if 1-3 isnt selected
            default -> { size = "(Small)"; price = 2.00; }
        }

        System.out.println("\nChoose Drink");//Flavor options and prompt cx for their choice of drink
        System.out.println("1) Lemonade");
        System.out.println("2) Dr. Pepper");
        System.out.println("3) Pepsi");
        System.out.println("4) Cheerwine");
        System.out.println("5) Fruit Punch");
        String flavorOfChoice = scanner.nextLine();


        String flavor = switch (flavorOfChoice) { //flavor choice and sets the flavor name
            case "1" -> "Lemonade";
            case "2" -> "Dr. Pepper";
            case "3" -> "Pepsi";
            case "4" -> "Cheerwine";
            case "5" -> "Fruit Punch";
            //default to lemonade if 1-5 isn't selected
            default -> "Lemonade";
        };

        //Drink object created with the select size, flavor& price
        Drinks drinks = new Drinks(size, flavor);

        System.out.println("Added to cart: " + drinks);//confirms to the cx that the drink was added to cart
        return drinks;  //return drink to be added to the order
    }


    @Override
    public double getPrice() {//calculate and return the price based on the drink size
        if(size.equals("S"))
            return 2.00;
        else if(size.equals("M"))
            return 2.50;
        else
            return 3.00;
    }

    @Override
    public String getDescription() {
        return size + "Drinks (" + flavor + ")" ;//description of the drink and flavor combined
    }


    @Override
    public String toString() { // formats the string with size,flavor & price
        return size + " " + flavor + " ($" + getPrice() + ")";
    }
}





