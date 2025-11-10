package com.pluralsight;

import java.util.Map;
import java.util.Scanner;

public class SelectToppings {

    //Each Map has the topping name and the base price
    private static final Map<String, Double> MEATS = Map.of(
            "steak", 2.00, "ham", 1.50, "salami", 1.00,
            "roast beef", 1.50, "chicken", 1.00, "bacon", 2.00);

    private static final Map<String, Double> CHEESE = Map.of(
            "american", 1.00, "provolone", 1.00, "cheddar", 1.50, "swiss", 1.50);

    private static final Map<String, Double> REG_TOPPINGS = Map.ofEntries(
            Map.entry("lettuce", 0.30),
            Map.entry("peppers", 0.45),
            Map.entry("onions", 0.50),
            Map.entry("tomatoes", 0.25),
            Map.entry("jalapeños", 0.25),
            Map.entry("cucumbers", 0.25),
            Map.entry("pickles", 0.30),
            Map.entry("guacamole", 2.50),
            Map.entry("mushrooms", 0.75)
    );

}


private static final Map<String, Double> SAUCES = Map.of(
        "mayo", 0.25, "mustard", 0.25, "ketchup", 0.25,
        "ranch", 0.75, "thousand island", 0.75, "vinaigrette", 1.00);


// this method is called when cx is building a sub
//walks the cx through each topping in each categorey
public static void AddToppingsTosandwich(Sandwich sandwich) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n------- Add Toppings -------");
    //topping category which cx will be walked through
    selectCategory(scanner, "Meats", MEATS, sandwich);
    selectCategory(scanner, "Cheese", CHEESE, sandwich);
    selectCategory(scanner, "Regular Toppings", REG_TOPPINGS, sandwich);
    selectCategory(scanner, "Sauces", SAUCES, sandwich);
}
