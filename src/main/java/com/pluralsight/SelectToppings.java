package com.pluralsight;

import java.util.Map;
import java.util.Scanner;

public class SelectToppings {

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

    private static final Map<String, Double> SAUCES = Map.of(
            "mayo", 0.25, "mustard", 0.25, "ketchup", 0.25,
            "ranch", 0.75, "thousand island", 0.75, "vinaigrette", 1.00);

    // MAIN ENTRY POINT
    public static void AddToppingsTosandwich(Sandwich sandwich) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------- Add Toppings -------");
        selectCategory(scanner, "Meats", MEATS, sandwich);
        selectCategory(scanner, "Cheese", CHEESE, sandwich);
        selectCategory(scanner, "Regular Toppings", REG_TOPPINGS, sandwich);
        selectCategory(scanner, "Sauces", SAUCES, sandwich);
    }

    // Handles one category at a time
    private static void selectCategory(Scanner scanner, String category, Map<String, Double> options, Sandwich sandwich) {
        System.out.println("\n" + category + ": " + options.keySet());

        while (true) {
            System.out.print("Choose a " + category.toLowerCase() + " (or type 'done'): ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("done")) break;
            if (!options.containsKey(choice)) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            double price = options.get(choice);
            System.out.print("How many extras for " + choice + "? (0 for regular): ");
            int extras = Integer.parseInt(scanner.nextLine());

            // Create and add topping
            Toppings topping = new Toppings(choice, category, price);
            topping.setExtras(extras);
            sandwich.AddToppings(topping);

            System.out.println(choice + " added!");
        }
    }
}