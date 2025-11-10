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
