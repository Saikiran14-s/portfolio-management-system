    package com.portfolioproject.model;

	public class Holding {

	    private String holdingId;
	    private String assetName;
	    private double quantity;
	    private double purchasePrice;

	    // Constructor
	    public Holding(String holdingId, String assetName, double quantity, double purchasePrice) {
	        this.holdingId = holdingId;
	        this.assetName = assetName;
	        this.quantity = quantity;
	        this.purchasePrice = purchasePrice;
	    }

	    // Getters
	    public String getHoldingId() {
	        return holdingId;
	    }

	    public String getAssetName() {
	        return assetName;
	    }

	    public double getQuantity() {
	        return quantity;
	    }

}
