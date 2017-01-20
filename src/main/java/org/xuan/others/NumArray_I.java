package org.xuan.others;

/**
 * Created by xzhou2 on 1/10/17.
 */
public class NumArray_I {
    int[] sums;
    public NumArray_I(int[] nums) {
        sums = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}

