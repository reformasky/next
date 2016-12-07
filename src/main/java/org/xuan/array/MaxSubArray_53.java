package org.xuan.array;

/**
 * Created by xzhou2 on 12/4/16.
 */
public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int result = nums[0], curr = 0;
        for(int i = 0; i < nums.length; i++) {
            curr += nums[i];
            result = Math.max(result, nums[i]);
            if (nums[i] >= 0) {
                result = Math.max(result, curr);
            } else if (curr > 0) {
                continue;
            } else {
                curr = 0;
            }
        }
        return result;
    }
}
