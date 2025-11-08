package com.pluralsight;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("""
                    --------------------------
                          Penn Station
                    ---------------------------
                    1) New order
                    0) Exit      
                    ----------------------------
                    1
                    
                    """);

            String choice = ConsoleHelper.promptForString("Enter your choice").trim().toUpperCase(); // Ask the user for a choice

            switch (choice) {

                case "1" -> Neworder();
                case "0" -> {
                    Exit();
                    return;
                }


            }
        }
    }

    private static void Exit() {
    }

    private static void Neworder() {
        OrderMenu.Ordermenu(); //calls the order menu
    }


}


