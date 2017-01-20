package org.xuan.ints;

import java.util.Arrays;

/**
 * Created by xzhou2 on 1/17/17.
 */
public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        long[] cache = new long[amount + 1];
        Arrays.sort(coins);
        for(int i = 1; i <= amount; i++) {
            long curr = Integer.MAX_VALUE;
            for(int j = coins.length - 1; j >= 0; j--) {
                if (i < coins[j]) {
                    continue;
                }
                curr = Math.min(cache[i - coins[j]] + 1, curr);
            }
            cache[i] = curr > Integer.MAX_VALUE ? Integer.MAX_VALUE : curr;
        }
        return cache[amount] >= Integer.MAX_VALUE ? -1 : (int)cache[amount];
    }
}
