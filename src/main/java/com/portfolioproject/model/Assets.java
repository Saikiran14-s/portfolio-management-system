package com.portfolioproject.model;

public abstract class Assets {

    private String assetId;
    private String assetName;
    private double purchasePrice;

    public Assets(String assetId, String assetName, double purchasePrice) {

        this.assetId = assetId;
        this.assetName = assetName;
        this.purchasePrice = purchasePrice;
    }

    public String getAssetId() {
        return assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public abstract double calculateCurrentValue();

    @Override
    public String toString() {
        return "Asset ID: " + assetId
                + ", Asset Name: " + assetName
                + ", Purchase Price: " + purchasePrice;
    }
}


   

