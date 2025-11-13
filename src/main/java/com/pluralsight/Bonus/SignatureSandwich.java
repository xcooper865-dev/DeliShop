package com.pluralsight.Bonus;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Toppings;

public class SignatureSandwich extends Sandwich {  // Predefined sandwich

    private String signatureName; // Sandwich name (e.g., BLT, Philly)

    // ---------- Constructor ----------
    public SignatureSandwich(String size, String bread, String signatureName) {
        super(size, bread, true); // Call parent Sandwich constructor, toasted by default
        this.signatureName = signatureName;
    }

    // ---------- Methods ----------
    public String getSignatureName() {
        return signatureName;
    }

    public void setSignatureName(String name) {
        this.signatureName = name;
    }

    @Override
    public String toString() {
        // Use the parent getDescription and prepend signature name
        return signatureName + " - " + super.getDescription();
    }

    // ---------- Factory Methods ----------
    public static SignatureSandwich createBLT() {
        SignatureSandwich sandwich = new SignatureSandwich("8", "White", "BLT");

        // Add BLT toppings
        sandwich.addTopping(new Toppings("Bacon", "MEAT", false));
        sandwich.addTopping(new Toppings("Cheddar Cheese", "CHEESE", false));
        sandwich.addTopping(new Toppings("Lettuce", "REGULAR", false));
        sandwich.addTopping(new Toppings("Tomato", "REGULAR", false));
        sandwich.addTopping(new Toppings("Ranch", "SAUCE", false));

        return sandwich;
    }

    public static SignatureSandwich createPhillyCheesesteak() {
        SignatureSandwich sandwich = new SignatureSandwich("8", "White", "Philly Cheesesteak");

        // Add Philly Cheesesteak toppings
        sandwich.addTopping(new Toppings("Steak", "MEAT", false));
        sandwich.addTopping(new Toppings("American Cheese", "CHEESE", false));
        sandwich.addTopping(new Toppings("Peppers", "REGULAR", false));
        sandwich.addTopping(new Toppings("Mayo", "SAUCE", false));

        return sandwich;
    }


}
