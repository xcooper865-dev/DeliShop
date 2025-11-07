package com.pluralsight;

import java.time.LocalTime;

public class OrderMenu {

    public static void Ordermenu(){
        while (true) {
            // SUBMENU LOOP stays in ledger menu until the user chooses to go back to the home screen
            // uses the same infinite loop pattern as main menu
            System.out.println("""
                    =============================
                           Order menu
                    =============================
                    1) Add Sandwich
                    2) Add Drink
                    3) Add chips
                    4) Check out
                    0) cancel order
                    -----------------------------
                                           page.2
                    """);

            String choice = ConsoleHelper.promptForString("Enter your choice").trim().toUpperCase();

            switch (choice) {

                case "1" -> AddSandwich();
                case "2" -> AddDrink();
                case "3" -> AddChips();
                case "4" -> CheckOut();
                case "5" -> {
                    CancelOrder();
                    return;
                }

            }
        }
    }

    private static void AddSandwich() {
        System.out.println("\n======= Build your Sub========");


        //size

        System.out.println("\n choose size");// prompt for size of sandwich 
        System.out.println("1) 4\"- $5.50");
        System.out.println("2) 8\" - $7.00");
        System.out.println("3) 12\"- $ 12.00");
        String sizeChoice = ConsoleHelper.promptForString("choose your chioce");

        String size = switch (sizeChoice){

        };


    }

    private static void CancelOrder() {
        System.out.println("cancel Order");
    }

    private static void CheckOut() {
    }

    private static void AddChips() {
    }

    private static void AddDrink() {



    }
}
