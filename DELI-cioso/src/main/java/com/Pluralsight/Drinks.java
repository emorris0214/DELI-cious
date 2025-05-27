package com.Pluralsight;

// Represents a drink item
public class Drinks extends OrderItem {
    private String size;
    private String flavor;

    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return PriceConstants.DRINK_PRICES.getOrDefault(size, 0.0);
    }

    @Override
    public String getDescription() {
        return size + " Drink - " + flavor + " ($" + getPrice() + ")";
    }
}

