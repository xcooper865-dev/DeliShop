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
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() {
        return price * (1 + extras); // price increases per extra
    }

    public void setPrice(double price) { this.price = price; }

    public int getExtras() { return extras; }
    public void setExtras(int extras) { this.extras = extras; }

    @Override
    public String toString() {
        return "Toppings{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + getPrice() +
                ", extras=" + extras +
                '}';
    }

    // You don’t need this unless you want to merge toppings
    public void add(Toppings toppings) {
        // empty or custom logic
    }
}