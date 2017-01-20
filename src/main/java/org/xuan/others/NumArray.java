package org.xuan.others;

import java.util.Arrays;

/**
 * Created by xzhou2 on 1/11/17.
 */
public class NumArray {
    int[] cache;
    int[] nums;
    int len;
    public NumArray(int[] nums) {
        this.len = nums.length;
        this.cache = new int[len + 1];
        this.nums = Arrays.copyOf(nums, len);
        for(int i = 0; i < len; i++) {
            init(i, nums[i]);
        }
    }

    private void init(int i, int val) {
        i++;
        while(i <= len) {
            cache[i] += val;
            i += (i & -i);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        init(i, diff);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    private int getSum(int i) {
        int sum = 0;
        i++;
        while(i > 0) {
            sum += cache[i];
            i -= (i & -i);
        }
        return sum;
    }
}