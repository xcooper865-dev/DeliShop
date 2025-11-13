package com.pluralsight.models;

public class SelectToppings { // selectToppings help manage and validate topping selection
    
    public static String [] Meats ={ //premium toppings with size based pricing
            "steak",
            "HAm",
            "salami",
            "Bacon",
            "chicken",
            "roast Beef"
            
    };
    
    public static String [] Cheese ={ //premium toppings with size based pricing
            "swiss",
            "provolone",
            "American",
            "Cheddar"
            
    };
 
    public static String [] Regular ={// regular toppings that come are free
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

    public static String [] Sauce ={ // array of sauces
            "Mayo",
            "Mustard",
            "ketcup",
            "Ranch",
            "Thousand Island",
            "vinaigrette"
    };
   public static String [] Sides ={ //side of options that complement the sandwich
           
           "au jus",
           "sauce"
   };

    private String name;
    private String category;
    private boolean extras;

       // constructor
    public SelectToppings(String name, String category, boolean extras) {
        this.name = name;
        this.category = category;
        this.extras = extras;
    }
    public static boolean isVAlidChoice(int choice,String [] options){

        return choice >= 1 && choice <= options.length;
    }



}