package com.mastercard;

/**
 * Created by ehimnay on 9/7/2016.
 */
public class PromotionDiscount implements Discount {
    private double discount;
    private Promotion promotion;

    public PromotionDiscount(double promotion) {
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
