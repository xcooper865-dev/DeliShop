package com.pluralsight;

public abstract class MenuItems {

    private String name;
    private double price;



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public MenuItems(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public abstract String getDescription();

    @Override
    public String toString() {
        return getDescription() + " - $" + String.format("%.2f", getPrice());
    }

    public abstract double getTotalPrice();

    public void AddToppings(Toppings topping) {
    }
}
