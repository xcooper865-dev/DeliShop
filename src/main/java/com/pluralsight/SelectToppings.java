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

   private static final Map<String, Double> SAUCES = Map.of(
            "mayo", 0.25, "mustard", 0.25, "ketchup", 0.25,
            "ranch", 0.75, "thousand island", 0.75, "vinaigrette", 1.00);


    // this method is called when cx is building a sub
    // walks the cx through each topping in each category
    public static void AddToppingsTosandwich(Sandwich sandwich) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------- Add Toppings -------");

        // topping categories which cx will be walked through
        selectCategory(scanner, "Meats", MEATS, sandwich);
        selectCategory(scanner, "Cheese", CHEESE, sandwich);
        selectCategory(scanner, "Regular Toppings", REG_TOPPINGS, sandwich);
        selectCategory(scanner, "Sauces", SAUCES, sandwich);
    }

    // displays the available options in each category
    // cx can also choose multiple toppings until they type done
    // this method also adds each selected topping to sub
    private static void selectCategory(Scanner scanner, String category, Map<String, Double> options, Sandwich sandwich) {

        System.out.println("\n" + category + ": " + options.keySet()); // display all available toppings in category

        while (true) { // loops until the cx types done
            System.out.print("Choose a " + category.toLowerCase() + " (or type 'done'): ");
            String choice = scanner.nextLine().trim().toLowerCase(); // cx can type lower case or upper and will still work

            if (choice.equals("done")) break; // exits category if cx is done
            if (!options.containsKey(choice)) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            double price = options.get(choice); // get the price for the selected topping

            // asks if cx wants extra toppings and if so, how many
            System.out.print("How many extras for " + choice + "? (0 for regular): ");
            String input = scanner.nextLine().trim();

            int extras = 0; // default value
            try {
                // if user presses enter or types nothing, default to 0
                extras = input.isEmpty() ? 0 : Integer.parseInt(input);
                if (extras < 0) extras = 0; // prevent negative extras
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, using 0 extras.");
            }
        }
    }

}