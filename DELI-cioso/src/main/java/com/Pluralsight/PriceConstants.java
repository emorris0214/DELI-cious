package com.Pluralsight;

import java.util.HashMap;
import java.util.Map;

// Stores static price constants and functional pricing maps
// Makes pricing logic more centralized
public class PriceConstants {
    public static final Map<String, Double> BASE_PRICES = new HashMap<>();
    public static final Map<String, Double> MEAT_PRICES = new HashMap<>();
    public static final Map<String, Double> CHEESE_PRICES = new HashMap<>();
    public static final Map<String, Double> DRINK_PRICES = new HashMap<>();

    public static final double CHIPS = 1.50;

    static {
        BASE_PRICES.put("4", 5.50);
        BASE_PRICES.put("8", 7.00);
        BASE_PRICES.put("12", 8.50);

        MEAT_PRICES.put("4", 1.00);
        MEAT_PRICES.put("8", 2.00);
        MEAT_PRICES.put("12", 3.00);

        CHEESE_PRICES.put("4", 0.75);
        CHEESE_PRICES.put("8", 1.50);
        CHEESE_PRICES.put("12", 2.25);

        DRINK_PRICES.put("Small", 2.00);
        DRINK_PRICES.put("Medium", 2.50);
        DRINK_PRICES.put("Large", 3.00);
    }
}
