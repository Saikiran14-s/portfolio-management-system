package com.portfolioproject.model;

public class MutualFund extends Assets {

    private double nav;

    public MutualFund(
            String mutualFundId,
            String mutualFundName,
            double purchasePrice,
            double nav) {

        super(mutualFundId, mutualFundName, purchasePrice);

        this.nav = nav;
    }

    public double getNav() {
        return nav;
    }

    public void setNav(double nav) {
        this.nav = nav;
    }

    @Override
    public double calculateCurrentValue() {
        return nav;
    }

    @Override
    public String toString() {

        return "Mutual Fund ID: " + getAssetId()
                + ", Mutual Fund Name: " + getAssetName()
                + ", Purchase Price: " + getPurchasePrice()
                + ", NAV: " + nav;
    }
}