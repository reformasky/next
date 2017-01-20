package org.xuan.array;

/**
 * Created by xzhou2 on 1/11/17.
 */
public class BuyStockCoolDown_309 {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, cool = 0, sell = 0;
        for(int p : prices) {
            int tmp = buy;
            buy = Math.max(cool - p, buy);
            cool = Math.max(cool, sell);
            sell = Math.max(sell, tmp + p);
        }
        return sell;
    }
}
