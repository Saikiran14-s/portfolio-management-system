package com.portfolioproject.app;

import com.portfolioproject.model.User;
import com.portfolioproject.model.Stock;
import com.portfolioproject.model.MutualFund;
import com.portfolioproject.model.Holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // Store all users
    static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("   STOCK PORTFOLIO MANAGEMENT SYSTEM");
        System.out.println("=====================================");

        int choice;

        do {
            System.out.println();
            System.out.println("----------- MENU -----------");
            System.out.println("1. Create User");
            System.out.println("2. Add Stock Holding");
            System.out.println("3. Add Mutual Fund Holding");
            System.out.println("4. Display User");
            System.out.println("5. Display Holdings");
            System.out.println("6. Exit");
            System.out.println("----------------------------");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {

                case 1:
                    createUser(sc);
                    break;

                case 2:
                    addStockHolding(sc);
                    break;

                case 3:
                    addMutualFundHolding(sc);
                    break;

                case 4:
                    displayUsers();
                    break;

                case 5:
                    displayHoldings();
                    break;

                case 6:
                    System.out.println();
                    System.out.println(
                            "Thank you for using Stock Portfolio Management System."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please enter a number from 1 to 6."
                    );
            }

        } while (choice != 6);

        sc.close();
    }

    // =====================================================
    // CREATE USER
    // =====================================================
    private static void createUser(Scanner sc) {

        System.out.println();
        System.out.println("--- Create User ---");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine().trim();

        if (userId.isEmpty()) {
            System.out.println("User ID cannot be empty.");
            return;
        }

        if (findUser(userId) != null) {
            System.out.println("User ID already exists.");
            return;
        }

        System.out.print("Enter User Name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("User name cannot be empty.");
            return;
        }

        System.out.print("Enter Email: ");
        String email = sc.nextLine().trim();

        if (email.isEmpty()) {
            System.out.println("Email cannot be empty.");
            return;
        }

         User newUser = new User(userId, name, email);
        
        //Add user to users list
         users.put(userId, newUser);
           
        System.out.println("User created successfully!");
    }

    // =====================================================
    // ADD STOCK HOLDING
    // =====================================================
    private static void addStockHolding(Scanner sc) {

        if (users.isEmpty()) {
            System.out.println("Please create a user first.");
            return;
        }

        System.out.println();
        System.out.println("--- Add Stock Holding ---");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine().trim();

        User user = findUser(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter Holding ID: ");
        String holdingId = sc.nextLine().trim();

        if (holdingId.isEmpty()) {
            System.out.println("Holding ID cannot be empty.");
            return;
        }

        System.out.print("Enter Stock ID: ");
        String stockId = sc.nextLine().trim();

        if (stockId.isEmpty()) {
            System.out.println("Stock ID cannot be empty.");
            return;
        }

        System.out.print("Enter Stock Name: ");
        String stockName = sc.nextLine().trim();

        if (stockName.isEmpty()) {
            System.out.println("Stock name cannot be empty.");
            return;
        }

        double purchasePrice = readDouble(
                sc,
                "Enter Purchase Price: "
        );

        double currentPrice = readDouble(
                sc,
                "Enter Current Price: "
        );

        int quantity = readPositiveInt(
                sc,
                "Enter Quantity: "
        );

        Stock stock = new Stock(
                stockId,
                stockName,
                purchasePrice,
                currentPrice
        );

        Holding holding = new Holding(
                holdingId,
                stock,
                quantity
        );

        user.addHolding(holding);

        System.out.println("Stock holding added successfully!");
    }

    // =====================================================
    // ADD MUTUAL FUND HOLDING
    // =====================================================
    private static void addMutualFundHolding(Scanner sc) {

        if (users.isEmpty()) {
            System.out.println("Please create a user first.");
            return;
        }

        System.out.println();
        System.out.println("--- Add Mutual Fund Holding ---");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine().trim();

        User user = findUser(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter Holding ID: ");
        String holdingId = sc.nextLine().trim();

        if (holdingId.isEmpty()) {
            System.out.println("Holding ID cannot be empty.");
            return;
        }

        System.out.print("Enter Mutual Fund ID: ");
        String mutualFundId = sc.nextLine().trim();

        if (mutualFundId.isEmpty()) {
            System.out.println("Mutual Fund ID cannot be empty.");
            return;
        }

        System.out.print("Enter Mutual Fund Name: ");
        String mutualFundName = sc.nextLine().trim();

        if (mutualFundName.isEmpty()) {
            System.out.println("Mutual Fund name cannot be empty.");
            return;
        }

        double purchasePrice = readDouble(
                sc,
                "Enter Purchase Price: "
        );

        double nav = readDouble(
                sc,
                "Enter NAV: "
        );

        int quantity = readPositiveInt(
                sc,
                "Enter Quantity: "
        );

        MutualFund mutualFund = new MutualFund(
                mutualFundId,
                mutualFundName,
                purchasePrice,
                nav
        );

        Holding holding = new Holding(
                holdingId,
                mutualFund,
                quantity
        );

        user.addHolding(holding);

        System.out.println("Mutual fund holding added successfully!");
    }

    // =====================================================
    // DISPLAY USERS
    // =====================================================
    private static void displayUsers() {

        if (users.isEmpty()) {
            System.out.println("No users created.");
            return;
        }

        System.out.println();
        System.out.println("--- User Details ---");
       
        for (User user : users.values() ) 
        {
        	user.display();
        	System.out.println("------------------");
          }
        }
       

    // =====================================================
    // DISPLAY HOLDINGS
    // =====================================================
    private static void displayHoldings() {

        if (users.isEmpty()) {
            System.out.println("No users created.");
            return;
        }

        System.out.println();
        System.out.println("--- Holdings ---");

         for (User user : users.values() ) {

            System.out.println();
            System.out.println("User ID: " + user.getUserid());
            System.out.println("User Name: " + user.getName());

            if (user.getHoldings() == null ||
                    user.getHoldings().isEmpty()) {

                System.out.println("No holdings available.");

            } else {

                for (Holding holding : user.getHoldings()) {
                    System.out.println(holding);
                }
            }

            System.out.println("----------------------------");
        }
    }

    // =====================================================
    // FIND USER BY USER ID
    // =====================================================
    private static User findUser(String userid) 

    	{
    		return users.get(userid);
    	}
    

    // =====================================================
    // READ INTEGER SAFELY
    // =====================================================
    private static int readInt(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a valid integer."
                );
            }
        }
    }

    // =====================================================
    // READ POSITIVE INTEGER
    // =====================================================
    private static int readPositiveInt(
            Scanner sc,
            String message) {

        while (true) {

            int value = readInt(sc, message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Quantity must be greater than 0."
            );
        }
    }

    // =====================================================
    // READ DOUBLE SAFELY
    // =====================================================
    private static double readDouble(
            Scanner sc,
            String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            try {

                double value = Double.parseDouble(input);

                if (value < 0) {
                    System.out.println(
                            "Value cannot be negative."
                    );
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );
            }
        }
    }
}



