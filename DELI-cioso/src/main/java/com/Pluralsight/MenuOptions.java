package com.Pluralsight;

import java.util.Arrays;
import java.util.List;

// Holds available sandwich ingredients for the shop
// Static lists for all valid user choices & Used for menu display and validation
public class MenuOptions {
    public static final List<String> BREAD_TYPES = Arrays.asList("White", "Wheat", "Rye", "Wrap");
    public static final List<String> SIZES = Arrays.asList("4", "8", "12");

    public static final List<String> MEATS = Arrays.asList("Turkey", "Ham", "Roast Beef", "Chicken", "Salami", "Bacon");
    public static final List<String> CHEESES = Arrays.asList("American", "Swiss", "Cheddar", "Provolone");

    public static final List<String> TOPPINGS = Arrays.asList("Lettuce", "Tomato", "Onion", "Pickles", "Olives", "Peppers", "Mushroom", "Jalapeno", "Guacamole");
    public static final List<String> SAUCES = Arrays.asList("Ketchup", "Mayo", "Mustard", "Ranch", "Oil", "Vinaigrette", "Thousand-Island");

    public static final List<String> DRINK_FLAVORS = Arrays.asList("Water", "Cola", "Lemonade", "Root Beer", "Orange Soda");
    public static final List<String> DRINK_SIZES = Arrays.asList("Small", "Medium", "Large");

    public static final List<String> CHIP_TYPES = Arrays.asList("Regular", "BBQ", "Sour Cream & Onion", "Salt & Vinegar");
}

