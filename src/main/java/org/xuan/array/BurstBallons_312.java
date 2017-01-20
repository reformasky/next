package org.xuan.array;

/**
 * Created by xzhou2 on 1/12/17.
 */
public class BurstBallons_312 {
    int[] nums;
    public int maxCoins(int[] nums) {
        this.nums = nums;
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] cache = new int[len][len];
        for(int i = 0; i < len; i++) {
            cache[i][i] = get(i-1) * nums[i] * get(i + 1);
        }

        for(int diff = 1; diff < len; diff++) {
            for(int i = 0; i + diff < len; i++) {
                int j = i + diff;
                int curr = 0;
                for(int k = i; k <= j; k++) {
                    int left = k > i ? cache[i][k-1] : 0,
                            right = k < j ? cache[k + 1][j] : 0,
                            tmp = left + right + get(i-1) * nums[k] * get(j+1);
                    curr = Math.max(tmp, curr);
                }
                cache[i][j] = curr;
            }
        }

        return cache[0][len - 1];
    }

    private int get(int i) {
        return (i < 0 || i >= nums.length) ? 1 : nums[i];
    }
}
