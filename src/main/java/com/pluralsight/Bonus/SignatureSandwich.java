package com.pluralsight.Bonus;

import com.pluralsight.models.Toppings;

import java.util.ArrayList;
import java.util.List;

public class SignatureSandwich {

    private String signatureName;
    private String size;
    private String bread;
    private boolean toasted;
    private List<Toppings> toppings;

    // ---------- Constructor ----------
    public SignatureSandwich(String size, String bread, String signatureName) {
        this.signatureName = signatureName;
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.toasted = true; // default toasted for signature sandwiches
    }

    // ---------- Methods ----------
    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getSignatureName() {
        return signatureName;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(signatureName)
                .append(" (").append(size).append(" ").append(bread).append(")")
                .append(toasted ? " [Toasted]" : " [Not Toasted]")
                .append("\nToppings: ");

        for (Toppings t : toppings) {
            sb.append(t.getName()).append(", ");
        }

        // Remove trailing comma
        if (!toppings.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        return sb.toString();
    }

    // ---------- Factory Methods ----------
    public static SignatureSandwich createBLT(String size) {
        SignatureSandwich sandwich = new SignatureSandwich(size, "White", "BLT");
        sandwich.addTopping(new Toppings("Bacon", "MEAT", false));
        sandwich.addTopping(new Toppings("Cheddar Cheese", "CHEESE", false));
        sandwich.addTopping(new Toppings("Lettuce", "REGULAR", false));
        sandwich.addTopping(new Toppings("Tomato", "REGULAR", false));
        sandwich.addTopping(new Toppings("Ranch", "SAUCE", false));
        return sandwich;
    }

    public static SignatureSandwich createPhillyCheesesteak(String size) {
        SignatureSandwich sandwich = new SignatureSandwich(size, "White", "Philly Cheesesteak");
        sandwich.addTopping(new Toppings("Steak", "MEAT", false));
        sandwich.addTopping(new Toppings("American Cheese", "CHEESE", false));
        sandwich.addTopping(new Toppings("Peppers", "REGULAR", false));
        sandwich.addTopping(new Toppings("Mayo", "SAUCE", false));
        return sandwich;
    }

    @Override
    public String toString() {
        return getDescription();
    }


}