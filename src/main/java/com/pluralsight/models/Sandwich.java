package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends MenuItems { // sandwich class represent a sandwich order which extends from MenuItems
    private String size; //size of sandwich
    private String breadType;// bread type
    private ArrayList<Toppings> toppings = new ArrayList<>();// list of toppings added to a sandwich
    private boolean toasted;// see if a sandwich is toasted


//========= CONSTRUCTOR======== create sandwich with size bread type and is toasted
    public Sandwich(String size, String breadType, boolean toasted) {
        this.size = size;//size of sandwich
        this.breadType = breadType;//bread type
        this.toasted = toasted;//whether sandwich is toasted
    }

    public Sandwich() {}//creates empty sandwich object used for inheritance

    public String getSize() { return size; }// getter for size
    public String getBreadType() { return breadType; }//getter for bread type
    public ArrayList<Toppings> getToppings() { return toppings; }//getter for topping list
    public boolean isToasted() { return toasted; }//getter to see if sandwich is toasted

    public void addTopping(Toppings t) { toppings.add(t); }//add topping to sandwich

    public double getExtraPrice(Toppings t) {

      //  if (!t.isExtras()) return 0; // Only extras cost money //line of code return 0 for signature sandwich didnt calculate

        String category = t.getCategory().toUpperCase(); // normalize category to uppercase
        double price = 0;

        switch (category) {

                case "MEAT" -> {//price based on sandwich size

                    switch (size) {
                        case "4" -> {
                            if (t.isExtras()) {
                                price = 1.50;//base $1.00 + a extra $0.50
                            } else {
                                price = 1;//base price
                            }
                        }
                        case "8" -> {
                            if (t.isExtras()) {
                                price = 3.00;//base $2.00 + extra $1.00
                            } else {
                                price = 2;//base price
                            }
                        }
                        case "12" -> {
                            if (t.isExtras()) {
                                price = 4.50;//base $3.00 + extra $1.50
                            } else {
                                price = 3;//base price
                            }
                        }
                    }
                }


                case "CHEESE" -> {//price based on sandwich size
                    switch (size) {

                        case "4" -> {
                            if (t.isExtras()) {
                                price = 1.05;//base $0.75 + extra $0.30
                            } else {
                                price = .75;//base price
                            }
                        }
                        case "8" -> {
                            if (t.isExtras()) {
                                price = 2.10;//base $1.50 + extra $0.60
                            } else {
                                price = 1.50;//base price
                            }
                        }
                        case "12" ->{
                            if (t.isExtras()) {
                                price = 3.15;//base $2.25 + extra $0.90
                            } else {
                                price = 2.25;//base price
                            }
                        }
                    }
                }

            }

        return price;//calculate total price of the sandwich
    }

    @Override
    public double getPrice() {//base price depending on the sandwich size
        double price = switch(size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0;
        };

        // Add price for toppings
        for (Toppings t : toppings) {
            price += getExtraPrice(t);
        }
        return price;
    }

    @Override
    public String getDescription() {//return description of the sandwich as a string
        StringBuilder sb = new StringBuilder();
        sb.append(size).append("\" ").append(breadType)
                .append(" (Toasted: ").append(toasted).append(")");

        if (toppings.isEmpty()) sb.append("\nNo toppings added.");
        else {
            sb.append("\nToppings: ");
            for (int i = 0; i < toppings.size(); i++) {
                Toppings t = toppings.get(i);
                sb.append(t.getName());
                if (t.isExtras()) sb.append(" (extra)");
                if (i < toppings.size() - 1) sb.append(", ");// seperate toppings with comma
            }
        }

        return sb.toString();
    }
}
