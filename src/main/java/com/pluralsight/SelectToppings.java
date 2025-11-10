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
