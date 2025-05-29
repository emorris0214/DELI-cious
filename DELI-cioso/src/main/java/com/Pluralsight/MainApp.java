package com.Pluralsight;

import java.util.Scanner;

public class MainApp {
    //Calling in Scanner
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {

            // Home Screen
            System.out.println("\n--- Welcome to Hoagies 4 Da Homies! ---");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            String choice = keyboard.nextLine();

            switch (choice) {
                case "1":
                    startNewOrder();
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }

    //Creation of new order
    private static void startNewOrder() {
        Order order = new Order();

        boolean ordering = true;
        while (ordering) {
            System.out.println("\n--- New Order Menu, Homie ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");
            String option = keyboard.nextLine();

            switch (option) {
                case "1":
                    order.addItem(createSandwich());
                    break;
                case "2":
                    order.addItem(createDrink());
                    break;
                case "3":
                    order.addItem(createChips());
                    break;
                case "4":
                    System.out.println("\n" + order.getDetails());
                    System.out.println("Confirm Order? (Y/N): ");
                    if (keyboard.nextLine().equalsIgnoreCase("Y")) {
                        ReceiptWriter.writeReceipt(order);
                        ordering = false;
                    }
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static Sandwich createSandwich() {
        System.out.println("\n--- Create a Sandwich, Homes ---");

        // Select size
        String size = promptChoice("Select sandwich size", MenuOptions.SIZES);

        // Select bread
        String bread = promptChoice("Select bread type", MenuOptions.BREAD_TYPES);

        Sandwich sandwich = new Sandwich(size, bread);

        // Add Meats
        addMultipleChoices("Select meats (enter 'done' to finish)", MenuOptions.MEATS, sandwich::addMeat);

        // Add extra meats
        System.out.println("Any extra meats? (Y/N): ");
        if (keyboard.nextLine().equalsIgnoreCase("Y")) {
            addMultipleChoices("Select extra meats (enter 'done' to finish)", MenuOptions.MEATS, sandwich::addExtraMeat);
        }

        // Add cheeses
        addMultipleChoices("Select cheeses (enter 'done' to finish)", MenuOptions.CHEESES, sandwich::addCheese);

        // Add extra cheeses
        System.out.println("Any extra cheeses? (Y/N): ");
        if (keyboard.nextLine().equalsIgnoreCase("Y")) {
            addMultipleChoices("Select extra cheeses (enter 'done' to finish)", MenuOptions.CHEESES, sandwich::addExtraCheese);
        }

        // Add regular toppings
        addMultipleChoices("Select regular toppings (enter 'done' to finish)", MenuOptions.TOPPINGS, sandwich::addTopping);

        // Add sauces
        addMultipleChoices("Select sauces (enter 'done' to finish)", MenuOptions.SAUCES, sandwich::addSauce);

        // Toasted?
        System.out.println("Would you like the sandwich toasted? (Y/N): ");
        sandwich.setToasted(keyboard.nextLine().equalsIgnoreCase("Y"));

        return sandwich;
    }

    private static Drinks createDrink() {
        System.out.println("\n--- Add a Drink, Homie ---");
        String size = promptChoice("Select drink size", MenuOptions.DRINK_SIZES);
        String flavor = promptChoice("Select drink flavor", MenuOptions.DRINK_FLAVORS);
        return new Drinks(size, flavor);
    }

    private static Chips createChips() {
        System.out.println("\n--- Add a Drink, Homie ---");
        String type = promptChoice("Select chip type", MenuOptions.CHIP_TYPES);
        return new Chips(type);
    }

    private static String promptChoice(String prompt, java.util.List<String> options) {
        System.out.println(prompt + ":");
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, options.get(i));
        }

        while (true) {
            System.out.println("Enter number: ");
            try {
                int choice = Integer.parseInt(keyboard.nextLine()) - 1;
                if (choice >= 0 && choice < options.size()) {
                    return options.get(choice);
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Try again.");
        }
    }

    private static void addMultipleChoices(String prompt, java.util.List<String> options, java.util.function.Consumer<String> adder) {
        System.out.println(prompt);
        while (true) {
            for (int i = 0; i < options.size(); i++) {
                System.out.printf("%d) %s\n", i + 1, options.get(i));
            }
            System.out.println("Enter number (or 'done'): ");
            String input = keyboard.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            try {
                int choice = Integer.parseInt(input) - 1;
                if (choice >= 0 && choice < options.size()) {
                    adder.accept(options.get(choice));
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }
}
