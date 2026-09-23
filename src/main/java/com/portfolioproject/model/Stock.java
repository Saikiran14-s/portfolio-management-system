package com.portfolioproject.model;

public class Stock extends Assets {

    private double currentPrice;

    public Stock(
            String stockId,
            String stockName,
            double purchasePrice,
            double currentPrice) {

        super(stockId, stockName, purchasePrice);

        this.currentPrice = currentPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public double calculateCurrentValue() {
        return currentPrice;
    }

    @Override
    public String toString() {

        return "Stock ID: " + getAssetId()
                + ", Stock Name: " + getAssetName()
                + ", Purchase Price: " + getPurchasePrice()
                + ", Current Price: " + currentPrice;
    }
}
