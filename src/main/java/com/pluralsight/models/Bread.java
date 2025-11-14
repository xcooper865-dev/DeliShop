package com.pluralsight.models;

public class Bread {// store avalible bread types and validates cx selection

    public static String [] type= {// array of avalabile bread types
      "white",
      "wheat",
      "Rye",
      "wrap"

    };
    public static boolean isValid(int choice){
        return choice >=1 && choice <= type.length;//true if choice is between 1 and the number of bread types false otherwise
    }

}
