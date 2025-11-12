package com.pluralsight;

public class SelectToppings {
    
    public static String [] Meats ={
            "steak",
            "HAm",
            "salami",
            "Bacon",
            "chicken",
            "roast Beef"
            
    };
    
    public static String [] Cheese ={
            "swiss",
            "provolone",
            "American",
            "Cheddar"
            
    };
 
    public static String [] Regular ={
            "Lettuce",
            "Tomato",
            "Onion",
            "Jalapenos",
            "cucomber",
            "Pickles",
            "guac",
            "Mushrooms"
    }
            ;

    public static String [] Sauce ={
            "Mayo",
            "Mustard",
            "ketcup",
            "Ranch",
            "Thousand Island",
            "vinaigrette"
    };
   public static String [] Sides ={
           
           "au jus",
           "sauce"
   };

    private String name;
    private String category;
    private boolean extras;

    public SelectToppings(String name, String category, boolean extras) {
        this.name = name;
        this.category = category;
        this.extras = extras;
    }
    public static boolean isVAlidChoice(int choice,String [] options){

        return choice >= 1 && choice <= options.length;
    }



}