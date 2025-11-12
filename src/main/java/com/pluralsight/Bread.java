package com.pluralsight;

public class Bread {

    public static String [] type= {
      "white",
      "wheat",
      "Rye",
      "wrap"

    };
    public static boolean isValid(int choice){
        return choice >=1 && choice <= type.length;
    }

}
