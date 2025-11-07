package com.pluralsight;

public class OrderMenu {

    public static void Ordermenu(){
        while (true) {
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
                case "1" -> Sandwich.AddSandwich.AddSandwich();
                case "2" -> AddDrink();
                case "3" -> AddChips();
                case "4" -> CheckOut();
                case "0" -> {
                    CancelOrder();
                    return;
                }
            }
        }
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