package com.pluralsight;


import com.pluralsight.ReceiptFileManager;
import com.pluralsight.*;

import java.util.ArrayList;
import java.util.List;

public class OrderMenu {

    // store all menu items in the list(sandwiches, drinks, chips, etc.)
    private static final List<MenuItems> currentOrder = new ArrayList<>();

    public static void Ordermenu() { //runs in a loop until cx checks out or cancells order
        while (true) { //loop that keeps showing menu until user exits

            //display order menu with available options
            System.out.println(""" 
                    =============================
                           Order menu
                    =============================
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Check out
                    0) Cancel order
                    -----------------------------
                                           page.2
                    """);

            String choice = ConsoleHelper.promptForString("Enter your choice").trim().toUpperCase();

            switch (choice) { //the cx menu selection
                case "1" -> currentOrder.add(Sandwich.AddSandwich()); //add sandwich to order
                case "2" -> currentOrder.add(Drinks.AddDrink());//add drink to order
                case "3" -> currentOrder.add(Chips.AddChips());//add chips to order
                case "4" -> CheckOut();//checkout displays the saved receipt
                case "0" -> {//cancels the entire order
                    CancelOrder();
                    return;//exits order loop
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void CancelOrder() { //cancels order
        System.out.println("Order cancelled.");
        currentOrder.clear();//removes items from the order
    }

    private static void CheckOut() {// displays checkout checks if items are in order
        if (currentOrder.isEmpty()) {
            System.out.println("Your order is empty!");
            return;//if nothing ordered exit checkout

        }

        System.out.println("\n===== CHECKOUT =====");//checkout Header
        double total = 0;//accumulate the total price
        for (MenuItems item : currentOrder) {// loop through each item in order displays and calculate total

            //display each items description and price
            System.out.println(item.getDescription() + " - $" + item.getTotalPrice());




