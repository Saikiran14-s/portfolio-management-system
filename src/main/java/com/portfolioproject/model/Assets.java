package com.portfolioproject.model;

public abstract class Assets {

    private String assetId;
    private String assetName;
    private double purchasePrice;

    // Constructor
    public Assets(String assetId, String assetName, double purchasePrice) {

        this.assetId = assetId;
        this.assetName = assetName;
        this.purchasePrice = purchasePrice;
    }

    // Getters

    public String getAssetId() {
        return assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    // Abstract method
    public abstract double CalculateCurrentValue();

}


   

