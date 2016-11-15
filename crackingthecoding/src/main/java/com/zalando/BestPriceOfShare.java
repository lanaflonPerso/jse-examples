package com.zalando;

/**
 * Given an array of time and selling price find the best buying and selling time to maximize the profit
 */
public class BestPriceOfShare {
    public static void main(String...args) {
        double[] prices = {7.5, 7.9, 8.0, 6.8, 9.01};
            System.out.println(new BestPriceOfShare().solution(prices));
    }

    public double solution(double[] prices) {
        // check if this is needed.
        if (prices.length <= 1) {
            return 0;
        }

        double minPrice = prices[0];
        double maxProfit = Integer.MIN_VALUE; // can be set to 0
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        System.out.println("Best price to buy : " + minPrice);
        System.out.println("Best price to sell : " + (minPrice + maxProfit));
        return maxProfit;
    }
}
