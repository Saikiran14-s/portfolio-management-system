package com.portfolioproject.model;

public class Holding {

    private String holdingId;
    private Stock stock;
    private MutualFund mutualFund;
    private int quantity;

    // Constructor for Stock holding
    public Holding(String holdingId, Stock stock, int quantity) {

        this.holdingId = holdingId;
        this.stock = stock;
        this.quantity = quantity;
        this.mutualFund = null;
    }

    // Constructor for Mutual Fund holding
    public Holding(String holdingId, MutualFund mutualFund, int quantity) {

        this.holdingId = holdingId;
        this.mutualFund = mutualFund;
        this.quantity = quantity;
        this.stock = null;
    }

    // Get Holding ID
    public String getHoldingId() {
        return holdingId;
    }

    // Get Stock
    public Stock getStock() {
        return stock;
    }

    // Get Mutual Fund
    public MutualFund getMutualFund() {
        return mutualFund;
    }

    // Get Quantity
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {

        if (stock != null) {

            return "Holding ID: " + holdingId
                    + ", Stock: " + stock
                    + ", Quantity: " + quantity;

        } else if (mutualFund != null) {

            return "Holding ID: " + holdingId
                    + ", Mutual Fund: " + mutualFund
                    + ", Quantity: " + quantity;
        }

        return "Holding ID: " + holdingId
                + ", Quantity: " + quantity;
    }
}