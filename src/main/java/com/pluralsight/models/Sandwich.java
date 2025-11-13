package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends MenuItems {
    private String size;
    private String breadType;
    private ArrayList<Toppings> toppings = new ArrayList<>();
    private boolean toasted;

    // Constructor


    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    public String getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public ArrayList<Toppings> getToppings() {//return list of all toppings on the sandwich
        return toppings;
    }

    public boolean isToasted() { //checks if sandwich is toasted
        return toasted;
    }

    // Add a topping
    public void addTopping(Toppings t) {// add toppings to sandwich list
        toppings.add(t);// t is the toppings object that's being added
    }

    public double getExtraPrice(Toppings t) {// calculates the extra price for a speific toppings based on category and size
        double price = 0;

        // pricing rules for the meat toppings
        if (t.getCategory().equals("Meats")) {
            if (size.equals("4")) price = 0.50;
            else if (size.equals("8")) price = 1.00;
            else if (size.equals("12")) price = 1.50;

            //pricing rules for the cheese toppings
        } else if (t.getCategory().equals("Cheese")) {
            if (size.equals("4")) price = 0.30;
            else if (size.equals("8")) price = 0.60;
            else if (size.equals("12")) price = 0.90;
        }
        return price;//return extra cost for toppings
    }


    @Override
    public double getPrice() {
        double base; //the total price of the sandwich
//Determine base price based on sandwich size
        switch (size) {
            case "4":
                base = 5.50; //Base price for a 4 inch sandwich
                break;
            case "8":
                base = 7.00; //Base price for an 8 inch sandwich
                break;
            case "12":
                base = 8.50; //Base price for a 12 inch sandwich
                break;
            default:
                base = 0;  //Unknown size results in zero charge
                break;
        }
//Start calculating total with the base sandwich price
        double total = base;

//Loop through selected sandwich toppings
        for (Toppings t : toppings) {
            //Prices for MEAT toppings
            if (t.getCategory().equals("MEAT")) {
                //Cost varies by sandwich size and whether it's an extra portion
                if (size.equals("4")) total += t.isExtras() ? 0.50 : 1.00;
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
//Return the final sandwich price
        return total;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(size)
                .append("\" ")
                .append(breadType)
                .append(" (Toasted: ")
                .append(toasted)
                .append(")");

        if (toppings.isEmpty()) { //checks if toppings have been added
            sb.append("\nNo toppings added.");
        } else {
            sb.append("\nToppings: ");

            //loops through and list all the toppings
            for (int i = 0; i < toppings.size(); i++) {
                Toppings t = toppings.get(i);
                sb.append(t.getName());

                //marks if its a extra portion
                if (t.isExtras()) sb.append(" (extra)");
                if (i < toppings.size() - 1) sb.append(", "); // Only add comma if not last
            }
        }
        return sb.toString();
    }
}