package org.xuan.array;

import java.util.Arrays;

/**
 * Created by xzhou2 on 12/29/16.
 */
public class StockIV_188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 0 || len == 0) {
            return 0;
        }
        if (k > len / 2) {
            int result = 0;
            for(int i = 0; i < len - 1; i++) {
                result += Math.max(0, prices[i + 1] - prices[i]);
            }
            return result;
        }

        int[] buy = new int[k], sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        for(int p : prices) {
            for(int i = k - 1; i >= 1; i--) {
                sell[i] = Math.max(sell[i], buy[i] + p);
                buy[i] = Math.max(buy[i], sell[i - 1] - p);
            }
            sell[0] = Math.max(sell[0], buy[0] + p);
            buy[0] = Math.max(buy[0], -p);
        }
        return sell[k - 1];
    }
}
