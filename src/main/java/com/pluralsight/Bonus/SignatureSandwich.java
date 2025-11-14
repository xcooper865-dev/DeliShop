package com.pluralsight.Bonus;

import com.pluralsight.models.Sandwich;
import com.pluralsight.models.Toppings;
                               //extends the sandwich class
public class SignatureSandwich extends Sandwich {  // Predefined sandwich

    private String signatureName; // Sandwich name (e.g., BLT, Philly)

    // ---------- Constructor ----------// Call parent Sandwich constructor,
    public SignatureSandwich(String size, String bread, String signatureName) {
        super(size, bread, true);  //toasted by default
        this.signatureName = signatureName;//name of signature sandwich
    }

    // ---------- Methods ----------
    public String getSignatureName() {
        return signatureName;// return the name of BLT,Philly
    }

    public void setSignatureName(String name) {//sets the name of the sandwich
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

        return sandwich;// returns a fully loaded BLT
    }

    public static SignatureSandwich createPhillyCheesesteak() {
        SignatureSandwich sandwich = new SignatureSandwich("8", "White", "Philly Cheesesteak");

        // Add Philly Cheesesteak toppings
        sandwich.addTopping(new Toppings("Steak", "MEAT", false));
        sandwich.addTopping(new Toppings("American Cheese", "CHEESE", false));
        sandwich.addTopping(new Toppings("Peppers", "REGULAR", false));
        sandwich.addTopping(new Toppings("Mayo", "SAUCE", false));

        return sandwich;// returns a fully loaded Philly
    }


}
