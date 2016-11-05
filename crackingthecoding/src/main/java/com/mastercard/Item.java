package com.mastercard;

/**
 * Created by ehimnay on 9/7/2016.
 */
public class Item {

    private Double currentPrice;
    private PriceHistory priceHistory;

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
