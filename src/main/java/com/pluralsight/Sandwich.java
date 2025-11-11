package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich extends MenuItems { // extends MenuItems using base items and its properties
    private String size;// size of sandwich 4,8,12
    private String bread;// type of bread white,wheat,etc
    private boolean toasted; //ask cx if the want sub toasted or not
    private List<Toppings> toppings = new ArrayList<>();// list of toppings added to sub

    public Sandwich(String size, String bread) {
        super("Sandwich", 0); // calls parent constructor
        this.size = size;
        this.bread = bread;
    }

    public static MenuItems AddSandwich() {// allows the cx to build sub and add or order
        Scanner scanner = new Scanner(System.in);// reads user input

        // display /Choose size
        System.out.println("\n===== ADD SANDWICH =====");
        System.out.println("Choose Size:");
        System.out.println("1) 4\" ($5.50)");
        System.out.println("2) 8\" ($7.00)");
        System.out.println("3) 12\" ($12.00)");
        String sizeChoice = scanner.nextLine();

        String size = switch (sizeChoice) { // size choice and size string
            case "1" -> "4\"";
            case "2" -> "8\"";
            case "3" -> "12\"";
            default -> "8\"";// default to 8 if 1-3 isnt selected
        };

        // Choose bread options
        System.out.println("\nChoose Bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        String breadChoice = scanner.nextLine();

        String bread = switch (breadChoice) { // bread choice and type
            case "1" -> "White";
            case "2" -> "Wheat";
            case "3" -> "Rye";
            case "4" -> "Wrap";
            default -> "White";//default to white bread if 1-4 isnt selected
        };

        Sandwich sandwich = new Sandwich(size, bread);//create sub object with size and bread

        // Ask if toasted
        System.out.println("\nWould you like it toasted? (y/n)");
        String toastedChoice = scanner.nextLine().trim().toLowerCase();
        sandwich.setToasted(toastedChoice.equals("y"));// toasted if cx enters Y

        SelectToppings.AddToppingsTosandwich(sandwich);


        // You can add toppings here if needed

        System.out.println("Added to cart: " + sandwich);//confirm what was added to cx order
        return sandwich;//return sub so it will be added to the order list
    }

    public void addTopping(Toppings topping) {// add toppings to sub which determines price
        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {//asked if toasted
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        double basePrice = switch (size) {//base price based off sub size
            case "4\"" -> 5.50;
            case "8\"" -> 7.00;
            case "12\"" -> 12.00;
            default -> 7.00;//default to 8 inch if invaild size is picked
        };
        double total = basePrice;

//Loop through selected sandwich toppings
        for (Toppings t : toppings) {
            //Prices for MEAT toppings
            if (t.getCategory().equals("MEAT")) {
                //Cost varies by sandwich size and whether it's an extra portion
                if (size.equals("4")) total += t.isExtras() ?   0.50 : 1.00;
                else if (size.equals("8")) total += t.isExtras() ? 1.00 : 2.00;
                else if (size.equals("12")) total += t.isExtras() ? 1.50 : 3.00;
            }
            //Price rules for CHEESE toppings
            else if (t.getCategory().equals("CHEESE")) {
                if (size.equals("4")) total += t.isExtras() ? 0.30 : 0.75;
                else if (size.equals("8")) total += t.isExtras() ? 0.60 : 1.50;
                else if (size.equals("12")) total += t.isExtras() ? 0.90 : 2.25;
            }
        }

        return total;
    }

    @Override
    public String getDescription() {// returns description of sub based on bread size if toasted
        StringBuilder sb = new StringBuilder();
        sb.append(size)//add the size
                .append("\" ")
                .append(bread) //add bread type
                .append("(Toasted: ")
                .append(toasted) //add true/false if toasted
                .append(")\nToppings: "); //closes parenthesis, new line, then "Toppings:"

        for (Toppings t : toppings) {
            sb.append(t.getName()); //Add topping name
            if (t.isExtras()) sb.append("(extra)"); //Mark extra
            sb.append(", "); //Separator
        }
        return sb.toString();
    }

    @Override
    public double getTotalPrice() {
        return getPrice();
    }


}
