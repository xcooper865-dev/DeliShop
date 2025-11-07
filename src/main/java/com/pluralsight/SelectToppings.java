package com.pluralsight;

import java.util.Map;
import java.util.Scanner;

public class SelectToppings {

    private static final Map<String ,Double>Meats = Map.of("Steak",2.00,"Ham" ,1.50,"Salami", 1.00,"Roast Beef",1.50,"Chicken",1.00,"Bacon",2.00);

    private static final Map<String , Double>Cheese = Map.of("American",1.00,"Provolone",1.00,"Cheddar",1.50,"Swiss",1.50);

    private static final Map<String ,Double> REGtoppings = Map.ofEntries(Map.entry("Lettuce",0.30),Map.entry("Peppers",0.45),Map.entry("Onions",0.50),Map.entry("Tomatos",0.25),Map.entry("Jalapenos",0.25),Map.entry("Cucombers",0.25),Map.entry("Pickles",0.30),Map.entry("Guacamole",2.50),Map.entry("Mushrooms",0.75));

    private static final Map<String,Double> Sauces = Map.of("Mayo",0.25,"Mustard",0.25,"Ketchup",0.25,"ranch",0.75,"Thousand Island",0.75,"Vinaigrette",1.00);


    public static void AddToppingsTosandwich(Sandwich sandwich){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n ------- Add Toppings-----");
        selectCategory(scanner,"Meats",Meats,sandwich);
        selectCategory(scanner,"Cheese",Cheese,sandwich);
        selectCategory(scanner,"Regular Toppings ",REGtoppings,sandwich);
        selectCategory(scanner,"Sauces",Sauces,sandwich);

    }

    private static void selectCategory(Scanner scanner, String meats, Map<String, Double> meats1, Sandwich sandwich) {

        String category = "";
        String options = "";
        System.out.println("\n"+ category+":"+options.keySet());

        while (true){
            System.out.println("Choose a" + category.toLowerCase()+"(Type done if done)");
            String choice = scanner.nextLine().toLowerCase();

            if(choice.equals("done"))break;
            if (!options.contains(choice)){

                System.out.println("invalid choice, try again");
                continue;
            }
            double price = options.get(choice);
            System.out.println("How many extra toppings"+ choice+"(0 for regular)");
            int extras = Integer.parseInt(scanner.nextLine());

            Toppings toppings = new Toppings(choice,category,price);
            toppings.setExtras(extras);
            sandwich.AddToppings(toppings);

            System.out.println(choice+"added");
        }

    }


}
