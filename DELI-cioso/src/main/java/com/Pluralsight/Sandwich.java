package com.Pluralsight;
import java.util.*;

import java.util.*;

// Represents a customizable sandwich item
public class Sandwich extends OrderItem {
    private String size;
    private String breadType;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> regularToppings;
    private List<String> sauces;
    private boolean toasted;

    public Sandwich(String size, String breadType) {
        this.size = size;
        this.breadType = breadType;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.toasted = false;
    }

    public void addMeat(String meat) { meats.put(meat, meats.getOrDefault(meat, 0) + 1); }
    public void addCheese(String cheese) { cheeses.put(cheese, cheeses.getOrDefault(cheese, 0) +1); }
    public void addTopping(String topping) { regularToppings.add(topping); }
    public void addSauce(String sauce) { sauces.add(sauce); }
    public void setToasted(boolean toasted) { this.toasted = toasted; }

    @Override
    public double getPrice() {
        double base = PriceConstants.BASE_PRICES.getOrDefault(size, 0.0);
        double meatCost = meats.size() * PriceConstants.MEAT_PRICES.getOrDefault(size, 0.0);
        double cheeseCost = cheeses.size() * PriceConstants.CHEESE_PRICES.getOrDefault(size, 0.0);
        return base + meatCost + cheeseCost;
    }

    @Override
    public String getDescription() {
        return size + "\" " + breadType + " Sandwich\nMeats: " + meats +
                "\nCheeses: " + cheeses +
                "\nToppings: " + regularToppings +
                "\nSauces: " + sauces +
                "\nToasted: " + (toasted ? "Yes" : "No");
    }
}
