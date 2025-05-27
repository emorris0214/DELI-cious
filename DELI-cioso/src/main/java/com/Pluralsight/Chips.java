package com.Pluralsight;

// Represents a chips item
public class Chips extends OrderItem {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public double getPrice() {
        return PriceConstants.CHIPS;
    }

    @Override
    public String getDescription() {
        return "Chips - " + type + " ($" + getPrice() + ")";
    }
}

