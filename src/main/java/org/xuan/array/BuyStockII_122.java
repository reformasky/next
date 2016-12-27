package org.xuan.array;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class BuyStockII_122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
