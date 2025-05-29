package com.Pluralsight;
import java.util.*;

import java.util.*;

// Represents a customizable sandwich item
public class Sandwich extends OrderItem {
    private String size;
    private String breadType;
    private Map<String, Integer> meats;
    private Map<String, Integer> cheeses;
    private List<String> regularToppings;
    private List<String> sauces;
    private boolean toasted;

    public Sandwich(String size, String breadType) {
        this.size = size;
        this.breadType = breadType;
        this.meats = new HashMap<>();
        this.cheeses = new HashMap<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.toasted = false;
    }

    // Sandwich Customization Methods (Extra for premium)
    public void addMeat(String meat) { meats.put(meat, meats.getOrDefault(meat, 0) + 1); }
    public void addExtraMeat(String meat) { addMeat(meat);}
    public void addCheese(String cheese) { cheeses.put(cheese, cheeses.getOrDefault(cheese, 0) +1); }
    public void addExtraCheese(String cheese) { addCheese(cheese);}
    public void addTopping(String topping) { regularToppings.add(topping); }
    public void addSauce(String sauce) { sauces.add(sauce); }
    public void setToasted(boolean toasted) { this.toasted = toasted; }

    //
    @Override
    public double getPrice() {
        double base = PriceConstants.BASE_PRICES.getOrDefault(size, 0.0);

        // Total meat/cheese counts
        int totalMeats = meats.values().stream().mapToInt(i -> i).sum();
        int totalCheeses = cheeses.values().stream().mapToInt(i -> i).sum();

        // Multiplies count of meals/cheeses
        double meatCost = totalMeats * PriceConstants.MEAT_PRICES.getOrDefault(size, 0.0);
        double cheeseCost = totalCheeses * PriceConstants.CHEESE_PRICES.getOrDefault(size, 0.0);
        return base + meatCost + cheeseCost;
    }

    // Builds a readable breakdown of the full sandwich
    @Override
    public String getDescription() {
        return size + "\" " + breadType + " Sandwich\nMeats: " + meats +
                "\nCheeses: " + cheeses +
                "\nToppings: " + regularToppings +
                "\nSauces: " + sauces +
                "\nToasted: " + (toasted ? "Yes" : "No") +
                "\nPrice: $" + String.format("%.2f", getPrice());
    }
}
