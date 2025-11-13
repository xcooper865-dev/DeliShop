package com.pluralsight.models;

public abstract class MenuItems {  //menu items is a abstract class for all menu items in the deli/Penn station

    public abstract double getPrice();//return thr price of the menu item
    //abstract method that can implemented by all subclasses and return price as a double

    public abstract String getDescription();// returns description of the menu item
    //abstract method that can be implemented by all subclasses

}


