package com.pluralsight;

public class Toppings {
//constructor
    private String name;
    private String category;
    private double price;
    private boolean extras;

//Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price *(1 + extras);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getExtras() {
        return extras;
    }

    public void setExtras(boolean extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", extras=" + extras +
                '}';
    }

    public Toppings(String name, String category, double price, int extras) {

    }

    public void add(Toppings toppings) {
    }
}
