package org.xuan.array;

/**
 * Created by xzhou2 on 12/17/16.
 */
public class BuyStockI_121 {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE, result = 0;
        for(int p : prices) {
            if (p < low) {
                low = p;
            } else {
                result = Math.max(p - low, result);
            }
        }
        return result;
    }
}
