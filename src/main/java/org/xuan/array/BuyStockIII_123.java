package org.xuan.array;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class BuyStockIII_123 {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE,
                sell1 = 0, sell2 = 0;
        for(int p : prices) {
            sell2 = Math.max(sell2, buy2 + p);
            buy2 = Math.max(buy2, sell1 - p);
            sell1 = Math.max(sell1, buy1 + p);
            buy1 = Math.max(buy1, -p);
        }

        return sell2;
    }
}
