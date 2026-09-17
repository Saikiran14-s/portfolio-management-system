package com.portfolioproject.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.portfolioproject.model.User;
import com.portfolioproject.model.Stock;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static User user;

    static ArrayList<Stock> stockHoldings = new ArrayList<>();
    static ArrayList<MutualFund> mutualFundHoldings = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        System.out.println("=====================================");
        System.out.println("     STOCK PORTFOLIO MANAGEMENT");
        System.out.println("=====================================");

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

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    createUser();
                    break;

                case 2:
                    addStockHolding();
                    break;

                case 3:
                    addMutualFundHolding();
                    break;

                case 4:
                    displayUser();
                    break;

                case 5:
                    displayHoldings();
                    break;

                case 6:
                    System.out.println();
                    System.out.println(
                        "Thank you for using Stock Portfolio Management!"
                    );
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice! Please enter 1-6.");
            }

        } while (choice != 6);

        scanner.close();
    }


    // =========================================
    // CASE 1 - CREATE USER
    // =========================================

    public static void createUser() {

        System.out.println();
        System.out.println("---------- CREATE USER ----------");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        user = new User(userId, name, email);

        System.out.println();
        System.out.println("User created successfully!");
    }


    // =========================================
    // CASE 2 - ADD STOCK HOLDING
    // =========================================

    public static void addStockHolding() {

        if (user == null) {
            System.out.println();
            System.out.println("Please create a user first!");
            return;
        }

        System.out.println();
        System.out.println("---------- ADD STOCK HOLDING ----------");

        System.out.print("Enter Stock ID: ");
        String stockId = scanner.nextLine();

        System.out.print("Enter Stock Name: ");
        String stockName = scanner.nextLine();

        System.out.print("Enter Stock Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Stock stock = new Stock(stockId, stockName, price);

        stockHoldings.add(stock);

        System.out.println();
        System.out.println("Stock holding added successfully!");
    }


    // =========================================
    // CASE 3 - ADD MUTUAL FUND HOLDING
    // =========================================

    public static void addMutualFundHolding() {

        if (user == null) {
            System.out.println();
            System.out.println("Please create a user first!");
            return;
        }

        System.out.println();
        System.out.println(
            "---------- ADD MUTUAL FUND HOLDING ----------"
        );

        System.out.print("Enter Mutual Fund ID: ");
        String fundId = scanner.nextLine();

        System.out.print("Enter Mutual Fund Name: ");
        String fundName = scanner.nextLine();

        System.out.print("Enter Mutual Fund Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        MutualFund fund = new MutualFund(
            fundId,
            fundName,
            price
        );

        mutualFundHoldings.add(fund);

        System.out.println();
        System.out.println("Mutual fund holding added successfully!");
    }


    // =========================================
    // CASE 4 - DISPLAY USER
    // =========================================

    public static void displayUser() {

        System.out.println();
        System.out.println("---------- USER DETAILS ----------");

        if (user == null) {
            System.out.println("No user created yet.");
            return;
        }

        System.out.println("User ID : " + user.getUserid());
        System.out.println("Name    : " + user.getName());
        System.out.println("Email   : " + user.getEmail());
    }


    // =========================================
    // CASE 5 - DISPLAY HOLDINGS
    // =========================================

    public static void displayHoldings() {

        System.out.println();
        System.out.println("========== HOLDINGS ==========");

        if (user == null) {
            System.out.println("No user created yet.");
            return;
        }

        // =====================================
        // STOCK HOLDINGS
        // =====================================

        System.out.println();
        System.out.println("--- STOCK HOLDINGS ---");

        if (stockHoldings.isEmpty()) {

            System.out.println("No stock holdings.");

        } else {

            for (Stock stock : stockHoldings) {

                System.out.println("Stock ID   : " + stock.getStockid());
                System.out.println("Stock Name : " + stock.getStockname());
                System.out.println("Price      : " + stock.getPrice());
                System.out.println();
            }
        }


        // =====================================
        // MUTUAL FUND HOLDINGS
        // =====================================

        System.out.println("--- MUTUAL FUND HOLDINGS ---");

        if (mutualFundHoldings.isEmpty()) {

            System.out.println("No mutual fund holdings.");

        } else {

            for (MutualFund fund : mutualFundHoldings) {

                System.out.println("Fund ID    : " + fund.getFundId());
                System.out.println("Fund Name  : " + fund.getFundName());
                System.out.println("Price      : " + fund.getPrice());
                System.out.println();
            }
        }
    }


    // =========================================
    // MUTUAL FUND CLASS
    // =========================================

    static class MutualFund {

        private String fundId;
        private String fundName;
        private double price;

        public MutualFund(
                String fundId,
                String fundName,
                double price) {

            this.fundId = fundId;
            this.fundName = fundName;
            this.price = price;
        }

        public String getFundId() {
            return fundId;
        }

        public String getFundName() {
            return fundName;
        }

        public double getPrice() {
            return price;
        }
    }
}
        
    
        
        
   
  
	

