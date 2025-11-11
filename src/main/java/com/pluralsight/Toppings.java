package com.pluralsight;

public class Toppings {
    private String name;
    private String category;
    private boolean extras; // number of extras

    // Constructor
    public Toppings(String name, String category, boolean extras) {
        this.name = name;
        this.category = category;
        this.extras = extras; // default to no extras
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }



    public boolean isExtras() {
        return extras;
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", extras=" + extras +
                '}';
    }
}