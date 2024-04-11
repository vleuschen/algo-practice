package com.akm.algo.mayi;

/**
 * 买入股票的最佳时机
 */
public class StockMaxProfit {

    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int currPrice = prices[i];

            if (currPrice < minPrice) {
                minPrice = currPrice;
            } else if (currPrice - minPrice > maxProfit) {
                maxProfit = currPrice - minPrice;
            }
        }

        return maxProfit;
    }
}
