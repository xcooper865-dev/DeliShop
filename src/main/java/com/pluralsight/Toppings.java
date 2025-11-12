package com.pluralsight;

public class Toppings {
    private String name;
    private String category;
    private boolean extras; // number of extras (0 = none)


    // Constructor
    public Toppings(String name, String category, boolean extras) {
        this.name = name;
        this.category = category;
        this.extras = extras;

    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isExtras() {
        return extras;
    }

}


