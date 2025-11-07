package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String size;
    private String bread;
    private List<Toppings> toppings = new ArrayList<>();
    private double basePrice;



    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;
    }

    public class AddSandwich {

        public static void AddSandwich() {  // ← Make it public and static
            System.out.println("\n======= Build your Sub========");

            //size of Sub
            System.out.println("\n choose size");
            System.out.println("1) 4\"- $5.50");
            System.out.println("2) 8\" - $7.00");
            System.out.println("3) 12\"- $ 12.00");
            String sizeChoice = ConsoleHelper.promptForString("choose your choice").trim();

            String size = switch (sizeChoice) {
                case "1" -> "4\"";
                case "2" -> "8\"";
                case "3" -> "12\"";
                default -> {
                    System.out.println("Invalid choice");
                    yield "8\"";
                }
            };

            // choose Bread of your choice
            System.out.println("\nChoose the bread of your choice");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");
            String breadOptions = ConsoleHelper.promptForString("Bread of choice ");

            String bread = switch (breadOptions) {
                case "1" -> "White";
                case "2" -> "Wheat";
                case "3" -> "Rye";
                case "4" -> "Wrap";
                default -> {
                    System.out.println("Invalid Option Default choice to white bread ");
                    yield "White";
                }
            };




            Sandwich sandwich = new Sandwich(size,bread);
            SelectToppings.AddToppingsTosandwich(sandwich);

            System.out.println("\n  final order");
            System.out.println(sandwich);


            // Create the Sub
            //Sandwich sandwich = new Sandwich(size, bread);
            System.out.println("Sandwich created: " + sandwich);

            // Return the sandwich or add to order here
        }
        public void AddToppings(Toppings toppings){
            toppings.add(toppings);
        }
        public double getFullPrice() {
            double total = basePrice;
            for(Toppings t : toppings){
                total += t.getPrice();
            }
            return total;

        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(size).append(" sandwich on ").append(bread).append("\n");
            sb.append("Toppings:\n");
            if (toppings.isEmpty()) {
                sb.append("  None\n");
            } else {
                for (Toppings t : toppings) {
                    sb.append("  - ").append(t).append("\n");
                }
            }
            sb.append("Total: $").append(String.format("%.2f", getFullPrice()));
            return sb.toString();



        }

    }




    }




