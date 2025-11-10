package com.pluralsight;

public class Toppings {
    private String name;
    private String category;
    private double price;
    private int extras; // number of extras

    // Constructor
    public Toppings(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.extras = 0; // default to no extras
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // returns total price for the topping, including extras
    // if extras = 2 and price = 1.00, total = 1.00 + (2 * 1.00) = 3.00
    public double getPrice() {
        return price + (price * extras);
    }

    public void setPrice(double price) { this.price = price; }

    public int getExtras() { return extras; }
    public void setExtras(int extras) { this.extras = extras; }

    @Override
    public String toString() {
        // display toppings with extras and price
        // ex: "cheddar +2 extra(s) ($3.00)"
        String extraText = extras > 0 ? " +" + extras + " extra(s)" : "";
        return name + extraText + " ($" + String.format("%.2f", getPrice()) + ")";
    }

    // You don’t need this unless you want to merge toppings
    public void add(Toppings toppings) {
        // empty or custom logic
    }
}