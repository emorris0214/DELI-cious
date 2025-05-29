## Hoagies 4 Da Homies POS System

A Java console-based point-of-sale (POS) application for a sandwich shop, designed to let customers build custom sandwiches, choose drinks and chips, and receive a printed receipt.

---

## Project Overview

This application simulates a real-world deli ordering system using object-oriented programming principles. Customers can:

- Customize sandwiches (bread, size, meats, cheeses, toppings, sauces)
- Add extra meats/cheeses (premium charge applies)
- Choose drinks (by size and flavor)
- Choose chips (by type)
- Checkout and generate a detailed receipt

---

## Features

- **Modular OOP structure** with reusable components
- **Dynamic pricing** based on sandwich size and extras
- **Receipt generation** with timestamped `.txt` files
- **Centralized configuration** for menu options and pricing
- **Input validation** and user-friendly prompts

---

## Folder Structure

DELI-cioso/
├── receipts/ # Auto-generated folder for receipt files
├── com/
│ └── Pluralsight/
│ ├── Chips.java
│ ├── Drinks.java
│ ├── MainApp.java
│ ├── MenuOptions.java
│ ├── Order.java
│ ├── OrderItem.java
│ ├── PriceConstants.java
│ ├── ReceiptWriter.java
│ └── Sandwich.java
