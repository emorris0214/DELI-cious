package com.Pluralsight;

import java.util.*;

// Represents an entire order consisting of various order items
public class Order {
    private List<OrderItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getPrice)
                .sum();
    }

    public String getDetails() {
        StringBuilder sb = new StringBuilder("Order Details:\n");
        for (OrderItem item : items) {
            sb.append(item.getDescription()).append("\n\n");
        }
        sb.append("Total: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
